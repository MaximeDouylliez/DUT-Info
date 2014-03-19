import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
/**
 * This class is the main class of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game. Users can walk
 * around some scenery. That's all. It should really be extended to make it more
 * interesting!
 * 
 * To play this game, create an instance of this class and call the "play"
 * method.
 * 
 * This main class creates and initialises all the others: it creates all rooms,
 * creates the parser and starts the game. It also evaluates and executes the
 * commands that the parser returns.
 * 
 * @author Michael Kolling and David J. Barnes and Julien Vion
 * @version 1.1 (March 2011)
 */

class Game {
    private final Parser parser;
    private Room currentRoom;
    private final PrintStream out;
    private List<Objet> inventaire;
    private Clodo Maxime ;
    /**
     * Creates the game to be played in a terminal
     */
    public Game() {
        this(System.in, System.out);
    }

    /**
     * Create the game and initialise its internal map.
     */
    public Game(final InputStream in, final PrintStream out) {
        createRooms();
        parser = new Parser(in);
        this.out = out;
        this.inventaire=new ArrayList<Objet>();
        this.Maxime= new Clodo();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms() {
        // create the rooms
        final Room  r1= new Room("1");
        final Room  r2= new Room("2");
        final Room  r3= new Room("3");
        final Room  r4= new Room("4");
        final Room  r5= new Room("5");
        final Room  r6= new Room("6");
        final Room  r7= new Room("7");
        final Room  r8= new Room("8");
        final Room  r9= new Room("9");
        final Room  r10= new Room("10");
        final Room  r11= new Room("11");
        final Room  r12= new Room("12");
        final Room  r13= new Room("In front of you, a legion of flies block this way !");
        final Room  r14= new Room("To the west,the sky is black");
        final Room  r15= new Room("OMG, i'ts raining showels! what the fuck is happening here.\nyou got a shock, your mind is fading away...\nYou earn a showel, and a head heck,hobo");
        final Room  r16= new Room("The extraction point, unfortunatly, you d'ont want to go out his place without get some money,Do your best ... Noob.");
        final Room  r17= new Room("Wana ride my Garbage's collector said the crasy who is repeating this sentence forever");
        final Room  r18= new Room("Still growing, garbage plant atempts to claim some food out of e-waste's stacks");
        final Room  r19= new Room("In the entrance garbage world.All around you smells alike dead flesh.\nCristopher's cadaver spread on the ground ,surround by worms and rats.");
        final Room  r20= new Room("and where all your hobo friend comes to earn some money by blowjobing heavy truckman");
        final Room  r21= new Room("In this corner of land you would be able to get some help by manufacturing suicide machine");
        
        // initialise room exits
        r19.addExit("north",r14);
        r19.addExit("west",r18);
        r19.addExit("east",r20);

        r18.addExit("west",r17);
        r18.addExit("east",r19);

        r17.addExit("north",r13);
        r17.addExit("east",r18);
        
        r13.addExit("south",r17);
        
        r14.addExit("south",r19);
        r14.addExit("east",r15);
        
        r20.addExit("north",r15);
        r20.addExit("west",r19);
        r20.addExit("east",r21);
        
        r21.addExit("north",r16);
        r21.addExit("west",r20);
        
        r16.addExit("north",r12);
        r16.addExit("south",r21);
        r16.addExit("west",r15);
        
        r15.addExit("north",r11);
        r15.addExit("south",r20);
        r15.addExit("west",r14);
        r15.addExit("east",r16);
        
        r12.addExit("south",r16);
        r12.addExit("west",r11);
        
        r11.addExit("north",r9);
        r11.addExit("east",r12);
        
        r9.addExit("north",r4);
        r9.addExit("west",r8);
        
        r4.addExit("south",r9);
        r4.addExit("west",r3);
        r4.addExit("east",r5);
        
        r5.addExit("west",r4);
        
        r8.addExit("north",r3);
        r8.addExit("west",r7);
        r8.addExit("east",r9);
        
        r3.addExit("south",r8);
        r3.addExit("west",r2);
        r3.addExit("east",r4);
        
        r2.addExit("west",r1);
        r2.addExit("east",r3);
        
        r1.addExit("south",r6);
        r1.addExit("east",r2);
        
        r6.addExit("north",r1);
        r6.addExit("east",r7);
        
        r7.addExit("west",r6);
        r7.addExit("east",r8);
        r7.addExit("south",r10);
      
        
        
        
        
        
        currentRoom =r19; // start game at entrance of garbage world
    }

    /**
     * Main play routine. Loops until end of play.
     */
    public void play() {
        printWelcome();

        /*
         * Enter the main command loop. Here we repeatedly read commands and
         * execute them until the game is over.
         */
        boolean finished;
        do {
            affHud();
            final Command command = parser.getCommand(out);
            finished = processCommand(command);
        } while (!finished && Maxime.isAlive());
        out.println("Vous avez perdus,NOOB!");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        out.println();
        out.println("Welcome to Adventure!");
        out.println("You have to survive in extreme poorness of your hobo's condition.\ntake care of your life and dig if necessary to grabe some food. \nBeware you can't hurt yourself while diging. \nEat some rotten food can even poison you.\nHave you the soul of a hobo and and the will to become rich");
        out.println("Type 'help' if you need help.");
        out.println();
        out.println(currentRoom.getLongDescription());
    }
    
    private void affHud(){
        int i;
        Objet item;
        if (inventaire.size()>0){
            out.println();
            out.print("Votre inventaire: ");
            for(i=0;i<inventaire.size();i++){
                item=inventaire.get(i);
                out.print(item.getNom()+" ");
            }
        }
            out.println();
            out.println("Votre vie: "+Maxime.getVie());
            
        }
            
    
    private void dig(){
        double a;
        
        Maxime.Modifier_vie(-1);
        
        if(existObj(currentRoom)==true){
            int i,j=0;
            
            Objet pelle=new Objet("lol" ,5);
                if(inventaire.contains(pelle)){
                    j++;}
            
            if(j>0){
                a = 15*Math.random()+7;
            } else {
                a = 15*Math.random()+3;
            }
            if(a<6){Maxime.Modifier_vie(-10);
            out.println("Vous vous êtes blessé en creusant avec vos mains de clodo");}
            else if(a<8) {
                
                out.println("Vous ne trouvez rien !!!");
               
            } else {
                if(inventaire.size()<5){
                out.println("Vous trouvez quelque chose !!!");
                inventaire.add(currentRoom.getObjet());
                } else{
                out.println("Votre inventaire est plein,êtes vous vraiment un clodo ?"); 
               
            }
            
        
         }  
      }
      else out.print("Vous ne trouvez rien");
      
    }
    
    private void use(Command nomObj) {
        
        String lol=nomObj.getSecondWord();
        Objet item;
        int i;
        double a;
        for(i=0;i<inventaire.size();i++) {
            item=inventaire.get(i);
        
      
             if(item.getNom().equals(lol)){
                 if(inventaire.contains(item)){
                    out.print("Vous utilisez ");
                    out.println(item.getNom());
                   a= 15*Math.random()+3;
                   a=a+item.getEffet();
                   
                   if(a<6){
                      Maxime.Modifier_vie(-50);
                    }else if(a>12){
                        Maxime.Modifier_vie(25);
                    }
                    inventaire.remove(inventaire.indexOf(item));
                    i=665;
                } }}
                if(i!=666){
                     out.println("Vous ne possedez pas ceci !");
                    }
             
       
        

       }    
    
         
 
     /**
     * La list de tous les objet outs.
     *
     private ArrayList<Objet> ensObjets()
    {
     ArrayList<Objet> allItem = new ArrayList<Objet>();
       
       
       Objet item = new Objet("Sandwich",5);
       allItem.add(item);
       
       Objet item1 = new Objet("Asticots",0);
       allItem.add(item1);
       
       Objet item2 = new Objet("Terre",0);
       allItem.add(item2);
       
       Objet item3 = new Objet("PoisonedSandwich",-8);
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
       
    }*/
    
    /**
     * Methode qui renvoie un bojet aleatoire parmi la liste ensObjet
     *
    private Objet aleaObjet ()
    {
      ArrayList<Objet> allItem =  ensObjets();
    
      int alea = (int) (Math.random() * allItem.size());
     
     
      Objet item = allItem.get(alea);  
      
      return item;
    }*/

   private boolean existObj( final Room salle){
        if(salle.hasItem()== true) return true;
        else return false;
    }
    /**
     * Given a command, process (that is: execute) the command. If this command
     * ends the game, true is returned, otherwise false is returned.
     */
    private boolean processCommand(final Command command) {
        final boolean wantToQuit;

        if (command.isUnknown()) {
            out.println("I don't know what you mean...");
            wantToQuit = false;
        } else {
            
            final CommandWord commandWord = command.getCommandWord();
            switch (commandWord) {
            case GO:
                goRoom(command);
                wantToQuit = false;
                break;
            case DIG:
                dig();
                wantToQuit = false;
                break;
            case USE:
                use(command);
                wantToQuit = false;
                break;
            case QUIT:
                wantToQuit = quit(command);
                break;
            case HELP:
            default:
                printHelp();
                wantToQuit = false;
                break;
            }

        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information. Here we print some stupid, cryptic
     * message and a list of the command words.
     */
    private void printHelp() {
        out.println("You are lost. You are alone. You wander");
        out.println("around at the university.");
        out.println();
        out.println("Your command words are:");
        out.println(Parser.commands());
    }

    /**
     * Try to go to one direction. If there is an exit, enter the new room,
     * otherwise print an error message.
     */
    private void goRoom(final Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            out.println("Go where?");
            return;
        }

        final String direction = command.getSecondWord();

        // Try to leave current room.
        final Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            currentRoom.setVisited();
            
            Maxime.Modifier_vie(-5);
            out.println(currentRoom.getLongDescription());
        }
    }

    /**
     * "Quit" was entered. Check the rest of the command to see whether we
     * really quit the game. Return true, if this command quits the game, false
     * otherwise.
     */
    private boolean quit(final Command command) {
        if (command.hasSecondWord()) {
            out.println("Quit what?");
            return false;
        }
        return true; // signal that we want to quit
    }

    public static void main(final String[] args) {
        new Game().play();
    }
}
