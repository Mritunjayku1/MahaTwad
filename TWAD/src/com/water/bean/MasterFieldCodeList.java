package com.water.bean;

import java.util.ArrayList;

public class MasterFieldCodeList extends ArrayList<MasterFieldCode> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6406851243028631906L;
	
	private MasterFieldCode masterFieldCode;

	public MasterFieldCode getMasterFieldCode() {
		return masterFieldCode;
	}

	public void setMasterFieldCode(MasterFieldCode masterFieldCode) {
		this.masterFieldCode = masterFieldCode;
	}

}
