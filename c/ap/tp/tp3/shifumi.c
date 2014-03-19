#include "ioap123.h"




struct  mscore_partie{
  int p;
  int g;                                                         // creation du type score
  int n;      
};
typedef struct mscore_partie Score;




struct mjoueur{
  text nom;
  Score score;                                                    // creation du type joueur
  bool hmn;                                                      //Type joueur contient type score
};
typedef struct mjoueur Joueur;


struct mpartie{
  Joueur j1;                                                   // creation du type partie
  Joueur j2;                                                  //type partie deux type joueur qui 
  int nbmanche;                                              //contienne chacun un type score
  int nbmanchejouee;
  bool avoeugle;                                         
                                          
};
typedef struct mpartie  Partie;


int alea (int bmin, int bmax)
{                            
  int nombre;                                              
                                                          
    nombre = bmin + rand() % (bmax - bmin + 1);
    return nombre;
}


Score init (){
  Score a;
                                                           // Mettre les scores a zero
  a.g=0;
  a.p=0;
  a.n=0;
  return a;
}


Joueur creerjoueur(bool botouhumain){
  Joueur joueur;
  
  print_text(" Veuillez entrer ");

  if (botouhumain==true){print_text("votre nom svp : ");}     //Creer les joueurs,Humain ou non
  else {print_text("le nom de l'ordinateur svp : ");}   //Et renvoi toute les infos sur le joueur crée

  joueur.nom=read_line();
  joueur.score=init();
  joueur.hmn=botouhumain;
  return joueur;
}


int demandernombre(int bmin, int bmax){
  int a;                                                //Test pour savoir si le joueur à bien pris
                                                       //une valeur entre bmin et bmax
  print_text(" choisissez entrez: pierre(1), papier(2), ciseaux(3) : ");
  a=read_int();
  print_newline();

  if ((a<bmin)||(a>bmax)){
    print_text(" Non non non ! ");
    print_newline();
    demandernombre(bmin,bmax);}

  else{;} return a;}



Partie creerpartie(){
  Partie wtp;
  int humainornot;

    print_text("Le premier joueur est-il humain ? y(0)/n(1) ");// creation de j1
    humainornot=read_int();
    print_newline();

  if (humainornot==0){wtp.j1=creerjoueur(true);}
  else{wtp.j1=creerjoueur(false);}

  print_newline();
  print_text("Le second joueur est-il humain ? y(0)/n(1) ");//creation de j2
  humainornot=read_int();
  print_newline();

  if (humainornot==0){wtp.j2= creerjoueur(true);}
  else{wtp.j2= creerjoueur(false);}

  print_newline();
  print_text(" Combien de manches souaitez-vous jouer ? : ");//Nombre de manche à jouer
  wtp.nbmanche=read_int();
  wtp.nbmanchejouee=0;
  print_newline();
  print_newline();


  return wtp;}


int victoire(int j1, int j2,Partie p){
  int caca;

    if(j1==j2){
      print_newline();
      print_text(" match nul !");
      print_newline();
      caca=0;
      return caca;}
 
    else if((j1==1 && j2==3) || (j1==2 && j2==1) || (j1==3 && j2==2)) {
     print_newline();
     print_text(p.j1.nom);
     print_text(" gagne la manche!");
     print_newline();
     caca=1;

      return caca;} 

    else {
      print_newline();
      print_text(p.j2.nom);
      print_text(" gagne la manche!");
      print_newline();
      caca=2;
      return caca;}}



Partie majscore(Partie p ,int resumch){
  
 

  if(resumch==1){
    p.j1.score.g= p.j1.score.g+1;
    p.j2.score.p= p.j2.score.p+1;
    print_int(p.j1.score.g);
    print_int(p.j2.score.g);
    print_int(p.j1.score.n);
    print_int(p.j2.score.n);
 }

  else(resumch==2 && resumch !=0)
    
    p.j2.score.g= p.j2.score.g+1;
    print_int(p.j1.score.g);
    print_int(p.j2.score.g);
    print_int(p.j1.score.n);
    print_int(p.j2.score.n);
   }

  p.nbmanchejouee=p.nbmanchejouee+1;
  return p;}


Partie jouermanche (Partie encour){
  int coupj1,coupj2,vainqueur;

  if (encour.j1.hmn==true){coupj1=demandernombre(1,3);}
  else{coupj1=alea(1,3);}

  if (encour.j2.hmn==true){coupj2=demandernombre(1,3);}
  else{coupj2=alea(1,3);}

  vainqueur = victoire (coupj1,coupj2,encour);
  majscore(encour,vainqueur);

  return encour;
}


void jouerpartie(){
  Partie jeu;

jeu=creerpartie();

while(jeu.nbmanchejouee!=jeu.nbmanche){
  jouermanche(jeu);
  jeu.nbmanchejouee=jeu.nbmanchejouee+1;
 }

print_newline();





if(jeu.j1.score.g==jeu.j2.score.g){
  print_text("egalité  !");
  }

 else if(jeu.j1.score.g>jeu.j2.score.g){
  print_text(jeu.j1.nom);
  print_text(" a gagné !");
 }

 else {
 print_text(jeu.j2.nom);
 print_text(" a gagné !");
 }}


int main(){
  int  a;
 jouerpartie();


 print_newline();
 print_text("Voulez vous rejouer ? y(0)/n(1)? : ");
 a=read_int();
 print_newline();

 if (a==1){print_text("Au revoir !");}
 else {main();}

 return 0;}



 











