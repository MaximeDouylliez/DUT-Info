public class SaveForme
{
    private int forme; // 1 -> ligne; 2 -> rectangle; 3 -> cercle; 4 -> triangle
    private int c1;
    private int c2;
    private int c3;
    private int c4;

    public SaveForme(int f, int a, int b, int c, int d)
    {
        this.forme = f;
        this.c1 = a;
        this.c2 = b;
        this.c3 = c;
        this.c4 = d;
    }
    
    public int getForme(){
        return this.forme;
    }
    
    public int getCa(){
        return this.c1;
    }
    
    public int getCb(){
        return this.c2;
    }
    
    public int getCc(){
        return this.c3;
    }
    
    public int getCd(){
        return this.c4;
    }
    
}
