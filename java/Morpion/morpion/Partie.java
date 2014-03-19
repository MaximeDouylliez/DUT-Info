public class Partie
{
    
    private int nbjoueurs;
    private String j1;
    private String j2;
    private int p1;
    private int p2;
    private int tour; // 1 -> croix ; 2 -> rond

    public Partie()
    {
        this.tour=2;
    }
    
    int getScore1(){
        return p1;
    }
    
    void setScore1(int i){
        this.p1 = i;
    }
    
     int getScore2(){
        return p2;
    }
    
    void setScore2(int i){
        this.p2 = i;
    }       
    
    int getTour(){
        return tour;   
    }
    
    void setTour(int i){
        this.tour = i;
    }
    
    int getNb(){ 
        return this.nbjoueurs;
    }
    
    void setNb(int i){
        this.nbjoueurs=i;
    }
    
    void setJ1(String s){
        this.j1=s;   
    }
    
    String getJp(){
        return this.j1;
    }
    
    String getJd(){
        return this.j2;
    }

    void setJ2(String s){
        this.j2=s;
    }
}
