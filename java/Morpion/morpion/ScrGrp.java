import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class ScrGrp extends JPanel
{

    public ScrGrp()
    {
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        //cadre
        g.drawRect(1,1,this.getWidth()-3,this.getHeight()-2);
    }
}
