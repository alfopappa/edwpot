package s21;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class DaoCountry2 {
	private Connection conn;

    public DaoCountry2(DataSource ds) {
        try {
            this.conn = ds.getConnection();
        } catch (SQLException se) {
            throw new IllegalStateException("Database issue " + se.getMessage());
        }
    }

    public List<Country> getAll(String value){
        List<Country> results = new ArrayList<>();
         try {
        	
           PreparedStatement query = null;
           String s = "select country_id, country_name from regions join countries using(region_id) where region_id = ?";
           query = conn.prepareStatement(s);
           query.setLong(1, Long.parseLong(value));
           ResultSet rs = query.executeQuery();
            

            while (rs.next()) {
                results.add(new Country(rs.getString("COUNTRY_ID"), rs.getString("COUNTRY_NAME")));
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Database issue " + se.getMessage());
        }

        return results;
    }
    
    
	
        
	  
}