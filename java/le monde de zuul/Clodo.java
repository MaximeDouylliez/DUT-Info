
/**
 * Write a description of class Clodo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Clodo
{
    // instance variables - replace the example below with your own
    private int vie;
    private boolean isAlive;

    /**
     * Constructor for objects of class Clodo
     */
    public Clodo()
    {
        // initialise instance variables
        vie = 100;
        isAlive=true;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void Modifier_vie(int x)
    {
        // put your code here
        vie = this.getVie()+x;
        if(vie<1){


            isAlive=false;






        }
    }
    
    public int getVie(){
        return vie;

    }
    
    public boolean isAlive(){
        return isAlive;
    }
}
