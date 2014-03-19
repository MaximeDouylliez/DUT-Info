

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.io.IOException;


public class Economie extends JFrame{
    

 private  ArrayList <Integer> coef;
 
   private  ArrayList <JTextField> tab;
 
 
   

        
    public  Economie(JButton fin,int taille){
        
 
 coef= new ArrayList <Integer> ();
   tab=new  ArrayList <JTextField> ();
   
   

    setTitle("Saisie des données");
    
    
    Container c= getContentPane();
    
    c.setLayout(new GridLayout(taille+2,2));
    
    c.add(new JLabel("annee"));
       c.add(new JLabel("Valeur"));
   
        for(int k=0;k<taille;k++){
       tab.add(new JTextField());}
       
   for(int i=0;i<taille;i++){
       c.add(new JLabel("n="+(i+1)));
       c.add(tab.get(i));}
       
       c.add(new JLabel(""));
       c.add(fin);
       
       setSize(1000 ,500);
       setVisible(true);
    }

ArrayList <Integer> getCoef(){

for(int l=0;l<tab.size();l++){

coef.add(new Integer(tab.get(l).getText()));}

return coef;



}}
       
       