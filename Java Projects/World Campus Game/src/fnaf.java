
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 *
 * @author sam
 */
public class fnaf extends JPanel implements MouseMotionListener, MouseListener, ActionListener
{  
    ImageIcon bg, eyes, cam1, cam2, mouseDown, camLeft, camLeft1, camRight, camRight1, twelve, one, two, three, four, five, six, fredJS, bonnyJS;
    JLabel background, eyez, eyez2, mouseDown1, camOne, camTwo, camLeftBg, camLeftBg1, camRightBg, camRightBg1,
            twelveAm, oneAm, twoAm, threeAm, fourAm, fiveAm, sixAm, gameOver, startGame, fredJumpScare, bonnyJumpScare;
    JButton bx,by,back, easy, medium, hard;
    int x = 0, delay = 1000, bDelay = 300, fDelay = 500, wDelay = 1000, time = 240;
    double bKill = 40, fKill = 38;
    Timer main, bonny, freddy, win, dead;
    Font myFont;
    File js, bgAudio, mouse, phone;
    
    public fnaf()
    {
        super();
        setLayout(null);
        myFont = new Font("Serif", Font.BOLD, 28);
        this.createFnaf();
    }

    @Override
    public void mouseDragged(MouseEvent e) { }

    @Override
    public void mouseMoved(MouseEvent e) 
    { }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        Object obj = e.getSource();
        if (obj == camOne)
        {
            camLeftBg.setVisible(true);
            camRightBg.setVisible(false);
            bKill += 3;
        }
        
        if (obj == camTwo)
        {
            camLeftBg.setVisible(false);
            camRightBg.setVisible(true);
            fKill += 3;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {  }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) 
    {
        Object obj = e.getSource();
        if (obj == mouseDown1)
        {
            changeScreen();
            fKill += 1;
            bKill += 1;
            playSound(mouse);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {  }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object obj = e.getSource();
        if (obj == main)
        {
            time--;
            fKill -= 0.5;
            bKill -= 0.5;
            timeSelector();
            gameOverDead();
            eyezCheck();
        }
        if(obj == dead)
        {

        }
    }
    
    public void eyezCheck()
    {
        if (bKill < 10)
        {
            eyez.setVisible(true);
        }
        if (fKill < 20)
        {
            eyez2.setVisible(true);
        }
        if (bKill > 10)
        {
            eyez.setVisible(false);
        }
        if (fKill > 20)
        {
            eyez2.setVisible(false);
        }
        if (bKill < 35)
        {
            camLeftBg.setIcon(camLeft1);
        }
        if (bKill >= 35)
        {
            camLeftBg.setIcon(camLeft);
        }
        if (fKill < 25)
        {
            camRightBg.setIcon(camRight1);
        }
        if (fKill >= 25)
        {
            camRightBg.setIcon(camRight);
        }
    }
    
    public void gameOverDead()
    {
        if (fKill <= 0)
        {
            fredJumpScare.setVisible(true);
            dead.start();
            main.stop();
            stopSound(bgAudio);
            playSound(js);
        }
        if (bKill <= 0)
        {
            bonnyJumpScare.setVisible(true);
            dead.start();
            main.stop();
            stopSound(bgAudio);
            playSound(js);
        }
        
    }
    
    static void stopSound (File sound)
    {
        try{
            Clip clip = AudioSystem.getClip();
            clip.stop();
        }catch(Exception e)
        {
            
        }
    }

    static void playSound(File sound)
    {
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
            
        }catch(Exception e)
        {
            
        }
    }

    public void gameOver()
    {
        background.setVisible(false);
        this.setBackground(Color.black);
        gameOver.setText("You Survived The Night!");
        gameOver.setFont(myFont);
        gameOver.setForeground(Color.WHITE);
        gameOver.setBounds(300,100,750, 300);
    }
    // This will correctly determine which screen to switch to when triggering the mouseDown
    public void changeScreen()
    {
            if (x == 1)
            {
                background.setVisible(true);
                camLeftBg.setVisible(false);
                camRightBg.setVisible(false);
                camOne.setVisible(false);
                camTwo.setVisible(false);
                x = 0;
            }
            else if (x == 0)
            {
                background.setVisible(false);
                camLeftBg.setVisible(true);
                camOne.setVisible(true);
                camTwo.setVisible(true);
                x = 1;
            }
    }
    // Method to increase the time on the clock
    // Get to 6am and survive the night
    public void timeSelector()
    {      
        if (time == 230)
        {
            playSound(phone);
        }
        if (time == 200)
        {
            twelveAm.setVisible(false);
            oneAm.setVisible(true);
        }
        if (time == 160)
        {
            oneAm.setVisible(false);
            twoAm.setVisible(true);
        }
        if (time == 120)
        {
            twoAm.setVisible(false);
            threeAm.setVisible(true);
        }
        if (time == 80)
        {
            threeAm.setVisible(false);
            fourAm.setVisible(true);
        }
        if (time == 40)
        {
            fourAm.setVisible(false);
            fiveAm.setVisible(true);
        }
        if (time == 0)
        {
            fiveAm.setVisible(false);
            sixAm.setVisible(true);
            main.stop();
            gameOver();
        }
    }
    
    public void timerStart()
    {
        main.start();
        bonny.start();
        freddy.start();
    }
    
    public void gameRestart()
    {
        main.restart();
        main.stop();
        bonny.restart();
        bonny.stop();
        freddy.restart();
        freddy.stop();
        //stopSound(bgAudio);
        stopSound(phone);
    }

    public void createFnaf()
    {
        main = new Timer(delay, this);
        bonny = new Timer(bDelay, this);
        freddy = new Timer(fDelay, this);
        win = new Timer(wDelay, this);
        dead = new Timer(delay, this);
        dead.addActionListener(this);
//        main.start();
        main.addActionListener(this);
        //bonny.start();
        //freddy.start();
        //win.start();
        bonny.addActionListener(this);
        freddy.addActionListener(this);
        win.addActionListener(this);
        
        // Create all of the images
        bg = new ImageIcon("images/fnaf_bg.gif");
        eyes = new ImageIcon("images/eyes.png");
        cam1 = new ImageIcon("images/cam1.png");
        cam2 = new ImageIcon("images/cam2.png");
        mouseDown = new ImageIcon("images/mouseDown.png");
        camLeft = new ImageIcon("images/cam2a.jpg");
        camLeft1 = new ImageIcon("images/cam1b.png");
        camRight = new ImageIcon("images/cam1a.png");
        camRight1 = new ImageIcon("images/cam2bfreddy.png");
        twelve = new ImageIcon("images/12am.png");
        one = new ImageIcon("images/1am.png");
        two = new ImageIcon("images/2am.png");
        three = new ImageIcon("images/3am.png");
        four = new ImageIcon("images/4am.png");
        five = new ImageIcon("images/5am.png");
        six = new ImageIcon("images/6am.png");
        fredJS = new ImageIcon("images/freddyJS.gif");
        bonnyJS = new ImageIcon("images/bonnyJS.gif");
        
        // Create all of the audio
        js = new File("audio/jumpscare.wav");
        bgAudio = new File("audio/background.wav");
        mouse = new File("audio/mousedown.wav");
        phone = new File("audio/phonecall.wav");
        
        mouseDown1 = new JLabel(mouseDown);
        camOne = new JLabel(cam1);
        camTwo = new JLabel(cam2);
        eyez = new JLabel(eyes);
        eyez2 = new JLabel(eyes);
        background = new JLabel(bg);
        camLeftBg = new JLabel(camLeft);
        camLeftBg1 = new JLabel(camLeft1);
        camRightBg = new JLabel(camRight);
        camRightBg1 = new JLabel(camRight1);
        twelveAm = new JLabel(twelve);
        oneAm = new JLabel(one);
        twoAm = new JLabel(two);
        threeAm = new JLabel(three);
        fourAm = new JLabel(four);
        fiveAm = new JLabel(five);
        sixAm = new JLabel(six);
        gameOver = new JLabel();
        fredJumpScare = new JLabel(fredJS);
        bonnyJumpScare = new JLabel(bonnyJS);
        
        add(gameOver);
        fredJumpScare.setVisible(false);
        bonnyJumpScare.setVisible(false);
        add(fredJumpScare);
        add(bonnyJumpScare);
        add(mouseDown1);
        mouseDown1.setBounds(275,425,450,225);
        add(twelveAm);
        twelveAm.setBounds(775,20,200,100);
        twelveAm.setVisible(true);
        add(oneAm);
        oneAm.setBounds(775,20,200,100);
        oneAm.setVisible(false);
        add(twoAm);
        twoAm.setBounds(775,20,200,100);
        twoAm.setVisible(false);
        add(threeAm);
        threeAm.setBounds(775,20,200,100);
        threeAm.setVisible(false);
        add(fourAm);
        fourAm.setBounds(775,20,200,100);
        fourAm.setVisible(false);
        add(fiveAm);
        fiveAm.setBounds(775,20,200,100);
        fiveAm.setVisible(false);
        //add(sixAm);
        sixAm.setBounds(775,20,200,100);
        sixAm.setVisible(false);
        add(camOne);
        camOne.setVisible(false);
        camOne.setBounds(300,20,150,100);
        add(camTwo);
        camTwo.setVisible(false);
        camTwo.setBounds(450,20,150,100);
        
        fredJumpScare.setBounds(0,0,1000,650);
        bonnyJumpScare.setBounds(0,0,1000,650);

        add(camLeftBg);
        add(camLeftBg1);
        add(camRightBg);
        add(camRightBg1);
        camLeftBg.setBounds(0,0,1000,650);
        camLeftBg1.setBounds(0,0,1000,650);
        camRightBg.setBounds(0,0,1000,650);
        camRightBg1.setBounds(0,0,1000,650);
        camLeftBg.setVisible(false);
        camLeftBg1.setVisible(false);
        camRightBg.setVisible(false);
        camRightBg1.setVisible(false);
        
        add(eyez);
        add(eyez2);
        eyez.setVisible(false);
        eyez2.setVisible(false);
        eyez.setBounds(35,300,150,100);
        eyez2.setBounds(845,300,150,100);
        eyez.repaint();
        eyez2.repaint();
        
        back = new JButton("Back");
        back.setBounds(20, 20, 100, 75);
        add(back);
        back.setVisible(true);
        back.repaint();

        add(background);
        background.setVisible(true);
        background.setBounds(0,0,1000,650);
        add(sixAm);
        
        camOne.addMouseListener(this);
        camTwo.addMouseListener(this);
        mouseDown1.addMouseListener(this);
    }
}
