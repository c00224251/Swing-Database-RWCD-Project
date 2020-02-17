package WIP;

public class test1customer
	{
		private int id;
		private String fname;
		private String lname;
		private int number;

		public test1customer(int id, String fname, String lname, int number)
			{
				this.id = id;
				this.fname = fname;
				this.lname = lname;
				this.number = number;
			}

		public int getId()
			{
				return id;
			}

		public String getFname()
			{
				return fname;
			}

		public String getLname()
			{
				return lname;
			}

		public int getNumber()
			{
				return number;
			}

	}
