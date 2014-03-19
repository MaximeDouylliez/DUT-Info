import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Skin extends JFrame implements ActionListener{






private Aiguilleur polet;



JButton b0 = new JButton("0");
JButton b1 = new JButton("1");
JButton b2 = new JButton("2");
JButton b3 = new JButton("3");
JButton b4 = new JButton("4");
JButton b5 = new JButton("5");
JButton b6 = new JButton("6");
JButton b7 = new JButton("7");
JButton b8 = new JButton("8");
JButton b9 = new JButton("9");
JButton bPlus = new JButton("+");
JButton bMoins = new JButton("-");
JButton bMul = new JButton(".");
JButton bDiv = new JButton("/") ;
JButton bEqu = new JButton("=") ;
JButton bClear = new JButton("C");
JButton bClearLast = new JButton("CE");
JButton bMemClear = new JButton("MC");
JButton bMemRec = new JButton("MR");
JButton bMrMoin = new JButton("M-");
JButton bMrPlus = new JButton("M+");
JButton bVirg = new JButton(",");

JLabel dehors;
public Skin(){

System.out.print(" Les fonction m+ et m- sont fonctionelles\n mais n'apparaissent pas de maniere naturelles à l'utilisateurla raison étant que le\n refresh recalcule l'operande a partir du tableau d'entier\n et comme la memoire vient directement modifier la valeur \nde l'operande ca bloque");


polet=new Aiguilleur(this);

 
setTitle("Great");
setSize(1000,500);
setVisible(true);

Container c =getContentPane();


JPanel gen=new JPanel();
gen.setLayout(new GridLayout(4,1));  


JPanel optn=new JPanel();
optn.setLayout(new GridLayout(1,6));

JPanel op=new JPanel();
op.setLayout(new GridLayout(2,4));

JPanel op2=new JPanel();
op2.setLayout(new GridLayout(2,4));


 dehors= new JLabel("lol");
dehors.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);  // j'aurais du implémenter avec une liste ou un tableau de bouton.




c.add(gen);
gen.add(dehors);
gen.add(optn);
gen.add(op);
gen.add(op2);


optn.add(bClear);
optn.add(bClearLast);
optn.add(bMemClear);
optn.add(bMemRec);
optn.add(bMrMoin);
optn.add(bMrPlus);
op.add(b7);
op.add(b8);
op.add(b9);
op.add(bDiv);
op.add(b4);
op.add(b5);
op.add(b6);
op.add(bMoins);
op2.add(b1);
op2.add(b2);
op2.add(b3);
op2.add(bPlus);
op2.add(b0);
op2.add(bVirg);
op2.add(bMul);
op2.add(bEqu);

bClear.addActionListener(this);
bClearLast.addActionListener(this);
bMemClear.addActionListener(this);
bMemRec.addActionListener(this);
bMrMoin.addActionListener(this);
bMrPlus.addActionListener(this);
b7.addActionListener(this);
b8.addActionListener(this);
b9.addActionListener(this);
bDiv.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
bMoins.addActionListener(this);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
bPlus.addActionListener(this);
b0.addActionListener(this);
bVirg.addActionListener(this);
bMul.addActionListener(this);
bEqu.addActionListener(this);


}


public void actionPerformed (ActionEvent ev){

  if(ev.getSource()== b0) polet.ajouterVal(0) ;
  else if(ev.getSource()==b1)polet.ajouterVal(1) ;
  else if(ev.getSource()== b2)polet.ajouterVal(2);
  else if(ev.getSource()== b3)polet.ajouterVal(3);
  else if(ev.getSource()== b4)polet.ajouterVal(4);
  else if(ev.getSource()== b5)polet.ajouterVal(5);
  else if(ev.getSource()== b6)polet.ajouterVal(6);
  else if(ev.getSource()== b7)polet.ajouterVal(7);
  else if(ev.getSource()== b8)polet.ajouterVal(8);
  else if(ev.getSource()== b9)polet.ajouterVal(9);
  else if(ev.getSource()== bMoins)polet.ajouterOp("-");
  else if(ev.getSource()== bPlus)polet.ajouterOp("+");
  else if(ev.getSource()== bVirg)polet.ajouterOp(",");
  else if(ev.getSource()== bDiv)polet.ajouterOp("/");
  else if(ev.getSource()== bEqu)polet.ajouterOp("=");
  else if(ev.getSource()== bMul)polet.ajouterOp("*");
  else if(ev.getSource()== bClear)polet.effectuerOptn("clear");
  else if(ev.getSource()== bClearLast)polet.effectuerOptn("clearl");
  else if(ev.getSource()== bMemClear)polet.effectuerOptn("memclear");
  else if(ev.getSource()== bMemRec)polet.effectuerOptn("memrec");
  else if(ev.getSource()== bMrMoin)polet.effectuerOptn("mrmoin");
  else if(ev.getSource()== bMrPlus)polet.effectuerOptn("mrplus");
else System.out.println("erreur");
}

public void aff(String s){dehors.setText(s);}
public void run(String args[]){
Skin skin1= new Skin();}}

