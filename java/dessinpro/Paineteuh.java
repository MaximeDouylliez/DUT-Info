import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.io.IOException;

public class Paineteuh extends JFrame implements MouseListener,MouseMotionListener,ActionListener{


private JPanel zonDessin;
private JPanel zonBouton;
private JPanel zonChecker;
private ArrayList <JButton> option;
private ArrayList <Type> statut; 
private ArrayList <JCheckBox> check;
private int actif;
private boolean isDragging=false;
private boolean isFunMode=false;

public Paineteuh(){

int i;

setTitle("Paineteuh/Rip by Skullptura");
setSize(1000,1000);
setVisible(true);
Container c= getContentPane();


String [] mot=new String [7];
mot[0]="Rectangle";
mot[1]="Triangle";
mot[2]="Ellipse";
mot[3]="Ligne";
mot[5]="Effacer";
mot[4]="Enlever";
mot[6]="Sauvegarder";

zonBouton= new JPanel();
zonChecker= new JPanel();

option= new ArrayList <JButton> ();

for(i=0;i<7;i++){
JButton caca=new JButton(mot[i]);
option.add(caca);
zonBouton.add(caca);
caca.addMouseListener(this);}


String [] mot2=new String [1];
mot2[0]= "FunMode";

check=new ArrayList <JCheckBox> ();

for( i=0;i<1;i++){
JCheckBox caca=new JCheckBox(mot2[i]);
check.add(caca);
zonChecker.add(caca);
caca.addActionListener(this);}


statut=new ArrayList <Type>();
zonDessin= new JAbdel(statut);
zonDessin.addMouseListener(this);
zonDessin.addMouseMotionListener(this);
//zonChecker.addActionListener(this);


JPanel zone= new JPanel();
c.add(zone);
zonBouton.setLayout(new GridLayout(option.size(),1));
zonChecker.setLayout(new GridLayout(check.size(),1));
zone.setLayout(new BorderLayout());

zone.add(zonBouton,BorderLayout.WEST);
zone.add(zonDessin,BorderLayout.CENTER);
zone.add(zonChecker,BorderLayout.NORTH);

try{charger();}
catch(IOException e){}







}
public void charger()throws IOException{
int x1=0,y1=0,x2=0,y2=0,i,count;
String lol=null,ligne;
BufferedReader entree=new BufferedReader(new FileReader("caca.txt"));

do{
       ligne=entree.readLine();
       if(ligne!=null)
       {
           StringTokenizer tok =new StringTokenizer(ligne," ");
           count=tok.countTokens();
           for(i=0;i<count;i++){
                if(i!=0){

                    if(i==1)x1=Integer.parseInt(tok.nextToken());
                    if(i==2)y1=Integer.parseInt(tok.nextToken());
                    if(i==3)x2=Integer.parseInt(tok.nextToken());
                    if(i==4)y2=Integer.parseInt(tok.nextToken());}
                else{
                    lol=tok.nextToken();}
                }
                
                statut.add(new Type(lol,x1,y1,x2,y2));
            }
        }while(ligne!=null);
    }
                    

public void sauvegarder()throws IOException{
String nomFich="caca.txt";
PrintWriter sortie = new PrintWriter (new FileWriter (nomFich));

for(Type t:statut){

sortie.println(t.polygone +" "+ t.x1+" " + t.y1+" " + t.x2+" " + t.y2);





}
sortie.close();
}


public void undo(){
  statut.remove(statut.get(statut.size()-1));
  repaint();}


public void mouseClicked (MouseEvent ev){
if(ev.getSource()==option.get(0)) actif=0;// rectangle
if(ev.getSource()==option.get(2)) actif=2; //ellipse
if(ev.getSource()==option.get(1)) actif=1;//triangle
if(ev.getSource()==option.get(3)) actif=3; //trait

if(ev.getSource()==option.get(4)) {
if(!statut.isEmpty())
   undo();
    }
if(ev.getSource()==option.get(6))
try{ sauvegarder();}
catch(IOException e){}; 
if(ev.getSource()==option.get(5)){
     statut.subList(0,statut.size()).clear(); 
     repaint();}}
     
     
public void mousePressed (MouseEvent e){
Type.tmpX=e.getX();
Type.tmpY=e.getY();
}



public void createur(MouseEvent e){

if(actif==0)
statut.add(new Type("Rectangle",Type.tmpX,Type.tmpY,e.getX(),e.getY()));

else if(actif==1)
statut.add(new Type("Triangle",Type.tmpX,Type.tmpY,e.getX(),e.getY()));

else if(actif==2)
statut.add(new Type("Ellipse",Type.tmpX,Type.tmpY,e.getX(),e.getY()));

else
statut.add(new Type("Ligne",Type.tmpX,Type.tmpY,e.getX(),e.getY()));

repaint();
}


public void mouseDragged(MouseEvent e){
isFunMode=check.get(0).isSelected();
if(e.getSource()==option.get(0) || e.getSource()==option.get(1)|| e.getSource()==option.get(2) || e.getSource()==option.get(3) || e.getSource()==option.get(4) || e.getSource()==option.get(5) || e.getSource()==option.get(6)){}
else{

     if(isDragging){
         if(isFunMode){}
         else undo();}
      

                
                
         isDragging=true; 
         createur(e);
}}

public void mouseReleased (MouseEvent e){



if(e.getSource()==option.get(0) || e.getSource()==option.get(1)|| e.getSource()==option.get(2) || e.getSource()==option.get(3) || e.getSource()==option.get(4) || e.getSource()==option.get(5) || e.getSource()==option.get(6)){}
else{
     if (isDragging){
        if(isFunMode){}
           else undo();
     
        isDragging=false;   
        createur(e);}
    }

}


public void actionPerformed(ActionEvent e){

if(e.getSource()==check.get(0)){
if (check.get(0).isSelected())
isFunMode=true;
isFunMode=false;}}

public void mouseEntered (MouseEvent e){}
public void mouseExited (MouseEvent e){}
public void mouseMoved (MouseEvent e){}
}

