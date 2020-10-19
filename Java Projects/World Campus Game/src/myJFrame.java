import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author IfedunniSegun-Abugan
 */
public class myJFrame extends JFrame {
    
    
    myJFrame f;
    myJPanel mjp = new myJPanel();
    
    
    public void myJFrame() {       
        f.setLayout(new BorderLayout());
        f.add(mjp, BorderLayout.CENTER);
        f.getContentPane().add(mjp);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize (1000, 650);
        this.setVisible(true); 
      
    }
}