
/**
 *
 * @author Jennifer
 */
import java.awt.*;
import javax.swing.*;


  public class introPanel extends JPanel
{
    JButton start,  programmers;
    JLabel jlTitle1, jlTitle2, background;
    ImageIcon welcome, wc;
    Font myFont = new Font("Serif", Font.BOLD, 20);

    public introPanel() {
        super();
        setLayout(null);
        setBackground(Color.white);
        
        wc = new ImageIcon("images/intro_WC.jpg");
        
        
        
        jlTitle1 = new JLabel();
        jlTitle1.setText("Team 1's Final Project Game!");
        jlTitle1.setFont(myFont);
        jlTitle1.setForeground(Color.white);
        add(jlTitle1);
        jlTitle1.setBounds(new Rectangle(400, 20, 330, 50));
       
        jlTitle2 = new JLabel("Select an Option:");
        jlTitle2.setBounds(new Rectangle(270, 40, 200, 40));
        add(jlTitle2);
        
        start = new JButton("Start Game");
        start.setBounds(new Rectangle(400, 450, 180, 80));
        add(start);
        
//        programmers = new JButton("Game Developers");
//        programmers.setBounds(new Rectangle(570, 450, 180, 80));
//        add(programmers);
        
        background = new JLabel(wc);
        background.setBounds(0,0,1000,650);
        add(background);
        
        
    } 


}
