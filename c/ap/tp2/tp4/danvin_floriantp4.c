#include "ioap123.h"
#include "stdio.h"
#include "stdbool.h"

void init_grille(char **grille,int dim){
  int i,j;

  for(j=0;j<dim;j++){
    for(i=0;i<dim;i++){
      grille[i][j]=' ';
    }}}

void affiche_grille(char **grille,int dim){
  int i,j;

  for(j=0;j<dim;j++){
    print_char('|');
    for(i=0;i<dim;i++){
      print_char(grille[i][j]);
      print_char('|');
    }
    print_newline();
  }
}


bool gagnant(char** grille,int dim,char chara){
  int i,j;

  for(j=0;j<dim;j++)
    {
      for(i=0;i<dim;i++)
	{
	  while(grille[j][i]==chara && (x<dim)

}
    


void place_jeton(char **grille,int dim,int compteur){
  int y,x,i;
  int carre=dim*dim;
  for(i=compteur;i<carre;i++){
  print_text("\nchoississez votre colonne: ");
  y=read_int();
  if(y>dim){//verifier si la ligne est bien dans la dimension du cube
      while(y>dim){
	  print_text("\nerreur!recommencer votre valeur : ");
	  y=read_int();}}
  print_text("\nchoississez votre ligne: ");
	x=read_int();

	if(x>dim){//verifier si la colonne est bien dans la dimension du cube
	    while(x>dim){
		print_text("\nerreur!recommencer votre valeur : ");
		x=read_int();}}

	    if((grille[y-1][x-1]=='X') || (grille[y-1][x-1]=='O')){
    print_text("case déjà prise! recommencer: ");
    place_jeton(grille,dim,i);}

	    if((i%2==0) && (i<carre) && (grille[y-1][x-1]!='X') && (grille[y-1][x-1]!='O')){
//si tout est correct et que le dernier carac est O
	      grille[y-1][x-1]='X';}

		else if((i%2==1) && (i<carre) && (grille[y-1][x-1]!='X') && (grille[y-1][x-1]!='O')){
//si tt correct et que le dernier caract est X
		  grille[y-1][x-1]='O';}
	    
		else if(gagnant(grille,dim)==true)
		  print_text("\nBRAVO!!!!!!!!!!!!!!!!!!!!!!");
		else if(i==carre){
		  //si on a rempli toutes les cases
		  print_text("\negalite");}
	    	    affiche_grille(grille,dim);

  }}

int main(){
  char **grille;
  int dim;
  int i;
  print_text("saisir dimension: ");
  dim=read_int();
  grille=malloc(dim*sizeof(int));
  for(i=0;i<dim;i++)
    grille[i]=malloc(dim*sizeof(int));
  init_grille(grille,dim);
  affiche_grille(grille,dim);
  place_jeton(grille,dim,0);
  return 0;
}
