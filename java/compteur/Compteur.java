

public class Compteur
{

private int maxVal;
private int minVal;
private int rezVal;
private int val;

public Compteur (int min,int max,int rez){
maxVal=max;
minVal=min;
val=rez;
rezVal=val;
}

public void add()throws tropHaut{

try{ if(val==maxVal) throw new tropHaut("La valeur est au maximum");
else val++;}
catch(tropHaut e){System.out.println(e.getMessage());}

}  

public void sub()throws tropBas{

try{ if(val==minVal) throw new tropBas("La valeur est au minimum"); 
else val--;}
catch(tropBas e){System.out.println(e.getMessage());}

}   

public void rez(){val=rezVal;}

}