package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import db.DBConnect;
import gui.Popup;
import gui.main;

public class Product
	{

		public static void AddProduct(String brand, String model, int price, String description)
			{

				Connection con = DBConnect.getConnection();
				PreparedStatement st;

				try
					{
						st = con.prepareStatement("INSERT INTO Product (brand,model,price,description, del) VALUES (?,?,?,?,0)"); // creates Statement object allowing us to send SQL Statements
						st.setString(1, brand);
						st.setString(2, model);
						st.setInt(3, price);
						st.setString(4, description);
						st.executeUpdate();

						Popup.information("Success");

					} catch (SQLException ex) // catch exception, display error in terminal
					{
						Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
						Popup.information("Error");
					}
			}

		public static void EditProduct(int id, String brand, String model, int price, String description)
			{
				Connection con = DBConnect.getConnection();
				PreparedStatement st;

				try
					{
						st = con.prepareStatement("UPDATE Product SET brand = ?, model = ?, price = ?, description = ? WHERE id = " + id + ";"); // creates Statement object allowing us to send SQL Statements
						st.setString(1, brand);
						st.setString(2, model);
						st.setInt(3, price);
						st.setString(4, description);
						st.executeUpdate();

						Popup.information("Success");

					} catch (SQLException ex) // catch exception, display error in terminal
					{
						Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
						Popup.information("Error");
					}
			}

		public static void DeleteProduct(String object)
			{
				Connection con = DBConnect.getConnection();
				PreparedStatement st;

				try
					{
						st = con.prepareStatement("UPDATE Product SET del = ? WHERE id = " + Integer.parseInt(object) + ";"); // creates Statement object allowing us to send SQL Statements
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
