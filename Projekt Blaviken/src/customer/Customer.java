package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import db.DBConnect;
import gui.Popup;
import gui.main;

//UPDATE table_name
//SET column1 = value1, column2 = value2, ...
//WHERE condition; 

public class Customer
	{

		public static void AddCustomer(String fname, String lname, int number, String email, String address)
			{

				Connection con = DBConnect.getConnection();
				PreparedStatement st;

				try
					{
						st = con.prepareStatement("INSERT INTO Customer (first_name,last_name,phone_no,email,address, del) VALUES (?,?,?,?,?,0)"); // creates Statement object allowing us to send SQL Statements
						st.setString(1, fname);
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

		public static void EditCustomer(int id, String fname, String lname, int number, String email, String address)
			{
				Connection con = DBConnect.getConnection();
				PreparedStatement st;

				try
					{
						st = con.prepareStatement("UPDATE Customer SET first_name = ?, last_name = ?, phone_no = ?, email = ?, address = ? WHERE id = " + id + ";"); // creates Statement object allowing us to send SQL Statements
						st.setString(1, fname);
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

		public static void DeleteCustomer(String object)
			{
				Connection con = DBConnect.getConnection();
				PreparedStatement st;

				try
					{
						st = con.prepareStatement("UPDATE Customer SET del = ? WHERE id = " + Integer.parseInt(object) + ";"); // creates Statement object allowing us to send SQL Statements
						st.setInt(1, 1);
						st.executeUpdate();

						Popup.information("Success");

					} catch (SQLException ex) // catch exception, display error in terminal
					{
						Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
						Popup.information("Error");
					}
			}

	}
