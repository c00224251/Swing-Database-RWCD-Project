package invoice;

import java.util.Date;

public class InvoiceValues
	{
		private int id;
		private int customerId;
		private int productId;
		Date date = new Date();
		private int price;

		protected InvoiceValues(int id, int customerId, int productId, Date date, int price)
			{
				this.id = id;
				this.customerId = customerId;
				this.productId = productId;
				this.date = date;
				this.price = price;
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

		protected Date getDate()
			{
				return date;
			}

		protected int getPrice()
			{
				return price;
			}

	}
