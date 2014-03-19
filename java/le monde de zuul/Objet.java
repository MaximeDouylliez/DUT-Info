/**
 * La classe objet regroupe tous les objets possibles
 * leur description et leur effet
 * elle contient aussi l'objet inventaire qui correspond au sac du joueur
 * 
 * @author (Projet ) 
 * 
 */
public class Objet
{
    // caracteristiques des objets (instances)
    private String nom ;
    private int effet; // en fonction de la valeur il perd ou gagne des PVs
   

    /**
     * construit un objet
     */
    public Objet(final String nom, final int effet)
    {
        this.nom = nom;
        this.effet = effet ;
    }
   
    /**
     * renvoie le nom de l'objet
     */
    public String getNom()
    {
        return nom;
    }
    
    /**
     * renvoie l'effet de l'objet
     */
    public int getEffet ( )
    {
        return effet ;
    }
    
    
}
