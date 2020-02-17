package WIP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JFrame;

public class WIP_JTable_sync extends JFrame
	{
		public WIP_JTable_sync()
		{
			ArrayList columns = new ArrayList();
			ArrayList values = new ArrayList();
			
			// Connect to mysql
			
			String url = "jgbc:mysql://lovalhost:3306/project";
			String username = "projekt";
			String password = "projekt";
			String sql = "SELECT * FROM TableName";
			
			// Try connecting
			try { 
					Connection con = DriverManager.getConnection(url, username, password);
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
		} catch(SQLException ex){ Logger.getLogger(sql);
					
				}
					{
						
					}
		}
	}
