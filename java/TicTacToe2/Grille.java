import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Grille extends JFrame implements MouseListener{
JLabel com;
JAbdel pan;
JPanel mess;
Container c;
Groupe playmate;
int idJoueur;

public Grille (){
this.setTitle("lol");
this.setVisible(true);
this.setSize(300,150);

playmate=new Groupe();
idJoueur=1 ;


c=getContentPane();


mess= new JPanel();
mess.setLayout(new GridLayout(2,1)); 
c.add(mess);

pan = new JAbdel(playmate);

com=new JLabel("Tour du joueur 1");

mess.add(com);
mess.add(pan);

pan.addMouseListener(this);





}





public void mouseClicked (MouseEvent e){
int x=e.getX();
int y=e.getY();

pan.repaint();

//check case 0,0
if(x>0 && x< pan.getWidth()/3 && y>0 && y<pan.getHeight()/3)ihm( playmate.jouerCoup(idJoueur,0,0));

//0.1
if(x> pan.getWidth()/3 && x< pan.getWidth()-pan.getWidth()/3  && y>0 && y<pan.getHeight()/3)ihm( playmate.jouerCoup(idJoueur,1,0));

//0.2
if(x> pan.getWidth()-pan.getWidth()/3 && x< pan.getWidth() && y>0 && y<pan.getHeight()/3)ihm( playmate.jouerCoup(idJoueur,2,0));



//1.0
if(x> 0 && x<pan.getWidth()/3 && y> pan.getHeight()/3 && y< pan.getHeight() -pan.getHeight()/3) ihm(playmate.jouerCoup(idJoueur,0,1));

//1.1
if(x>pan.getWidth()/3 && x<pan.getWidth()-pan.getWidth()/3 && y> pan.getHeight()/3 && y< pan.getHeight() -pan.getHeight()/3) ihm(playmate.jouerCoup(idJoueur,1,1));

//1.2
if(x> pan.getWidth()-pan.getWidth()/3 && x< pan.getWidth() && y> pan.getHeight()/3 && y< pan.getHeight() -pan.getHeight()/3) ihm(playmate.jouerCoup(idJoueur,2,1));




//2.0
if(x>0 && x< pan.getWidth()/3 && y> pan.getHeight() -pan.getHeight()/3 && y<pan.getHeight())ihm( playmate.jouerCoup(idJoueur,0,2));

//2.1
if(x>pan.getWidth()/3 && x<pan.getWidth()-pan.getWidth()/3 && y> pan.getHeight() -pan.getHeight()/3 && y<pan.getHeight()) ihm(playmate.jouerCoup(idJoueur,1,2));

//2.2
if(x>pan.getWidth()-pan.getWidth()/3 && x< pan.getWidth() && y> pan.getHeight() -pan.getHeight()/3 && y<pan.getHeight())ihm( playmate.jouerCoup(idJoueur,2,2));
}





public void ihm( boolean coupvalide){
if (coupvalide && idJoueur==1){
com.setText("au Tour du joueur 2");
idJoueur=2;
pan.repaint();}

else if (coupvalide && idJoueur==2){
com.setText("au Tour du joueur 1");
idJoueur=1;
pan.repaint();}

else{
com.setText("Zone déja occupé, veuillez choisir une zone disponible, joueur" + idJoueur);
pan.repaint();}
}

















public void mousePressed (MouseEvent e){};
public void mouseReleased (MouseEvent e){};
public void mouseEntered (MouseEvent e){};
public void mouseExited (MouseEvent e){}
};
