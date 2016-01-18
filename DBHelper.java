/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class DBHelper {
    private static final    String URL = "jdbc:mysql://localhost:3306/";
    private static final    String DBNAME = "central_office";
    private static final    String DRIVER = "com.mysql.jdbc.Driver";
    private static final    String USERNAME = "root";
    private static final    String PASSWORD = "";
    private Statement st;
    
    DBHelper() {
        try {
            Class.forName(DRIVER).newInstance();
            Connection conn = DriverManager.getConnection(URL+DBNAME, USERNAME, PASSWORD);
            st = conn.createStatement();
            
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    public void getAllDataQuery() {
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM employes_table;");
            
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String age = rs.getString("age");
                String sex = rs.getString("sex");
                String job = rs.getString("job");
                String salary = rs.getString("salary");
                
                
                System.out.println("| "+id+" | "+name+" | "+age+" | "+sex+" | "+job+" | "+salary+" |");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
}
