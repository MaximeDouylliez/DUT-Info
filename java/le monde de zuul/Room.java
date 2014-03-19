import java.util.LinkedHashMap;
import java.util.Map;
import java.util.*;

/**
 * Class Room - a room in an adventuree
 * 
 * This class is the main class of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure .
 * 
 * A "Room" represents one location in the scenery of the . It is connected
 * to other rooms via exits. For each existing exit, the room stores a reference
 * to the neighboring room.
 * 
 * @author Michael Kolling and David J. Barnes and Julien Vion
 * @version 1.1 (March 2011)
 */

class Room {
    private final String description;
    private final Map<String, Room> exits; // stores exits of this room.
    private Objet  blob =aleaObjet();
private boolean isVisited;
    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "in a kitchen" or "in an open court
     * yard".
     */
    public Room(final String description) {
        this.description = description;
        exits = new LinkedHashMap<String, Room>();
        this.blob=blob;
        this.isVisited=false;
    }
/**
     * La list de tous les objet outs.
     */
     private ArrayList<Objet> ensObjets()
    {
     ArrayList<Objet> allItem = new ArrayList<Objet>();
       
       Objet item = new Objet("Sandwich",5);
       allItem.add(item);
       
       Objet item1 = new Objet("Asticots",0);
       allItem.add(item1);
       
       Objet item2 = new Objet("Terre",0);
       allItem.add(item2);
       
       Objet item3 = new Objet("PoisonedSandwich",-5);
       allItem.add(item3);
       
       Objet item4 = new Objet("Roches",0);
       allItem.add(item4);
       
       Objet item5 = new Objet("Dechets",0);
       allItem.add(item5);
       
       Objet item6 = new Objet("Energydrink",2);
       allItem.add(item6);
       
       Objet item7 = new Objet("Biscuits",3);
       allItem.add(item7);
       
       Objet item8 = new Objet("waterbottle",1);
       allItem.add(item8);
       
       Objet item9 = new Objet("Rottenbiscuit",-3);
       allItem.add(item9);
       
       Objet item10 = new Objet("Surprisepocket",-3);
       allItem.add(item10);
       
       
      return allItem;
       
    }
    
    public void setVisited(){
        this.isVisited=true;
    }
    public boolean getVisited(){
        return isVisited;
    }
    
    
    /**
     * Methode qui renvoie un bojet aleatoire parmi la liste ensObjet
     */
   private Objet aleaObjet ()
    {
      ArrayList<Objet> allItem =  ensObjets();
    
      int alea = (int) (Math.random() * allItem.size());
     
     
      Objet item = allItem.get(alea);  
      
      return item;
    }
    /**
     * Define an exit from this room.
     */
    public void addExit(final String direction, final Room neighbor) {
        exits.put(direction, neighbor);
    }

    /**
     * Return the description of the room (the one that was defined in the
     * constructor).
     */
    public String getDescription() {
        return description;
    }

    /**
     * Return a long description of this room, in the form: You are in the
     * kitchen. Exits: north west
     */
    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     */
    private String getExitString() {
        final StringBuilder stb = new StringBuilder();
        stb.append("Exits:");
        for (String s : exits.keySet()) {
            stb.append(' ').append(s);
        }
        return stb.toString();
    }       

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     */
    public Room getExit(final String direction) {
        return exits.get(direction);
    }
    
    /** obtenir l'objet de la salle**/
    Objet getObjet()
    {
        Objet lol=blob;
        suprObjet();
        return lol;
    }
    /** savoir si la salle contient un objet**/
    boolean hasItem()
    {
        if (blob!= null){
        return true;
    }
    else
        return false;
    }
    


private void suprObjet ()
{
this.blob=null;
}

}