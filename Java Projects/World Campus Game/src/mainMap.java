
/**
 *
 * @author Jennifer
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class mainMap extends JPanel implements ActionListener
{
    JLabel backgroundImage, worldCampus, directions;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;
    startPanel sp;
    
    
    ImageIcon pennsylvania, erie, beaver, altoona, harrisburg, bw, wc;
    
    public mainMap()
    {
        super();
        setLayout(null);
        
        
        pennsylvania = new ImageIcon("images/Pennsylvania.png");
        erie = new ImageIcon("images/psuErie.jpg");
        beaver = new ImageIcon("images/psuBeaver.jpg");
        altoona = new ImageIcon("images/psuAltoona.jpg");
        harrisburg = new ImageIcon("images/psuHarrisburg.png");
        bw = new ImageIcon("images/psuBrandywine.jpg");
        wc = new ImageIcon("images/psuWC.png");
        

       b1 = new JButton(erie);
       b1.setBounds(50,70, 210, 117);
       add(b1);
      
       
       b2 = new JButton(beaver);
       b2.setBounds(50,350, 210,118);
       add(b2);
       
       
       b3 = new JButton(altoona);
       b3.setBounds(250,300, 221,72);
       add(b3);
       
       
       
       b4 = new JButton(harrisburg);
       b4.setBounds(500,350, 221,72);
       add(b4);
       
       
       b5 = new JButton(bw);
       b5.setBounds(700,500,221,72);
       add(b5);
       
       
       b6 = new JButton(wc);
       b6.setBounds(600,100,221,72);
       add(b6);
       
       
       directions = new JLabel("Click on a Campus to Play a Game!");
       directions.setBounds(3,500,200,100);
       add(directions);
       
       backgroundImage = new JLabel(pennsylvania);
       backgroundImage.setBounds(0,0,1000,615);
       add(backgroundImage);
       
       sp = new startPanel();
       
       sp.boyButton.addActionListener(this);
       sp.girlButton.addActionListener(this);
       
  
       
    }
    @Override
     public void actionPerformed(ActionEvent ae)
     {
        Object obj = ae.getSource();
        if (obj == sp.boyButton)
        {
           sp.customBoyCursor();
        }
        if (obj == sp.girlButton)
        {
           sp.customGirlCursor();
           
        }
     }
     
//      public void customBoyCursor() 
//    {
//
//        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        Image boy = toolkit.getImage("images/boy.png");
//        Point point = new Point(0, 0);
//        Cursor boyCursor = toolkit.createCustomCursor(boy, point, "boyCursor");
//        this.setCursor(boyCursor);
//
//    }
//         
//       public void customGirlCursor() 
//    {
//
//        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        Image girl = toolkit.getImage("images/girl.png");
//        Point point = new Point(0, 0);
//        Cursor girlCursor = toolkit.createCustomCursor(girl, point, "girlCursor");
//        this.setCursor(girlCursor);
//
//    }

    
    
    
}

//
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Image;
//import java.awt.Toolkit;
//import javax.swing.JPanel;
//
///**
// *
// * @author sjanv (my original map design)
// */
//public class mainMap extends JPanel
//{
//    Image myImage, myImage2;
//    Graphics gg;
//    
//    public mainMap()
//    {
//        super();
//        setLayout(null);
//    }
//
//    @Override
//    public void paintComponent(Graphics g) 
//    {
//        super.paintComponent(g);
//        gg = g;
//        myImage = Toolkit.getDefaultToolkit().getImage("images/mapBoy.jpg");
//        myImage2 = Toolkit.getDefaultToolkit().getImage("images/mapGirl.jpg");
//        gg.drawImage(myImage, 0, 0, this);
//    }
//}
