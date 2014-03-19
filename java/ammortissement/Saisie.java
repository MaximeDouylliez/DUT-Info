
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.io.IOException;

public class Saisie extends JFrame implements MouseListener,FocusListener{

    private  ArrayList <String> parametre;

    private JLabel designation;
    private JTextField z;
    private  JTextField duree;
    private JLabel a;
    private  JTextField acquisition;
    private JLabel b;
    private  JTextField debut;
    private JLabel cc;
    private  JLabel fin;
    private JLabel d;
    private JComboBox type ;
    private JLabel e;
    private  JLabel taux;
    private JLabel f;
    private  JTextField valeur;
    private JLabel g;

    private JButton val,eco,preco;

    private boolean isCaptiving;
    private int hauteur,largeur,cpt;

    private Economie ec;

    private ArrayList <Integer> coef;
    
    private Graph tableau;
    
    private int date1,date2,date3;

    public Saisie(ArrayList <String> inf){

        isCaptiving=false;
        setTitle("Saisie des données");

        Container c= getContentPane();
        c.setLayout(new GridLayout(6,4));
    
        parametre=inf;

        c.add(new JLabel(""));
        designation=new JLabel("Designation");
        c.add(designation);
        z=new JTextField(inf.get(0));
        c.add(z);
        c.add(new JLabel(""));

        c.add(new JLabel(""));
        c.add(new JLabel(""));
        c.add(new JLabel(""));
        c.add(new JLabel(""));


        a=new JLabel("Duree d'amortissement(en année)");
        c.add(a);
        duree =new JTextField(parametre.get(1));
        c.add(duree);

        e=new JLabel("Type d'ammortissement");
        c.add(e);
        type=new JComboBox();
        type.addItem("Economique");
        type.addItem("Lineaire");
        type.addItem("Degressif");
        type.setSelectedItem((Object)parametre.get(5));
        c.add(type);

        b=new JLabel("Date d'acquisition(inutile)");
        c.add(b);
        acquisition=new JTextField(parametre.get(2));
        c.add(acquisition);

        f=new JLabel("Taux d'ammortissement");
        c.add(f);
        taux=new JLabel(calcTaux(0));
        c.add(taux);

        cc=new JLabel("Debut d'ammortissement(jj/mm/aaaa)");
        c.add(cc);
        debut =new JTextField(parametre.get(3));
        c.add(debut);

   
        g=new JLabel("Valeur d'ammortissement");
        c.add(g);
        valeur=new JTextField(parametre.get(7));
        c.add(valeur);

        d=new JLabel("Date de fin");
        c.add(d);
        fin=new JLabel(calcDate(parametre.get(1),parametre.get(3)));
        c.add(fin);

        
        val=new JButton("Generer tableau");
        val.addMouseListener(this);
        eco=new JButton("valider");
        eco.addMouseListener(this);
         preco=new JButton("taux eco");
        preco.addMouseListener(this);
        c.add(preco);
        c.add(val);

        type.addFocusListener(this);
        duree.addFocusListener(this);
        debut.addFocusListener(this);
        valeur.addFocusListener(this);
        designation.addFocusListener(this);
        acquisition.addFocusListener(this);
        this.addMouseListener(this);

        largeur=1200;
        hauteur=300;
        setSize(largeur,hauteur);
        setVisible(true);

        coef=new ArrayList <Integer>();
        z.requestFocus();
        cpt=0;
    }

    private void err(String s){
        isCaptiving=true;
        JOptionPane.showMessageDialog(this,s,"Noobie",JOptionPane.ERROR_MESSAGE);
        isCaptiving=false;
    }

    private void checkDate(String s,String errr){
        boolean caca=true;

        if( s.length()<9)
            caca= false;        

        else{
            for (int i=0;i<s.length();i++){
                char c=s.charAt(i);
                char d;

                if(i<6){
                    d=s.charAt(i+1);

                    if(i==0){
                        if((c>='0' && c<='2' && (d >='0'&& d<='9'))|| (d=='0' && c=='3' )){;}
                        else caca=false;}

                    else if(i==2 ||i==5){
                        if (c=='/'){;}
                        else caca=false;}

                    else if(i==3){
                        if(((c>='0'&& (d>='0'&& d<='9')) && d!='0')||
                        ((d=='2'|| d=='0'|| d=='1') && (c=='1'))){;}
                        else caca=false;}}

                if(i==6 ||i==7 ||i==8||i==9){
                    if(c>='0'&& c<='9'){;}

                    else caca= false;}
            }}

        if (!caca)
            err(errr);

    }

        
        
    private void checkVal(String s,String errr){
        try{
            int i=Integer.parseInt(s);
            if(i==0)err("0 n'est pas une valeur valide!");
        }
        catch(NumberFormatException e){
            err(errr);
        } 
    }

        

    private void check(ArrayList <String> inf)
    {

        //  checkVal(inf.get(1),"Entrez une durée valide");

        //  checkVal(inf.get(7),"Entrez une Valeur d'ammortissement valide");
       
        //checkDate(inf.get(3),"Entrez une Date de début d'ammortissement valide");
    }

    public ArrayList<String> getPar(){
        parametre = new ArrayList <String>();
        if(!this.duree.getText().equals("")&&!debut.getText().equals(""))
            fin.setText(calcDate(duree.getText(),debut.getText()));
               
        taux.setText(calcTaux(0));

        parametre.add(designation.getText());
        parametre.add(duree.getText());
        parametre.add(acquisition.getText());
        parametre.add(debut.getText());
        parametre.add(fin.getText());
        parametre.add((String)type.getSelectedItem());
        parametre.add(taux.getText());
        parametre.add(valeur.getText());
        parametre.add(calcTaux(2));

        return parametre;}

    private String calcDate(String duree,String debut){
        if(!this.duree.getText().equals("")){
            int dur=Integer.parseInt(duree);
            int jour=Integer.parseInt(debut.substring(0,2));
            int mois=Integer.parseInt(debut.substring(3,5));
            int annee=Integer.parseInt(debut.substring(6));
            String resuj="01";
            String resum="01";
            if((String)type.getSelectedItem()=="Lineaire"){

                if(jour==1){jour=30;mois=mois-1;}else{jour=jour-1;}
                if(mois==0){mois=12;annee=annee-1;}
                annee=annee + dur;

                if(jour<10)resuj=(jour+"");
                resuj=jour+"";
                

                if(mois<10)resum=(mois+"");
                resum=mois+"";

                return  (resuj+"/"+resum+"/"+annee);

            }
            else if((String)type.getSelectedItem()=="Degressif"){
                if(mois==1){mois=12;annee=annee-1;}mois=mois-1;
                annee=annee + dur;

                return "01"+"/"+mois+"/"+annee;

            }

            else{
                return "Selon Danvin pas de date";}

        }
        return "0";
    }

      static int evalDate(String debut, String borne){

        int jour=Integer.parseInt(debut.substring(0,2));
        int mois=Integer.parseInt(debut.substring(3,5));
        int annee=Integer.parseInt(debut.substring(6));
        int jourb=Integer.parseInt(borne.substring(0,2));
        int moisb=Integer.parseInt(borne.substring(3,5));
        int anneeb=Integer.parseInt(borne.substring(6));

        if(annee>anneeb)return 1;
        else if(annee<anneeb)return -1;

        else{
            if(mois>moisb)return 1;
            else if(mois<moisb)return -1;
            else{
                if(jour>jourb)return 1;
                else if(jour<jourb)return -1;
                else
                {return 0;}}}
    }


    private String calcTaux(int a){
        if(duree.getText().equals("")==false){
            int durr=(Integer.parseInt(duree.getText()));
            String d=debut.getText();
            if((String)type.getSelectedItem()=="Lineaire"|| a==2){

                Double dur=(double)(1.0/ durr);
                return  dur.toString();
            }
            else if((String)type.getSelectedItem()=="Degressif"){
                if(evalDate(d,"01/02/1996")==-1){if (durr==3|| durr==4) return "1.5"; else if (durr==5|| durr==6) return "2.0"; else if (durr>6) return "2.5"; }
                else if(evalDate(d,"01/02/1997")==-1){if (durr==3|| durr==4) return "2.5"; else if (durr==5|| durr==6) return "3.0"; else if (durr>6) return "3.5"; }
                else if(evalDate(d,"01/01/2001")==-1){if (durr==3|| durr==4) return "1.5"; else if (durr==5|| durr==6) return "2.0"; else if (durr>6) return "2.5"; }
                else{if (durr==3|| durr==4) return "1.25"; else if (durr==5|| durr==6) return "1.75"; else if (durr>6) return "2.25"; }
            }return "Selon Danvin pas de taux";}
        else return "0";}


    public void mouseClicked(MouseEvent e){
        if(e.getSource()==val){
            String debut=this.debut.getText();
           date1=Integer.parseInt(debut.substring(0,2));
        date2=Integer.parseInt(debut.substring(3,5));
        date3=Integer.parseInt(debut.substring(6));
        
          tableau= new Graph(getPar(),coef,this,date1,date2,date3);
        ;}
        
        
        else
        if(e.getSource()==eco){
            
            coef=ec.getCoef();
            ec.dispose();}
            
            else if(e.getSource()==preco){   ec=new Economie(eco,Integer.parseInt(duree.getText()));}
            
 

 
    }

  
    public void focusGained(FocusEvent e) {

    }

    public void focusLost(FocusEvent e) {
        if(cpt<2){cpt++; }
        else {
            if(isCaptiving==false){

                ArrayList <String> par =getPar();

                if(e.getSource()== type){if( (String)type.getSelectedItem()=="Economique"){

                     ;}}
                else 
                if(e.getSource()== debut){
                    checkDate(par.get(3),"Entrez une Date de début d'ammortissement valide");  }
                else 
                if(e.getSource()== duree){   checkVal(par.get(1),"Entrez une durée valide");  }
                else 
                if(e.getSource()== valeur){  checkVal(par.get(7),"Entrez une Valeur d'ammortissement valide"); }

                isCaptiving=false;}
        }
    }

    
    
    public void mouseExited(MouseEvent e){
    }

    public void mouseEntered(MouseEvent e){}

    public void mouseReleased(MouseEvent e){}

    public void mousePressed(MouseEvent e){}

}