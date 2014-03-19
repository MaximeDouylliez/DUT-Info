import java.beans.*;
import java.util.*;
import java.beans.PropertyVetoException;

public class simulTrader {

  public static void main(String[] args) throws PropertyVetoException{
    new simulTrader();
  }
  
  public simulTrader() throws PropertyVetoException{
   	Trader unTrader = new Trader();
   	superviseur unchef=new superviseur();
	
	
	unTrader.addVetoableChangeListener(unchef);
                               
	System.out.println("mise de depart = " + unTrader.getMise());
	

	unTrader.setMise("lol");


	System.out.println("mise arrivée= " + unTrader.getMise());
	
	
	unTrader.removeVetoableChangeListener(unchef);
	System.out.println("on a supprimé l'acces au superviseur");

	unTrader.setMise("plop"); 
	

	System.out.println("mise arrivée= " + unTrader.getMise());
	

	unTrader.addVetoableChangeListener(unchef);
	System.out.println("on remet l'acces au superviseur");

	unTrader.setMise("caca"); 
	

	System.out.println("mise arrivée= " + unTrader.getMise());
	

  }
}
