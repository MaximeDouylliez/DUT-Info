struct  mscore_partie
{
  int p;
  int g;                                                         // creation du type score
  int n;      
};
typedef struct mscore_partie Score;




struct mjoueur
{
  text nom;
  Score score;                                                    // creation du type joueur
  bool hmn;                                                      //Type joueur contient type score
};
typedef struct mjoueur Joueur


struct mpartie
{
  Joueur j1;                                                   // creation du type partie
  Joueur j2;                                                  //type partie deux type joueur qui 
  int nbmanche;                                              //contienne chacun un type score
  int nbmanchejouee;
  bool avoeugle;                                         
                                          
};
typedef struct mpartie  Partie;


int alea (int bmin, int bmax)
{                                                           //creation d'une valeur aléatoire
  int nombre;                                              //pour le choix du bot entre 1.2.3
                                                          
    nombre = bmin + rand() % (bmax - bmin + 1);
    return nombre;
}


Score init (){
  Score a;
                                                           // Mettre les scores a zero
  a.g=0;
  a.p=0;
  a=n=0;
  return a;
}


Joueur creerjoueur(bool botouhumain){
  Joueur joueur;
  
  print_text(" Veuillez entrer ");

  if (humain==true){print_text("votre nom svp : ");}     //Creer les joueurs,Humain ou non
  else {print_text("le nom de l'ordinateur svp : ");}   //Et renvoi toute les infos sur le joueur crée

  joueur.nom=read_text();
  joueur.score=init();
  joueur.hmn=botouhumain;
  return joueur;
}


int demandernombre(int bmin, int bmax){
  int a;                                                //Test pour savoir si le joueur à bien pris
                                                       //une valeur entre bmin et bmax
  print_text("Veuillez entrez un nombre compris entre ");  
  print_int(bmin);
  print_text(" et ");
  print_int(bmax);
  print_text(" svp : ");
  a=read_int();

  if ((a<bmin)||(a>bmax)){
    print_text(" Non non non ! ");
    demandernombre(bmin,bmax);}

  else return a;}



Partie creerpartie(int a ){
  Partie wtp;
  char humainornot;
  char x;

    print_text("Le premier joueur est-il humain ? y/n ");// creation de j1
    humainornot=read_char();
    print_newline();

  if (humainornot==y){j1= creerjoueur(true);}
else (humainornot==n){j1= creerjoueur(false);}

  print_text("Le second joueur est-il humain ? y/n ");//creation de j2
  humainornot=read_char();
  print_newline();

  if (humainornot==y){j2= creerjoueur(true);}
  else (humainornot==n){j2= creerjoueur(false);}


  print_text(" Combien de manches souaitez-vous jouer ? : ");//Nombre de manche à jouer
  wtp.nbmanche=read_int();
  wtp.nbmanchejouee=0;
  print_newline();

  print_text("Voulez vous jouer en mode avoeugle ? Le mode avoeugle ne donne le gagnant qu'aprés toute les manches jouées");
  print_text("y/n ?");
  x=read_char();

  if (x==y){wtp.avoeugle=true;}
    else{wtp.avoeugle=false;}

  return wtp;}


int victoire(int j1, int j2,Partie p){
  int resultat;

  assert((j1 >0 && j1<4) && (j2<4 && j2 >0));

  if(p.avoeugle==true){// si le mode avoeugle est activé
  if(j1==j2){return 0;}
 
  else if((j1==1 && j2==3) || (j1==2 && j2==1) || (j1==3 && j2==2)) //situation ou le j1 gagne
  {return 1;} 

  else {return 2;}} //toute les autres situations ou le j2 gagne (on evite du code inutile).

  else{                //si le mode avoeugle est desactivé
    if(j1==j2){
      print_text(" match nul !");
      return 0;}
 
    else if((j1==1 && j2==3) || (j1==2 && j2==1) || (j1==3 && j2==2)) {
      print_text(p.j1.nom);
      print_text(" gagne la manche!");
      return 1;} 

    else {
      print_text(p.j2.nom);
      print_text(" gagne la manche!");
      return 2;}}
}


Partie majscore(Partie p,int resumch){

  if (resumch==0){
    p.j1.score.n++;
    p.j2.score.n++;
  }

  else if(resumch==1){
    p.j1.score.g++;
    p.j2.score.p++;
  }

  else{
    p.j1.score.p++;
    p.j2.score.g++;
  }

  p.nbmanchejouee++;

  return p;
}


Partie jouermanche (Partie encour){
  int coupj1,coupj2,vainqueur;

  if (encour.j1.hmn==true){coupj1=demandernombre(1,3);}
  else{coupj1=alea(1,3);}

  if (encour.j2.hmn==true){coupj2=demandernombre(1,3);}
  else{coupj2=alea(1,3);}

  vainqueur= victoire (coupj1,coupj2,encour);
  majscore(encour,vainqueur);

  return encour;
}





Void jouerpartie(){
Partie jeu;

jeu=creerpartie();

while(jeu.nbmanchejouee!=jeu.nbmanche){
  jouermanche(jeu);
  jeu.nbmanchejouee++;
 }


while(jeu.j1.score.g==jeu.j2.score.){

if(jeu.j1.score.g>jeu.j2.score.g){
  print_text(jeu.j1.nom);
  print_text(" a gagné !");
 }

 else if(jeu.j1.score.g<jeu.j2.score.g){
 print_text(jeu.j2.nom);
 print_text(" a gagné !");
 }

 else if(jeu.j1.score.g==jeu.j2.score.g){
   print_text(" egalité : rejouez une manche pour départager !");
   jouermanche(jeu);}
 }}


int main(){
  char a;
 jouerpartie();

 print_text("Voulez vous rejouer ? y/n : ");
 a=read_char();
 print_newline();

 if (a==n){print_text("Au revoir !");}
 else {jouerpartie();}

 return 0;}



 











