
package product;

public class ProductData
	{
		public static Object[] productData()
			{

				Object[] productData = new Object[5];

				for (int i = 0; i < ProductArray.getProduct().size(); i++)
					{

						productData[0] = ProductArray.getProduct().get(i).getId();
						productData[1] = ProductArray.getProduct().get(i).getBrand();
						productData[2] = ProductArray.getProduct().get(i).getModel();
						productData[3] = ProductArray.getProduct().get(i).getPrice();
						productData[4] = ProductArray.getProduct().get(i).getDescription();
					}
				return productData;
			}
	}
