#include"ioap123.h"
#include<assert.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
struct modele{
  int id;
  int prt;
  char* name;
  
};typedef struct modele candidat;
int alea(int bmin,int bmax);
candidat new_candidat();
candidat new_candidat_al();
void ajouter_txt(candidat ajouter,char* nom);
void aff_candidat(candidat bartender);

