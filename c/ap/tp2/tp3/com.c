#include "ioap123.h"
#include <stdio.h>


void init(int** tab,int nbl, int nbc){
  int i,j;
  for(i=0; i<nbl;i++){
    for(j=0; j<nbc; j++){
      tab[i][j]=0;
    }}
} 
  void affiche_tableau(int** tab, int nbl, int nbc){
    int i,j;

    for(i=0; i<nbl; i++){
      for(j=0; j<nbc; j++){
	print_int(tab[i][j]);
      }
      print_newline();
}
  }
    void mettre_vie( int** tab, int nbl, int nbc){
      int x, y;

    while(x!=666)
      { print_text("ou voulez-vous mettre une vie? \n");
	print_text("x=?");
	x=read_int();
	print_newline();
	print_text("y=?");
	y=read_int();
	print_newline();

	if(x==666){

	  }else{
  
  	if(tab[x-1][y-1]==1)
  	  tab[x-1][y-1]=0;
  
  	else tab[x-1][y-1]=1;
  	}
  	affiche_tableau(tab,nbl,nbc);
        }
  }  
    
int  voisinage(int** tab, int nbl, int nbc, int x, int y){
   int nb=0;
 
   if(x==0){
     nb=nb+tab[y+1][x];
     if(y==0){
       nb=nb+(tab[y+1][x+1] + tab[y][x+1];
	      }
	 if(y==nbc){
	   nb=nb+(tab[y-1][x-1] +tab[y+1][x-1];

   if (y==0){
     nb=nb+(tab[y][x+1]

int main(){
    int** tab;
    int** tab2;
    int a,b,i;
    print_text("\nligne : ");
    a=read_int();

    tab =malloc(a*sizeof(int));
    tab2 =malloc(a*sizeof(int));

    print_text("\ncolonne: ");
    b=read_int();

    for(i=0;i<a;i++){
    tab[i]= malloc(b*sizeof(int));
    tab2[i]= malloc(b*sizeof(int));
    }
    init(tab,a,b);
    mettre_vie(tab,a,b);
    return 0;
}
