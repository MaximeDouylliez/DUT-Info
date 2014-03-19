import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class GrilleGraf extends JPanel
{
    private Partie par;
    private Frame fen;
    
    private boolean c1;
    private boolean c2; 
    private boolean c3; 
    private boolean c4; 
    private boolean c5; 
    private boolean c6; 
    private boolean c7; 
    private boolean c8; 
    private boolean c9; 
    
    private boolean r1;
    private boolean r2; 
    private boolean r3; 
    private boolean r4; 
    private boolean r5; 
    private boolean r6; 
    private boolean r7; 
    private boolean r8; 
    private boolean r9; 
    

    public GrilleGraf(Partie p,Frame f)
    {
        par = p;
        fen = f;
        
        c1 = false;
        c2 = false;
        c3 = false;
        c4 = false;
        c5 = false;
        c6 = false;
        c7 = false;
        c8 = false;
        c9 = false;
        
        r1 = false;
        r2 = false;
        r3 = false;
        r4 = false;
        r5 = false;
        r6 = false;
        r7 = false;
        r8 = false;
        r9 = false;
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        //barres verticales
        g.drawLine(this.getWidth()/3,0,this.getWidth()/3,this.getHeight());
        g.drawLine((this.getWidth()/3)*2,0,(this.getWidth()/3)*2,this.getHeight());
        //barres horizontales
        g.drawLine(0,this.getHeight()/3,this.getWidth(),this.getHeight()/3);
        g.drawLine(0,(this.getHeight()/3)*2,this.getWidth(),(this.getHeight()/3)*2);
        //limites grille
        g.drawRect(0,0,this.getWidth()-1,this.getHeight()-1);   
        //dessin croix / rond
        if(par.getNb()==2){
            if(par.getTour()==1){
                //case 1 1 croix
                if((fen.geX() > 0 && fen.geX() < this.getWidth()/3 && fen.geY() > 0 && fen.geY() <this.getHeight()/3) && this.r1 == false || this.c1 == true){
                    g.setColor(Color.RED);
                    g.drawLine(10,10,(this.getWidth()/3)-10,(this.getHeight()/3)-10);
                    g.drawLine(10,(this.getHeight()/3)-10,(this.getWidth()/3)-10,10); 
                    if(c1 == false){
                        par.setTour(2);
                    }
                    this.c1 = true;
                    
                }
                //case 1 2 croix
                if((fen.geX() > this.getWidth()/3 && fen.geX() < (this.getWidth()/3)*2 && fen.geY() > 0 && fen.geY() <this.getHeight()/3) && this.r2 == false || this.c2 == true ){
                    g.setColor(Color.RED);
                    g.drawLine(10+this.getWidth()/3,10,((this.getWidth()/3)*2)-10,(this.getHeight()/3)-10);
                    g.drawLine(10+this.getWidth()/3,(this.getHeight()/3)-10,((this.getWidth()/3)*2)-10,10); 
                    if(c2 == false){
                        par.setTour(2);
                    }
                    this.c2 = true;
                    
                }
                //case 1 3 croix
                if((fen.geX() > (this.getWidth()/3)*2 && fen.geX() < this.getWidth() && fen.geY() > 0 && fen.geY() <this.getHeight()/3) && this.r3 == false || this.c3 == true ){
                    g.setColor(Color.RED);
                    g.drawLine((this.getWidth()/3)*2+10,10,this.getWidth()-10,(this.getHeight()/3)-10);
                    g.drawLine((this.getWidth()/3)*2+10,(this.getHeight()/3)-10,this.getWidth()-10,10); 
                    if(c3 == false){
                        par.setTour(2);
                    }
                    this.c3 = true;
                    
                }
                //case 2 1 croix
                if((fen.geX() > 0 && fen.geX() < this.getWidth()/3 && fen.geY() > this.getHeight()/3 && fen.geY() < (this.getHeight()/3)*2  )  && this.r4 == false || this.c4 == true ){
                    g.setColor(Color.RED);
                    g.drawLine(10,(this.getHeight()/3)+10,(this.getWidth()/3)-10,((this.getHeight()/3)*2)-10);
                    g.drawLine(10,((this.getHeight()/3)*2)-10,(this.getWidth()/3)-10,(this.getHeight()/3)+10); 
                    if(c4 == false){
                        par.setTour(2);
                    }
                    this.c4 = true;
                    
                }
                //case 2 2 croix
                if((fen.geX() > this.getWidth()/3 && fen.geX() < (this.getWidth()/3)*2 && fen.geY() > this.getHeight()/3 && fen.geY() < (this.getHeight()/3)*2  ) && this.r5 == false || this.c5 == true ){
                    g.setColor(Color.RED);
                    g.drawLine((this.getWidth()/3)+10,(this.getHeight()/3)+10,((this.getWidth()/3)*2)-10,((this.getHeight()/3)*2)-10);
                    g.drawLine((this.getWidth()/3)+10,((this.getHeight()/3)*2)-10,((this.getWidth()/3)*2)-10,(this.getHeight()/3)+10); 
                    if(c5 == false){
                        par.setTour(2);
                    }
                    this.c5 = true;
                    
                }
                //case 2 3 croix
                if((fen.geX() > (this.getWidth()/3)*2 && fen.geX() < this.getWidth()-1 && fen.geY() > this.getHeight()/3 && fen.geY() < (this.getHeight()/3)*2  ) && this.r6 == false || this.c6 == true ){
                    g.setColor(Color.RED);
                    g.drawLine(((this.getWidth()/3)*2)+10,(this.getHeight()/3)+10,this.getWidth()-10,((this.getHeight()/3)*2)-10);
                    g.drawLine(((this.getWidth()/3)*2)+10,((this.getHeight()/3)*2)-10,this.getWidth()-10,(this.getHeight()/3)+10); 
                    if(c6 == false){
                        par.setTour(2);
                    }
                    this.c6 = true;
                    
                }
                //case 3 1 croix
                if((fen.geX() > 0 && fen.geX() < this.getWidth()/3 && fen.geY() > (this.getHeight()/3)*2 && fen.geY() < this.getHeight()  )  && this.r7 == false || this.c7 == true  ){
                    g.setColor(Color.RED);
                    g.drawLine(10,((this.getHeight()/3)*2)+10,(this.getWidth()/3)-10,this.getHeight()-10);
                    g.drawLine(10,this.getHeight()-10,(this.getWidth()/3)-10,((this.getHeight()/3)*2)+10); 
                    if(c7 == false){
                        par.setTour(2);
                    }
                    this.c7 = true;
                    
                }
                //case 3 2 croix
                if((fen.geX() > this.getWidth()/3 && fen.geX() < (this.getWidth()/3)*2 && fen.geY() > (this.getHeight()/3)*2 && fen.geY() < this.getHeight()  ) && this.r8 == false || this.c8 == true ){
                    g.setColor(Color.RED);
                    g.drawLine((this.getWidth()/3)+10,((this.getHeight()/3)*2)+10,((this.getWidth()/3)*2)-10,this.getHeight()-10);
                    g.drawLine((this.getWidth()/3)+10,this.getHeight()-10,((this.getWidth()/3)*2)-10,((this.getHeight()/3)*2)+10); 
                    if(c8 == false){
                        par.setTour(2);
                    }
                    this.c8 = true;
                    
                }
                //case 3 3 croix
                if((fen.geX() > (this.getWidth()/3)*2 && fen.geX() < this.getWidth() && fen.geY() > (this.getHeight()/3)*2 && fen.geY() < this.getHeight()  )   && this.r9 == false || this.c9 == true ){
                    g.setColor(Color.RED);
                    g.drawLine(((this.getWidth()/3)*2)+10,((this.getHeight()/3)*2)+10,this.getWidth()-10,this.getHeight()-10);
                    g.drawLine(((this.getWidth()/3)*2)+10,this.getHeight()-10,this.getWidth()-10,((this.getHeight()/3)*2)+10); 
                    if(c9 == false){
                        par.setTour(2);
                    }
                    this.c9 = true;
                    
                }               
                //case 1 1 rond
                if(this.r1 == true){
                    g.setColor(Color.BLUE);
                    g.drawOval(20,20,(this.getWidth()/3)-40,(this.getWidth()/3)-40);
                    this.r1 = true;
                }
                //case 1 2 rond
                if(this.r2 == true){
                    g.setColor(Color.BLUE);
                    g.drawOval(20+(this.getWidth()/3),20,(this.getWidth()/3)-40,(this.getWidth()/3)-40);
                    this.r2 = true;
                }
                //case 1 3 rond
                if(this.r3 == true){
                    g.setColor(Color.BLUE);
                    g.drawOval(20+((this.getWidth()/3)*2),20,(this.getWidth()/3)-40,(this.getWidth()/3)-40);
                    this.r3 = true;
                }
                //case 2 1 rond
                if(this.r4 == true){
                    g.setColor(Color.BLUE);
                    g.drawOval(20,20+(this.getHeight()/3),(this.getWidth()/3)-40,(this.getWidth()/3)-40);
                    this.r4 = true;
                }
                //case 2 2 rond
                if(this.r5 == true){
                    g.setColor(Color.BLUE);
                    g.drawOval(20+(this.getWidth()/3),20+(this.getHeight()/3),(this.getWidth()/3)-40,(this.getWidth()/3)-40);
                    this.r5 = true;
                }
                //case 2 3 rond
                if(this.r6 == true){
                    g.setColor(Color.BLUE);
                    g.drawOval(20+((this.getWidth()/3)*2),20+(this.getHeight()/3),(this.getWidth()/3)-40,(this.getWidth()/3)-40);
                    this.r6 = true;
                }
                //case 3 1 rond
                if(this.r7 == true){
                    g.setColor(Color.BLUE);
                    g.drawOval(20,20+((this.getHeight()/3)*2),(this.getWidth()/3)-40,(this.getWidth()/3)-40);
                    this.r7 = true;
                }
                //case 3 2 rond
                if(this.r8 == true){
                    g.setColor(Color.BLUE);
                    g.drawOval(20+(this.getWidth()/3),20+((this.getHeight()/3)*2),(this.getWidth()/3)-40,(this.getWidth()/3)-40);
                    this.r8 = true;
                }
                //case 3 3 rond
                if(this.r9 == true){
                    g.setColor(Color.BLUE);
                    g.drawOval(20+((this.getWidth()/3)*2),20+((this.getHeight()/3)*2),(this.getWidth()/3)-40,(this.getWidth()/3)-40);
                    this.r9 = true;
                }            
            } else {
                //case 1 1 rond
                if((fen.geX() > 0 && fen.geX() < this.getWidth()/3 && fen.geY() > 0 && fen.geY() <this.getHeight()/3) && this.c1 == false||  this.r1 == true){
                    g.setColor(Color.BLUE);
                    g.drawOval(20,20,(this.getWidth()/3)-40,(this.getWidth()/3)-40);
                    if(r1==false){
                        par.setTour(1);
                    }
                    this.r1 = true;
                    
                }
                //case 1 2 rond
                if((fen.geX() > this.getWidth()/3 && fen.geX() < (this.getWidth()/3)*2 && fen.geY() > 0 && fen.geY() <this.getHeight()/3) && this.c2 == false||  this.r2 == true){
                    g.setColor(Color.BLUE);
                    g.drawOval(20+(this.getWidth()/3),20,(this.getWidth()/3)-40,(this.getWidth()/3)-40);
                    if(r2==false){
                        par.setTour(1);
                    }
                    this.r2 = true;
                    
                }
                //case 1 3 rond
                if((fen.geX() > (this.getWidth()/3)*2 && fen.geX() < this.getWidth() && fen.geY() > 0 && fen.geY() <this.getHeight()/3) && this.c3 == false||  this.r3 == true){
                    g.setColor(Color.BLUE);
                    g.drawOval(20+((this.getWidth()/3)*2),20,(this.getWidth()/3)-40,(this.getWidth()/3)-40);
                    if(r3==false){
                        par.setTour(1);
                    }
                    this.r3 = true;
                    
                }
                //case 2 1 rond
                if((fen.geX() > 0 && fen.geX() < this.getWidth()/3 && fen.geY() > this.getHeight()/3 && fen.geY() < (this.getHeight()/3)*2  ) && this.c4 == false||  this.r4 == true){
                    g.setColor(Color.BLUE);
                    g.drawOval(20,20+(this.getHeight()/3),(this.getWidth()/3)-40,(this.getWidth()/3)-40);
                    if(r4==false){
                        par.setTour(1);
                    }
                    this.r4 = true;
                    
                }
                //case 2 2 rond
                if((fen.geX() > this.getWidth()/3 && fen.geX() < (this.getWidth()/3)*2 && fen.geY() > this.getHeight()/3 && fen.geY() < (this.getHeight()/3)*2  )&& this.c5 == false||  this.r5 == true){
                    g.setColor(Color.BLUE);
                    g.drawOval(20+(this.getWidth()/3),20+(this.getHeight()/3),(this.getWidth()/3)-40,(this.getWidth()/3)-40);
                    if(r5==false){
                        par.setTour(1);
                    }
                    this.r5 = true;
                    
                }
                //case 2 3 rond
                if((fen.geX() > (this.getWidth()/3)*2 && fen.geX() < this.getWidth()-1 && fen.geY() > this.getHeight()/3 && fen.geY() < (this.getHeight()/3)*2  ) && this.c6 == false||  this.r6 == true){
                    g.setColor(Color.BLUE);
                    g.drawOval(20+((this.getWidth()/3)*2),20+(this.getHeight()/3),(this.getWidth()/3)-40,(this.getWidth()/3)-40);
                    if(r6==false){
                        par.setTour(1);
                    }
                    this.r6 = true;
                    
                }
                //case 3 1 rond
                if((fen.geX() > 0 && fen.geX() < this.getWidth()/3 && fen.geY() > (this.getHeight()/3)*2 && fen.geY() < this.getHeight()  ) && this.c7 == false||  this.r7 == true){
                    g.setColor(Color.BLUE);
                    g.drawOval(20,20+((this.getHeight()/3)*2),(this.getWidth()/3)-40,(this.getWidth()/3)-40);
                    if(r7==false){
                        par.setTour(1);
                    }
                    this.r7 = true;
                    
                }
                //case 3 2 rond
                if((fen.geX() > this.getWidth()/3 && fen.geX() < (this.getWidth()/3)*2 && fen.geY() > (this.getHeight()/3)*2 && fen.geY() < this.getHeight()  ) && this.c8 == false||  this.r8 == true){
                    g.setColor(Color.BLUE);
                    g.drawOval(20+(this.getWidth()/3),20+((this.getHeight()/3)*2),(this.getWidth()/3)-40,(this.getWidth()/3)-40);
                    if(r8==false){
                        par.setTour(1);
                    }
                    this.r8 = true;
                    
                }
                //case 3 3 rond
                if((fen.geX() > (this.getWidth()/3)*2 && fen.geX() < this.getWidth() && fen.geY() > (this.getHeight()/3)*2 && fen.geY() < this.getHeight()  ) && this.c9 == false||  this.r9 == true){
                    g.setColor(Color.BLUE);
                    g.drawOval(20+((this.getWidth()/3)*2),20+((this.getHeight()/3)*2),(this.getWidth()/3)-40,(this.getWidth()/3)-40);
                    if(r9==false){
                        par.setTour(1);
                    }
                    this.r9 = true;
                    
                }
                //case 1 1 croix
                if(this.c1 == true){
                    g.setColor(Color.RED);
                    g.drawLine(10,10,(this.getWidth()/3)-10,(this.getHeight()/3)-10);
                    g.drawLine(10,(this.getHeight()/3)-10,(this.getWidth()/3)-10,10);  
                    this.c1 = true;
                }
                //case 1 2 croix
                if(this.c2 == true ){
                    g.setColor(Color.RED);
                    g.drawLine(10+this.getWidth()/3,10,((this.getWidth()/3)*2)-10,(this.getHeight()/3)-10);
                    g.drawLine(10+this.getWidth()/3,(this.getHeight()/3)-10,((this.getWidth()/3)*2)-10,10); 
                    this.c2 = true;
                }
                //case 1 3 croix
                if(this.c3 == true ){
                    g.setColor(Color.RED);
                    g.drawLine((this.getWidth()/3)*2+10,10,this.getWidth()-10,(this.getHeight()/3)-10);
                    g.drawLine((this.getWidth()/3)*2+10,(this.getHeight()/3)-10,this.getWidth()-10,10); 
                    this.c3 = true;
                }
                //case 2 1 croix
                if(this.c4 == true ){
                    g.setColor(Color.RED);
                    g.drawLine(10,(this.getHeight()/3)+10,(this.getWidth()/3)-10,((this.getHeight()/3)*2)-10);
                    g.drawLine(10,((this.getHeight()/3)*2)-10,(this.getWidth()/3)-10,(this.getHeight()/3)+10); 
                    this.c4 = true;
                }
                //case 2 2 croix
                if(this.c5 == true ){
                    g.setColor(Color.RED);
                    g.drawLine((this.getWidth()/3)+10,(this.getHeight()/3)+10,((this.getWidth()/3)*2)-10,((this.getHeight()/3)*2)-10);
                    g.drawLine((this.getWidth()/3)+10,((this.getHeight()/3)*2)-10,((this.getWidth()/3)*2)-10,(this.getHeight()/3)+10); 
                    this.c5 = true;
                }
                //case 2 3 croix
                if(this.c6 == true ){
                    g.setColor(Color.RED);
                    g.drawLine(((this.getWidth()/3)*2)+10,(this.getHeight()/3)+10,this.getWidth()-10,((this.getHeight()/3)*2)-10);
                    g.drawLine(((this.getWidth()/3)*2)+10,((this.getHeight()/3)*2)-10,this.getWidth()-10,(this.getHeight()/3)+10); 
                    this.c6 = true;
                }
                //case 3 1 croix
                if(this.c7 == true  ){
                    g.setColor(Color.RED);
                    g.drawLine(10,((this.getHeight()/3)*2)+10,(this.getWidth()/3)-10,this.getHeight()-10);
                    g.drawLine(10,this.getHeight()-10,(this.getWidth()/3)-10,((this.getHeight()/3)*2)+10); 
                    this.c7 = true;
                }
                //case 3 2 croix
                if(this.c8 == true ){
                    g.setColor(Color.RED);
                    g.drawLine((this.getWidth()/3)+10,((this.getHeight()/3)*2)+10,((this.getWidth()/3)*2)-10,this.getHeight()-10);
                    g.drawLine((this.getWidth()/3)+10,this.getHeight()-10,((this.getWidth()/3)*2)-10,((this.getHeight()/3)*2)+10); 
                    this.c8 = true;
                }
                //case 3 3 croix
                if(this.c9 == true ){
                    g.setColor(Color.RED);
                    g.drawLine(((this.getWidth()/3)*2)+10,((this.getHeight()/3)*2)+10,this.getWidth()-10,this.getHeight()-10);
                    g.drawLine(((this.getWidth()/3)*2)+10,this.getHeight()-10,this.getWidth()-10,((this.getHeight()/3)*2)+10); 
                    this.c9 = true;
                }
            }                   
        }
    }
}

