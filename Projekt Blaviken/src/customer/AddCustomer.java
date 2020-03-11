package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import db.DBConnect;
import gui.Popup;
import gui.main;

public class AddCustomer
	{

		public static void AddCustomer(String fname, String lname, int number, String email, String address)
			{

				Connection con = DBConnect.getConnection();
				PreparedStatement st;

				try
					{
						st = con.prepareStatement("INSERT INTO Customer (first_name,last_name,phone_no,email,address) VALUES (?,?,?,?,?)"); // creates Statement object allowing us to send SQL Statements
								st.setString(1,fname); 
								st.setString(2, lname);
								st.setInt(3, number);
								st.setString(4, email);
								st.setString(5, address);
								st.executeUpdate();
								
								Popup.information("Success");
								
					} catch (SQLException ex) // catch exception, display error in terminal
					{
						Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
						Popup.information("Error");
					}
			}
	}
