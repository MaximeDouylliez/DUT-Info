#include"ioap123.h"
#include <assert.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include "data.h"





typedef struct cell { 
  elt val; 
  struct cell *next; //adresse de la suite
}  list;


 elt head(list l);

/*
IN: une liste non vide
OUT: la queue de la liste,
     i.e. la liste qui suit le premier maillon
HYPOTHÈSE: son argument n'est pas vide 
*/
void get(list l,elt* val);
void aff_all(list l);

list vide();
