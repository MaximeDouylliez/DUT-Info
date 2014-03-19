import java.beans.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

public class superviseur implements PropertyChangeListener, VetoableChangeListener
{


public void propertyChange(PropertyChangeEvent event) {

	if (event.getPropertyName().equals("recherche")&&(event.getNewValue()!=event.getOldValue())) System.out.println("changement sur  : recherche = "+ event.getNewValue());
	//if ((event.getPropertyName().equals("nb"))&&((Integer)event.getNewValue() > 1)) System.out.println("changement sur : nb = "+ event.getNewValue());
     }

  public void vetoableChange(PropertyChangeEvent event) throws PropertyVetoException {
      String mot="caca";
      
		if((event.getPropertyName().equals("mise")) && mot.equals( ((String)event.getNewValue())))
			throw new PropertyVetoException("Veto",event);
		//if((event.getPropertyName().equals("nb")) && ((Integer)event.getNewValue()>=10))
		//	throw new PropertyVetoException("Veto",event);
	}
	

}
