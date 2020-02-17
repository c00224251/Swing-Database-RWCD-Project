package WIP;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class test1table
	{
		public static void main(String[] args)
			{

				JTable table = new JTable();

				DefaultTableModel model = new DefaultTableModel();

				Object[] columnsName = new Object[4];

				columnsName[0] = "Id";
				columnsName[1] = "Fname";
				columnsName[2] = "Lname";
				columnsName[3] = "Number";

				model.setColumnIdentifiers(columnsName);

				Object[] rowData = new Object[4];

				for (int i = 0; i < test1dbarraylist.getCustomer().size(); i++)
					{

						rowData[0] = test1dbarraylist.getCustomer().get(i).getId();
						rowData[1] = test1dbarraylist.getCustomer().get(i).getFname();
						rowData[2] = test1dbarraylist.getCustomer().get(i).getLname();
						rowData[3] = test1dbarraylist.getCustomer().get(i).getNumber();

						model.addRow(rowData);
					}

				table.setModel(model);

				System.out.println(test1dbarraylist.getCustomer().size());

				test1app window = new test1app();

				JPanel panel = new JPanel();

				panel.setLayout(new BorderLayout());

				JScrollPane pane = new JScrollPane(table);

				panel.add(pane, BorderLayout.CENTER);

				window.setContentPane(panel);
			}
	}
