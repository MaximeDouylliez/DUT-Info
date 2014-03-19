
class Guichet extends Thread {
    int numero_client_attendu;
    int num_guichet;
    boolean libre;
    BorneAffichage borne;
    Affichage aff;

    public  Guichet(BorneAffichage b, Affichage a, int num){
        libre=true;
        borne = b;
        aff = a;
        num_guichet = num;
        aff.message("\t\tCréation du guichet ");
    }
    public int attend_qui(){
        return numero_client_attendu;
            }
    public synchronized void prendre_guichet (int numClient) {
        if (numClient == numero_client_attendu)
           {
               libre=false;
               aff.message("\t\tLe client avec le ticket " + numClient + " prend un guichet");
               servir_client();
               notify();
           }
    }
    public synchronized void attendre_etre_servi() {
        try {  
            wait();}
        catch(InterruptedException e) {};
    }
    public synchronized void attente() {
        if(libre==true) {
            try {
                aff.message("\t\tle guichet " + num_guichet +  " attend le client" + numero_client_attendu);
                wait(); // bloque jusqu'a un notify()
            }
            catch(InterruptedException e) {};
        }
    }
    private void servir_client() {
        aff.message("\t\tle guichet " + num_guichet +  " sert le client "+numero_client_attendu);
         try { Thread.currentThread().sleep(1000);  }
            catch(InterruptedException e) {};                   
    }
    private synchronized void libere_client() {
        notify();
    }
    public boolean guichet_libre () {
        return libre;
    }
    public void run(){
        while(true)
            {
                numero_client_attendu = borne.next();
                attente();
                libre=true;
            }
    }
}
