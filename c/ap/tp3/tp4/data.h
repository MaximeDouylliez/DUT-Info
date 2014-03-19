#include"ioap123.h"
#include<assert.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>


struct model{
  char* nom;
  char* prenom;
  char* tel;
  int age; };
typedef struct model elt;




int alea(int bmin,int bmax);
elt new_candidat();
elt new_candidat_al();
void ajouter_txt(elt ajouter,char* nom);
void aff_candidat(elt bartender);

