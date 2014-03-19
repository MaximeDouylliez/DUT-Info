import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class JAbdel extends JPanel{
ArrayList<Integer> note;

public JAbdel(ArrayList<Integer> lol){
note=lol;
}
public void paintComponent(Graphics g){
super.paintComponent(g);
setBackground(Color.white);


if(note.isEmpty()){}

else{

int []tab= new int [21];

for(int lol=0;lol<note.size();lol++)
tab[note.get(lol)]++;

g.drawLine(50,0,50,700);
g.drawLine(50,700,1550,700);

//for(int y=0;y<21;y++)
//{g.drawLine(50+(1500/21)*y,700,50+(1500/21)*y,710);}


for(int i=0;i<21;i++)

g.drawRect(50+(1500/21)*i,700-(700/note.size())*tab[i],1500/21,50+(i+1)*(1500/21));






}}}