import java.awt.Color;

import javax.swing.*;

public class GUIPractice {
    public static void main(String [] args) {
        JFrame frame = new JFrame();    //creates a new frame for your buttons
        //frame.setSize(d);               //sets the size of your frame (x,y)
        frame.setVisible(true);         //makes your frame show up  
        frame.setTitle("Weld Search");  //sets title for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//makes the program close when the X button is pressed
        //ImageIcon image = new ImageIcon("logo.png"); //creates icon
        //frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(Color.LIGHT_GRAY); //sets backgroun color
        //frame.getContentPane().setBackground(new Color(0,0,0)); //you can use RGB to make a new color
        //frame.getContentPane().setBackground(new Color(0x123456)); //change color using hex code



    }   

}
