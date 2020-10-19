

/**
 *
 * @author Jennifer Smith
 */
import java.awt.*;
import javax.swing.*;

public class developers extends JPanel
{
    JButton back; 
    JLabel display;
    
    public developers()
    {
        super();
        setLayout(null);
        this.setBackground(Color.CYAN);
        
        //add back button to get back to map
        back = new JButton("Back To Map");
        back.setBounds(50, 10, 150, 35);
        add(back);
        
        display = new JLabel(" Developers of this program are Jennifer Smith, Sam Janvey, and Ifedunni Segun-Abugan");
        display.setBounds(200,200,750, 300);
        display.setFont(new Font("New Roman Times", Font.BOLD, 15));
        add(display);
    }
    
    
    
    
}
