package com.water.util;

import  java.io.*;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import  org.apache.poi.hssf.usermodel.HSSFSheet;
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import com.water.bean.DDPaymentFormBean;
import com.water.bean.PaymentFormBean;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import  org.apache.poi.hssf.usermodel.HSSFRow;

public class CreateExlFile{
    
    public void generateXls(List<DDPaymentFormBean> ddPaymentFormBeanList, HttpServletRequest request){
    	

        try {
        	
        	String path = request.getRealPath("/");
        	
            String filename = path+"library/ViewAllApplication.xls" ;
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("View All Application"); 
            
            HSSFCellStyle style = workbook.createCellStyle();
           	HSSFFont font = workbook.createFont();
        	font.setFontHeightInPoints((short) 10);
        	font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        	style.setFont(font);                 
        	style.setWrapText(true);
        	style.setBorderBottom((short) 2);
        	sheet.setColumnWidth(0,2000);
            for(int i=1;i<47;i++){
            	if(i==2 || i==3 || i==4 || i==7 || i==9 || i==10 || i==14 || i==37){
            		sheet.setColumnWidth(i,7000);
            	}
            	else{
                    sheet.setColumnWidth(i,5000);
            	}
            }
            
            HSSFRow rowhead = sheet.createRow((short)0);
            rowhead.setHeight((short) 500);
            Cell cell0 = rowhead.createCell(0);
            cell0.setCellStyle(style);
            cell0.setCellValue("SNo.");
            
            Cell cell1 = rowhead.createCell(1);
            cell1.setCellStyle(style);
            cell1.setCellValue("Application Ref #");
            
            Cell cell2 = rowhead.createCell(2);
            cell2.setCellStyle(style);
            cell2.setCellValue("Registered Date");
            
            Cell cell3 = rowhead.createCell(3);
            cell3.setCellStyle(style);
            cell3.setCellValue("Legal Name of Company");
            
            Cell cell4 = rowhead.createCell(4);
            cell4.setCellStyle(style);
            cell4.setCellValue("Name of contact person");
            
            Cell cell5 = rowhead.createCell(5);
            cell5.setCellStyle(style);
            cell5.setCellValue("Mobile Number");
            
            Cell cell6 = rowhead.createCell(6);
            cell6.setCellStyle(style);
            cell6.setCellValue("Land line number");
            
            Cell cell7 = rowhead.createCell(7);
            cell7.setCellStyle(style);
            cell7.setCellValue("Email Id");
            
            Cell cell8 = rowhead.createCell(8);
            cell8.setCellStyle(style);
            cell8.setCellValue("Survey Field No");
            
            Cell cell9 = rowhead.createCell(9);
            cell9.setCellStyle(style);
            cell9.setCellValue("Address for Correspondence");
            
            Cell cell10 = rowhead.createCell(10);
            cell10.setCellStyle(style);
            cell10.setCellValue("Site Address");
           
            Cell cell11 = rowhead.createCell(11);
            cell11.setCellStyle(style);
            cell11.setCellValue("District");
            
            Cell cell12 = rowhead.createCell(12);
            cell12.setCellStyle(style);
            cell12.setCellValue("Taluk");
            
            Cell cell13 = rowhead.createCell(13);
            cell13.setCellStyle(style);
            cell13.setCellValue("Village");
            
            Cell cell14 = rowhead.createCell(14);
            cell14.setCellStyle(style);
            cell14.setCellValue("Type of category");
            
            Cell cell15 = rowhead.createCell(15);
            cell15.setCellStyle(style);
            cell15.setCellValue("Is this New Connection?");
            
            Cell cell16 = rowhead.createCell(16);
            cell16.setCellStyle(style);
            cell16.setCellValue("Requirement of water in KLD");
            
            Cell cell17 = rowhead.createCell(17);
            cell17.setCellStyle(style);
            cell17.setCellValue("Circle");
            
            Cell cell18 = rowhead.createCell(18);
            cell18.setCellStyle(style);
            cell18.setCellValue("Region");
            
            Cell cell19 = rowhead.createCell(19);
            cell19.setCellStyle(style);
            cell19.setCellValue("Division");
            
            Cell cell20 = rowhead.createCell(20);
            cell20.setCellStyle(style);
            cell20.setCellValue("SE-UserId");
            
            Cell cell21 = rowhead.createCell(21);
            cell21.setCellStyle(style);
            cell21.setCellValue("SE-Process Remarks");
            
            Cell cell22 = rowhead.createCell(22);
            cell22.setCellStyle(style);
            cell22.setCellValue("SE Ref File");
            
            Cell cell23 = rowhead.createCell(23);
            cell23.setCellStyle(style);
            cell23.setCellValue("SE Ref Date");
           
            Cell cell24 = rowhead.createCell(24);
            cell24.setCellStyle(style);
            cell24.setCellValue("CE-UserId");
            
            Cell cell25 = rowhead.createCell(25);
            cell25.setCellStyle(style);
            cell25.setCellValue("CE-Process Remarks");
            
            Cell cell26 = rowhead.createCell(26);
            cell26.setCellStyle(style);
            cell26.setCellValue("CE Ref File");
            
            Cell cell27 = rowhead.createCell(27);
            cell27.setCellStyle(style);
            cell27.setCellValue("CE Ref Date");
           
            Cell cell28 = rowhead.createCell(28);
            cell28.setCellStyle(style);
            cell28.setCellValue("Board-UserId");
            
            Cell cell29 = rowhead.createCell(29);
            cell29.setCellStyle(style);
            cell29.setCellValue("Board-Process Remarks");
            
            Cell cell30 = rowhead.createCell(30);
            cell30.setCellStyle(style);
            cell30.setCellValue("Board Ref File");
            
            Cell cell31 = rowhead.createCell(31);
            cell31.setCellStyle(style);
            cell31.setCellValue("Board Ref Date");
            
            
            Cell cell32 = rowhead.createCell(32);
            cell32.setCellStyle(style);
            cell32.setCellValue("Application Fee");
            
            Cell cell33 = rowhead.createCell(33);
            cell33.setCellStyle(style);
            cell33.setCellValue("Upfront Charges");
            
            Cell cell34 = rowhead.createCell(34);
            cell34.setCellStyle(style);
            cell34.setCellValue("Full Payment");
            
            Cell cell35 = rowhead.createCell(35);
            cell35.setCellStyle(style);
            cell35.setCellValue("Inspected Date");
            
            Cell cell36 = rowhead.createCell(36);
            cell36.setCellStyle(style);
            cell36.setCellValue("Work Type");
            
            Cell cell37 = rowhead.createCell(37);
            cell37.setCellStyle(style);
            cell37.setCellValue("Application Status");
            
            Cell cell38 = rowhead.createCell(38);
            cell38.setCellStyle(style);
            cell38.setCellValue("Application Total Amount");
            
            Cell cell39 = rowhead.createCell(39);
            cell39.setCellStyle(style);
            cell39.setCellValue("Application Transaction Ref No");
            
            Cell cell40 = rowhead.createCell(40);
            cell40.setCellStyle(style);
            cell40.setCellValue("Application Bank Ref No");
            
            Cell cell41 = rowhead.createCell(41);
            cell41.setCellStyle(style);
            cell41.setCellValue("Upfront Total Amount");
            
            Cell cell42 = rowhead.createCell(42);
            cell42.setCellStyle(style);
            cell42.setCellValue("Upfront Transaction Ref No");
            
            Cell cell43 = rowhead.createCell(43);
            cell43.setCellStyle(style);
            cell43.setCellValue("Upfront Bank Ref No");
            
            Cell cell44 = rowhead.createCell(44);
            cell44.setCellStyle(style);
            cell44.setCellValue("Full Total Amount");
            
            Cell cell45 = rowhead.createCell(45);
            cell45.setCellStyle(style);
            cell45.setCellValue("Full Transaction Ref No");
            
            Cell cell46 = rowhead.createCell(46);
            cell46.setCellStyle(style);
            cell46.setCellValue("Full Bank Ref No");
            
            

            HSSFRow row =null;
            int count = 1;
            for(DDPaymentFormBean ddPaymentFormBean : ddPaymentFormBeanList){
             row = sheet.createRow((short)count);
             row.setHeight((short) 500);
             row.createCell(0).setCellValue(count);
             row.createCell(1).setCellValue(ddPaymentFormBean.getAppId());
             row.createCell(2).setCellValue(ddPaymentFormBean.getCreateDate());
             row.createCell(3).setCellValue(ddPaymentFormBean.getLegCompName());
             
             row.createCell(4).setCellValue(ddPaymentFormBean.getContactPersonName());
             row.createCell(5).setCellValue(ddPaymentFormBean.getMobileNum());
             row.createCell(6).setCellValue(this.checkNull(ddPaymentFormBean.getLandLineNo()+""));
             row.createCell(7).setCellValue(ddPaymentFormBean.getEmailAddr());
             
             row.createCell(8).setCellValue(ddPaymentFormBean.getSurveyFieldNo());
             row.createCell(9).setCellValue(ddPaymentFormBean.getCdoorNo() +" "+ddPaymentFormBean.getCplotNo()+" "+ ddPaymentFormBean.getCstreetName() +" "+ ddPaymentFormBean.getClocation() +" "+ ddPaymentFormBean.getCpinCode());
             row.createCell(10).setCellValue(ddPaymentFormBean.getDoorNo() +" "+ddPaymentFormBean.getPlotNo()+" "+ ddPaymentFormBean.getStreetName() +" "+ ddPaymentFormBean.getLocation() +" "+ ddPaymentFormBean.getPinCode());
             row.createCell(11).setCellValue(ddPaymentFormBean.getDistrict());
             
             row.createCell(12).setCellValue(this.checkNull(ddPaymentFormBean.getTaluk()));
             row.createCell(13).setCellValue(this.checkNull(ddPaymentFormBean.getVillage()));
             row.createCell(14).setCellValue(ddPaymentFormBean.getCategoryType());
             row.createCell(15).setCellValue(ddPaymentFormBean.getIsNewConnectionDisplay());
             row.createCell(16).setCellValue(ddPaymentFormBean.getReqMld());
             
             row.createCell(17).setCellValue(this.checkNull(ddPaymentFormBean.getCircle()));
             row.createCell(18).setCellValue(this.checkNull(ddPaymentFormBean.getRegion()));
             row.createCell(19).setCellValue(this.checkNull(ddPaymentFormBean.getDivisionName()));
           
            Map<String,PaymentFormBean> paymentFormBeanMap  = ddPaymentFormBean.getProcessMap();
            PaymentFormBean paymentFormBeanSE = paymentFormBeanMap.get("SE");
            PaymentFormBean paymentFormBeanCE = paymentFormBeanMap.get("CE");
            PaymentFormBean paymentFormBeanBoard = paymentFormBeanMap.get("Board");
            
            row.createCell(20).setCellValue( paymentFormBeanSE.getLoginName());
            row.createCell(21).setCellValue( paymentFormBeanSE.getRemarks());
            row.createCell(22).setCellValue( paymentFormBeanSE.getReferenceFile());
            row.createCell(23).setCellValue( paymentFormBeanSE.getReferenceDate());
            row.createCell(24).setCellValue( paymentFormBeanCE.getLoginName());
            row.createCell(25).setCellValue( paymentFormBeanCE.getRemarks());
            row.createCell(26).setCellValue( paymentFormBeanCE.getReferenceFile());
            row.createCell(27).setCellValue( paymentFormBeanCE.getReferenceDate());
            row.createCell(28).setCellValue( paymentFormBeanBoard.getLoginName());
            row.createCell(29).setCellValue( paymentFormBeanBoard.getRemarks());
            row.createCell(30).setCellValue( paymentFormBeanBoard.getReferenceFile());
            row.createCell(31).setCellValue( paymentFormBeanBoard.getReferenceDate());
           
             
             
             row.createCell(32).setCellValue(ddPaymentFormBean.getApplicationFee());
             row.createCell(33).setCellValue(this.checkNull(ddPaymentFormBean.getUpfrontCharges()+""));
             row.createCell(34).setCellValue(this.checkNull(ddPaymentFormBean.getFullPayment()+""));
             row.createCell(35).setCellValue("");
             row.createCell(36).setCellValue(ddPaymentFormBean.getWorkTypeDisplay());
             row.createCell(37).setCellValue(this.checkNull(ddPaymentFormBean.getManagementComments()));
             
             
             for(DDPaymentFormBean ddPayment :  ddPaymentFormBean.getPaymentList()){
            	 if(null != ddPayment.getPaymentType() && ddPayment.getPaymentType().equals("Application Fee")){
                      row.createCell(38).setCellValue(ddPayment.getPaymentAmount());
                      row.createCell(39).setCellValue(ddPayment.getTransactionRefNo());
                      row.createCell(40).setCellValue(ddPayment.getBankRefNo());
            	 }
            	 if(null != ddPayment.getPaymentType() && ddPayment.getPaymentType().equals("Upfront Charges")){
                      row.createCell(41).setCellValue(ddPayment.getPaymentAmount());
                      row.createCell(42).setCellValue(ddPayment.getTransactionRefNo());
                      row.createCell(43).setCellValue(ddPayment.getBankRefNo());
            	 }
            	 if(null != ddPayment.getPaymentType() && ddPayment.getPaymentType().equals("Full Payment")){
                      row.createCell(44).setCellValue(ddPayment.getPaymentAmount());
                      row.createCell(45).setCellValue(ddPayment.getTransactionRefNo());
                      row.createCell(46).setCellValue(ddPayment.getBankRefNo());
            	 }
             }
             
            count++;
            }
           
            FileOutputStream fileOut = new FileOutputStream(new File(filename));
            workbook.write(fileOut);
            fileOut.close();
            workbook=null;
            System.out.println("Your excel file has been generated!");

        } catch ( Exception ex ) {
            System.out.println(ex);
        }
    
    	
    }
    
    public String checkNull(String txt){
    	if(txt==null){
    		return "";
    	}
    	return txt;
    }
    
    
}