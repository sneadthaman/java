
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 *
 * @author Jennifer Smith
 */
public class worldCampus extends JPanel implements ActionListener
{
    //Global variables
    JButton b1, b2, b3, score, back, option;
    JLabel jl1, jl2, jl3, title, directions, choose, gameOver, develop;
    
    ImageIcon tc1, tc1b, tc2, tc2b, tc3, tc3b; 
    
    int i = 0, t = 0;
    
    JTextArea message;
        
    Timer counter;
    
    public worldCampus()
        {
            super();
            setLayout(null);
            setBackground(Color.PINK); 
            
            //images
            tc1 = new ImageIcon("images/treasureChest1.jpg");
            tc1b = new ImageIcon("images/treasureChest1b.jpg");
            tc2 = new ImageIcon("images/treasureChest2.jpg");
            tc2b = new ImageIcon("images/treasureChest2b.jpg");
            tc3 = new ImageIcon("images/treasureChest3.jpg");
            tc3b = new ImageIcon("images/treasureChest3b.jpg");
            
            //buttons
            b1 = new JButton(tc1);
            b1.setBounds(150, 300, 200,200);
            b1.addActionListener(this);
            add(b1);
            
            b2 = new JButton(tc2);
            b2.setBounds(400, 300, 200,200);
            b2.addActionListener(this);
            add(b2);
            
            b3 = new JButton(tc3);
            b3.setBounds(650, 300, 200,200);
            b3.addActionListener(this);
            add(b3);
            
            //score
            score = new JButton("Score = "+i);
            score.setBounds(20,100,100,75);
            add(score);
            
            back = new JButton("Back");
            back.setBounds(20, 20, 100, 75);
            add(back);
            
            //title
            title = new JLabel("Welcome to World Campus BONUS ROUND ");
            title.setBounds(200,20,250,100);
            add(title);
            
            //seconds 
            counter = new Timer(1000, this);
            counter.start();
        
            //display seconds played
            message = new JTextArea();
            message.setBounds(20,200, 75,25);
            add(message);
            
            //directions
            directions = new JLabel("Select a Chest to receive bouns points");
            directions.setBounds(350, 100, 250, 100);
            add(directions);
            
            jl1 = new JLabel("Chest One");
            jl1.setBounds(150, 250, 200, 75);
            add(jl1);
            
            jl2 = new JLabel("Chest Two");
            jl2.setBounds(400, 250, 100, 75);
            add(jl2);
            
            jl3 = new JLabel("Chest Three");
            jl3.setBounds(650, 250, 100, 75);
            add(jl3);
            
        }
    //action to open chest
    @Override
    public void actionPerformed(ActionEvent e)
    {
       Object obj = e.getSource();
       if (obj == b1)
       {
           b1.setIcon(tc1b);
           jl1.setText("You received " +i+ " bonus points");   
           i= (int) (Math.random()*10);
           
           score.setText("Score = "+i);
           endGame();
       }
       
       else if (obj == b2)
       {
           b2.setIcon(tc2b);
           
           jl1.setText("You received " +i+ " bonus points");   
           i= (int) (Math.random()*20);
            score.setText("Score = "+ i);
            endGame();
       }
       
       else if (obj == b3)
       {
           b3.setIcon(tc3b);
           jl1.setText("You received " +i+ " bonus points");   
           i= (int) (Math.random()*50);
            score.setText("Score = "+i);
            endGame();
       }
       if (obj == counter)
		{
                    
                    t = t+1;
                    message.setText("Seconds "+t);
                        
		}
       
    }
    
    //add game over
     public void endGame()
    {
        
        this.setBackground(Color.black);
        gameOver = new JLabel("You Received " + i + " Bonus Points! Game Over");
        gameOver.setFont(new Font("New Roman Times", Font.BOLD, 20));
        gameOver.setForeground(Color.GREEN);
        gameOver.setBounds(250,50,750, 300);
        add(gameOver);
        counter.stop();
        develop = new JLabel();
        develop.setText("Game developed by Jennifer Smith, Sam Janvey, and Ifedunni Segun-Abugan");
        develop.setFont(new Font("New Roman Times", Font.ITALIC, 18));
        develop.setForeground(Color.green);
        develop.setBounds(50,450,750,300);
        add(develop);
    }
    
    
}
