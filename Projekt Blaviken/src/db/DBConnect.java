package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import gui.main;

public class DBConnect
	{
		public static Connection getConnection() 
			{
				Connection con = null;
				String url = "jdbc:mysql://localhost:3306/proj3kt"; //insecure connection
				String user = "root";
				String password = ""; //password set at installation
				try //use try to make sure connection turns off when app quits
					{
						try
							{
								Class.forName("com.mysql.jdbc.Driver");
							} catch (ClassNotFoundException e)
							{
								e.printStackTrace();
							}
						con = DriverManager.getConnection(url, user, password); // establish a connection to the
																				// database using getConnection()
					} catch (SQLException ex) // in case of exception, log error. Display it in terminal.
					{
						Logger.getLogger(main.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
					}
				return con;
			}
	}
