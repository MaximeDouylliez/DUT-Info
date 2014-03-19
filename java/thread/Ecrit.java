

public class Ecrit extends Thread
{

    private String texte;
    private int nb;

    public Ecrit(String text, int nbr)
    {
        this.texte=text;
        this.nb=nbr;

    }

    public void run()
    {
            for(int i=0;i<nb;i++)
                System.out.println(texte+"");
    }

public static void main(String args[])
{
       Ecrit e1=new Ecrit ("Hello",5);

            e1.start();
}
}
