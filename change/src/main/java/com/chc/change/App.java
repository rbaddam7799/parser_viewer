package com.chc.change;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.command.Prepared;

public class App	 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String url = "jdbc:h2:tcp://localhost:9092/~/tmp/h2dbs/testdb";
        String user = "sa";
        String passwd = "s$cret";
        
        String REQUEST_MESSAGE = "REQUEST MESSAGE:";
        String SOAP_REQUEST_RECEIVED = "SOAP REQUEST RECEIVED";
        String TIME = "TIME";
        String SOAP_URI = "SOAP URI";
        String SOAP_AUCTION = "SOAP AUCTION";
        String GUID = "GUID";

        // String query = "SELECT * FROM cars";
        String line = "";
        
        String SOAP_RESPONSE = "SOAP RESPONSE";
        String HRESULT = "HRESULT: ";
        String HTTP_Status = "HTTP Status";
        String RESPONSE_MESSAGE = "RESPONSE MESSAGE:";
        String type = null;

        try{
        	 BufferedReader br = new BufferedReader(new FileReader("trace.txt"));
        	 Class.forName ("org.h2.Driver"); 
        	 Connection con = DriverManager.getConnection ("jdbc:h2:~/test", "sa",""); 
        	 PreparedStatement ps = (PreparedStatement) con.createStatement();
        	 

        	 while ((line = br.readLine()) != null)
             {
        		 if(line.equalsIgnoreCase(REQUEST_MESSAGE)) {
        			 line = br.readLine();
        			 String tmp[] = line.split(":");
        			 TIME = tmp[1];
        			 
        			 line = br.readLine();
        			 SOAP_URI = tmp[1];
        			 
        			 line = br.readLine();
        			 SOAP_AUCTION = tmp[1];
        			 
        			 line = br.readLine();
        			 GUID = tmp[1];
        			 
        			 line = br.readLine();
        			 type = "request";
        		 }
        		 
                
                 String sql =
                         "INSERT INTO resultat (GUID,type,SOAP_AUCTION,SOAP_URI,TIME) values ('"
                                 + GUID + "','" + type + "','" + SOAP_URI + "','" + TIME +
                                 "')";

                 ps = con.prepareStatement(sql);
                 ps.executeUpdate();
             }

        } catch (SQLException ex) {

           
        }
    }
}