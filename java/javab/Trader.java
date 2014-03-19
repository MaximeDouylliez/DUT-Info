import java.io.Serializable;
import java.beans.*;

public class Trader implements Serializable {
  protected String mot;
  
  
  PropertyChangeSupport cs;
  VetoableChangeSupport vcs;

  public Trader(){ 
    	this.mot = "lol";
	
    vcs= new VetoableChangeSupport(this);
    cs = new PropertyChangeSupport(this);
  }
  
  public void setMise(String mot) throws PropertyVetoException{
	
		String oldMise = this.mot;	
		this.mot = mot;
		cs.firePropertyChange("mot",oldMise,mot);
		try{
			vcs.fireVetoableChange("mot", oldMise, mot);
			System.out.println("Recherche effectué");
		}catch(PropertyVetoException e){
			System.out.println("Recherche refusé par véto");
			this.mot=oldMise;
		}
	}

  public String getMise() {
    return mot;
  }

  
  
 
   

  public void addPropertyChangeListener(PropertyChangeListener l) {
    cs.addPropertyChangeListener(l);
  }
  
  public void removePropertyChangeListener(PropertyChangeListener l) {
    cs.removePropertyChangeListener(l);
  }

  public void  addVetoableChangeListener(VetoableChangeListener l){
		vcs.addVetoableChangeListener (l);
	}

     public void  removeVetoableChangeListener(VetoableChangeListener l){
		vcs.removeVetoableChangeListener (l);	
	 }
}
