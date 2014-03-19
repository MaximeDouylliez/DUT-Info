import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.io.IOException;

public class Main extends MouseAdapter
{
    private ArrayList <Integer> stock;
    private Saisie fen;
    private Graph hist;
   private String s;
    private JButton but;
    
    public Main()
    {
     stock =new ArrayList <Integer>();
        but = new JButton ("ok");
        but.addMouseListener(this);
        fen = new Saisie(but);
        
    
    }

 
    
 public void charger(String s)throws IOException{
int i,count;
String lol=null,ligne;
BufferedReader entree=new BufferedReader(new FileReader(s));

do{
       ligne=entree.readLine();
       if(ligne!=null)
       {
           StringTokenizer tok =new StringTokenizer(ligne," ");
           count=tok.countTokens();
           for(i=0;i<count;i++){
               
                    stock.add(Integer.decode(tok.nextToken()));}
                }
                
           

        }while(ligne!=null);
    }
    
    public void mouseClicked(MouseEvent e){
        if( e.getSource()== but){
            s=fen.getCont();
            fen.setVisible(false);
            fen=null;
            try{charger(s);}
            catch(IOException ee){}
            hist=new Graph(stock);
            ;}
                    
}}
