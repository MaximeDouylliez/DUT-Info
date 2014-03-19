
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.io.IOException;


public class Saisie extends JFrame {
    

 private   String s;
 private  JTextField temp;
 private JLabel mess;
 
    
    public Saisie(JButton j){
    
    
    setTitle("chargement depuis un fichier");
    setSize(450,100);
    setVisible(true);
    Container c= getContentPane();
    
    c.setLayout(new FlowLayout());
    
    mess=new JLabel("Entrez le nom de fichier svp");
    c.add(mess);
    temp =new JTextField(30);
    c.add(temp);
   ;
    c.add(j);


}


public String getCont(){
return s=temp.getText();}}