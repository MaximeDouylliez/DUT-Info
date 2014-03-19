import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Frame implements MouseListener,MouseMotionListener
{
    //AFFICHAGE
    private JFrame fenetre;

    private JPanel main;
    private JPanel bline;
    private DessinZone deszone;

    private JButton line;
    private JButton rect;
    private JButton tri;
    private JButton rond;
    private JButton undo;
    private JButton clear;
    private JButton save;
    private JButton load;
    

    //PROGRAMME
    private int posxd;
    private int posyd;
    private int posxf;
    private int posyf;
    private int bactuel; //0 -> rien; 1 -> ligne; 2 -> rectangle; 3 -> cercle; 4 -> triangle 
    private ArrayList<SaveForme> liste;

    public Frame(){

        //PROGRAMME
        bactuel = 0;
        liste = new ArrayList<SaveForme>();

        //AFFICHAGE
        fenetre = new JFrame("Editeur dessin");
        fenetre.setSize(800,500);

        Container c = fenetre.getContentPane();

        main = new JPanel();
        main.setLayout(new BorderLayout());

        bline = new JPanel();
        bline.setLayout(new GridLayout(8,1));

        line = new JButton(" Ligne ");
        line.addMouseListener(this);
        rect = new JButton(" Rectangle ");
        rect.addMouseListener(this);
        rond = new JButton(" Elipse ");
        rond.addMouseListener(this);
        tri = new JButton(" Triangle ");
        tri.addMouseListener(this);
        undo = new JButton(" Undo ");
        undo.addMouseListener(this);
        clear = new JButton(" C ");
        clear.addMouseListener(this);
        save = new JButton(" Save ");
        save.addMouseListener(this);
        load = new JButton(" Load ");
        load.addMouseListener(this);

        deszone = new DessinZone(this);
        deszone.addMouseListener(this);
        deszone.addMouseMotionListener(this);

        c.add(main);
        main.add(bline,BorderLayout.WEST);
        main.add(deszone);
        bline.add(line);
        bline.add(rect);
        bline.add(tri);
        bline.add(rond);
        bline.add(undo);
        bline.add(clear);
        bline.add(save);
        bline.add(load);

        fenetre.setVisible(true);
    }
    
    public void saveFile(String nfile){
        try{
            BufferedWriter fichier = new BufferedWriter(new FileWriter(nfile));
            for( SaveForme f : liste ){
                fichier.write(Integer.toString(f.getForme()));
                fichier.newLine();
                fichier.write(Integer.toString(f.getCa()));
                fichier.newLine();
                fichier.write(Integer.toString(f.getCb()));
                fichier.newLine();
                fichier.write(Integer.toString(f.getCc()));
                fichier.newLine();
                fichier.write(Integer.toString(f.getCd()));
                fichier.newLine();
            }
            fichier.close();
        }
        catch ( Exception e ){}  
    }
    
    public void loadFile(String nfile){
        try{
            BufferedReader fichier = new BufferedReader(new FileReader(nfile));
            String ligne;
            
            do{
                for(int i = 0; i < 5; i++ ){
                    liste.add(new SaveForme(Integer.parseInt(fichier.readLine()),Integer.parseInt(fichier.readLine()),Integer.parseInt(fichier.readLine())
                    ,Integer.parseInt(fichier.readLine()),Integer.parseInt(fichier.readLine())));   
                }
            }
            while(fichier.readLine() != null);
             
            fichier.close();
        }
        catch(Exception e){}    
    }
    
    public ArrayList<SaveForme> getList(){
        return liste;
    }
    
    public int getPosxd(){
        return this.posxd;
    }

    public int getPosyd(){
        return this.posyd;
    }

    public int getPosxf(){
        return this.posxf;
    }

    public int getPosyf(){
        return this.posyf;
    }

    public int getBactu(){
        return this.bactuel;
    }
    
    public void mouseDragged(MouseEvent e) {
        posxf = e.getX();
        posyf = e.getY();
        deszone.repaint();
    }
    
    public void mousePressed(MouseEvent e){
        if( e.getSource() == deszone ){
            posxd = e.getX();
            posyd = e.getY();
        }
    }

    public void mouseReleased(MouseEvent e){
        
        if( e.getSource() == deszone ){
            if( bactuel != 0 ){
                posxf = e.getX();
                posyf = e.getY();
                liste.add(new SaveForme(bactuel,posxd,posyd,posxf,posyf));
                deszone.repaint();
            }
        }
    }

    public void mouseClicked(MouseEvent e){
        if( e.getSource() == line ){
            this.bactuel = 1; 
            line.setEnabled(false);
            rect.setEnabled(true);
            rond.setEnabled(true);
            tri.setEnabled(true);
        }  
        if ( e.getSource() == rect ){
            this.bactuel = 2;
            line.setEnabled(true);
            rect.setEnabled(false);
            rond.setEnabled(true);
            tri.setEnabled(true);
        }
        if ( e.getSource() == rond ){
            this.bactuel = 3;
            line.setEnabled(true);
            rect.setEnabled(true);
            rond.setEnabled(false);
            tri.setEnabled(true);
        }
        if ( e.getSource() == tri ){
            this.bactuel = 4;
            line.setEnabled(true);
            rect.setEnabled(true);
            rond.setEnabled(true);
            tri.setEnabled(false);
        }
        if ( e.getSource() == clear ){
            this.bactuel = 0;
            posxd = 0;
            posyd = 0;
            posxf = 0;
            posyf = 0;
            liste.clear();
            line.setEnabled(true);
            rect.setEnabled(true);
            rond.setEnabled(true);
            tri.setEnabled(true);
            deszone.repaint();
        }
        if ( e.getSource() == save ){
            saveFile("test.txt");   
        }
        if ( e.getSource() == load ){
            loadFile("test.txt");
            deszone.repaint();
        }
        if ( e.getSource() == undo ){
            if ( liste.size() > 0){
                posxd = 0;
                posyd = 0;
                posxf = 0;
                posyf = 0;
                liste.remove(liste.size()-1);  
                deszone.repaint();
            }
        }
    }

    public void mouseEntered(MouseEvent e){}

    public void mouseExited(MouseEvent e){}
    
    public void mouseMoved(MouseEvent e) {} 

}