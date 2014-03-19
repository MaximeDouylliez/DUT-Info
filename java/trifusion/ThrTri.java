public class ThrTri extends Thread{

private static volatile int[] depart=new int[20];
private static volatile int lgTab;
private static volatile int[] arrive= new int[20];
private int deb;
private int fin;
 
public ThrTri(int bmin, int bmax){
deb=bmin;
fin=bmax;
}

public void run(){

while (deb!=fin){
ThrTri a= new ThrTri((fin-deb)/2,fin);
fin=((fin-deb/2)-1);
a.start();
try{
a.join();}
catch(Exception e){}
}}}

//this.fusion();}

//public void fusion(){}



