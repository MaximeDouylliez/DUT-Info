import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.io.IOException;

public class main extends MouseAdapter
{
  
private JButton rechercheVersAffSite;
private JButton retourVersRecherche;

private JButton affSiteVersPreciSite;
private JButton retourVersAffSite;

private JButton preciSiteVersDocSup;
private JButton preciSiteVersPaiement;
private JButton retourVersPreciSitedoc;
private JButton retourVersPreciSitepai;

private JButton docSupVersPaiement;
private JButton retourVersDocSup;
private JButton payer;

private RecherchFichier f1;
private Affsite f2;
private PreciSite f3;
private DocSup f4;
private Paiement f5;

    public main()
    {
        
        rechercheVersAffSite =new JButton ("Rechercher !");
        rechercheVersAffSite.addMouseListener(this);
        f1=new RecherchFichier(rechercheVersAffSite); }

  
    public  void mouseClicked(MouseEvent e){
        if(e.getSource()==rechercheVersAffSite){
            affSiteVersPreciSite =new JButton ("Voir plus");
            retourVersRecherche =new JButton ("Retour");
            affSiteVersPreciSite.addMouseListener(this);        
            retourVersRecherche.addMouseListener(this);
            
            f2=new Affsite(affSiteVersPreciSite,retourVersRecherche);
            f1.dispose();
            
        }
        
        if(e.getSource()==affSiteVersPreciSite){
            preciSiteVersDocSup =new JButton ("Voir description");
            preciSiteVersPaiement =new JButton ("Reserver");
            retourVersAffSite =new JButton ("Retour !");
            preciSiteVersDocSup.addMouseListener(this);
            preciSiteVersPaiement.addMouseListener(this);
            retourVersAffSite.addMouseListener(this);
            
            f3=new PreciSite(preciSiteVersDocSup,preciSiteVersPaiement,retourVersAffSite);
            f2.dispose();
        }
        
        if(e.getSource()==retourVersRecherche){
            rechercheVersAffSite =new JButton ("Rechercher !");
            rechercheVersAffSite.addMouseListener(this);
            
            f1=new RecherchFichier(rechercheVersAffSite);
            f2.dispose();
        }
        
        if(e.getSource()==preciSiteVersDocSup){
            
            retourVersPreciSitedoc =new JButton ("Retour");
            docSupVersPaiement =new JButton ("Acheter");
            retourVersPreciSitedoc.addMouseListener(this);
            docSupVersPaiement.addMouseListener(this);
            
            f4=new DocSup(docSupVersPaiement,retourVersPreciSitedoc);
            f3.dispose();
        }
        
        if(e.getSource()==preciSiteVersPaiement){
            payer=new JButton ("payer");
            retourVersPreciSitepai =new JButton ("Retour");
            retourVersPreciSitepai.addMouseListener(this);
            
            f5= new Paiement(payer, retourVersPreciSitepai);
            f3.dispose();
            
            
        }
        
        if(e.getSource()==retourVersAffSite){
            affSiteVersPreciSite =new JButton ("Voir plus");
            retourVersRecherche =new JButton ("Retour");
            affSiteVersPreciSite.addMouseListener(this);        
            retourVersRecherche.addMouseListener(this);
            
            f2=new Affsite(affSiteVersPreciSite,retourVersRecherche);
            f3.dispose();
        }
        
        if(e.getSource()==docSupVersPaiement){
            payer=new JButton ("payer");
            retourVersDocSup =new JButton ("Retour");
            retourVersDocSup.addMouseListener(this);
            
            f5= new Paiement(payer,retourVersDocSup);
            f4.dispose();
        }
        
        if(e.getSource()==retourVersPreciSitepai){
            preciSiteVersDocSup =new JButton ("Voir description");
            preciSiteVersPaiement =new JButton ("Reserver");
            retourVersAffSite =new JButton ("Retour !");
            preciSiteVersDocSup.addMouseListener(this);
            preciSiteVersPaiement.addMouseListener(this);
            retourVersAffSite.addMouseListener(this);
            
            f3=new PreciSite(preciSiteVersDocSup,preciSiteVersPaiement,retourVersAffSite);
            f5.dispose();
        }
        
        if(e.getSource()==retourVersPreciSitedoc){
            retourVersPreciSitedoc =new JButton ("Retour");
            docSupVersPaiement =new JButton ("Acheter");
            retourVersPreciSitedoc.addMouseListener(this);
            docSupVersPaiement.addMouseListener(this);
            
            f4=new DocSup(docSupVersPaiement,retourVersPreciSitedoc);
            f5.dispose();
        }
        
    
}
}
