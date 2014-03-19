#include "ioap123.h"

//valeur min valeur max moyenne nbvaleur

typedef struct{
  int vmin;
  int vmax;
  int nbv;
  double moy;}
  resultat;

resultat xtrm(){
  resultat res;
  int x,s=0;

  x=read_int();
  res.nb=0;
  res.vmin=x;
  res.vmax=x;

  while (x>=0){
    res.nb=res.nb+1;
    s=s+x;
    if(x<res.vmin){
      res.vmin=x;}
    else if(x>res.vmax){
      res.vmax=x;}
    x=read_int();}
  res.moy=(s+0.0)/res.nb;
  return res;}
