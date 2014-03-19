#include "ioap123.h"

int  demander(){
  int nb_choosen_by_user;
  print_text("Veuillez entrez un entier entre 1 et 10000 : ");
  print_newline();
  print_newline();
  nb_choosen_by_user=read_int();
  return nb_choosen_by_user;
}

int verifier(int nb_a_verifier){

int nbmodifiable=nb_a_verifier;

 while((nbmodifiable<1)||(nbmodifiable>10000)){
  print_text("Fais pas chier rentres un nombre valable ");
  print_newline();
  print_newline();
  nbmodifiable=read_int();
  print_newline();}

 return nbmodifiable;}




int alea (int bmin, int bmax){                                                           
  int nombre; 
                                                                                                       
    nombre = bmin + rand() % (bmax - bmin + 1);
    return nombre;}




 bool comparer(int nombre_a_comparer, int nb_genere_aleatoirement){
   bool gagne_ou_pas;
   if(nb_genere_aleatoirement < nombre_a_comparer){
     print_text("Le nombre mysterieux est plus petit que le nombre entré");
     print_newline();
     print_newline();
     gagne_ou_pas=false;}

   else if(nb_genere_aleatoirement > nombre_a_comparer){
     print_text("Le nombre mysterieux est plus grand que le nombre entré");
     print_newline();
     print_newline();
     gagne_ou_pas=false;}

   else{
     print_text("Vous avez gagné");
     print_newline();
     print_newline();
     gagne_ou_pas=true;}

   return gagne_ou_pas;}

int main(){
  int nombreutilisateur,nombreverifie,nombrealeatoire;
  bool victoire=false;
  int compteur=0,rejouer;

  nombrealeatoire = alea(1,10000);

  while(victoire==false){

    nombreutilisateur = demander();
    print_newline();
    print_newline();
    

    nombreverifie = verifier(nombreutilisateur);

    victoire = comparer(nombreverifie,nombrealeatoire);

    compteur = compteur+1;}

  print_text("Vous avez trouvé la solution en ");
  print_int(compteur);
  print_text(" coups");
  print_newline();
  print_newline();

  print_text("Voulez vous rejouer ? : Oui ? tapez(1), Non ? tapez (2) : ");
  print_newline();
  print_newline();

  rejouer=read_int();

  if(rejouer==1){main();}

  else{print_text("Au revoir !"); print_newline();print_newline();}

  return 0;}




