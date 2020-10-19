import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author sjanv
 */
public class levelThree extends JPanel implements KeyListener, ActionListener, MouseMotionListener, MouseListener
{
    final static int RIGHT_BOUND = 800, LEFT_BOUND = 25;
    final static int B_START = 450, SANS_WIDTH = 100;
    
    ImageIcon shooter, lawn, bullet, sans;
    JLabel shooter1, background, direct, instruct, start, bullet1, sans1, sansLife1, gameOver, lose, win;
    int x = 395, y = 450, delay = 1000, i = 0, j = 0, bY = B_START, xBullet, sansX = 250, sansY = 0,
            sansW = SANS_WIDTH, random = 1000, dx, sansLife = 3;
    JButton back, timer, bx, by, tryAgain, winBack, easy, medium, hard;
    Font myFont = new Font("Serif", Font.BOLD, 26);
    Timer timStart, bulletTimer, sansTimer;
    
    public levelThree()
    {
        super();
        this.setLayout(null);
        this.createShooter();
    }
    
//    public int randomPosition()
//    {
//         int myRandom;
//         double r = Math.random();
//         myRandom = (int) (r * random);
//            
//         return myRandom;
//     }
    @Override
    public void keyPressed(KeyEvent evt) 
    {
        //System.out.println("Key pressed");
        int kk = evt.getKeyCode();
        if(kk ==  evt.VK_LEFT)  {x=x-10;}
        if(x<=LEFT_BOUND)  {x=LEFT_BOUND;}
        if(kk ==  evt.VK_RIGHT) {x=x+10;}
        if(x>=RIGHT_BOUND) {x=RIGHT_BOUND;}
            shooter1.setBounds(x,450,175,205);
        if(kk == evt.VK_SPACE)
        {
            direct.setVisible(false);
            instruct.setVisible(false);
            start.setVisible(false);
            back.setVisible(false);
            timStart.start();
            sansTimer.start();
            sansHealth();
        }
        if(kk == evt.VK_SHIFT)
        {
            this.bullet1.setBounds((x+88),bY,5,10);
            this.xBullet = x+88;
            bulletTimer.start();
            this.bullet1.setVisible(true);
            this.repaint();
        }
    }
    
    @Override
    public void keyReleased(KeyEvent evt) 
    {
        System.out.println("Key Released");
    }

    @Override
    public void paintComponent(Graphics g)
    {
	super.paintComponent(g);
	requestFocusInWindow();
    }
    
    @Override
    public void keyTyped(KeyEvent evt) {  }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        Object obj = ae.getSource();
        
        if (obj == sansTimer)
        {
            sans1.setBounds(sansX, sansY, 100, 150);
            sans1.setVisible(true);
            this.sansMove();
            this.repaint();
            checkKill();
        }
        if (obj == timStart)
        {
            i += 1;
        }
        
        if (obj == bulletTimer)
        {
            this.bY--;
            this.bullet1.setBounds(xBullet,bY,5,10);
            this.repaint();
            if (bY < 0)
            {
                bulletTimer.stop();
                this.bullet1.setVisible(false);
                bY = B_START;
            }
            if ((xBullet >= sansX) && (xBullet <= (sansX+100)) && (bY == 90))
            {
                bulletTimer.stop();
                this.bullet1.setVisible(false);
                bY = B_START;
                sansLife1.setText("Sans Health: "+(--sansLife));
                if (healthCheck() == true)
                {
                    youWin();
                }
            }
        }
    }
    
    public void checkKill()
    {
        if (sansY == 400)
        {
            youLose();
        }
    }
    
    public void youWin()
    {
        endGame();
        win.setVisible(true);
        back.setVisible(true);
    }
    
    public void youLose()
    {
        endGame();
        lose.setVisible(true);
        back.setVisible(true);
//        tryAgain.setVisible(true);
    }
    public void endGame()
    {
        timStart.stop();
        bulletTimer.stop();
        sansTimer.stop();
        sansLife1.setVisible(false);
        sans1.setVisible(false);
    }
        
    public boolean healthCheck()
    {
        if (sansLife == 0)
        {
            return true;
        }
        return false;
    }
    public void sansMove()
    {
        sansX+=dx;
        
        if (sansX >= RIGHT_BOUND)
        {
            sansY += 20;
            dx = -dx;
        }
        if (sansX <= LEFT_BOUND)    
        {
            sansY += 20;
            dx = -dx;
        }
    }
    
    public void sansHealth()
    {
        sansLife1.setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent me) {

    }

    @Override
    public void mouseMoved(MouseEvent evt) {
        Point pt = evt.getPoint();
    	String sx = "x = " + pt.getX();
        bx.setText(sx);
    	String sy = "y = " + pt.getY();
        by.setText(sy);
    }
    
    public void createShooter()
    {
                // creates a x/y output box for development
//        bx = new JButton();
//        by = new JButton();
//        add(bx);
//        add(by);
//        //bx.setBounds(50,500,100,25);
//        //by.setBounds(50,525,100,25);
//        addMouseMotionListener(this);
        
        shooter = new ImageIcon("images/shooter.png");
        shooter1 = new JLabel(shooter);
        add(shooter1);
        shooter1.setBounds(x,y,175,205);
        addKeyListener(this);
        
        bullet = new ImageIcon("images/bullet.gif");
        bullet1 = new JLabel(bullet);
        add(bullet1);
        
        // Sans is the bad guy in this game
        
        // Sans is a character from a popular game called Undertale
        
        sans = new ImageIcon("images/sans.png");
        sans1 = new JLabel(sans);
        add(sans1);
        
        // We can monitor how much health Sans has in the upper left corner
        sansLife1 = new JLabel();
        sansLife1.setText("Sans Health: "+(sansLife));
        add(sansLife1);
        sansLife1.setVisible(false);
        sansLife1.setBounds(50,35,130,35);
        
        back = new JButton("Back to Map");
        add(back);
        back.setBounds(50,35,130,35);
        
        easy = new JButton("Easy");
        medium = new JButton("Medium");
        hard = new JButton("Insane");
        easy.setBounds(900,80,100,100);
        medium.setBounds(900,180,100,100);
        hard.setBounds(900,280,100,100);
        add(easy);
        add(medium);
        add(hard);
        easy.addMouseListener(this);
        medium.addMouseListener(this);
        hard.addMouseListener(this);
        easy.setVisible(true);
        medium.setVisible(true);
        hard.setVisible(true);
        
        
        direct = new JLabel();
        direct.setText("Ready...Set....Shoot!");
        direct.setFont(myFont);
        add(direct);
        direct.setBounds(350,200,400,100);
        
        lose  = new JLabel();
        lose.setText("You Lose - Try Again");
        lose.setFont(myFont);
        lose.setBounds(200,200,700,200);
        add(lose);
        lose.setVisible(false);
        
        win  = new JLabel();
        win.setText("You Win!");
        win.setFont(myFont);
        win.setBounds(200,200,700,200);        
        add(win);
        win.setVisible(false);
        
//        tryAgain = new JButton("Try Again");
//        tryAgain.setBounds(300,350,200,100);
//        add(tryAgain);
//        tryAgain.setVisible(false);
//        tryAgain.addMouseListener(this);
        
        gameOver = new JLabel();
        gameOver.setText("Game Over");
        add(gameOver);
        
        instruct = new JLabel();
        instruct.setText("Use 'Left' and 'Right' Arrows to Move Shooter");
        instruct.setBounds(350,375,500,100);
        add(instruct);
        
        start = new JLabel();
        start.setText("Press 'Space' to Start");
        start.setFont(myFont);
        start.setBounds(350,35,400,50);
        add(start);
        
        lawn = new ImageIcon("images/lawn.png");
        background = new JLabel(lawn);
        background.setBounds(0,0,1000,650);
        add(background);
        
        timStart = new Timer(delay, this);
        timer = new JButton();
        timer.setBounds(50,75,100,35);
        add(timer);
        
        bulletTimer = new Timer(1, this);
        sansTimer = new Timer(1, this);
        
        timStart.addActionListener(this);
        bulletTimer.addActionListener(this);
        sansTimer.addActionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        Object obj = e.getSource();
        if (obj == easy)
        {
            dx = 1;
            easy.setVisible(false);
            medium.setVisible(false);
            hard.setVisible(false);
        }
        if (obj == medium)
        {
            dx = 2;
            easy.setVisible(false);
            medium.setVisible(false);
            hard.setVisible(false);
        }
        if (obj == hard)
        {
            dx = 3;
            easy.setVisible(false);
            medium.setVisible(false);
            hard.setVisible(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}
