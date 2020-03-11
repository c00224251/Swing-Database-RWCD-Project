
package invoice;

public class InvoiceData
	{
		public static Object[][] invoiceData()
			{

				Object[][] invoiceData = new Object[InvoiceArray.getInvoice().size()][5];

				for (int i = 0; i < InvoiceArray.getInvoice().size(); i++)
					{

						invoiceData[i][0] = InvoiceArray.getInvoice().get(i).getId();
						invoiceData[i][1] = InvoiceArray.getInvoice().get(i).getCustomerId();
						invoiceData[i][2] = InvoiceArray.getInvoice().get(i).getProductId();
						invoiceData[i][3] = InvoiceArray.getInvoice().get(i).getDate();
						invoiceData[i][4] = InvoiceArray.getInvoice().get(i).getPrice();
					}
				return invoiceData;
			}
	}
