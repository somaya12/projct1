package net.codejava;
 
import java.sql.*;
 
public class UserDAO {
 
    public User checkLogin(String id, String password) throws SQLException,
            ClassNotFoundException {
        
 
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?zeroDateTimeBehavior=convertToNull", "root", "");
        String sql = "SELECT * FROM teacher WHERE id = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        statement.setString(2, password);
 
        ResultSet result = statement.executeQuery();
 
        User user = null;
 
        if (result.next()) {
            user = new User();
            user.setPassword(result.getString("Password"));
            user.setId(id);
        }
 
        connection.close();
 
        return user;
    }
}