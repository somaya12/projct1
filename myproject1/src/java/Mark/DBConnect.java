/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anas
 */

package Mark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class DBConnect {
                private String MySqlURL = "jdbc:mysql://";
         	private Connection connection;
                private String hostName = "localhost:3306";
		private String dbName = "student";
		private String user = "root";
		private String password = "";
                private Statement st ;
                // constructors...................
                // constructor without parameters.......................
	public DBConnect() {
		
		try {Class.forName("com.mysql.jdbc.Driver").newInstance();
		     } catch (Exception ex) {
			throw new SecurityException("class not found. " + ex.toString());
		                            }
                
                
		try {connection = DriverManager.getConnection(MySqlURL + hostName + "/"
					+ dbName + "?user=" + user + "&password=" + password);
		     connection.setAutoCommit(true);
                      st = connection.createStatement();
		     } catch (Exception ex) {
			throw new SecurityException("Cannot connect to MySql database. "
					+ ex.toString());
		                            }
                          }
       // constructor with parameters ...................
                public DBConnect(String hostName, String dbName, String user,
			String password) throws SecurityException {
		try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
		     } catch (Exception ex) {
			throw new SecurityException("class not found. " + ex.toString());
		                            }
                
		try {
                    connection = DriverManager.getConnection(MySqlURL + hostName + "/"
					+ dbName + "?user=" + user + "&password=" + password);
		     connection.setAutoCommit(true);
                     st = connection.createStatement();
		     } catch (Exception ex) {
			throw new SecurityException("Cannot connect to MySql database. "
					+ ex.toString());
		                            }
		}
                
                
                
             // excuteSelect .................
                
             public ResultSet excuteSelect(String selectStat)throws Exception
                 {    
                        return st.executeQuery(selectStat);
                 }
             
             // excuteDml ...................
              public void excuteDml(String dmlStat)throws Exception
                {
                 st.executeUpdate(dmlStat);
                 }
              //close the connection .....................
              public void close()
               {
                try
               {
                st.close();
                connection.close();
                }catch(Exception ex)
              {
            throw new SecurityException("can not close the connection. " + ex.toString());             
            }
    }
}
