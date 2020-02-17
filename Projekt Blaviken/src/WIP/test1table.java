package WIP;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class test1table
	{
		public static Object[] customerData()
			{
				
				Object[] columnsName = new Object[4];

				columnsName[0] = "Id";
				columnsName[1] = "Fname";
				columnsName[2] = "Lname";
				columnsName[3] = "Number";

				Object[] rowData = new Object[4];

				for (int i = 0; i < test1dbarraylist.getCustomer().size(); i++)
					{

						rowData[0] = test1dbarraylist.getCustomer().get(i).getId();
						rowData[1] = test1dbarraylist.getCustomer().get(i).getFname();
						rowData[2] = test1dbarraylist.getCustomer().get(i).getLname();
						rowData[3] = test1dbarraylist.getCustomer().get(i).getNumber();

					}
				return rowData;
			}
	}
