import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author sjanv
 */

public class startPanel extends JPanel implements ActionListener, ChangeListener
{
    JButton start, boyButton, girlButton, backButton;
    player play1, play2;
    JLabel bg, boy, girl, choose;
    int random, boySelect = 1, girlSelect = 0;
    ImageIcon luke, liz;
    
    public startPanel()
    {
            super();
            
            setLayout(null);
            setBackground(Color.white);
            
            luke = new ImageIcon("images/boy.png");
            liz = new ImageIcon("images/girl.png");
            start = new JButton("Click to Start");
            boyButton = new JButton("Boy");
            girlButton = new JButton("Girl");
            backButton = new JButton("Back to Main Menu");

            this.boy = new JLabel(luke);
            girl = new JLabel(liz);
            this.add(boy);
            add(start);
            add(girl);
            add(boyButton);
            add(girlButton);
            add(backButton);
            backButton.setBounds(new Rectangle(35,40,150,40));
            start.setBounds(new Rectangle(400, 25, 250, 75));
            this.boy.setBounds(500, 150, 600, 450);
            girl.setBounds(500, 150, 600, 450);
            choose = new JLabel("Choose Your Player");
            add(choose);
            choose.setBounds(50,200,250,50);
            choose.setFont(new Font("Courier New", Font.BOLD, 16));
            this.boy.setVisible(true);
            girl.setVisible(false);
            boyButton.setBounds(35,335,100,100);
            girlButton.setBounds(200,335,100,100);
            boyButton.addActionListener(this);
            girlButton.addActionListener(this);
    }
        
//        @Override
//        public void paint(Graphics g)
//        {
//            super.paint(g);
//            g.drawImage(background, 0, 0, null);
//        }
        
        public void actionPerformed(ActionEvent ae)
        {
            Object obj = ae.getSource();
            if (obj == boyButton)
            {
                boy.setVisible(true);
                girl.setVisible(false);
                boySelect = 1;
                girlSelect = 0;
                customBoyCursor();
                
            }
            
            if (obj == girlButton)
            {
                boy.setVisible(false);
                girl.setVisible(true);
                boySelect = 0;
                girlSelect = 1;
                customGirlCursor();
            }
        }

        
        public void stateChanged(ChangeEvent e)
        {
            
        }
        
        // Our handy random number gen which can be modified

        public int randomPosition()
        {
            int myRandom;
            double r = Math.random();
            myRandom = (int) (r * random);
            
            return myRandom;
        }
        
         public void customBoyCursor() 
    {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image boy = toolkit.getImage("images/boy.png");
        Point point = new Point(0, 0);
        Cursor cursor = toolkit.createCustomCursor(boy, point, "Cursor");
        setCursor(cursor);

    }
         
         public void customGirlCursor() 
    {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image girl = toolkit.getImage("images/girl.png");
        Point point = new Point(0, 0);
        Cursor cursor = toolkit.createCustomCursor(girl, point, "Cursor");
        setCursor(cursor);

    }

}

