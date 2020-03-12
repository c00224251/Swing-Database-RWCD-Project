package invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import db.DBConnect;
import gui.Popup;
import gui.Driver;

//UPDATE table_name
//SET column1 = value1, column2 = value2, ...
//WHERE condition; 

public class Invoice
	{

		public static void AddInvoice(int customer, int product, int price, String date)
			{

				Connection con = DBConnect.getConnection();
				PreparedStatement st;

				try
					{
						// creates Statement object allowing us to send SQL Statements
						st = con.prepareStatement("INSERT INTO Invoice (customer_id,product_id,price,date,del) VALUES (?,?,?,?,0)"); // creates Statement object allowing us to send SQL Statements
						st.setInt(1, customer);
						st.setInt(2, product);
						st.setInt(3, price);
						st.setString(4, date);
						st.executeUpdate();

						Popup.information("Success");

					} catch (SQLException ex) // catch exception, display error in terminal
					{
						Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
						Popup.information("Error");
					}
			}

		public static void EditInvoice(int id, int customer, int product, int price, String date)
			{
				Connection con = DBConnect.getConnection();
				PreparedStatement st;

				try
					{
						// creates Statement object allowing us to send SQL Statements
						st = con.prepareStatement("UPDATE Invoice SET customer_id = ?, product_id = ?, price = ?, date = ? WHERE id = " + id + ";");
						st.setInt(1, customer);
						st.setInt(2, product);
						st.setInt(3, price);
						st.setString(4, date);
						st.executeUpdate();

						Popup.information("Success");

					} catch (SQLException ex) // catch exception, display error in terminal
					{
						Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
						Popup.information("Error");
					}
			}

		public static void DeleteInvoice(String object)
			{
				Connection con = DBConnect.getConnection();
				PreparedStatement st;

				try
					{
						 // creates Statement object allowing us to send SQL Statements
						st = con.prepareStatement("UPDATE Invoice SET del = ? WHERE id = " + Integer.parseInt(object) + ";");
						st.setInt(1, 1);
						st.executeUpdate();

						Popup.information("Success");

					} catch (SQLException ex) // catch exception, display error in terminal
					{
						Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
						Popup.information("Error");
					}
			}

	}
