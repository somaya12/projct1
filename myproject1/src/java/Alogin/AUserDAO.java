/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alogin;
import Alogin.Auser;
import java.sql.*;
/**
 *
 * @author alfjer
 */
public class AUserDAO {


    public Auser checkLogin(String Aid, String Apassword) throws SQLException,
            ClassNotFoundException {
        
 
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
        String sql = "SELECT * FROM admin WHERE id = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, Aid);
        statement.setString(2, Apassword);
 
        ResultSet result = statement.executeQuery();
 
        Auser user = null;
 
        if (result.next()) {
            user = new Auser();
           
            user.setAid(Aid);
        }
 
        connection.close();
 
        return user;
    }

   
}
  

