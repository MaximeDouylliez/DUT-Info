#include "ioap123.h"

int demander(){
  int x;
  print_text (" entrer un nombre entre 5 et 8 :");
  x=read_int();
  while ((x<5) || (x>8))
    {print_text (" faux, essayes encore! ");
      x=read_int();
    }
  return x;
}

int ajouter(int a, int b){
  int c;
  c=a+b;
  return c;
}

int retirer(int d, int e){
  int f;
  f=d-e;
  return f;
}

void afficher(int g){
  print_int(g);}


int main(){
  int fairelademande, ajouterlenombre, retirerlenombre;

  fairelademande = demander();
  ajouterlenombre = ajouter(fairelademande,2);
  ajouterlenombre = ajouter(ajouterlenombre,4);
  ajouterlenombre = ajouter(ajouterlenombre,5);
  retirerlenombre = retirer(ajouterlenombre,3);
  afficher(retirerlenombre);
  print_newline();
  print_newline();
  return 0;
}