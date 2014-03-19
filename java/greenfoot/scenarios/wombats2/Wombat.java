import greenfoot.*;  // imports Actor, World, Greenfoot, GreenfootImage

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Wombat. A Wombat moves forward until it can't do so anymore, at
 * which point it turns left. This wombat can not move over rocks. 
 * If a wombat finds a leaf, it eats it.
 * 
 * @author Michael Kolling
 * @version 1.0.1
 */
public class Wombat extends Actor
{
    private static final int EAST = 0;
    private static final int WEST = 1;
    private static final int NORTH = 2;
    private static final int SOUTH = 3;

    private int direction;
    private int leavesEaten;
    
    private GreenfootImage wombatRight;
    private GreenfootImage wombatLeft;
    
    public Wombat()
    {
        wombatRight  = getImage();
        wombatLeft = new GreenfootImage(getImage());
        wombatLeft.mirrorHorizontally();
        
        setDirection(EAST);
        leavesEaten = 0;
    }

    public Leaf nearestLeaf()
  { 
        List<Leaf> l=getLeaves();
        Leaf feuille,arenvoyer=l.get(0);
        int i,ppr=100,temp;
    
        for(i=0;i<l.size();i++)
        {
    feuille= l.get(i);
    temp=Math.abs(getX()-feuille.getX())+Math.abs(getY()-feuille.getY());
    if(temp<ppr)
    ppr=temp;
    arenvoyer=l.get(i);
}
return arenvoyer;
}
    
    
    public List<Leaf> getLeaves ()
    {
        return Collections.unmodifiableList(
        (List<Leaf>)getWorld().getObjects(
        Leaf.class));
    }
    
    /**
     * Do whatever the wombat likes to to just now.
     */
    public void act()
    {List<Leaf> l =getLeaves();
        if(foundLeaf()) {
            eatLeaf();
        }
       
        else if(canMove() && l.size()>0) {
           ChooseWay();
            move();
        }
        else {
            turnRandom();
        }
    }

    /**
     * Check whether there is a leaf in the same cell as we are.
     */
    public boolean foundLeaf()
    {
        Actor leaf = getOneObjectAtOffset(0, 0, Leaf.class);
        if(leaf != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Eat a leaf.
     */
    public void eatLeaf()
    {
        Actor leaf = getOneObjectAtOffset(0, 0, Leaf.class);
        if(leaf != null) {
            // eat the leaf...
            getWorld().removeObject(leaf);
            leavesEaten = leavesEaten + 1; 
        }
    }
    
    
    public void ChooseWay()
    {
        Leaf l=nearestLeaf();
        
    int x=getX()-l.getX();//si sup alr wombat a droite de la feuille sinon a gauche
    int y=getY()-l.getY();//si sup alr wombat plus bas sinon plus haut
    //int z=Math.abs(x)-Math.abs(y);//si sup alors plus de distance horizontale sinon laterale
    //d=0,b=1,g=2,h=3
    //if(z>=0)
    //{
        if(x>0)
       setDirection(WEST);
        else if(x<0) 
        setDirection(EAST);
    //}   
    // else 
      //  {   
        else if(y>0)
        setDirection(NORTH);
        else setDirection(SOUTH);
   // }
}
    /**
     * Move one cell forward in the current direction.
     */
    public void move()
    {
        if (!canMove()) {
            return;
        }
        switch(direction) {
            case SOUTH :
                setLocation(getX(), getY() + 1);
                break;
            case EAST :
                setLocation(getX() + 1, getY());
                break;
            case NORTH :
                setLocation(getX(), getY() - 1);
                break;
            case WEST :
                setLocation(getX() - 1, getY());
                break;
        }
    }

    /**
     * Test if we can move forward. Return true if we can, false otherwise.
     */
    public boolean canMove()
    {
        World myWorld = getWorld();
        int x = getX();
        int y = getY();
        switch(direction) {
            case SOUTH :
                y++;
                break;
            case EAST :
                x++;
                break;
            case NORTH :
                y--;
                break;
            case WEST :
                x--;
                break;
        }
        // test for outside border
        if (x >= myWorld.getWidth() || y >= myWorld.getHeight()) {
            return false;
        }
        else if (x < 0 || y < 0) {
            return false;
        }
        List rocks = myWorld.getObjectsAt(x, y, Rock.class);
        if(rocks.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Turn in a random direction.
     */
    public void turnRandom()
    {
        // get a random number between 0 and 3...
        int turns = Greenfoot.getRandomNumber(4);
        
        // ...an turn left that many times.
        for(int i=0; i<turns; i++) {
            turnLeft();
        }
    }

    /**
     * Turns towards the left.
     */
    public void turnLeft()
    {
        switch(direction) {
            case SOUTH :
                setDirection(EAST);
                break;
            case EAST :
                setDirection(NORTH);
                break;
            case NORTH :
                setDirection(WEST);
                break;
            case WEST :
                setDirection(SOUTH);
                break;
        }
    }

    /**
     * Sets the direction we're facing.
     */
    public void setDirection(int direction)
    {
        this.direction = direction;
        switch(direction) {
            case SOUTH :
                setImage(wombatRight);
                setRotation(90);
                break;
            case EAST :
                setImage(wombatRight);
                setRotation(0);
                break;
            case NORTH :
                setImage(wombatLeft);
                setRotation(90);
                break;
            case WEST :
                setImage(wombatLeft);
                setRotation(0);
                break;
            default :
                break;
        }
    }

    /**
     * Tell how many leaves we have eaten.
     */
    public int getLeavesEaten()
    {
        return leavesEaten;
    }
}