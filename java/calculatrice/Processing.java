public class Processing{

public Processing(){;}

public double addition (double a, double b){return a+b;}

public double soustraction(double a, double b){return a-b;}

public double multiplication (double a, double b){return a*b;}

public double division (double a, double b) throws zeroException{

try{
if(b==0) throw new zeroException();
}

catch(zeroException e){
System.out.println("Syntax Error");
}

return a/b;}

}