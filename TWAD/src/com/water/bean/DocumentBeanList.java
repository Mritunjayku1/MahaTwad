package com.water.bean;

import java.util.ArrayList;

public class DocumentBeanList extends ArrayList<DocumentBean> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1559683379866469253L;
	private DocumentBean DocumentBean;

	public DocumentBean getDocumentBean() {
		return DocumentBean;
	}

	public void setDocumentBean(DocumentBean documentBean) {
		DocumentBean = documentBean;
	}

}
