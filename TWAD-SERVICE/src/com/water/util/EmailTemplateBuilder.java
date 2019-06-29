package com.water.util;

import java.io.CharArrayWriter;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.ResourceBundle;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class EmailTemplateBuilder {

	private static Configuration configuration;
	private static final String EMAILTEMPLATES_LOCATION = getTemplatesPath();
	static ResourceBundle rs = ResourceBundle.getBundle("resources/mail");

	static {
		init();
	}

	public static String getEmailTemplate(String templateName,
			@SuppressWarnings("rawtypes") Map params) throws TemplateException,
			IOException {

		Template template = configuration.getTemplate(templateName);
		CharArrayWriter writer = new CharArrayWriter();
		template.process(params, writer);

		return (writer.toString());
	}

	private static void init() {
		try {
			configuration = new Configuration();
			configuration.setDirectoryForTemplateLoading(new File(
					EMAILTEMPLATES_LOCATION));
			configuration.setObjectWrapper(new DefaultObjectWrapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getTemplatesPath() {
		EmailTemplateBuilder etb = new EmailTemplateBuilder();
		// Local Ecllipse Path

		String path = "";
		path = etb.getClass().getProtectionDomain().getCodeSource()
				.getLocation().getPath();
		String[] spilit_path = path.split("/com");
		path = spilit_path[0].replace("%20", " ") + ("/resources");

		return path;

	}
}
