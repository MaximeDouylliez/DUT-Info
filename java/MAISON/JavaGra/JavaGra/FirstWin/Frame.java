import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame
{
    private JFrame fenetre;
    private JLabel affVal;
    private JButton incr;
    private JButton dec;
    private JButton raz;
    
    public Frame(){
        fenetre = new JFrame("Incrementeur/Decrementeur");
        Container c = fenetre.getContentPane();
        fenetre.setSize(500,300);
        fenetre.setVisible(true);
        JButton b1 = new JButton("Incrementer");
        JButton b2 = new JButton("Decrementer");
        JButton b3 = new JButton("Remise à 0");
        c.setLayout(new GridLayout(1,2));
        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(3,1));
        c.add(pan);
        pan.add(b1);
        pan.add(b2);
        pan.add(b3);
        affVal = new JLabel("Valeur");
        c.add(affVal);
    }
    
    public void run(String args[]){
        Frame fram1= new Frame();
    }
    
}
