package com.water.bean;

import java.util.ArrayList;

public class MasterViolationList extends ArrayList<MasterViolation> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8950724701628316374L;
	
	private MasterViolation masterViolation;

	public MasterViolation getMasterViolation() {
		return masterViolation;
	}

	public void setMasterViolation(MasterViolation masterViolation) {
		this.masterViolation = masterViolation;
	}

}
