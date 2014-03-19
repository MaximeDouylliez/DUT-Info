import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class JAbdel extends JPanel{
ArrayList<Type> statut;

public JAbdel(ArrayList<Type> lol){
statut=lol;
}
public void paintComponent(Graphics g){
super.paintComponent(g);
setBackground(Color.white);

int i;

if(statut.isEmpty()){}

else{

for(i=0;i<statut.size();i++){
Type dess=statut.get(i);
int x1=dess.x1;
int x2=dess.x2;
int y1=dess.y1;
int y2=dess.y2;

    if(dess.polygone.equals("Rectangle")){
        if( x1<x2){
            if(y1<y2){
               g.drawRect(x1,y1,x2-x1,y2-y1);}
 
            else g.drawRect(x1,y2,x2-x1,y1-y2);}
        else 
         if(y1<y2)
             g.drawRect(x2,y1,x1-x2,y2-y1);
         else
             g.drawRect(x2,y2,x1-x2,y1-y2);
         
         
}


    else if(dess.polygone.equals("Triangle")){
        if(x1<x2){
            if(y1<y2){
                g.drawLine(x1,y1,x2,y2);
                g.drawLine(x2,y2,x1-(x2-x1),y2);
                g.drawLine(x1,y1,x1-(x2-x1),y2);
            }
            else{
                
                g.drawLine(x1,y1,x2,y2);
                g.drawLine(x1,y1,x2+(x2-x1),y1);
                g.drawLine(x2,y2,x2+(x2-x1),y1);
            }
        }
        else{
            if(y1<y2){
                g.drawLine(x1,y1,x2,y2);
                g.drawLine(x2,y2,x2+(x1-x2)*2,y2);
                g.drawLine(x1,y1,x2+(x1-x2)*2,y2);}
            else{
                g.drawLine(x1,y1,x2,y2);
                g.drawLine(x1,y1,x2-(x1-x2),y1);
                g.drawLine(x2,y2,x2-(x1-x2),y1);}
                
         
            }  


}


    else if(dess.polygone.equals("Ellipse")){
        int  rayon;
           if(x1<x2){
              if(y1<y2)
                  rayon=(int)(Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2)));
              
              else
                  rayon=(int)(Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y1-y2),2)));
              
                }
           else {
              if(y1<y2)
                  rayon=(int)(Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y2-y1),2)));
              
              else
                  rayon=(int)(Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2)));
           
            }
        g.drawOval(x1-rayon,y1-rayon,rayon*2,rayon*2);
        g.drawLine(x1,y1,x1,y1);
}


else{

g.drawLine(x1,y1,x2,y2);





}
}
}
}
}

