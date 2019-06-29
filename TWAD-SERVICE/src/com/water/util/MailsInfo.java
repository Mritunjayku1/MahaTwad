package com.water.util;

import java.io.File;
import java.util.Date;
import java.util.List;

public class MailsInfo {

	private String mailInfoId;
	private String subject;
	private String mailFrom;
	private String mailTo;
	private String description;
	private String mailBody;
	private String mailType;
	private Date processedDate;
	private boolean mailStatus;
	private byte[] data;
	private String attachment;
	private String fileName;
	private List<File> uploadFiles;
	private String workFolderPath;

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getMailInfoId() {
		return mailInfoId;
	}

	public void setMailInfoId(String mailInfoId) {
		this.mailInfoId = mailInfoId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMailFrom() {
		return mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	public String getMailTo() {
		return mailTo;
	}

	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMailBody() {
		return mailBody;
	}

	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}

	public String getMailType() {
		return mailType;
	}

	public void setMailType(String mailType) {
		this.mailType = mailType;
	}

	public Date getProcessedDate() {
		return processedDate;
	}

	public void setProcessedDate(Date processedDate) {
		this.processedDate = processedDate;
	}

	public boolean isMailStatus() {
		return mailStatus;
	}

	public void setMailStatus(boolean mailStatus) {
		this.mailStatus = mailStatus;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<File> getUploadFiles() {
		return uploadFiles;
	}

	public void setUploadFiles(List<File> uploadFiles) {
		this.uploadFiles = uploadFiles;
	}

	public String getWorkFolderPath() {
		return workFolderPath;
	}

	public void setWorkFolderPath(String workFolderPath) {
		this.workFolderPath = workFolderPath;
	}

}
