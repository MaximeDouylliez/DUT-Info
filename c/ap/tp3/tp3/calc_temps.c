#include"calc_temps.h"
#include <time.h>

int alea (int bmin, int bmax)
{   
  int nombre   ;        
  return nombre= bmin + rand() % (bmax - bmin + 1);
}

void gen(int multiplicateur,int tranche){
  clock_t deb,fin;
  double tps;
  list simu=NULL;
  int i,j,k,pasdenom;// pas de nom permet en fait de faire 10 000 = pasdenom* tranche
  
  if( tranche==1000)
    pasdenom=10;
  else if (tranche==500)
    pasdenom=20;
  else {
    print_text("Vous essayez toujours de faire planter nos prog ?\n\n");
    exit(0);}

  deb=clock();

  for(i=0;i<multiplicateur;i++)
    {
      for(j=0;j<pasdenom;j++)
	{
	  for (k=0;k<tranche;k++)
	    simu=cons(alea(0,100),simu);
	  for(k=0;k<tranche;k++)
	    simu=sub(simu);
	}
    }

  fin=clock();
  tps=((fin-deb)/CLOCKS_PER_SEC);

  printf("La manipulation spécifié a pris %f s.\n",tps );
}



int main(){
  int nb,tranche,continuer=1;


  print_text("\n\nBonjour et bienvenue dans le systeme de gaspillage d'énergie.\n\nIl a pour but de simuler le l'ajout et le retrait successif de données.\n\n");


  while(continuer==1){
    print_text("Combien de données ? (tappez 1 pour 10k,2 pour 20k, 3 pour 30k ...) : ");
    scanf("%d",&nb);
    print_text("\nPar tranche de 500 ou 1000 ? tapper(500/1000): ");
    scanf("%d",&tranche);
    gen(nb,tranche);
    print_text("\n\nVoulez vous continuer ?(oui=1)");
    scanf("%d",&continuer);
  }

  print_text("\n\n A plus !");
  return 0;}
