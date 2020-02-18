package customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import db.DBConnect;
import gui.main;

public class CustomerArray
	{
		protected static ArrayList<CustomerValues> getCustomer() //creates an ArrayList for Customer
			{
				ArrayList<CustomerValues> customers = new ArrayList<CustomerValues>(); // initializes the ArrayList

				Connection con = DBConnect.getConnection(); //establish connection
				Statement st;
				ResultSet rs;
				CustomerValues c;

				try
					{
						st = con.createStatement(); // creates Statement object allowing us to send SQL Statements
						rs = st.executeQuery("SELECT * FROM Customer"); // Executes SQL Statement, returning ResultSet object(data returned by Statement)
						//ResultSet selects the data at position 0. SQL Tables begin at 1
						while (rs.next()) // moves to next row and retrieves the values
							{
								c = new CustomerValues(
														rs.getInt("id"), 
														rs.getString("fname"), 
														rs.getString("lname"),
														rs.getInt("number"),
														rs.getString("email"),
														rs.getString("address")
													 );
								customers.add(c); //store data in the ArrayList
							}
					} catch (SQLException ex) //catch exception, display error in terminal
					{
						Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
					}
				return customers;
			}
	}
