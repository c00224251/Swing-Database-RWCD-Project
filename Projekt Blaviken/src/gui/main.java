package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import customer.CustomerData;
import invoice.InvoiceData;
import product.ProductData;

/*

    By:             

    Date Started:   17/01/2020
    Date Ended:     []/02/2020

 */
public class main implements ActionListener
	{
		JPanel cards; // a panel that uses CardLayout
		// Main Stuff to Edit
		final static String projectName = "name";
		final static int[] minDimension = { 1000, 700 };
		final static String[] mainMenu = { "Main Menu", "Customer", "Product", "Invoice" };
		final static String[] buttons = { "Add", "Delete", "Edit" };
		final static Color color1 = Color.blue; // Set Color of all things
		final static Color color2 = Color.red; // Set Color of all things
		final static Color color3 = Color.yellow; // Set Color of all things

		// public static Connection connection = Connector.getConnection();

		public static void main(String[] args)
			{

				// Michals connection
				// PreparedStatement pstm = null;
				// String SQL = "INSERT INTO customer(firstName, secondName, phoneNo,
				// email,address) VALUES (?,?,?,?,?)";

				// try {
				// connection.setAutoCommit(false);
				// pstm = (PreparedStatement) connection.prepareStatement(SQL);
				// pstm.setString(1, "John");
				// pstm.setString(2, "Doe");
				// pstm.setInt(3, 91282193);
				// pstm.setString(4, "John.doe@gmail.com");
				// pstm.setString(5, "1 main street");
				// connection.commit();

				// } catch (SQLException e) {
				// e.getMessage();
				// } finally {

				// try {
				// // pstm.close();
				// connection.setAutoCommit(true);
				// connection.close();
				// } catch (SQLException ex) {
				// System.out.println(ex.getMessage());
				// }
				// }
				createGui();
			}// -------------------------------------------------------------------end main

		private JPanel addButtons(JPanel panel, String name)
			{

				for (int i = 0; i < buttons.length; i++)
					{
						JButton button = new JButton(buttons[i] + " " + name);
						button.addActionListener(this);
						panel.setBackground(color3);
						panel.add(button);
					}

				return panel;
			}

		private JPanel addContent(JPanel panel, int i)
			{

				// Creating a Table
				String[] customersColumns = { "ID", "First Name", "Last Name", "Phone Number", "Email", "Address" };
				Object[] customersData = CustomerData.customerData();
				String[] productsColumns = { "ID", "Brand", "Model", "Price", "Description" };
				Object[] productsData = ProductData.productData();
				String[] invoiceColumns = { "ID", "Customer ID", "Product ID", "Date", "Price" };
				Object[] invoiceData = InvoiceData.invoiceData();

				DefaultTableModel customerTable = new DefaultTableModel(customersColumns, 0);
				customerTable.addRow(customersData);
				DefaultTableModel productTable = new DefaultTableModel(productsColumns, 0);
				productTable.addRow(productsData);
				DefaultTableModel invoiceTable = new DefaultTableModel(invoiceColumns, 0);
				invoiceTable.addRow(invoiceData);

				JTable customers = new JTable(customerTable);
				JTable products = new JTable(productTable);
				JTable invoices = new JTable(invoiceTable);

				panel.setBackground(color2);
				if (i == 0)
					{ // Home Page

						panel.setLayout(new GridLayout());
						panel.add(new JLabel("Hello to our new Project"));

					}
				if (i == 1)
					{ // Customers
						JScrollPane pane = new JScrollPane(customers);
						pane.setBackground(color3);
						JPanel options = new JPanel();
						options = addButtons(options, "Customer");
						panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
						panel.add(pane, BorderLayout.CENTER);
						panel.add(options, BorderLayout.PAGE_END);
					}
				if (i == 2)
					{ // Products
						JScrollPane pane = new JScrollPane(products);
						pane.setBackground(color3);
						JPanel options = new JPanel();
						options = addButtons(options, "Product");

						panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
						panel.add(pane, BorderLayout.CENTER);
						panel.add(options, BorderLayout.PAGE_END);
					}
				if (i == 3)
					{ // Invoices
						JScrollPane pane = new JScrollPane(invoices);
						pane.setBackground(color3);
						JPanel options = new JPanel();
						options = addButtons(options, "Invoice");

						panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
						panel.add(pane, BorderLayout.CENTER);
						panel.add(options, BorderLayout.PAGE_END);

					}

				return panel;
			}

		private void createScenes(Container pane)
			{

				JPanel panel = new JPanel();
				panel.setLayout(new FlowLayout());
				for (int i = 0; i < mainMenu.length; i++)
					{
						JButton button = new JButton(mainMenu[i]);
						button.addActionListener(this);
						panel.setBackground(color1);
						panel.add(button, BorderLayout.PAGE_START);
					}
				cards = new JPanel(new CardLayout());
				for (int i = 0; i < mainMenu.length; i++)
					{
						JPanel mainPanel = new JPanel();
						mainPanel = addContent(mainPanel, i);
						cards.add(mainPanel, mainMenu[i]);
					}

				pane.add(panel, BorderLayout.PAGE_START);
				pane.add(cards, BorderLayout.CENTER);
			}

		private static void createGui()
			{

				JFrame frame = new JFrame(projectName);// Create A frame
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Terminate the program completely on close
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);// Start maximized
				// frame.setIconImage(image);

				// Create and set up the content pane.
				main demo = new main(); // Start the page
				demo.createScenes(frame.getContentPane());

				frame.setMinimumSize(new Dimension(minDimension[0], minDimension[1]));
				frame.setVisible(true);
			}

		@Override
		public void actionPerformed(ActionEvent e)
			{
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, e.getActionCommand());

			}

	}// end class

// public class Driver {

// public static Connection connection = Connector.getConnection();

// public static void main(String[] args) {
// // TODO Auto-generated method stub

// PreparedStatement pstm = null;
// String SQL = "INSERT INTO customer(firstName, secondName, phoneNo, email,
// address) VALUES (?,?,?,?,?)";

// try {
// connection.setAutoCommit(false);
// pstm = (PreparedStatement) connection.prepareStatement(SQL);
// pstm.setString(1, "John");
// pstm.setString(2, "Doe");
// pstm.setInt(3, 91282193);
// pstm.setString(4, "John.doe@gmail.com");
// pstm.setString(5, "1 main street");
// connection.commit();

// } catch (SQLException e) {
// e.getMessage();
// } finally {

// try {
// // pstm.close();
// connection.setAutoCommit(true);
// connection.close();
// } catch (SQLException ex) {
// System.out.println(ex.getMessage());
// }
// }

// }

// }