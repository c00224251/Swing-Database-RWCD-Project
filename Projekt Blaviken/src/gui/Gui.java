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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import customer.CustomerData;
import invoice.InvoiceData;
import product.ProductData;

// import customer.CustomerData;
// import invoice.InvoiceData;
// import product.ProductData;

class Gui implements ActionListener
	{

		JPanel cards; // a panel that uses CardLayout
		// public static Connection connection = Connector.getConnection();
		// Main Stuff to Edit
		final static String projectName = "CA3 Project";
		final static int[] minDimension = { 500, 200 };
		final static String[] mainMenu = { "Main Menu", "Customer", "Product", "Invoice" };
		final static String[] buttons = { "Add", "Delete", "Edit" };
		final static Color color1 = new Color(100, 50, 10); // Set Color of all things
		final static Color color2 = new Color(255, 255, 255); // Set Color of all things
		final static Color color3 = new Color(50, 20, 10); // Set Color of all things
		static JTable customers;
		static JTable products;
		static JTable invoices;

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
		
		private void initContent() 
		{
			Object[] customersColumns = { "ID", "First Name", "Last Name", "Phone Number", "Email", "Address" };
			Object[][] customerData = CustomerData.customerData();
			Object[] productsColumns = { "ID", "Brand", "Model", "Price", "Description" };
			Object[][] productData = ProductData.productData();
			Object[] invoicesColumns = { "ID", "Customer ID", "Product ID", "Date", "Price" };
			Object[][] invoiceData = InvoiceData.invoiceData();

			customers = new JTable(customerData, customersColumns);
			products = new JTable(productData, productsColumns)
				{
					public boolean isCellEditable(int row, int column)
						{
							return false;
						}
				};
			invoices = new JTable(invoiceData, invoicesColumns)
				{
					public boolean isCellEditable(int row, int column)
						{
							return false;
						}
				};

			customers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			products.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			invoices.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			customers.setRowSelectionAllowed(true);
			customers.setSelectionBackground(Color.pink);
			

			
			customers.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					System.out.println(customers.getSelectedRow());
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}});
			/*customers.addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent e)
						{
							System.out.println(customers.getSelectedRow());
						}

				});*/
		
			
			products.addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent e)
						{
							System.out.println(products.getSelectedRow());
						}

				});
		}

		private JPanel addContent(JPanel panel, int i)
			{

				// // Creating a Table

			

				panel.setBackground(color2);
				if (i == 0)
					{ // Home Page

						panel.setLayout(new GridLayout());
						panel.add(new JLabel("Hello to our new Project"));

					}
				if (i == 1)
					{ // Customers
						JScrollPane pane = new JScrollPane(customers);
						pane.revalidate();
						pane.repaint();
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
				initContent();
				for (int i = 0; i < 3; i++)
				{
						JPanel mainPanel = new JPanel();
						mainPanel = addContent(mainPanel, i);
						cards.add(mainPanel, mainMenu[i]);
				}

				pane.add(panel, BorderLayout.PAGE_START);
				pane.add(cards, BorderLayout.CENTER);
			}

		public static void createGui()
			{

				JFrame frame = new JFrame(projectName);// Create A frame
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Terminate the program completely on close
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);// Start maximized
				// frame.setIconImage(image);

				// Create and set up the content pane.
				Gui demo = new Gui(); // Start the page
				demo.createScenes(frame.getContentPane());

				frame.setMinimumSize(new Dimension(minDimension[0], minDimension[1]));
				frame.setVisible(true);
			}

		@Override
		public void actionPerformed(ActionEvent e)
			{
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, e.getActionCommand());

				String buttonLabel = e.getActionCommand();
				if (buttonLabel.equals("Add Customer"))
					{
						AddCustomerGui addCustomer = new AddCustomerGui();
						addCustomer.setVisible(true);
					} else if (buttonLabel.equals("Delete Customer"))
					{
						Popup.information("Works!");
					} else if (buttonLabel.equals("Edit Customer"))
					{
						EditCustomerGui editCustomer = new EditCustomerGui(customers.getSelectedRow());
						editCustomer.setVisible(true);
					} else if (buttonLabel.equals("Delete Product"))
					{
						Popup.information("Works!");
					} else if (buttonLabel.equals("Edit Product"))
					{
						Popup.information("Works!");
					} else if (buttonLabel.equals("Add Product"))
					{
						Popup.information("Works!");
					} else if (buttonLabel.equals("Add Invoice"))
					{
						Popup.information("Works!");
					} else if (buttonLabel.equals("Delete Invoice"))
					{
						Popup.information("Works!");
					} else if (buttonLabel.equals("Edit Invoice"))
					{
						Popup.information("Works!");
					}
			}

	}