#include "ioap123.h"
#include <math.h>
//douylliez maxime.

struct  mscore_partie
{
    int p;
    int g;
    int n;
};
typedef struct mscore_partie ScorePartie;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
struct mjoueur
{
    text nom;
    ScorePartie scr;
    bool hmn;
};
 typedef struct mjoueur Joueur;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
struct mpartie
{
    Joueur j1;
    Joueur j2;
    int nbmanche;
    int nbmanchejouee;
};
typedef struct mpartie  Partie;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

ScorePartie initScore(){
  Scorepartie a;
  a.p=0;
  a.g=0;
  a.n=0;

  return a;}

int alea (int bmin, int bmax)
{
    int nombre;
    nombre = bmin + rand() % (bmax - bmin + 1);
    return nombre;
}


Joueur creer_joueur(bool hmn){
  Joueur joueur_humain;
 print_text("Bonjour ! Veuillez entrer votre nom: ");
 joueur_humain.nom=read_line();
 joueur_humain.scr=initScore();
   joueur_humain.hmn=hmn;

   return joueurcree;}

int demandernombreentre(int bmin, int bmax){
  int x; 
 print_text("veuillez entrez un nombre entre ");
    print_int (bmin) ;
    print_text(" et ");
    print_int(bmax);

    x=read_int();
    print_newline();
      print_newline();
    print_newline();

    if(x<bmin || x>bmax){
      print_text("ne vous moquez pas du monde, ");
     demandernombreentre(bmin,bmax);}

    else return x;}



Partie creerPartie(){
  text x,z;
  Partie prt;


 print_text("Le premier joueur est-il humain ? y/n ? ");
 x=read_line();

  if(x=='y'){
    prt.j1= creer_joueur(true);
    else prt.j1= creer_joueur(false);}

print_text("Le second joueur est-il humain ? y/n ? ");
 z=read_line();

  if(z=='y'){
    prt.j2= creer_joueur(true);
    else prt.j2= creer_joueur(false);}

  print_text("Combien de partie souhaitez vous jouer ? : ");
  prt.nbmanche=readint();
  prt.nbmanchejouee==0;

  return prt;

int vainqueur(int j1,int j2)

  if(j1==j2)
  {return 0;}

  else if((j1==1 && j2==2) || (j1==2 && j2==3) || (j1==3 && j2==1))
    {return 1;}

  else return 2;}

Partie MAJScore(Partie p, int v ){

  p.nbmanchejouee++;

if(v==0){
  p.j1.scr.n++;
  p.j2.scr.n++;
  print_text("egalite !");
  return p;}

  else if(v==1){
  p.j1.scr.g++;
  p.j2.scr.p++;
  print_text"(le joueur ");
  print_text(p.j1.nom);
print_text("a gagné !");
 return p;}

 else
  p.j1.scr.p++;
  p.j2.scr.g++;
  print_text"(le joueur ");
print_text(p.j2.nom);
print_text("a gagné !")
;return p;}

Partie jouerUneManche(Partie p){
  int  x,y,z;

  print_text(p.j1.n);
  print_text(" choisissez: pierre(1) ciseaux (2) feuille(3)");
  x=read_int();
 print_newline();
 print_newline();
 print_text(" Maintenant ");
 print_text(p.j2.n);
 print_text("choisissez: pierre(1) ciseaux(2) feuille(3)");
 y=read_int()

   z= vainqueur (x,y);
 return MajScore (p,z);







 
