//package gui;

import javax.swing.JFrame;

/*

    By:             

    Date Started:   17/01/2020
    Date Ended:     []/02/2020

    []  To Do: []

    [[] -   Main
    {}  -   Create Body
    {}] -   Connect to the server
    [[] -   Log In
    {}  -   Add buttons
    {}  -   Add Text Fields
    {}  -   Add Labels
    {{} -   Methods:
    {}  -   Exit
    {}}]-   Log In Button
    [[] -   Main Page
    {}  -   
    ]


 */
public class main{

    public static void main(String[] args) {

        Body mainPage = new Body("Main Menu");
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.setSize(1000, 500);
        // mainPage.setIconImage(icon);
        mainPage.setVisible(true);

    }// end main

}// end class