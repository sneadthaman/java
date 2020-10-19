
/**
 *
 * @author Jennifer Smith
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.Cursor;

public class levelTwo extends JPanel implements ActionListener, MouseListener {

    // Global variables
    JButton f1, back, score, easy, medium, hard;

    //timers
    Timer timer, counter;
    
    //display seconds played
    JTextArea message;

    int x = 2, y = 1, xVel = 1, yVel = 2;
    int i = 0, t = 0;
    int WIN_WIDTH = 800;
    int WIN_HEIGHT = 600;
    int delay;

    ImageIcon fishIcon, waterIcon;

    JLabel background, directions, gameOver;

    public levelTwo() 
    {
        super();

        //set layout
        setLayout(null);
        this.setFocusable(true);

        //sets images
        fishIcon = new ImageIcon("images/fish.png");
        waterIcon = new ImageIcon("images/water.jpg");

        // add fish button with listeners 
        f1 = new JButton(fishIcon);
        f1.setBounds(350, 200, 75, 50);
        f1.addActionListener(this);
        f1.addMouseListener(this);
        add(f1);

        //add back button to get back to map
        back = new JButton("Back To Map");
        back.setBounds(50, 10, 150, 35);
        add(back);
        
        //options
        easy = new JButton("Easy");
        easy.setBounds(100, 50, 70, 30);
        easy.addActionListener(this);
        add(easy);
        
        medium = new JButton("Medium");
        medium.setBounds(170, 50, 80, 30);
        medium.addActionListener(this);
        add(medium);
        
        hard = new JButton("Hard");
        hard.setBounds(250, 50, 70, 30);
        hard.addActionListener(this);
        add(hard);

        // add score button
        score = new JButton("Score = " + i);
        score.setBounds(200, 10, 150, 35);
        score.addActionListener(this);
        add(score);

        // add directions
        directions = new JLabel("Click on the fish using the Penguin cursor");
        directions.setBounds(400, 2, 350, 75);
        add(directions);
        
        //area to display counter
        message = new JTextArea();
        message.setBounds(600,10, 75,25);
        add(message);
        
        //to count seconds game played
        counter = new Timer(1000, this);
        counter.start();

        // add background image
        background = new JLabel(waterIcon);
        background.setBounds(0, 0, 1000, 615);
        add(background);
        
        // call custom cursor method
        customCursor();

    }

    //to change the cursor to a penguin
    public void customCursor() 
    {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image penguin = toolkit.getImage("images/penguin.png");
        Point point = new Point(0, 0);
        Cursor cursor = toolkit.createCustomCursor(penguin, point, "Cursor");
        setCursor(cursor);

    }
    

    //add game over
     public void endGame()
    {
        background.setVisible(false);
        this.setBackground(Color.black);
        gameOver = new JLabel("GAME OVER! Your Score is " + i);
        gameOver.setFont(new Font("New Roman Times", Font.BOLD, 20));
        gameOver.setForeground(Color.RED);
        gameOver.setBounds(350,200,750, 300);
        add(gameOver);
        timer.stop();
        counter.stop();
    }

    @Override
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        requestFocusInWindow(true);

    }

    //method to make fish image move
    public void update() 
    {

        x = x + xVel;
        y = y + yVel;
        if (x < 0 || x > WIN_WIDTH) 
        {
            xVel = -xVel;

        }
        if (y < 0 || y > WIN_HEIGHT - 56) 
        {
            yVel = -yVel;

        }
        repaint();
    }

    //to start game 
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Object obj = e.getSource();
        if(obj == easy)
        {
            delay = 2;
            timer = new Timer(delay, this);
            timer.start();
        }
        else if (obj == medium)
        {
            delay = 5;
            timer = new Timer(delay, this);
            timer.start();
        }
        else if (obj == hard)
        {
            delay = 7;
            timer = new Timer(delay, this);
            timer.start();
        }
        
        if (obj == counter)
		{
                    
                    t = t+1;
                    message.setText("Seconds "+t);
                        
		}
        
        f1.setBounds(x, y, 75, 56);
       
        update();
        repaint();
        
        if (i >= 5)
        {
            endGame();
         
        }
       
        
        

    }

    // to add action to the mouse for score
    @Override
    public void mouseClicked(MouseEvent e) 
    {

    }

    @Override
    public void mouseEntered(MouseEvent e) 
    {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        Object obj = e.getSource();
        if (obj == f1) {
            i = i + 1;
            score.setText("score is: " + i);
            
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {

    }

}
