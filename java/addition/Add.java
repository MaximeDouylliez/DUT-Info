public class Add{

private Tre premier;
private Tre second;
public Add(){
}

public void main(){
premier=new Tre(2,3);
second =new Tre(5,1);
premier.start();
second.start();
try{
premier.join();
second.join();}
catch(Exception e){};
System.out.println(premier.getRez1()*second.getRez2());
}
}
