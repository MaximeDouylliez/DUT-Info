#include "ioap123.h"

struct mjoueur{
  text nom;
  bool victoire;
  int nbcoup;};

typedef struct mjoueur joueur;

struct mbot {
  text nom;
  int bbotmin;
  int bbotmax;
  bool victoire;
  int nbcoup;};
typedef struct mbot bot;


joueur creer_joueur(){
  joueur plow;
  
  print_text("Entrez votre nom : ");
  plow.nom=read_line();
  plow.victoire=false;
  plow.nbcoup=0;
  return plow;}

bot creer_bot(){
  bot ia;
  print_text("Entrez le nom du bot : ");
  ia.nom=read_line();
  ia.bbotmin=0;
  ia.bbotmax=10000;
  ia.victoire=false;
  ia.nbcoup=0;
  return ia;}


int verification(int nb_by_user){
  int nbmodifiable=nb_by_user;
  while ((nbmodifiable>10000)||(nbmodifiable<0)){
    print_text("Hey sale buse, t'as pas entré un nombre valide !");
    print_newline();
    print_text("Veuillez entrez un nombre valide cette fois ci !: ");
    nbmodifiable=read_int();}
  return nbmodifiable;}


int alea (int bmin, int bmax)
{                                                           //creation d'une valeur aléatoire
  int nombre;                                              //pour le choix du bot entre 1.2.3
                                                          
    nombre = bmin + rand() % (bmax - bmin + 1);
    return nombre;
}

bot comparaisonbot(int nbchoose, int aleatoire,bot angela){
  print_text("le bot a choisi le nombre "); 
  print_int(nbchoose);
  angela.nbcoup++;

  if(nbchoose>aleatoire) {
print_text (" qui est plus grand que le nombre mystere");
print_newline();
 print_newline();
if(angela.bbotmax>nbchoose){
   angela.bbotmax=nbchoose;}
}
else if(nbchoose<aleatoire){
  print_text (" qui est plus petit  que le nombre mystere");
  print_newline();
  print_newline();
  if(angela.bbotmin<nbchoose){
    angela.bbotmin=nbchoose;}
}
 else {
   print_text (" et c'est le bon. Powned by computer");
   print_newline();
   print_newline();
   angela.victoire=true;
}
 return angela;}

 

joueur comparaison(int nbchoose, int aleatoire,joueur jambon){
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

bot majbbot(bot angela,int aleatoire , int coupjoueur){
  if((coupjoueur<aleatoire)&&(angela.bbotmin<coupjoueur)){
    angela.bbotmin=coupjoueur;}
    else if ((coupjoueur>aleatoire) && (angela.bbotmax>coupjoueur)) {
    angela.bbotmax=coupjoueur;}
  else{}
  return angela;}

int demander_un_nombre(){
    int nb_demande;
    print_text("Entre un nombre entre 1 et 10000 S.V.P");
    print_newline();
    nb_demande=read_int();
    return nb_demande;
}

void victoirehomme(joueur lol){

  print_text(lol.nom);
  print_text(" a trouvé la solution en ");
  print_int(lol.nbcoup);
  print_text(" coups ");}

void victoirebot(bot omo){
  print_text(omo.nom); 
  print_text(" vous a vraiment powned en ");
  print_int(omo.nbcoup);
  print_text(" coups");

  }


void alternance(joueur j1,bot b1,int aleatoire,int altern){
  int nb,nbverif;
  joueur j1modif;
  bot b1modif;

  if(altern==1){
    nb=demander_un_nombre();
    nbverif=verification(nb); 
    j1modif=comparaison(nbverif,aleatoire,j1);
    b1modif=majbbot(b1,aleatoire,nbverif);
    print_newline();

    if(j1modif.victoire==true){victoirehomme(j1modif);}
    else{alternance(j1modif,b1modif,aleatoire,2);}}

  else{
    nb=alea(b1.bbotmin,b1.bbotmax);
    b1modif=comparaisonbot(nb,aleatoire,b1);

    if(b1modif.victoire==true){victoirebot(b1modif);}
    else{alternance(j1modif,b1modif,aleatoire,1);}}}




int main(){
  int nbalea;
  joueur nous;
  bot quipown;

  nous=creer_joueur();
  quipown= creer_bot();
  nbalea= alea(0,10000);
  alternance(nous,quipown,nbalea,1);

return 0;}





