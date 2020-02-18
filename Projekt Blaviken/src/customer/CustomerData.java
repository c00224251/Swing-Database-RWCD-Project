package customer;

public class CustomerData
	{
		public static Object[] customerData()
			{

				Object[] customerData = new Object[6];

				for (int i = 0; i < CustomerArray.getCustomer().size(); i++)
					{

						customerData[0] = CustomerArray.getCustomer().get(i).getId();
						customerData[1] = CustomerArray.getCustomer().get(i).getFname();
						customerData[2] = CustomerArray.getCustomer().get(i).getLname();
						customerData[3] = CustomerArray.getCustomer().get(i).getNumber();
						customerData[4] = CustomerArray.getCustomer().get(i).getEmail();
						customerData[5] = CustomerArray.getCustomer().get(i).getAddress();
					}
				return customerData;
			}
	}
