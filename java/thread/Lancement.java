public class Lancement{
private Test a;
private Test b;
private String poura="lol";
private String pourb="blob";
public Lancement(){

this.a=new Test(poura);
this.b=new Test(pourb);
}

public void main(){

a.start();
b.start();
try{
a.join();
b.join();
}
catch(Exception e){}}
}