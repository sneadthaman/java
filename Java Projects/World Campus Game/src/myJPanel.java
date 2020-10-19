
/**
 *
 * @author Sjanvey / Jennifer Smith
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;

public class myJPanel extends JFrame implements ActionListener
{
	
    introPanel ip;
    startPanel sp;
    mainMap mm;
    levelOne lev1;
    levelTwo lev2;
    levelThree lev3;
    levelFour lev4;
    levelFive lev5;
    worldCampus wc;
    Container pane;
    fnaf f;
    developers dev;
    
        public myJPanel ()
        {
                super ("Group Game");
                ip = new introPanel();
                sp = new startPanel();
     
                //lev1 = new levelOne();
                f = new fnaf();
                lev2 = new levelTwo();
                lev3 = new levelThree();
                lev4 = new levelFour();
                lev5 = new levelFive();
                wc = new worldCampus();
                mm = new mainMap();
                dev = new developers();


                pane = getContentPane();
                ip.start.addActionListener(this);
                pane.add(ip);

                this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                this.setSize (1000, 650);
                this.setResizable(true);
                this.setVisible(true);
                
                pane.add(lev4);
                
                mm.setVisible(false);
                
                //lev1.setVisible(false);
                lev2.setVisible(false);
                lev3.setVisible(false);
                lev4.setVisible(false);
                lev5.setVisible(false);
                wc.setVisible(false);
                dev.setVisible(false);
                sp.setVisible(false);
                
                pane.add(sp);
                ip.setVisible(true);
                sp.backButton.addActionListener(this);
                sp.start.addActionListener(this);
                mm.b1.addActionListener(this);
                mm.b2.addActionListener(this);
                mm.b3.addActionListener(this);
                mm.b4.addActionListener(this);
                mm.b5.addActionListener(this);
                mm.b6.addActionListener(this);
                //ip.programmers.addActionListener(this);
                
                lev2.back.addActionListener(this);
                lev3.back.addActionListener(this);
                lev4.back.addActionListener(this);
                lev5.back.addActionListener(this);
                f.back.addActionListener(this);
                wc.back.addActionListener(this);
                dev.back.addActionListener(this);
                f.back.addActionListener(this);
               
                mm.requestFocusInWindow();
                
        }
//-------------------------------------------------------------------

        
    public void actionPerformed(ActionEvent ae)
    {
        Object obj = ae.getSource();
        if (obj == ip.start)
        {
            this.ip.setVisible(false);
            this.sp.setVisible(true);
        }
        
        if (obj == sp.backButton)
        {
            this.ip.setVisible(true);
            this.sp.setVisible(false);
        }
        
        if (obj == sp.start)
        {
            pane.add(mm);
            this.sp.setVisible(false);
            this.mm.setVisible(true);
        }
        
        if (obj == mm.b1)
        {
            pane.add(f);
            this.mm.setVisible(false);
            this.f.setVisible(true);
            f.timerStart();
        }
        
        if (obj == f.back)
        {
            this.f.setVisible(false);
            this.mm.setVisible(true);
            f.gameRestart();
        }
        
        if (obj == mm.b2)
        {
            pane.add(lev2);
            this.mm.setVisible(false);
            this.lev2.setVisible(true);
        }
        
        if (obj == lev2.back)
        {
            this.lev2.setVisible(false);
            this.mm.setVisible(true);
        }
         
        if (obj == mm.b3)
        {
            pane.add(lev3);
            this.mm.setVisible(false);
            this.lev3.setVisible(true);
        }
         
        if (obj == lev3.back)
        {
            this.lev3.setVisible(false);
            this.mm.setVisible(true);
        }
        
        if (obj == mm.b4)
        {
            pane.add(lev4);
            this.mm.setVisible(false);
            this.lev4.setVisible(true);
        }
         
        if (obj == lev4.back)
        {
            this.lev4.setVisible(false);
            this.mm.setVisible(true);
        }
        
        if (obj == mm.b5)
        {
            pane.add(lev5);
            this.mm.setVisible(false);
            this.lev5.setVisible(true);
        }
        
        if (obj == lev5.back)
        {
            this.lev5.setVisible(false);
            this.mm.setVisible(true);
        }
        if (obj == mm.b6)
        {
            pane.add(wc);
            this.mm.setVisible(false);
            this.wc.setVisible(true);   
        }
         if (obj == wc.back)
        {
            this.wc.setVisible(false);
            this.mm.setVisible(true);
        }
         if (obj == ip.programmers)
        {
            pane.add(dev);
            this.ip.setVisible(false);
            this.dev.setVisible(true);
        }
          if (obj == dev.back)
        {
            this.dev.setVisible(false);
            this.ip.setVisible(true);
            this.repaint();
        }
         
        
    }
        
    
}
   

