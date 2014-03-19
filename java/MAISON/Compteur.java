public class Compteur
{

    private int val;
    private int defaut;
    private int valMin;
    private int valMax;

    public Compteur(int v,int d,int min,int max)
    {
        this.val=v;
        this.defaut=d;
        this.valMin=min;
        this.valMax=max;
    }
    
    public int getVal()
    {
        return val;
    }
    
    public int getMin()
    {
        return valMin;
    }
    
    public int getMax()
    {
        return valMax;
    }
    
    public int degDef()
    {
        return defaut;
    }
    
    public void increment(){
        this.val++;
    }
    
    public void decrement(){
        this.val--;
    }
}
