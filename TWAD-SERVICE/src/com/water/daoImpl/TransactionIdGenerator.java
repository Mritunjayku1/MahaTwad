package com.water.daoImpl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;


public class TransactionIdGenerator implements IdentifierGenerator{

    @Override
    public Serializable generate(SessionImplementor session, Object object)
            throws HibernateException {
    	//Calendar now = Calendar.getInstance();
       // String prefix = "WI2017";
    	int month=Calendar.getInstance().get(Calendar.MONTH) + 1;
    	String monthstr = month<10?"0"+month:month+"";
    	
        Integer year = Calendar.getInstance().get(Calendar.YEAR);
       // int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
      // String prefix = "WE"+year.toString();
       String prefix = "TR";
        Connection connection = session.connection();

        try {
            Statement statement=connection.createStatement();

            ResultSet rs=statement.executeQuery("select count(TRNS_ID) as Id from TransMaster");

            if(rs.next())
            {
                int id=rs.getInt(1)+1;
                
               // String idstr = id<10?"000"+id: id<100?"00"+id: id<1000?"0"+id: id+"";
                String generatedId = prefix + id;
            
                return generatedId;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return null;
    }

}