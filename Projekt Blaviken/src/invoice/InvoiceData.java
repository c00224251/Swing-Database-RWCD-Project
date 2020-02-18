
package invoice;

public class InvoiceData
	{
		public static Object[] invoiceData()
			{

				Object[] invoiceData = new Object[5];

				for (int i = 0; i < InvoiceArray.getInvoice().size(); i++)
					{

						invoiceData[0] = InvoiceArray.getInvoice().get(i).getId();
						invoiceData[1] = InvoiceArray.getInvoice().get(i).getCustomerId();
						invoiceData[2] = InvoiceArray.getInvoice().get(i).getProductId();
						invoiceData[3] = InvoiceArray.getInvoice().get(i).getDate();
						invoiceData[4] = InvoiceArray.getInvoice().get(i).getPrice();
					}
				return invoiceData;
			}
	}
