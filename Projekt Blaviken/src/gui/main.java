package gui;
//package gui;

//import gui.Popup;

/*

    By:             

    Date Started:   17/01/2020
    Date Ended:     []/02/2020

 */
public class main
	{
public class main {

	public static void main(String[] args) {

		public static void main(String[] args)
			{
				Gui.createGui();
			}// -------------------------------------------------------------------end main
		try {
			Gui.createGui();
		} catch (Exception exp) {
			Popup.error("Gui failed to load:\n" + exp.toString());
		}
	}// -------------------------------------------------------------------end main

}// end class