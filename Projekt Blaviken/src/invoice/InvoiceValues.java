package invoice;

import java.util.Date;

public class InvoiceValues
	{
		private int id;
		private int customerId;
		private int productId;
		private String date;
		private int price;

		protected InvoiceValues(int id, int customerId, int productId, int price, String date)
			{
				this.id = id;
				this.customerId = customerId;
				this.productId = productId;
				this.price = price;
				this.date = date;
			}

		protected int getId()
			{
				return id;
			}

		protected int getCustomerId()
			{
				return customerId;
			}

		protected int getProductId()
			{
				return productId;
			}

		protected String getDate()
			{
				return date;
			}

		protected int getPrice()
			{
				return price;
			}

		protected void setId(int id)
			{
				this.id = id;
			}

		protected void setCustomerId(int customerId)
			{
				this.customerId = customerId;
			}

		protected void setProductId(int productId)
			{
				this.productId = productId;
			}

		protected void setDate(String date)
			{
				this.date = date;
			}

		protected void setPrice(int price)
			{
				this.price = price;
			}

	}
