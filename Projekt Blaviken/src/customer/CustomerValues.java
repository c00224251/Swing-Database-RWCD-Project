package customer;

public class CustomerValues
	{
		private int id;
		private String fname;
		private String lname;
		private int number;
		private String email;
		private String address;

		protected CustomerValues(int id, String fname, String lname, int number, String email, String address)
			{
				this.id = id;
				this.fname = fname;
				this.lname = lname;
				this.number = number;
				this.email = email;
				this.address = address;
			}

		protected int getId()
			{
				return id;
			}

		protected String getFname()
			{
				return fname;
			}

		protected String getLname()
			{
				return lname;
			}

		protected int getNumber()
			{
				return number;
			}

		protected String getEmail()
			{
				return email;
			}

		protected String getAddress()
			{
				return address;
			}

	}
