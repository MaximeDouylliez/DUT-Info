class Client extends Thread {
    int num_ticket;
    boolean estServi;
    DistributeurTicket distrib;
    BorneAffichage borne;
    Guichet[] tab_guichet;
    Affichage aff;

    public  Client(BorneAffichage b, DistributeurTicket d, Guichet[] g, Affichage a) {
        estServi=false;
        borne=b;
        distrib=d;
        tab_guichet=g;
        aff=a;
    }
    private void trouve_guichet(){
        int i = 0;
        while((tab_guichet[i].attend_qui()!=num_ticket) && i<tab_guichet.length)
            {i++;};
        if (i<tab_guichet.length)
            {
                tab_guichet[i].prendre_guichet(num_ticket);
            }
    }
    public synchronized void attendre() {
        while(num_ticket>borne.num_appelle())
            {
                aff.message("le client "+ num_ticket+ " se met en attente");
                borne.regarde();
            }
     }    
    public void run() {
        num_ticket = distrib.prendre();
        aff.message("Un client prend le ticket "+ num_ticket);
        attendre();
        trouve_guichet();
        aff.message("le client "+ num_ticket + " sort");
    }
}
