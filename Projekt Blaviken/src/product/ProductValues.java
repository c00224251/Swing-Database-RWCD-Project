package product;


public class ProductValues
	{
		private int id;
		private String brand;
		private String model;
		private int price;
		private String description;


		protected ProductValues(int id, String brand, String model, int price, String description)
			{
				this.id = id;
				this.brand = brand;
				this.model = model;
				this.price = price;
				this.description = description;
			}


		protected int getId()
			{
				return id;
			}


		protected String getBrand()
			{
				return brand;
			}


		protected String getModel()
			{
				return model;
			}


		protected int getPrice()
			{
				return price;
			}


		protected String getDescription()
			{
				return description;
			}

		

	}
