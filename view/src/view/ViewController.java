package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@RestController
public class ViewController {
	
	@GetMapping(execute/{query})
	pulbic Map executeQuery(query) {
		try (Connection con = DriverManager.getConnection(url, user, passwd);
	             
	            ) {
			
		}
		 Class.forName ("org.h2.Driver"); 
    	 Connection con = DriverManager.getConnection ("jdbc:h2:~/test", "sa",""); 
    	 PreparedStatement ps = (PreparedStatement) con.createStatement();
			ps = con.prepareStatement(query);
           ResultSet rs =  ps.executeUpdate();
           java.util.Map<K, V> result = new HashMap();
           
           String SOAP_RESPONSE = "SOAP RESPONSE";
           String HRESULT = "HRESULT: ";
           String HTTP_Status = "HTTP Status";
           String RESPONSE_MESSAGE = "RESPONSE MESSAGE:";
           String type = null;
           
           while(rs.next()) {
        	   result.put("SOAP_RESPONSE",rs.getString(SOAP_RESPONSE));
        	   result.put("HRESULT",rs.getString(HRESULT));
        	   result.put("HTTP_Status",rs.getString(HTTP_Status));
        	   result.put("RESPONSE_MESSAGE",rs.getString(RESPONSE_MESSAGE));
        	   result.put("type",rs.getString(type));
           }
           
           return result;
        	   
           }

