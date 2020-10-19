
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author sjanv
 */
public class levelOne extends JPanel implements MouseListener, MouseMotionListener
{   
    final static int WIDTH = 100;
    final static int HEIGHT = 100;
    
    int x=0,y=25;
    JLabel label, label2, instruct;
    Font myFont = new Font("Serif", Font.BOLD, 16);
    JButton back, bx, by;
    
    public levelOne()
    {
        super();
        setLayout(null);
        setBackground(Color.yellow);
        
        back = new JButton("Back To Map");
        add(back);
        back.setBounds(800,550,130,35);
        
        label = new JLabel();
        label2 = new JLabel();
        label.setText("Penn State Erie Campus");
        label2.setText("Level 1");
        label.setFont(myFont);
        label2.setFont(myFont);
        add(label);
        add(label2);
        label.setBounds(750,35,300,300);
        label2.setBounds(800,55,300,300);
        instruct = new JLabel();
        instruct.setText("Test Your Memory!");
        instruct.setFont(myFont);
        add(instruct);
        instruct.setBounds(765,150,300,400);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        setLayout(new GridLayout(4,4));
        
        for (int row = 0; row < 4; row++)
        {
            for (int col = 0; col < 4; col++)
            {
                x+=150;
                g.fillRect(x,y,WIDTH,HEIGHT);
            }
            y+=150;
            x=0;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj = e.getSource();
        
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

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point pt = e.getPoint();
    	String sx = "x = " + pt.getX();
        bx.setText(sx);
    	String sy = "y = " + pt.getY();
        by.setText(sy);
        System.out.println("x: "+sx+" y: "+sy);
    }
    
}
