package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class menu extends JFrame
	{
		public menu()
			{
				JTable table = new JTable();
				setSize(700, 700);
				setTitle("czrne chuje brzydko pachna");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				new BorderLayout();

				JPanel tableMenu = new JPanel(new FlowLayout());
				add(new JScrollPane(table), BorderLayout.CENTER);

				add(tableMenu, BorderLayout.PAGE_START);
				JButton customerButton = new JButton("Customer");
				JButton productButton = new JButton("Product");
				JButton invoiceButton = new JButton("Invoice");
				tableMenu.add(customerButton);
				tableMenu.add(productButton);
				tableMenu.add(invoiceButton);

				JPanel tableOperations = new JPanel(new FlowLayout());
				add(tableOperations, BorderLayout.PAGE_END);
				JButton add = new JButton("ADD");
				JButton edit = new JButton("EDIT");
				JButton delete = new JButton("DELETE");
				tableOperations.add(add);
				tableOperations.add(edit);
				tableOperations.add(delete);
				setVisible(true);
			}
	}
