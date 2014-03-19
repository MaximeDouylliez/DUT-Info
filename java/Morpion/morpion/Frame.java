import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame implements MouseListener
{

    private Partie pa;
    private int posx;
    private int posy;
    
    /*
    private boolean c1;
    private boolean c2; 
    private boolean c3; 
    private boolean c4; 
    private boolean c5; 
    private boolean c6; 
    private boolean c7; 
    private boolean c8; 
    private boolean c9; 
    private boolean r1;
    private boolean r2; 
    private boolean r3; 
    private boolean r4; 
    private boolean r5; 
    private boolean r6; 
    private boolean r7; 
    private boolean r8; 
    private boolean r9; 
    */
   
    //fenetre
    private JFrame fenetre;
    
    //panneaux
    private JPanel mainp;//principal
    private GrilleGraf grille;//grille
    private JLabel aff;//panneau d'affichage
    private ScrGrp inst;//instructions
    private ScrGrp sc;//score
     
    //affichage
    private JLabel ainst;//instructions
    private JLabel s;//scores
    
    public Frame(Partie p)
    {       
        pa = p;
        
        fenetre = new JFrame("Morpion");
        fenetre.setSize(300,600);
        Container c = fenetre.getContentPane();
        
        mainp = new JPanel();
        mainp.setLayout(new GridLayout(2,1));
        grille = new GrilleGraf(this.pa,this);
        grille.addMouseListener(this);
        aff = new JLabel();
        aff.setLayout(new GridLayout(2,1));
        inst = new ScrGrp();
        sc = new ScrGrp();
        
        Font police = new Font("Arial",Font.BOLD, 12);
        
        ainst = new JLabel();
        ainst.setFont(police);
        
        if(pa.getTour() == 1){
            ainst.setText(pa.getJp()+", c'est à vous de jouer");
        } else {
            ainst.setText(pa.getJd()+", c'est à vous de jouer");
        }
  
        ainst.setFont(police);
        s = new JLabel("Score            j1 :               j2 :   ");  
        s.setFont(police);
        
        c.add(mainp);
        mainp.add(grille);
        mainp.add(aff);
        aff.add(inst);
        aff.add(sc);
        inst.add(ainst);
        sc.add(s);
        
        fenetre.setVisible(true);
    }  
    
    int geX(){
        return posx;
    }
    
    int geY(){
        return posy;
    }
    
    /* point
     * 
     *          if((c1 == true && c2 == true && c3)  || (c4 == true && c5 == true && c6)  ||(c7 == true && c8 == true && c9)  ||(c1 == true && c4 == true && c7) 
     *              ||(c2 == true && c5 == true && c8)  ||(c3 == true && c6 == true && c9)  ||(c1 == true && c5 == true && c9)  ||(c7 == true && c5 == true && c3) ){
     *     
     *                  victoire rond;     
     *          }
     *          
     *          if((r1 == true && r2 == true && r3)  || (r4 == true && r5 == true && r6)  ||(r7 == true && r8 == true && r9)  ||(r1 == true && r4 == true && r7) 
     *              ||(r2 == true && r5 == true && r8)  ||(r3 == true && r6 == true && r9)  ||(r1 == true && r5 == true && r9)  ||(r7 == true && r5 == true && r3) ){
     *     
     *                  victoire croix;     
     *          }
     * 
     */
    
    
    public void mouseClicked(MouseEvent e)
    {
        posx=e.getX();
        posy=e.getY();
        if(pa.getTour() == 1){
            ainst.setText(pa.getJd()+", c'est à vous de jouer");
        } else {
            ainst.setText(pa.getJp()+", c'est à vous de jouer");
        }
        grille.repaint();
    }
    public void mouseEntered(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseExited(MouseEvent e){}    
}