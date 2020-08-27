/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Slogin;

import java.sql.*;
 
public class UserDAO {
 
    public User checkLogin(String id, String password) throws SQLException,
            ClassNotFoundException {
        
 
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?zeroDateTimeBehavior=convertToNull", "root", "");
        String sql = "SELECT * FROM user WHERE id = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        statement.setString(2, password);
 
        ResultSet result = statement.executeQuery();
 
        User user = null;
 
        if (result.next()) {
            user = new User();
           
            user.setId(id);
        }
 
        connection.close();
 
        return user;
    }

   
}
