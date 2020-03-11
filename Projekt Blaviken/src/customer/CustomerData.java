package customer;

public class CustomerData
	{
		public static Object[][] customerData()
			{

				Object[][] customerData = new Object[CustomerArray.getCustomer().size()][6];

				for (int i = 0; i < CustomerArray.getCustomer().size(); i++)
					{

						customerData[i][0] = CustomerArray.getCustomer().get(i).getId();
						customerData[i][1] = CustomerArray.getCustomer().get(i).getFname();
						customerData[i][2] = CustomerArray.getCustomer().get(i).getLname();
						customerData[i][3] = CustomerArray.getCustomer().get(i).getNumber();
						customerData[i][4] = CustomerArray.getCustomer().get(i).getEmail();
						customerData[i][5] = CustomerArray.getCustomer().get(i).getAddress();
					}
				return customerData;
			}
	}
