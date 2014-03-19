import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CompteurGraph extends JFrame implements MouseListener
{
private JFrame fenetre;
private JLabel affVal;

  public CompteurGraph(){

fenetre = new JFrame("Incrementeur/Decrementeur");
        Container c = fenetre.getContentPane();
        fenetre.setSize(500,300);
        fenetre.setVisible(true);


JPanel pan=new JPanel();
pan.setLayout(new GridLayout(2,2));

JButton inc = new JButton("+");
JButton dec = new JButton("-");
JButton rez = new JButton("Raz");

c.add(pan);
pan.add(inc);
pan.add(dec);
pan.add(rez);
}

public void mouseClicked(MouseEvent e ){};
public void mousePressed(MouseEvent e) {    };
public void mouseReleased(MouseEvent e) {    };
 public void mouseEntered(MouseEvent e) {     };
public void mouseExited(MouseEvent e) {    };


public void run(String args[]){
Frame dram1=new Frame();}
}
