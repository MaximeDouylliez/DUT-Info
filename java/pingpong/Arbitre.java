

public class Arbitre extends Thread
{
   
    private static volatile int ping=0;
    private static volatile int pong=0;
    private static volatile int fin=0;

    T tping;
    T tpong;
    /**
     * Constructor for objects of class Arbitre
     */
    public Arbitre()
    {
        ping=0;
        pong=0;
        
    }

    public void point_ping(){ ping++;}
    public void point_pong(){ pong++;}
    
    
    
    
    public void lecture(){
        String[] listetab=T.get_list();
        int index=T.get_index();
        int i=0;
        while ((this.ping<11) && (this.pong<11) && (i<=21) )
        {
            index=T.get_index();
            if(i>=index-1)
            yield();
            else{
            
                   
            if (listetab[i].equals(listetab[i+1])){
                i++;
                if(listetab[i].equals("pong"))
                pong++;
                else
                ping++;
            }
             else{i++;}
            }
            }
            this.fin=1;
            if(ping>=11 && pong<11)
            System.out.println("PoulainPing a gagné");
            else 
            if(pong>=11)
            System.out.println("MaximePong a gagné");
            else
            {System.out.println("Match Nul");}
            
            System.out.println(ping);
            System.out.println(pong);
            
        }
            
            
           
        
    
    
    
    public void main(){
        
         tpong=new T("pong");
         tping= new T("ping");
         tpong.start();
         tping.start();
         T.setReady(true);
         lecture();
        }
         
         
         
       
        
      
        
        
    
    
   
}
