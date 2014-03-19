

public class T extends Thread
{
   private String mess;
   private volatile static String[] list= new String[1000];
   private volatile static int index=0;
   private static boolean isReady=false;
   
    public T(String messss)
    {
        this.mess=messss;
    }
    
     public static void setReady(boolean a){isReady=a;}
    
    public static String[] get_list(){ return list;}
    
    
    public void run(){
   int i=0;
   int t1;
   
    java.util.Random r=new java.util.Random( ) ; 

    while(index!=21){
        if(isReady==false)yield();
     if((r.nextInt(2))==0){
     System.out.println(mess + " donne la main");
   try{  T.sleep(100);}
   catch(InterruptedException e){}
   
}
     else{

        list[index]=mess;
        System.out.println(mess + index);
         index++;
         
        }
    }

}

    public static int get_index(){ return index;}
   
    

}
