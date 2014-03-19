import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Iframe implements MouseListener
{

    private Partie part;
    private Frame grid;
    
    private JFrame ifenetre;
    
    private JPanel imain;
    private JPanel nb;
    private JPanel j1;
    private JPanel j2;
    
    private JButton conf;
    
    private Checkbox one;
    private Checkbox two;
    private CheckboxGroup grp;
    
    private JLabel nbj;
    private JLabel nj1;
    private JLabel nj2;
    private JTextField t1;
    private JTextField t2;
    
    public Iframe(){
      
        part = new Partie();
        
        ifenetre = new JFrame("Initialisation partie");
        ifenetre.setSize(400,400);
        Container c = ifenetre.getContentPane();
        
        imain = new JPanel();
        imain.setLayout(new GridLayout(4,1));
        nb = new JPanel();
        nb.setLayout(new GridLayout(1,3));
        j1 = new JPanel();
        j1.setLayout(new GridLayout(1,2));
        j2 = new JPanel();
        j2.setLayout(new GridLayout(1,2));
        
        conf = new JButton("Confirmer");
        conf.addMouseListener(this);
        grp = new CheckboxGroup();
        one = new Checkbox("1",grp,true);
        two = new Checkbox("2",grp,false);
        
        nbj = new JLabel("Nombre");
        nj1 = new JLabel("Nom joueur 1");
        nj2 = new JLabel("Nom joueur 2");
        t1 = new JTextField("joueur 1");
        t2 = new JTextField("joueur 2");
        
        c.add(imain);
        imain.add(nb);
        imain.add(j1);
        imain.add(j2);
        imain.add(conf);
        nb.add(nbj);
        nb.add(one);
        nb.add(two);
        j1.add(nj1);
        j1.add(t1);
        j2.add(nj2);
        j2.add(t2);
        
        
        ifenetre.setVisible(true);
    }
    
    public void mouseClicked(MouseEvent e)
    {
            if(one.getState()==true){
                part.setNb(1);
                part.setJ1(t1.getText());
                part.setJ2("bot");
            } else {
                part.setNb(2);
                part.setJ1(t1.getText());
                part.setJ2(t2.getText());
            }   
            ifenetre.dispose();
            grid = new Frame(part);
    }
    public void mouseEntered(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
}
