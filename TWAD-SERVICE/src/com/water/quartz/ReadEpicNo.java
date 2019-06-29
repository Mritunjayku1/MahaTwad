package com.water.quartz;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;
import javax.ws.rs.core.MultivaluedMap;

import com.water.bean.EPICBean;
import com.water.util.EmailTemplateBuilder;
import com.water.util.SendEMailUtil;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import freemarker.template.TemplateException;

public class ReadEpicNo {

	Properties prop = new Properties();
	InputStream input = Thread.currentThread().getContextClassLoader()
			.getResourceAsStream("resources/mail.properties");

	String host;
	String mailStoreType;
	String username;
	String password;
	String pop3_port;
	String emailURL;
	String EPICURL;

	String from, subject;

	String EPICKeyMap = null;

	byte data[] = null;
	String imgPath = null;
	Map<String, Object> params = null;

	public ReadEpicNo() {
		try {
			prop.load(input);
			this.host = prop.getProperty("EPIC.pop3.host");
			this.mailStoreType = prop.getProperty("EPIC.pop3.mailStoreType");
			this.username = prop.getProperty("EPIC.userName");
			this.password = prop.getProperty("EPIC.userpassword");
			this.emailURL = prop.getProperty("EmailURL");
			this.EPICURL = prop.getProperty("EPICURL");
			this.pop3_port = prop.getProperty("EPIC.pop3.port");
			this.EPICKeyMap = prop.getProperty("EPICKeyMap");

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

	Message[] messages = null;

	public void fetch(String pop3Host, String storeType, String user,
			String password) {
		try {

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
			store.connect(pop3Host, user, password);

			// create the folder object and open it
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_WRITE);

			FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
			Message messages[] = emailFolder.search(ft);
			System.out.println("EPIC Filtered Messages :" + messages.length);

			if (messages != null && messages.length > 0) {
				for (int i = 0; i < messages.length; i++) {
					try {
						Message message = messages[i];

						writePart(message);

						if (subject != null
								&& subject.toLowerCase().trim()
										.startsWith("epic")) {

							System.out.println("Correct Format : " + subject);
							subject = subject.replaceAll("(^ )|( $)", "");
							System.out.println("SUBJECT:  " + subject);
							System.out.println("from : " + from);
							// from = "ss";
							String[] sub_split = subject.split(" ");
							System.out.println("lebgth  : " + sub_split[1]);

							String EPIC = subject.substring(
									subject.indexOf(" ") + 1, subject.length());
							message.setFlag(Flag.SEEN, true);

							Gson gson = new Gson();
							String json = "";// gson.toJson(complaint);
							Client client = Client.create();

							System.out.println("EPICURL : " + EPICURL);
							WebResource web = client.resource(EPICURL
									+ "?EPIC=" + EPIC + "&channelID=3&from="
									+ URLEncoder.encode(from));

							System.out.println(EPICURL + "?EPIC=" + EPIC
									+ "&channelID=3&from="
									+ URLEncoder.encode(from));
							MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
							queryParams.add("json", json);
							// String s =
							// web.queryParams(queryParams).get(String.class);
							ClientResponse response = web.type(
									"application/json").post(
									ClientResponse.class, json);
							//
							String output = response.getEntity(String.class);

							EPICBean epicBean = new Gson().fromJson(output,
									EPICBean.class);
							if (output != null
									&& !"".equals(output)
									&& epicBean.getEpicNumber() != null
									&& !"invalid".equals(epicBean
											.getEpicNumber())
									&& !"null".equalsIgnoreCase(output)) {
								EPICBean bean = gson.fromJson(output,
										EPICBean.class);
								params = new HashMap<String, Object>();
								params.put("type", "valid");
								params.put("electoralrolldetails",
										bean.getElectoralRollDetails());
								params.put("pollingstationaddress",
										bean.getPollingStationAddress());
								imgPath = EPICKeyMap + bean.getKeyMap();

								System.out
										.println("imgPath ---------------- 1 : "
												+ imgPath);
							} else {
								params = new HashMap<String, Object>();
								params.put("type", "invalid");
								params.put("notfound",
										"No Data found / Invalid EPIC No");
								imgPath = "";
							}
							System.out.println("imgPath ---------------- : "
									+ imgPath);
						} else {

							System.out.println("invalid Format  : " + subject);
							params = new HashMap<String, Object>();
							params.put("type", "invalid");
							params.put("invalidformat", "Invalid Format");
							imgPath = "";
						}
						sendEmail(params, imgPath);

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

	public void sendEmail(Map<String, Object> params, String path) {

		String body;
		try {
			body = EmailTemplateBuilder.getEmailTemplate("EPIC.ftl", params);
			new SendEMailUtil().sendMail(from, "EPIC Information", body, path,
					data);

		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			System.out.println("Template Exception : " + e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception : " + e);
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

				from = a[j].toString();
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
			subject = m.getSubject();

		}

	}

	public static void main(String[] args) {
		new ReadEpicNo().MethodEmail();
	}

}