
package product;

public class ProductData
	{
		public static Object[][] productData()
			{

				Object[][] productData = new Object[ProductArray.getProduct().size()][5];

				for (int i = 0; i < ProductArray.getProduct().size(); i++)
					{

						productData[i][0] = ProductArray.getProduct().get(i).getId();
						productData[i][1] = ProductArray.getProduct().get(i).getBrand();
						productData[i][2] = ProductArray.getProduct().get(i).getModel();
						productData[i][3] = ProductArray.getProduct().get(i).getPrice();
						productData[i][4] = ProductArray.getProduct().get(i).getDescription();
					}
				return productData;
			}
	}
