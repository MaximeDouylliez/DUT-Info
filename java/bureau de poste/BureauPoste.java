class BureauPoste {

    public static void main(String [] args){
        DistributeurTicket DisTicket = new DistributeurTicket();
        BorneAffichage Borne_aff = new BorneAffichage();
        Affichage aff = new Affichage();

        Guichet [] tab_guichet = new Guichet[3];

        int i;
        int nb_client = 0;
        for(i=0;i<3;i++) 
            {
                tab_guichet[i]= new Guichet(Borne_aff,aff,i);
                tab_guichet[i].start();
            }
        for (i=1;i<10;i++)
            {
                System.out.println("Creation du client "+ i);
                (new Client(Borne_aff,DisTicket,tab_guichet,aff)).start();
                nb_client++; 
            }
    }

}
