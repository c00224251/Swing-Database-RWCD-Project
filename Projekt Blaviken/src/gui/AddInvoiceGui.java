package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import invoice.Invoice;

@SuppressWarnings("serial")
public class AddInvoiceGui extends JFrame
	{

		private JPanel contentPane;
		private JComboBox<Object> comboBox;
		private JComboBox<Object> comboBox_1;
		private JTextField textField_2;
		private JTextField textField_3;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args)
			{
				EventQueue.invokeLater(new Runnable()
					{
						public void run()
							{
								try
									{
										AddInvoiceGui frame = new AddInvoiceGui();
										frame.setVisible(true);
									} catch (Exception e)
									{
										e.printStackTrace();
									}
							}
					});
			}

		/**
		 * Create the frame.
		 */
		public AddInvoiceGui()
			{
				setBounds(100, 100, 450, 300);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);

				JLabel lblNewLabel = new JLabel("CustomerID");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblNewLabel.setBounds(100, 20, 70, 14);
				contentPane.add(lblNewLabel);

				JLabel lblNewLabel_1 = new JLabel("ProductID");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblNewLabel_1.setBounds(100, 60, 60, 14);
				contentPane.add(lblNewLabel_1);

				JLabel lblNewLabel_2 = new JLabel("Price");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblNewLabel_2.setBounds(100, 100, 60, 14);
				contentPane.add(lblNewLabel_2);

				JLabel lblNewLabel_3 = new JLabel("Date");
				lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblNewLabel_3.setBounds(100, 140, 60, 14);
				contentPane.add(lblNewLabel_3);

				JButton btnNewButton = new JButton("Add");
				btnNewButton.setBounds(112, 227, 89, 23);
				btnNewButton.addActionListener(new ActionListener()

					{

						public void actionPerformed(ActionEvent e)
							{
								Invoice.AddInvoice(
													Integer.parseInt(comboBox.getSelectedItem().toString()), 
													Integer.parseInt(comboBox_1.getSelectedItem().toString()), 
													Integer.parseInt(textField_2.getText()), 
													textField_3.getText()
												  );
								setVisible(false);
							}
					});
				contentPane.add(btnNewButton);

				JButton btnNewButton_1 = new JButton("Cancel");
				btnNewButton_1.setBounds(222, 227, 89, 23);
				contentPane.add(btnNewButton_1);

				btnNewButton_1.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
							{
								setVisible(false);
							}
					});

				comboBox = new JComboBox<Object>();
				comboBox.setBounds(225, 20, 86, 20);
				contentPane.add(comboBox);

				comboBox_1 = new JComboBox<Object>();
				comboBox_1.setBounds(225, 60, 86, 20);
				contentPane.add(comboBox_1);

				for (int i = 0; i < Gui.customers.getRowCount(); i++)
					{
						comboBox.addItem(Gui.customers.getModel().getValueAt(i, 0));
					}
				for (int i = 0; i < Gui.products.getRowCount(); i++)
					{
						comboBox_1.addItem(Gui.products.getModel().getValueAt(i, 0));
					}
				textField_2 = new JTextField();
				textField_2.setBounds(225, 100, 86, 20);
				contentPane.add(textField_2);
				textField_2.setColumns(10);

				textField_3 = new JTextField();
				textField_3.setBounds(225, 140, 86, 20);
				contentPane.add(textField_3);
				textField_3.setColumns(10);
			}

	}
