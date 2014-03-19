#include "clients.h"
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>
#include <assert.h>
#include "ioap123.h"
#include "files.h"



struct fl{
  int taille;
  int ilibre;
  int ifirst;
  client tab;};

file createFifo(){
  file f;
  int t=8*60*60;

  f.taille=t;
  f.ilibre=0;
  f.ifirst=0;
  f.tab=malloc(t*sizeof(client));
  return f;
}

void aff_client(client c){
printf("le client est arrivé a  %d  et part a %d",george.ha,george.hd);
}



bool file_is_full(file f){
  return f.libre>=f.taille;
}

bool file_is_empty(file f){
  return f.taille<=f.libre;
}



file add_fifo(file f,client c){
  assert(!(file_is_full(f)));
  
  f.tab[f.libre]=c;
  f.libre++;
  return f;
}

file sub_fifo(file f, client c){
  assert(!(file_is_empty(f)));

  aff_client(f.client[f.first]);
  f.first++;
  return f;
}
