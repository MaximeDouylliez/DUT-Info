import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class DessinZone extends JPanel
{
    private Frame fenetre;

    public DessinZone(Frame f)
    {
        this.fenetre = f;
    }

    public void paintComponent(Graphics g)
    {   
        super.paintComponent(g);
        g.drawRect(0,0,this.getWidth()-1,this.getHeight()-1);
        for(SaveForme fo : fenetre.getList()){
            if( fo.getForme() == 1){
                g.drawLine(fo.getCa(),fo.getCb(),fo.getCc(),fo.getCd());
            }
            if( fo.getForme() == 2){
                if(fo.getCa() < fo.getCc() && fo.getCb() < fo.getCd()){
                    g.drawRect(fo.getCa(),fo.getCb(),fo.getCc()-fo.getCa(),fo.getCd()-fo.getCb());
                }
                if(fo.getCa() < fo.getCc() && fo.getCb() > fo.getCd()){
                    g.drawRect(fo.getCa(),fo.getCd(),fo.getCc()-fo.getCa(),fo.getCb()-fo.getCd());
                }
                if(fo.getCa() > fo.getCc() && fo.getCb() < fo.getCd()){
                    g.drawRect(fo.getCc(),fo.getCb(),fo.getCa()-fo.getCc(),fo.getCd()-fo.getCb());
                }
                if(fo.getCa() > fo.getCc() && fo.getCb() > fo.getCd()){
                    g.drawRect(fo.getCc(),fo.getCd(),fo.getCa()-fo.getCc(),fo.getCb()-fo.getCd());
                } 
            }
            if( fo.getForme() == 3){
                if(fo.getCa() < fo.getCc() && fo.getCb() < fo.getCd()){
                    g.drawOval(fo.getCa(),fo.getCb(),fo.getCc()-fo.getCa(),fo.getCd()-fo.getCb());
                }
                if(fo.getCa() < fo.getCc() && fo.getCb() > fo.getCd()){
                    g.drawOval(fo.getCa(),fo.getCd(),fo.getCc()-fo.getCa(),fo.getCb()-fo.getCd());
                }
                if(fo.getCa() > fo.getCc() && fo.getCb() < fo.getCd()){
                    g.drawOval(fo.getCc(),fo.getCb(),fo.getCa()-fo.getCc(),fo.getCd()-fo.getCb());
                }
                if(fo.getCa() > fo.getCc() && fo.getCb() > fo.getCd()){
                    g.drawOval(fo.getCc(),fo.getCd(),fo.getCa()-fo.getCc(),fo.getCb()-fo.getCd());
                }   
            }
            if( fo.getForme() == 4 ){
                g.drawLine(fo.getCa(),fo.getCb(),fo.getCc(),fo.getCd());
                g.drawLine(fo.getCa(),fo.getCb(),fo.getCc()-(2*(fo.getCc()-fo.getCa())),fo.getCd());
                g.drawLine(fo.getCc()-(2*(fo.getCc()-fo.getCa())),fo.getCd(),fo.getCc(),fo.getCd());
            }
        }
        if( fenetre.getBactu() == 1){
            g.drawLine(fenetre.getPosxd(),fenetre.getPosyd(),fenetre.getPosxf(),fenetre.getPosyf());
        }
        if( fenetre.getBactu() == 2){
            
            if(fenetre.getPosxd() < fenetre.getPosxf() && fenetre.getPosyd() < fenetre.getPosyf()){
                g.drawRect(fenetre.getPosxd(),fenetre.getPosyd(),fenetre.getPosxf()-fenetre.getPosxd(),fenetre.getPosyf()-fenetre.getPosyd());
            }
            if(fenetre.getPosxd() < fenetre.getPosxf() && fenetre.getPosyd() > fenetre.getPosyf()){
                g.drawRect(fenetre.getPosxd(),fenetre.getPosyf(),fenetre.getPosxf()-fenetre.getPosxd(),fenetre.getPosyd()-fenetre.getPosyf());
            }
            if(fenetre.getPosxd() > fenetre.getPosxf() && fenetre.getPosyd() < fenetre.getPosyf()){
                g.drawRect(fenetre.getPosxf(),fenetre.getPosyd(),fenetre.getPosxd()-fenetre.getPosxf(),fenetre.getPosyf()-fenetre.getPosyd());
            }
            if(fenetre.getPosxd() > fenetre.getPosxf() && fenetre.getPosyd() > fenetre.getPosyf()){
                g.drawRect(fenetre.getPosxf(),fenetre.getPosyf(),fenetre.getPosxd()-fenetre.getPosxf(),fenetre.getPosyd()-fenetre.getPosyf());
            }   
            
        }
        if( fenetre.getBactu() == 3){
            if(fenetre.getPosxd() < fenetre.getPosxf() && fenetre.getPosyd() < fenetre.getPosyf()){
                g.drawOval(fenetre.getPosxd(),fenetre.getPosyd(),fenetre.getPosxf()-fenetre.getPosxd(),fenetre.getPosyf()-fenetre.getPosyd());
            }
            if(fenetre.getPosxd() < fenetre.getPosxf() && fenetre.getPosyd() > fenetre.getPosyf()){
                g.drawOval(fenetre.getPosxd(),fenetre.getPosyf(),fenetre.getPosxf()-fenetre.getPosxd(),fenetre.getPosyd()-fenetre.getPosyf());
            }
            if(fenetre.getPosxd() > fenetre.getPosxf() && fenetre.getPosyd() < fenetre.getPosyf()){
                g.drawOval(fenetre.getPosxf(),fenetre.getPosyd(),fenetre.getPosxd()-fenetre.getPosxf(),fenetre.getPosyf()-fenetre.getPosyd());
            }
            if(fenetre.getPosxd() > fenetre.getPosxf() && fenetre.getPosyd() > fenetre.getPosyf()){
                g.drawOval(fenetre.getPosxf(),fenetre.getPosyf(),fenetre.getPosxd()-fenetre.getPosxf(),fenetre.getPosyd()-fenetre.getPosyf());
            }   
        }
        if( fenetre.getBactu() == 4 ){
            g.drawLine(fenetre.getPosxd(),fenetre.getPosyd(),fenetre.getPosxf(),fenetre.getPosyf());
            g.drawLine(fenetre.getPosxd(),fenetre.getPosyd(),fenetre.getPosxf()-(2*(fenetre.getPosxf()-fenetre.getPosxd())),fenetre.getPosyf());
            g.drawLine(fenetre.getPosxf()-(2*(fenetre.getPosxf()-fenetre.getPosxd())),fenetre.getPosyf(),fenetre.getPosxf(),fenetre.getPosyf());
        } 
      
    }

}