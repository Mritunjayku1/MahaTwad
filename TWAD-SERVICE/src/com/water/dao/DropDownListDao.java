package com.water.dao;

import java.util.List;

import com.water.bean.ComplaintBean;
import com.water.model.Documents;
import com.water.model.Login;
import com.water.model.MasterFieldCode;

public interface DropDownListDao {

	public List<MasterFieldCode> listFieldCode(String Key);

	public List<MasterFieldCode> listSubFieldCode(String Key, Integer parentID);

	public List<Login> listAssignTo();

	public List<Documents> listFiles(ComplaintBean complaintBean);

}
