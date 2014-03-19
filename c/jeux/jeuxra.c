#include "ioap123.h"
#include <time.h>
//Creation d'un jeu qui demande a l'utilisateur de trouver un nombre aleatoire généré entre 1 et 10000. Le programme lui indiqueras si le nombre entré est plus eptit ou plus grand que le nombre généré aleatoirement . On installe également un bot qui jouera et mettra a jour ses bornes pour générer un nombre aléatoire "logique".

struct mjoueur{// Creation du type joueur
  text nom;                 
  bool victoire;
  int nbcoup;};

typedef struct mjoueur joueur;

struct mbot {//creation du type bot
  text nom;
  int bbotmin;// borne  minimale et borne maximale
  int bbotmax;
  bool victoire;
  int nbcoup;};
typedef struct mbot bot;


joueur creer_joueur(){//creation d'un joueur 
  joueur plow;
  
  print_text("Entrez votre nom : ");
  plow.nom=read_line();
  plow.victoire=false;
  plow.nbcoup=0;
  return plow;}

bot creer_bot(){//creation d'un bot
  bot ia;
  print_text("Entrez le nom du bot : ");
  ia.nom=read_line();
  ia.bbotmin=1; //Ses bornes entre 1 et 10000
  ia.bbotmax=10000;
  ia.victoire=false;
  ia.nbcoup=0;
  return ia;}


int verification(int nb_by_user, bot b3){// Permet de vérifier que les nombres entré par l'utilisateur sont bien entre les bornes du bot
  int nbmodifiable=nb_by_user;
  while ((nbmodifiable>b3.bbotmax)||(nbmodifiable<b3.bbotmin)){
    print_text("Hey sale buse, t'as pas entré un nombre valide !");
    print_newline();
    print_text("Veuillez entrez un nombre valide cette fois ci !: ");
    nbmodifiable=read_int();}
  return nbmodifiable;}
// parce que si c'est 0  et que le mec rentre une lettre genre "a ou b ou c ou à..." nb modifiable sera mis a 0 et dans le programme de test ca sera valide .

int alea (int bmin, int bmax)
{                                                           //creation d'une valeur aléatoire
  int nombre;                                              //pour le choix du bot entre bmin et bmax
                                                          
    nombre = bmin + rand() % (bmax - bmin + 1);
    return nombre;
}

bot comparaisonbot(int nbchoose, int aleatoire,bot angela){// permet de mettre a jour le nombre de coup joué par le bot et de savoir s'il a gagné ou non.
  angela.nbcoup++; 

  if(nbchoose>aleatoire) {// s'il a choisi un nombre plus grand que le nombre mystere
    if(angela.bbotmax>nbchoose){//mettre a jour les bornes
      angela.bbotmax=nbchoose;}
}
  else if(nbchoose<aleatoire){// s'il a choisi un nombre plus petit que le nombre mystere
    if(angela.bbotmin<nbchoose){// Mettre a jour les bornes
      angela.bbotmin=nbchoose;}
}
 else {// s'il a trouvé le nombre mystere
   print_text (" et c'est le bon. Powned by computer");
   print_newline();
   print_newline();
   angela.victoire=true;
}
 return angela;}

 

joueur comparaison(int nbchoose, int aleatoire,joueur jambon){//Met a jour le nombre de coup, et compare 
                                                             //la valeur choisi par l'utilisateur avec le nombre mystere
  jambon.nbcoup=jambon.nbcoup+1;
 


if(nbchoose>aleatoire){
print_text ("Le nombre mystère est plus petit");
print_newline();}

 else if(nbchoose<aleatoire){
print_text ("Le nombre mystère est plus grand");
print_newline();}

 else {
   print_text ("gagné!!!!!!!");
   print_newline();
 jambon.victoire=true;}
return jambon;}



bot majbbot(bot angela,int aleatoire , int coupjoueur){      //mettre a jour les bornes du bot pandant le tour du joueur
  if((coupjoueur<aleatoire) && (angela.bbotmin<coupjoueur)){// si le coup du joueur est plus petit que le mystere mais plus grand que les bornes
    angela.bbotmin=coupjoueur;}                            //min du bot
  else if ((coupjoueur>aleatoire) && (angela.bbotmax>coupjoueur)) {//ou l'inverse
    angela.bbotmax=coupjoueur;}
  
  return angela;}

int demander_un_nombre(bot b2){//c'est évident
    int nb_demande;
    print_text("Entre un nombre entre ");
    print_int (b2.bbotmin);
    print_text(" et ");
    print_int(b2.bbotmax);
    print_text(" S.V.P : ");
    print_newline();
    nb_demande=read_int();
    return nb_demande;
}

void victoirehomme(joueur lol){// Si le joueur gagne

  print_text(lol.nom);
  print_text(" a trouvé la solution en ");
  print_int(lol.nbcoup);
  print_text(" coups ");}



void victoirebot(bot omo){//si le bot gagne
  print_text(omo.nom); 
  print_text(" vous a vraiment powned en ");
  print_int(omo.nbcoup);
  print_text(" coups");

  }


void alternance(joueur j1,bot b1,int aleatoire,int altern){// Fait alternance entre les tours du joueurs et du bot . si altern ==1 tour du joueur
  int nb,nbverif;                                                                                                   //si altern!=1 tour du bot
  joueur j1modif=j1;
  bot b1modif=b1;

  if(altern==1){
    print_text("Le nombre mystere est entre ");
    print_int(b1.bbotmin);
    print_text(" et ");
    print_int(b1.bbotmax);
    print_newline();print_newline();
    nb=demander_un_nombre(b1);                       //on obtient le nombre
    nbverif=verification(nb, b1);                      // on le vérifie
    j1modif=comparaison(nbverif,aleatoire,j1);// on met a jour le type joueur ( gagnant ou pas et nb coup joué)
    b1modif=majbbot(b1,aleatoire,nbverif);    // on met a jour les bornes du bot en fonction du coup choisi par le joueur
    print_newline();

    if(j1modif.victoire==true){victoirehomme(j1modif);} // si le joueur a trouvé lancer la fonction victoire
    else{alternance(j1modif,b1modif,aleatoire,2);}}     //sinon lancer le tour du bot

  else{
    nb=alea(b1.bbotmin,b1.bbotmax);           // nb est un nombre aleatoire généré entre les bornes min et max du bot
    b1modif=comparaisonbot(nb,aleatoire,b1);  // on regarde si le bot a gagné et on met éventuellement ses bornes a jour, on ++ son nb coup joué

    if(b1modif.victoire==true){victoirebot(b1modif);}  // si le bot a trouvé lancer la fonction victoire bot
    else{alternance(j1modif,b1modif,aleatoire,1);}}}// sinon on lance le tour du joueur




int main(){
  int nbalea;
  joueur nous;
  bot quipown;

  srand(time(NULL));
  print_text("Bienvenue: Vous allez jouer au jeu mystere contre un bot . Ce dit bot est plutôt discret; vous qui êtes doué de logique. à vous de deviner quelle valeur le bot a choisi.")
;print_newline()
;print_newline();
  nous=creer_joueur();//creation du joueur
  quipown= creer_bot();//creation du bot
  nbalea= alea(1,10000);
  alternance(nous,quipown,nbalea,1);//lancement de la partie

return 0;}





