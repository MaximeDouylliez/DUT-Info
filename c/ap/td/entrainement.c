#include"ioap123.h"

int demander_un_entier(){
  int x;
  x=read_int();
  return x;
}

int addition(int x, int y){
  int result;
  result= x + y;
  return result;
}

void espace(int nbspace){
  int ref= nbspace;
  while(ref>0){
      print_char(' ');
      ref= ref-1;
    }
}

void espace2(int nbspace2){
  int ref2=0;
  while(ref2<nbspace2)   
  print_char(' '); 
  ref= ref+1;                                             //ref + 1 ou bien ref++ pour incrémenter
}}


void espace3(int nbspace3){
  int ref3;
  for(ref3=nbspace3; ref3>0; ref3=ref3-1){
    print_char (' ');
  }
}

void espace4(int nbspace4){
  int caca=nbspace4;
  if(caca!=0){

    print_char(' ');
    caca=caca-1;
    espace4(caca);}}                                     //pas de for qui s'appelle 


struct mcaca{
  text texture;
  text taille;
  text poid;
  text saveur;
};
typedef struct mcaca caca





typedef struct{
  text texture;
  text taille;
  text poid;
  text saveur;
};caca

 



 





  



























int alea (int bmin, int bmax)
{                                                           //creation d'une valeur aléatoire
  int nombre;                                              //pour le choix du bot entre le minimum (bmin)
                                                          //et le maximum (bmax)
  nombre = bmin + rand() % (bmax - bmin + 1);            //on renvoie le nombre aléatoire ainsi généré
    return nombre;
}
