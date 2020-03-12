package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import customer.Customer;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class AddCustomerGui extends JFrame
	{

		private JPanel contentPane;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		private JTextField textField_3;
		private JTextField textField_4;
		int number = 0;

		/**
		 * Launch the application.
		 * 
		 * public static void main(String[] args) { EventQueue.invokeLater(new
		 * Runnable() { public void run() { try { AddCustomer frame = new AddCustomer();
		 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
		 * }
		 * 
		 * 
		 * Create the frame.
		 * 
		 * @return
		 */
		public AddCustomerGui()
			{
				setBounds(100, 100, 450, 300);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);

				JLabel lblNewLabel = new JLabel("First Name");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblNewLabel.setBounds(100, 20, 60, 14);
				contentPane.add(lblNewLabel);

				JLabel lblNewLabel_1 = new JLabel("Last Name");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblNewLabel_1.setBounds(100, 60, 60, 14);
				contentPane.add(lblNewLabel_1);

				JLabel lblNewLabel_2 = new JLabel("Phone No.");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblNewLabel_2.setBounds(100, 100, 60, 14);
				contentPane.add(lblNewLabel_2);

				JLabel lblNewLabel_3 = new JLabel("Email");
				lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblNewLabel_3.setBounds(100, 140, 60, 14);
				contentPane.add(lblNewLabel_3);

				JLabel lblNewLabel_4 = new JLabel("Address");
				lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblNewLabel_4.setBounds(100, 180, 60, 14);
				contentPane.add(lblNewLabel_4);

				JButton btnNewButton = new JButton("Add");
				btnNewButton.setBounds(112, 227, 89, 23);

				btnNewButton.addActionListener(new ActionListener()

					{

						public void actionPerformed(ActionEvent e)
							{
								Customer.AddCustomer
									(
										textField.getText(), 
										textField_1.getText(),
										Integer.parseInt(textField_2.getText()), 
										textField_3.getText(),
										textField_4.getText()
									);
								setVisible(false);
							}
					});
				contentPane.add(btnNewButton);

				JButton btnNewButton_1 = new JButton("Cancel");
				btnNewButton_1.setBounds(222, 227, 89, 23);
				btnNewButton_1.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
							{
								setVisible(false);
							}
					});
				contentPane.add(btnNewButton_1);

				textField = new JTextField();
				textField.setBounds(225, 20, 86, 20);
				contentPane.add(textField);
				textField.setColumns(10);

				textField_1 = new JTextField();
				textField_1.setBounds(225, 60, 86, 20);
				contentPane.add(textField_1);
				textField_1.setColumns(10);

				textField_2 = new JTextField();
				textField_2.setBounds(225, 100, 86, 20);
				contentPane.add(textField_2);
				textField_2.setColumns(10);

				textField_3 = new JTextField();
				textField_3.setBounds(225, 140, 86, 20);
				contentPane.add(textField_3);
				textField_3.setColumns(10);

				textField_4 = new JTextField();
				textField_4.setBounds(222, 180, 86, 20);
				contentPane.add(textField_4);
				textField_4.setColumns(10);
			}
	}
