//package gui;

/**

    This will be here to Create scenes and if needed delete them


 */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
//import javax.swing.border.*;

public class Body extends JFrame{

    /**
     *                          ONLY UPDATE THESE 3 ARRAYS TO CHANGE THE LAYOUT
     */
    private static final long serialVersionUID = 1L;
    private String[] mainMenu = { "Customers", "Invoice", "Product" };
    private String[][] dataBase = {{"Name","ID","Date","SomeShit"},{},{}};
    private String[][] subOptions = {{"Add","Dell","Edit"},{"Read","This","Thing"},{"Done"}};



    public Body(String title) {
        super(title);
        
        getContentPane().setBackground(new Color(107, 106, 104)); // Background
        setTitle("Projekt Z Blaviken");

        ButtonListiner listiner = new ButtonListiner(); // Listener class
        JTabbedPane tab = new JTabbedPane(); // Create a Tabbed Panel
        tab = tabPane(tab, listiner); //  Put Stuff into Tabbed Panel

        add(tab);
        //Add panels before Displaying
    }// end constructor
    
    //-------------------------------------------------------------------------------------------Print Tabbed Pane
    private JTabbedPane tabPane(JTabbedPane tabPanel, ButtonListiner listiner){//----------------Create Plates

        for(int i =0;i < mainMenu.length;i++){  //for the lenght of mainMenu
            JPanel panel = new JPanel();        //Create panels
            JPanel left = new JPanel();        //Create panels
            JPanel right = new JPanel();        //Create panels
            panel.setBackground(Color.green);
            left.setBackground(Color.red);
            right.setBackground(Color.blue);
            left.setLayout(new GridLayout(1,3));
            left.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5)); // Top Left Bottom Right
            left = input(left, dataBase,i);
            left = subMenuPanel(left, subOptions, listiner ,i);
            panel.setLayout(new GridLayout(1,2));
            panel.add(left);
            panel.add(right);
            tabPanel.add(panel,mainMenu[i]);
            System.out.println("eee");
        }
        return tabPanel;
    }
    //-------------------------------------------------------------------------------------------Print Panels   
    private JPanel input(JPanel panel, String[][] string, int ii){//-----------------------------Add Label and TextField
            for(int i=0;i<string[ii].length; i++) {
                JLabel label = new JLabel(string[ii][i] + ": ");
                label.setBackground(Color.white);
                panel.add(label);
                JTextField text = new JTextField("",10);
                text.setBackground(Color.white);
                panel.add(text);
            }
            return panel;
    }
    private JPanel subMenuPanel(JPanel panel, String[][] string,ButtonListiner listiner, int ii){

        panel.setLayout(new GridLayout(10,2));

        for(int i =0;i < string[ii].length;i++){
            JButton button = new JButton(string[ii][i]);
            button.setBackground(Color.white);
            button.setForeground(Color.blue);
            button.addActionListener(listiner);
            panel.add(button);
        }

        return panel;
    }
    //-------------------------------------------------------------------------------------------Button Listener
    class ButtonListiner implements ActionListener {

        public void actionPerformed(ActionEvent evt) {

            //String buttonLabel = evt.getActionCommand();

            //if (buttonLabel.equals("Customers")) {
                //frame.revalidate();
            //}
        }
    }
}// end class