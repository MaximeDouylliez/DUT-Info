
public class Test extends Thread
{
    private String s;
    private int ca =5;

public Test(String m){this.s=m;}


public void run (){
while(ca<30){
ca++;
System.out.println(ca);
System.out.println(s);
}
}

}