class BorneAffichage {
    int dernier_appelle=0;

    public int num_appelle(){
        return dernier_appelle;
    }
    public synchronized int next () {
        dernier_appelle++;
        notifyAll();
        return dernier_appelle;
    }
    public synchronized void regarde(){
        try {  
            wait();
        }
        catch(InterruptedException e) {};

    }
}
