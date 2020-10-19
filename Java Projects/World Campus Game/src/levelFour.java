/*
Programmed by Jennifer Smith
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.Timer;

public class levelFour extends JPanel implements ActionListener, MouseListener
{
    
        JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, back, easy, medium, hard, score, seconds;
        JLabel title, question1, question2, question3, question4, question5, background, option, gameOver;
        
        ImageIcon backgroundIcon;
       
        int i = 0;
        int t = 0;
        
        JTextArea message;
        
        Timer counter;
        
    public levelFour()
    {
        super();
        
        
        setLayout(null);
        backgroundIcon = new ImageIcon("images/qm.jpg");
        
        counter = new Timer(1000, this);
        counter.start();
        
        message = new JTextArea();
        message.setBounds(20,400, 75,25);
        add(message);
        
        back = new JButton("Back To Map");
        back.setBounds(20,20, 221,72);
        add(back);
        
        easy = new JButton("EASY");
        easy.setBounds(20,100, 221,72);
        easy.addActionListener(this);
        add(easy);
        
        medium = new JButton("MEDIUM");
        medium.setBounds(20,175, 221,72);
        medium.addActionListener(this);
        add(medium);
        
        hard = new JButton("HARD");
        hard.setBounds(20,250, 221,72);
        hard.addActionListener(this);
        add(hard);
        
        score = new JButton("Score is " +i);
        score.setBounds(20,325, 221,72);
        add(score);
        
        title = new JLabel("You have entered the Harrisburg PSU campus. QUIZ TIME");
        title.setForeground(Color.RED);
        title.setFont(new Font("New Roman Times", Font.BOLD, 15));
        title.setBounds(300,20, 525,72);
        add(title);
        
        
        option = new JLabel("Choose Easy, Meduim, or Hard to Start");
        option.setForeground(Color.RED);
        option.setFont(new Font("New Roman Times", Font.BOLD, 15));
        option.setBounds(300, 50, 350, 72);
        add(option);
        
        question1 = new JLabel("what will this question be?");
        question1.setForeground(Color.RED);
        question1.setFont(new Font("New Roman Times", Font.BOLD, 15));
        question1.setBounds(300,100, 550,72);
        add(question1);
        
        b1 = new JButton("True");
        b1.setBounds(300,150, 75,50);
        
        b2 = new JButton("false");
        b2.setBounds(400,150, 75,50);
        
        add(b1);
        add(b2);
        
        question2 = new JLabel("what will this question be?");
        question2.setForeground(Color.RED);
        question2.setFont(new Font("New Roman Times", Font.BOLD, 15));
        question2.setBounds(300,200, 550,72);
        add(question2);
        
        b3 = new JButton("True");
        b3.setBounds(300,250, 75,50);
        
        b4 = new JButton("false");
        b4.setBounds(400,250, 75,50);
        
        add(b3);
        add(b4);
        
        question3 = new JLabel("what will this question be?");
        question3.setForeground(Color.RED);
        question3.setFont(new Font("New Roman Times", Font.BOLD, 15));
        question3.setBounds(300,300, 550,72);
        add(question3);
        
        b5 = new JButton("True");
        b5.setBounds(300,350, 75,50);
        
        b6 = new JButton("false");
        b6.setBounds(400,350, 75,50);
        
        add(b5);
        add(b6);
        
        question4 = new JLabel("what will this question be?");
        question4.setForeground(Color.RED);
        question4.setFont(new Font("New Roman Times", Font.BOLD, 15));
        question4.setBounds(300,400, 550,72);
        add(question4);
        
        b7 = new JButton("True");
        b7.setBounds(300,450, 75,50);
        
        b8 = new JButton("false");
        b8.setBounds(400,450, 75,50);
        
        add(b7);
        add(b8);
        
        question5 = new JLabel("what will this question be?");
        question5.setForeground(Color.RED);
        question5.setFont(new Font("New Roman Times", Font.BOLD, 15));
        question5.setBounds(300,500, 550,72);
        add(question5);
        
        b9 = new JButton("True");
        b9.setBounds(300,550, 75,50);
        
        b10 = new JButton("false");
        b10.setBounds(400,550, 75,50);
        
        add(b9);
        add(b10);
        
        b1.addMouseListener(this);
        b2.addMouseListener(this);
        b3.addMouseListener(this);
        b4.addMouseListener(this);
        b5.addMouseListener(this);
        b6.addMouseListener(this);
        b7.addMouseListener(this);
        b8.addMouseListener(this);
        b9.addMouseListener(this);
        b10.addMouseListener(this);
        
        background = new JLabel(backgroundIcon);
        background.setBounds(0,0,1000,615);
        add(background);
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object obj = e.getSource();
        if (obj == easy)
        {
          question1.setText("You can attend Penn State no matter where you live. "); 
          question2.setText("Penn State is in Pennsylvania. ");
          question3.setText("Penn State's colors are blue and white. ");
          question4.setText("Penn State has a Panther mascot. ");
          question5.setText("We are Penn State. ");
          
        }
        else if (obj == medium)
        {
          question1.setText("You can take online classes at Penn State. "); 
          question2.setText("Penn State has 24 campuses in Pennsylvania. ");
          question3.setText("Penn State's original colors were pink and black. ");
          question4.setText("The Nittany Lion is the most photographed landmark in Pennsylvania. ");
          question5.setText("Beaver Statium holds 107,232 people. ");
          
        }
        
        else if (obj == hard)
        {
          question1.setText("The Berkey Creamery has been operational for more than 150 years. "); 
          question2.setText("Old Main was the first building built on campus. ");
          question3.setText("The WE ARE PENN STATE chant started in the 70's. ");
          question4.setText("Old Coaly is a lion. ");
          question5.setText("There is an unsolved murder that happened at Penn State. "); 
          
        }
       
       if (obj == counter)
		{
                    
                    t = t+1;
                    message.setText("Seconds "+t);
                        
		}
 
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        
        Object obj = e.getSource();
        if (obj == b1)
        {
            i++;
            System.out.println("Your Answer is Correct");
        }
        else if (obj == b3)
        {
            i++;
             System.out.println("Your Answer is Correct");
        }
        else if (obj == b5)
        {
            i++;
             System.out.println("Your Answer is Correct");
        }
        else if (obj == b8)
        {
            i++;
             System.out.println("Your Answer is Correct");
        }
        else if (obj == b9)
        {
            i++;
             System.out.println("Your Answer is Correct");
        }
        else
        {
            System.out.println("Your answer is incorrect. ");
        }
        
        if ( i == 5)
        {
            endGame();
        }
            score.setText("score is: " + i);
         
    }

    @Override
    public void mousePressed(MouseEvent e) {
      
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    //add game over
     public void endGame()
    {
        background.setVisible(false);
        this.setBackground(Color.black);
        gameOver = new JLabel("GAME OVER! Your Score is " + i);
        gameOver.setFont(new Font("New Roman Times", Font.BOLD, 20));
        gameOver.setForeground(Color.YELLOW);
        gameOver.setBounds(650,100,750, 300);
        add(gameOver);
        counter.stop();
        
    }
    
}
