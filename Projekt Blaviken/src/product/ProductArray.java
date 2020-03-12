
package product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import db.DBConnect;
import gui.Driver;

public class ProductArray
	{
		protected static ArrayList<ProductValues> getProduct() //creates an ArrayList for Product
			{
				ArrayList<ProductValues> products = new ArrayList<ProductValues>(); // initializes the ArrayList

				Connection con = DBConnect.getConnection(); //establish connection
				Statement st;
				ResultSet rs;
				ProductValues c;

				try
					{
						st = con.createStatement(); // creates Statement object allowing us to send SQL Statements
						rs = st.executeQuery("SELECT * FROM Product WHERE del = 0"); // Executes SQL Statement, returning ResultSet object(data returned by Statement)
						//ResultSet selects the data at position 0. SQL Tables begin at 1
						while (rs.next()) // moves to next row and retrieves the values
							{
								c = new ProductValues(
														rs.getInt("id"), 
														rs.getString("brand"), 
														rs.getString("model"),
														rs.getInt("price"),
														rs.getString("description")
													 );
								products.add(c); //store data in the ArrayList
							}
					} catch (SQLException ex) //catch exception, display error in terminal
					{
						Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
					}
				return products;
			}
	}
