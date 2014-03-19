public class Groupe{
private  int [][] plateau;
private boolean isJ1Turn;

public  Groupe(){
plateau= new int[3][3];
isJ1Turn=true;
}

public boolean isValide(int idJoueur, int largeur, int hauteur){

    if (isJ1Turn==true){
        return (plateau [largeur][hauteur]==0 && idJoueur==1);
    }

    else {
        return (plateau [largeur] [hauteur]==0 && idJoueur==2);
    }


}


public boolean jouerCoup(int idJoueur,int largeur, int hauteur){

if(isValide(idJoueur,largeur,hauteur)){

plateau[largeur] [hauteur]=idJoueur;
if(isJ1Turn==true)
isJ1Turn=false;
else 
isJ1Turn=true;
return true;}


else 
return false;
}

public int[][] getPlateau(){return plateau;}
}