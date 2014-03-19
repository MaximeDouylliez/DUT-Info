public class Tre extends Thread{

private int a;
private int b;
private int d;
private int c;
private int rez;

public Tre(int a,int b ){
this.a=a;
this.b=b;
}

public void run(){
c=c+a;
d=d+b;
;}

public int getRez1(){return c;}
public int getRez2(){return d;}
}