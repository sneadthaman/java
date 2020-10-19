
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 *
 * by Ifedunni Segun-Abugan
 */
public class levelFive extends JPanel implements ActionListener, ChangeListener
{
    JButton score1, winner, winner2, back;
    student st1;
    JLabel jLabel1, startLabel, background;
    int score = 0, newScore, a, b, 
            limit, delay = 1000, halfDelay = 250, count, count2, random = 300, 
            difficult = 0;
    Timer timer, delTim;
    ImageIcon shrek1, shrek2;
    JSlider js1;
    Font myFont = new Font("Times New Roman", Font.BOLD, 24);
    ImageIcon backgroundIcon;
    
    private JButton startButton;
    final static int WIDTH = 100;
    final static int HEIGHT = 100;
    int x = 0, y = 25;
    int i = 0, t = 0;

    
	public levelFive()
	{
            super();
        setLayout(null);
        backgroundIcon = new ImageIcon("images/swamp.png");       
        
        back = new JButton("Back to Map");
        add(back);
        back.setBounds(800, 550, 130, 25);
        
        jLabel1 = new JLabel();
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setText("Welcome to Penn State Brandywine");
        jLabel1.setBounds(300,20, 525,72);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setVerticalAlignment(SwingConstants.CENTER);
        jLabel1.setFont(myFont);
        add(jLabel1);
             
        
            
            
            
           ImageIcon shrekIcon = new ImageIcon("images/shrek1.png");
           st1 = new student("click", "me", 4);
           st1.addActionListener(this);
            
           startButton = new JButton("START");
	    startButton.addActionListener(this);
            timer = new Timer(delay, this);
            delTim = new Timer(halfDelay, this);
            
            score1 = new JButton("score: " + score);
            score1 = new JButton("Score = " + i);
            score1.setBounds(800, 500, 130, 25);
            score1.addActionListener(this);
            add(score1);
            
            winner = new JButton("You Win!!");
            winner2 = new JButton("You Won on Expert Mode!"); // 
                                                              
            
            js1 = new JSlider(0,100,0);
            js1.setBorder(BorderFactory.createTitledBorder("Difficulty"));
            js1.setMinorTickSpacing(25);
            js1.setPaintTicks(true);
            js1.setPaintLabels(true);
            
            js1.addChangeListener(this);
            js1.setVisible(true);
            
//-------------------------------------------------------	    
// Create Images and add Buttons		
//-------------------------------------------------------
                
                shrek1 = new ImageIcon("images/shrek1.png");
                shrek2 = new ImageIcon("images/shrek2.jpeg");
                
		add(st1);
                add(startButton);
                add(winner);
                winner.setVisible(false);
                add(winner2);
                winner2.setVisible(false);
                
                st1.setBounds(new Rectangle(50,400,100,84));
                winner.setBounds(new Rectangle(450, 200, 250, 50));
                winner2.setBounds(new Rectangle(450, 200, 250, 50));
                startButton.setBounds(new Rectangle(300, 100, 350, 100));
                js1.setBounds(400, 500, 250, 100);
                add(js1);
                
                 background = new JLabel(backgroundIcon);
                 background.setBounds(0,0,1000,615);
                 add(background);
	}
        


        public void actionPerformed(ActionEvent ae)
        
        {
            Object obj = ae.getSource();
            
            if (obj == st1)
            {
                newScore = ++score;
                score1.setText("score: " + newScore);
                st1.setIcon(shrek2);
                random += 50;
                if (newScore == 10)
                {
                    if (difficult == 100)
                    {
                        winner2.setVisible(true);
                    }
                    else
                    {  
                    winner.setVisible(true);
                    }
                    timer.stop();
                    delTim.stop();
                }
            }
            // When the player clicks Start, the timers will start and the button will disappear
            
            if (obj == startButton)
            {         
                timer.start();
                delTim.start();
                startButton.setVisible(false);
            }
        

            
            if (obj == timer)
            {
                count++;
                startButton.setText("Counter: " + count);
                a = randomPosition();
                b = randomPosition();
                st1.setBounds(a, b, 100, 84);
                st1.setIcon(shrek1);
            
            }
           
                
        }
        
        // The difficulty slider will decrease the amount of delay for the timer
        // ---------------------------------------
        
        public void stateChanged(ChangeEvent e)
        {
            Object obj = e.getSource();
            if (obj == js1)
            {
                difficult = js1.getValue();
                if ((difficult >= 25) && (difficult < 50))
                {
                    timer.setDelay(900);
                }
                else if ((difficult >= 50) && (difficult < 75))
                {
                    timer.setDelay(700);
                }
                else if ((difficult >= 75) && (difficult < 100))
                {
                    timer.setDelay(500);
                }
                else if (difficult == 100)
                {
                    timer.setDelay(200);
                }
            }
        }
        
  
        public int randomPosition()
        {
            int myRandom;
            double r = Math.random();
            myRandom = (int) (r * random);
            
            return myRandom;
        }

}
