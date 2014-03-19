import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.JTable;
import java.text.*;

public class Graph extends JFrame {
    ArrayList <String>  ar;
    ArrayList <Integer>  coef;
    Container c;
    JScrollPane pan;
    int aa,bb,cc;
    public Graph(ArrayList<String>  doo,ArrayList <Integer> eco ,Saisie s,int a,int b,int ccc){

        ar=doo;
        coef=eco;

        aa=a;
        bb=b;
        cc=ccc;
        setTitle("Tableau");
        setSize(2000,1500);
        setVisible(true);
        Container c= getContentPane();
        lol();

    
        ;}

    
    private Object [][] affLin (){
        int duree,annee;
        double vncd,vncf,annuite,annuitepr,taux;
DecimalFormat df = new DecimalFormat("#.##");
        vncd=Double.parseDouble(ar.get(7));
        annee=cc;
        duree=Integer.parseInt(ar.get(1));
        taux=Double.parseDouble(ar.get(6));
        annuite=(vncd+0.0)*(taux+0.0);
        annuitepr=0;
        vncf=vncd;

        if(aa!=1 || bb!=1 )duree=duree+1;

        Object [][] tab= new Object [duree][5];
        
        for (int i=0;i<duree;i++){
            if((aa>1 || bb>1) && i==0){

                double premier=((360+0.0)-((30+0.0)* (bb-1+0.0)+ (aa-1+0.0)))/(360+0.0);

                annuitepr=(vncd+0.0)*(taux+0.0)*(0.0+premier);

                vncf=vncd-annuitepr;
                tab[0][0]=df.format(annee); tab[0][1]=df.format(vncd);tab[0][2]=df.format(taux);tab[0][3]=df.format(annuitepr);tab[0][4]=df.format(vncf);
                annee=annee+1;
            }

            else if((aa>1 || bb>1 )&& i==(duree-1)){
annuitepr=annuite;
vncf=vncf-vncd;
                //annuitepr=annuite-annuitepr;
               // vncf=vncd-annuitepr;

                tab[i][0]=df.format(annee); tab[i][1]=df.format(vncd);tab[i][2]=df.format(taux);tab[i][3]=df.format(annuitepr);tab[i][4]=df.format(vncf);

            }

            else{
                vncd=vncf;
                vncf=vncd-annuite;
                tab[i][0]=df.format(annee); tab[i][1]=df.format(vncd);tab[i][2]=df.format(taux);tab[i][3]=df.format(annuite);tab[i][4]=df.format(vncf);
                annee=annee+1;
            }

    
 
        }
        return tab;}   

    private double total(){
        double caca=0;
        for(int i=0;i<coef.size();i++)
            caca=caca+coef.get(i).intValue();
        return caca;}

    private Object [][] affEco(){
         
        int duree,annee;
        double vncd,vncf,annuite,taux;
DecimalFormat df = new DecimalFormat("#.##");
        vncd=Double.parseDouble(ar.get(7));
        annee=cc;
        duree=Integer.parseInt(ar.get(1));

        vncf=vncd;

        double tot =total();
        
        
        Object [][] tab= new Object [duree][5];

        
        for (int i=0;i<duree;i++){

          
          
            vncd=vncf;
            annuite=(Double.parseDouble(ar.get(7)))*((coef.get(i).intValue()+0.0)/(tot+0.0));

            vncf=vncd-annuite;

            tab[i][0]=df.format(annee); tab[i][1]=df.format(vncd);tab[i][2]=df.format((coef.get(i).intValue()+0.0/tot+0.0));tab[i][3]=df.format(annuite);tab[i][4]=df.format(vncf);
            annee=annee+1;

          
          
          
          
          
          
            ;}
        return tab;}
        
    private  Object [][]  affDegr(){ 
     
        int duree,annee;
        double vncd,vncf,annuite,annuitel=0,taux;

        vncd=Double.parseDouble(ar.get(7));
        annee=cc;
        duree=Integer.parseInt(ar.get(1));

        vncf=vncd;

        double tauxl=(double)(1.0/ duree);
       
        taux=Double.parseDouble(ar.get(6))*tauxl;
        
        
        

        Object [][] tab= new Object [duree][5];
        
        

        for (int i=0;i<duree;i++){
   DecimalFormat df = new DecimalFormat("#.##");
            vncd=vncf;
            if(i==0){
                double premier=((360+0.0)-((30+0.0)* (bb-1+0.0)))/(360+0.0);
                
                double annuitepr=(vncd+0.0)*(taux+0.0)*(0.0+premier);

                
                
                
                
                vncf=vncd-annuitepr;
                tab[0][0]=df.format(annee); tab[0][1]=df.format(vncd);tab[0][2]=df.format(taux);tab[0][3]=df.format(annuitepr);tab[0][4]=df.format(vncf);
                annee=annee+1;
            }

            
            
           //else if(o==false){
             else{  
                 tauxl=(double)(1.0/(duree-i));
                 System.out.println(tauxl);
                annuitel=tauxl*vncd;
                System.out.println(annuitel);
                annuite=(taux+0.0)*vncd;

                if(tauxl>taux ){
                 //   o=true;
                    
                    vncf=vncd-annuitel;
                    tab[i][0]=df.format(annee); tab[i][1]=df.format(vncd);tab[i][2]=df.format(tauxl);tab[i][3]=df.format(annuitel);tab[i][4]=df.format(vncf);
                    annee=annee+1;}

                else{

                    vncf=vncd-annuite;
                    tab[i][0]=df.format(annee); tab[i][1]=df.format(vncd);tab[i][2]=df.format(taux);tab[i][3]=df.format(annuite);tab[i][4]=df.format(vncf);
                    annee=annee+1;}}

           
          //else{
             //       o=true;
              //      vnnn=annuitel;
              //      vncf=vncd-vnnn;
              //      tab[i][0]=annee; tab[i][1]=vncd;tab[i][2]=tauxl;tab[i][3]=vnnn;tab[i][4]=vncf;
               //     annee=annee+1;}
          
          
          
          
          
            
        }
    
    return tab;}
    
    
    
    private void lol (){

        c= getContentPane();

        Object[][] data=null ;

        if(ar.get(5).equals("Economique")){ data=affEco();
        }

        else if(ar.get(5).equals("Lineaire"))data=affLin();


        else{data=affDegr();

        }

        String  title[] = {"Annee", "vnc debut", "taux","annuite","vnc fin"};
        JTable tableau = new JTable(data, title);
        c.add(new JScrollPane(tableau));

    }}

