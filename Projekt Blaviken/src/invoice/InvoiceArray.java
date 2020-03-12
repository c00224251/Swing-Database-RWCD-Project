
package invoice;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import db.DBConnect;
import gui.Driver;

public class InvoiceArray
	{
		protected static ArrayList<InvoiceValues> getInvoice() //creates an ArrayList for Product
			{
				ArrayList<InvoiceValues> invoice = new ArrayList<InvoiceValues>(); // initializes the ArrayList

				Connection con = DBConnect.getConnection(); //establish connection
				Statement st;
				ResultSet rs;
				InvoiceValues c;

				try
					{
						st = con.createStatement(); // creates Statement object allowing us to send SQL Statements
						rs = st.executeQuery("SELECT * FROM Invoice WHERE del = 0"); // Executes SQL Statement, returning ResultSet object(data returned by Statement)
						//ResultSet selects the data at position 0. SQL Tables begin at 1
						while (rs.next()) // moves to next row and retrieves the values
							{
								c = new InvoiceValues(
														rs.getInt("id"), 
														rs.getInt("customer_id"), 
														rs.getInt("product_id"),
														rs.getDate("date"),
														rs.getInt("price")
													 );
								invoice.add(c); //store data in the ArrayList
							}
					} catch (SQLException ex) //catch exception, display error in terminal
					{
						Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
					}
				return invoice;
			}
	}
