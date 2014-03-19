import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JAbdel extends JPanel{

int [][] tab;
Groupe s;
public  JAbdel (Groupe s){
int i,j;
this.s=s;
tab=s.getPlateau();
for(j=0;j<3;j++){
    for(i=0;i<3;i++){
        tab[j][i]=0;
   
}
}}

public void paintComponent(Graphics g){
super.paintComponent(g);
setBackground(Color.white);

tab=s.getPlateau();
tab[0][0]=1;

int i,j;

g.drawLine(getWidth()/3,0,getWidth()/3,getHeight());
g.drawLine(getWidth()-getWidth()/3,0,getWidth()-getWidth()/3,getHeight());
g.drawLine(0,getHeight()/3,getWidth(),getHeight()/3);
g.drawLine(0,getHeight()-getHeight()/3,getWidth(),getHeight()-getHeight()/3);

for(j=0;j<3;j++){
    for(i=0;i<3;i++){
        if(tab[j][i]==1){
            g.drawLine((getWidth()/3)*j,(getHeight()/3)*i,(getWidth()/3)*(j+1),(getHeight()/3)*(i+1));
            g.drawLine((getWidth()/3)*j,(getHeight()/3)*(i+1),(getWidth()/3)*(j+1),(getHeight()/3)*i);
}

}}}}