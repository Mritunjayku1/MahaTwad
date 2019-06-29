/**
 * 
 */
package com.water.ws;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.water.bean.ComplaintBean;
import com.water.bean.FieldcodeBean;
import com.water.dao.DropDownListDao;
import com.water.daoImpl.DropDownListDaoImpl;
import com.water.model.Documents;
import com.water.model.Login;
import com.water.model.MasterFieldCode;
import com.google.gson.Gson;

/**
 * @author Mahalingam
 * 
 *         Created on 02-06-2017 for Utility service, It contains dropdownlist
 *         services:
 * 
 * 
 * 
 */
@Path("UtilService")
public class UtilService {

	DropDownListDao ddl;
	private static Logger logger = Logger.getLogger(UtilService.class);

	@POST
	@Path("listFieldCode")
	@Produces(MediaType.APPLICATION_JSON)
	public String listFieldCode(@QueryParam("key") String key) {
		ddl = new DropDownListDaoImpl();
		Gson gson = new Gson();

		FieldcodeBean fieldcodeBean;

		List<FieldcodeBean> fieldcodeBeanList = new ArrayList<FieldcodeBean>();

		for (MasterFieldCode masterFieldCode : ddl.listFieldCode(key)) {

			fieldcodeBean = new FieldcodeBean();
			fieldcodeBean.setFieldCodeID(masterFieldCode.getFieldCodeID());
			fieldcodeBean.setDerivedValue(masterFieldCode.getDerivedValue());
			fieldcodeBean.setIcon(masterFieldCode.getIcon());
			fieldcodeBean.setBgColor((masterFieldCode.getColor()));
			fieldcodeBeanList.add(fieldcodeBean);
		}

		return gson.toJson(fieldcodeBeanList);

	}

	@POST
	@Path("crashReport")
	@Consumes(MediaType.APPLICATION_JSON)
	public void crashReport(String message) {

		logger.info(message);

		Writer filewriter = null;
		try {
			String date = new SimpleDateFormat("yyyyMMddhhmmssS'.txt'")
					.format(new Date());
			String filepath = "C:\\EC\\Crash_Report\\" + date + ".txt";
			File file = new File(filepath);
			if (!file.exists()) {
				if (file.getParentFile().mkdirs())
					if (file.createNewFile()) {
						logger.info("File not exists");
						filewriter = new FileWriter(file);
						filewriter.write(message);
						filewriter.flush();
						filewriter.close();
					}
			} else {
				logger.info("File not exists");
				filewriter = new FileWriter(file);
				filewriter.write(message);
				filewriter.flush();
				filewriter.close();
			}
		}
		/*
		 * catch (ParseException e) { e.printStackTrace(); }
		 */
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			/*
			 * try { filewriter.close(); } catch (IOException e) {
			 * e.printStackTrace(); }
			 */
		}

	}

	@POST
	@Path("listAssignTo")
	@Produces(MediaType.APPLICATION_JSON)
	public String listAssignTo() {
		ddl = new DropDownListDaoImpl();
		Gson gson = new Gson();
		return gson.toJson((List<Login>) ddl.listAssignTo());

	}

	@POST
	@Path("listFiles")
	@Produces(MediaType.APPLICATION_JSON)
	public String listFiles(ComplaintBean complaintBean) {

		ddl = new DropDownListDaoImpl();
		Gson gson = new Gson();
		return gson.toJson((List<Documents>) ddl.listFiles(complaintBean));
	}

	@POST
	@Path("/listSubFieldCode")
	@Produces(MediaType.APPLICATION_JSON)
	public String listMajor(@QueryParam("key") String key,
			@QueryParam("parentID") Integer parentID) {

		ddl = new DropDownListDaoImpl();
		Gson gson = new Gson();

		FieldcodeBean fieldcodeBean;

		List<FieldcodeBean> fieldcodeBeanList = new ArrayList<FieldcodeBean>();

		for (MasterFieldCode masterFieldCode : ddl.listSubFieldCode(key,
				parentID)) {

			fieldcodeBean = new FieldcodeBean();
			fieldcodeBean.setFieldCodeID(masterFieldCode.getFieldCodeID());
			fieldcodeBean.setDerivedValue(masterFieldCode.getDerivedValue());
			fieldcodeBean.setKeyValue(masterFieldCode.getKeyValue());
			fieldcodeBeanList.add(fieldcodeBean);
		}

		return gson.toJson(fieldcodeBeanList);

	}
}
