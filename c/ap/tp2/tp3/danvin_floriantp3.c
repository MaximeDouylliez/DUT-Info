#include "ioap123.h"
#include <stdio.h>
#include <stdlib.h>

void init(int **tab, int nbl,int nbc){
  int i,j;
  for(j=0; j<nbl;i++){
  for(i=0; i<nbc;j++){
    tab[j][i]=0;
  }}
}
void affiche_tableau(int **tab, int nbl,int nbc){
  int i,j;
  
  for(j=0; j<nbl;i++){
    for(i=0; i<nbc;j++){
      print_int(tab[j][i]);
    }
    print_newline();
  }
}
void mettre_vie(int **tab, int nbl,int nbc){
  int x,y;

  while(x!=666){
    print_text("Où voulez-vous mettre une vie? \n");
    print_text("x=?");
    x=read_int();
    print_newline();
    print_text("y=?");
    y=read_int();
    print_newline();

    if(x==666){
    }else{
      if(tab[y-1][x-1]==1)
	tab[y-1][x-1]=0;

      else tab[y-1][x-1]=1;
    }
    affiche_tableau(tab,nbl,nbc);
  }
}

 int voisinage(int **tab, int nbl,int nbc, int x, int y){
   int nb=0;


   if(x==0){ //le coté gauche
     nb=nb+tab[y][x+1];
     if(y==0)//si en haut a gauche
       nb=nb+(tab[y+1][x+1] + tab[y+1][x]);
      else if(y==nbl)//si en haut a droite
	 nb=nb+(tab[y-1][x+1] + tab[y-1][x]);
      else if((y!=0) && (y!=nbc-1))//tout le reste
	 nb=nb+ (tab[y-1][x+1] + tab[y-1][x]+ tab[y-1][x+1] + tab[y-1][x]);}


if(x==nbc-1){ //le coté droit
       nb=nb+(tab[y][x-1]);
       if(y==0)//si en haut a droite
	 nb=nb+(tab[y+1][x-1] +tab[y+1][x]);
       else if(y==nbc-1)//si en haut a gauche
		  nb=nb+(tab[y-1][x-1] +tab[y-1][x]);
       else if((y!=0) && (y!=nbc-1))// le reste
	 nb=nb+(tab[y+1][x-1] +tab[y+1][x] +tab[y-1][x-1] +tab[y-1][x]);
     }


     if(y==nbl-1){//partie du bas
       nb=nb+(tab[y-1][x]);
       if(x==0)//si en bas a gauche
	 nb=nb+(tab[y-1][x+1] + tab[y][x+1]);
	 else if(x==nbl-1)//si en bas a droite
	   nb=nb+(tab[y-1][x-1] + tab[y][x-1]);
	   else if((x!=0) && (x!=nbl-1))//le reste
	     nb=nb+(tab[y-1][x+1] + tab[y][x+1] +tab[y-1][x-1] + tab[y][x-1]);
     }


     if(y==0){ //partie du haut
       nb=nb+(tab[y+1][x]);
       if(x==0)//si en haut a gauche
		nb=nb+(tab[y+1][x+1]+tab[y][x+1]);
	      else if(x==nbc-1)//si en haut a droite
		nb=nb+(tab[y][x-1]+tab[y+1][x-1]);
	      else if((x!=nbc-1) && (x!=0))//le reste
		nb=nb+(tab[y+1][x+1]+ tab[y][x+1] + tab[y][x-1]+tab[y+1][x-1]);}



	      //pour tout ce qui est en dehors des cotés
     if((y!=0) && (y!=nbl-1) && (x!=nbc-1) && (x!=0))
		nb=nb+(tab[y-1][x-1] +tab[y-1][x]+tab[y-1][x+1] +tab[y][x-1]+tab[y+1][x+1]+tab[y+1][x]+tab[y+1][x-1]+tab[y][x-1]);

     return nb;
 }


void generation_suivante(int **tab,int **tab2,int nbl,int nbc){
  int i,j,nbvoisin;

  for(j=0;j<nbl;i++){
    for(i=0;i<nbc;j++){
      nbvoisin=voisinage(tab,nbl,nbc,i,j);
      if(tab[j][i]==0){
	if(nbvoisin==3){
	  tab2[j][i]=1;}
	else
	  {tab2[j][i]=0;}}
      if(tab[j][i]==1){
	if((nbvoisin<2) || (nbvoisin>3)){
	  tab2[j][i]=0;}
	else
	  {tab2[j][i]=1;}
      }
    }
  }
   for(j=0;j<nbl;i++){
    for(i=0;i<nbc;j++){
      tab2[j][i]=tab[j][i];
    }}
}

   int main(){
   int **tab;
   int **tab2;
   int a,b,i,n,o;
   print_text("\nligne : ");
   a=read_int();

   tab=malloc(a*sizeof(int));
 tab2=malloc(a*sizeof(int));

 print_text("\ncolonne : ");
 b=read_int();

 for(i=0;i<a;i++){
   tab[i]=malloc(b*sizeof(int));
 tab2[i]=malloc(b*sizeof(int));
 }
 init(tab,a,b);
 mettre_vie(tab,a,b);
 print_text("nombre de generation demande: ");
 n=read_int();
 for(o=0;o!=n;o++){
   generation_suivante(tab,tab2,a,b);
affiche_tableau(tab,a,b);
 print_newline();
 print_newline(); 
 }

 return 0;
 }