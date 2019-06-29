package com.water.quartz;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;
import javax.mail.search.FlagTerm;
import javax.ws.rs.core.MultivaluedMap;

import com.water.bean.ComplaintBean;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class EmailComplaint {

	Properties prop = new Properties();
	InputStream input = Thread.currentThread().getContextClassLoader()
			.getResourceAsStream("resources/mail.properties");

	String host;
	String mailStoreType;
	String username;
	String password;
	String pop3_port;
	String emailURL;
	String emailAttachmentURL;

	String EC_AtttachementFolder = "";

	public EmailComplaint() {

		try {

			prop.load(input);
			this.host = prop.getProperty("mail.pop3.host");
			this.mailStoreType = prop.getProperty("mail.pop3.mailStoreType");
			this.username = prop.getProperty("mail.userName");
			this.password = prop.getProperty("mail.userpassword");
			this.emailURL = prop.getProperty("EmailURL");
			this.pop3_port = prop.getProperty("mail.pop3.port");
			this.EC_AtttachementFolder = prop.getProperty("EC_Atttachement");
			this.emailAttachmentURL = prop.getProperty("EmailAttachmentURL");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (input != null)
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

	String compliantSupplier = "";
	String compliantContent = "";

	Message[] messages = null;

	public void fetch(String pop3Host, String storeType, String user,
			String password) {
		try {

			String complaintNo = "0";
			Integer complaintID = 0;

			// create properties field
			Properties properties = new Properties();
			properties.put("mail.store.protocol", mailStoreType);
			properties.put("mail.pop3.host", pop3Host);
			properties.put("mail.pop3.port", pop3_port);
			properties.put("mail.pop3.starttls.enable", "true");
			Session emailSession = Session.getDefaultInstance(properties);
			// emailSession.setDebug(true);

			// create the POP3 store object and connect with the pop server
			Store store = emailSession.getStore("imaps");
			store.connect(pop3Host, "maha.lingam2k7@gmail.com", "maha12345");

			// create the folder object and open it
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_WRITE);

			FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
			Message messages[] = emailFolder.search(ft);
			System.out.println("Filtered Messages Count :" + messages.length);

			if (messages != null && messages.length > 0) {
				for (int i = 0; i < messages.length; i++) {
					try {
						Message message = messages[i];
						String contentType = message.getContentType();

						System.out.println("contentType ======  :"
								+ contentType);
						writePart(message);
						// message.setFlag(Flag.SEEN, true);
						ComplaintBean complaint = new ComplaintBean();
						System.out.println("Complaint : " + compliantContent);
						System.out.println("Email Id : " + compliantSupplier);
						complaint.setComplaintSource(3);
						complaint.setComplaintContent(compliantContent);
						complaint
								.setComplaintSubmitterEmailID(compliantSupplier);

						Gson gson = new Gson();
						String json = gson.toJson(complaint);
						Client client = Client.create();

						System.out.println("Email : " + emailURL);
						WebResource web = client.resource(emailURL);
						MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
						queryParams.add("json", json);
						// String s =
						// web.queryParams(queryParams).get(String.class);
						ClientResponse response = web.type("application/json")
								.post(ClientResponse.class, json);

						String output = response.getEntity(String.class);

						System.out.println("Email response :    : " + output);

						if (output != null && !"".equals(output)) {
							complaint = gson.fromJson(output,
									ComplaintBean.class);

							complaintNo = complaint.getComplaintNumber();
							complaintID = complaint.getComplaintID();
						}

						if (contentType.contains("multipart")) {
							// content may contain attachments
							Multipart multiPart = (Multipart) message
									.getContent();
							int numberOfParts = multiPart.getCount();
							System.out.println("Number of Count : "
									+ numberOfParts);
							for (int partCount = 0; partCount < numberOfParts; partCount++) {
								MimeBodyPart part = (MimeBodyPart) multiPart
										.getBodyPart(partCount);

								if (Part.ATTACHMENT.equalsIgnoreCase(part
										.getDisposition())) {
									// this part is attachment
									String fileName = part.getFileName();

									if (!new File(EC_AtttachementFolder
											+ complaintNo).exists()) {

										new File(EC_AtttachementFolder
												+ complaintNo).mkdirs();
									}

									part.saveFile(EC_AtttachementFolder
											+ complaintNo + "//" + fileName);

									complaint.setComplaintID(complaintID);
									complaint.setComplaintNumber(complaintNo);
									complaint.setAttachementPath(complaintNo
											+ "//" + fileName);
									complaint.setAttachementOwner(0);
									json = gson.toJson(complaint);

									web = client.resource(emailAttachmentURL);
									queryParams = new MultivaluedMapImpl();
									queryParams.add("json", json);

									response = web.type("application/json")
											.post(ClientResponse.class, json);

									output = response.getEntity(String.class);

								}
							}

						}

					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}

				// emailFolder.getFolder("INBOX").
				emailFolder
						.setFlags(messages, new Flags(Flags.Flag.SEEN), true);

			}
			// close the store and folder objects
			emailFolder.close(true);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void MethodEmail() {
		try {
			fetch(host, mailStoreType, username, password);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void writePart(Part p) throws Exception {
		if (p instanceof Message) {
			writeEnvelope((Message) p);
		}

		// System.out.println("----------------------------");
		// System.out.println("CONTENT-TYPE: " + p.getContentType());

		// check if the content is plain text
		if (p.isMimeType("text/plain")) {
			compliantContent = (String) p.getContent();
			System.out.println("Compliant Contenr : " + compliantContent);
		}

		// check if the content has attachment
		else if (p.isMimeType("multipart/*")) {

			Multipart mp = (Multipart) p.getContent();
			int count = mp.getCount();
			for (int i = 0; i < count; i++) {
				writePart(mp.getBodyPart(i));
			}

		} // check if the content is a nested message
		else if (p.isMimeType("message/rfc822")) {

			writePart((Part) p.getContent());
		} // check if the content is an inline image

	}

	/*
	 * This method would print FROM,TO and SUBJECT of the message
	 */

	public void writeEnvelope(Message m) throws Exception {

		Address[] a;

		// FROM
		if ((a = m.getFrom()) != null) {

			for (int j = 0; j < a.length; j++) {
				compliantSupplier = a[j].toString();
				System.out.println(" compliantSupplier : " + compliantSupplier);
			}
		}

		// TO
		if ((a = m.getRecipients(Message.RecipientType.TO)) != null) {
			for (int j = 0; j < a.length; j++) {
				System.out.println("TO: " + a[j].toString());
			}
		}

		// SUBJECT
		if (m.getSubject() != null) {
			System.out.println("SUBJECT: " + m.getSubject());
		}

	}

	public static void main(String[] args) {
		new EmailComplaint().MethodEmail();
	}

}