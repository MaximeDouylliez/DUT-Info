#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<time.h>

int alea(){//fonction qui genere un nombre aleatoire entre 1 et 365
int j;
  j = 1 + rand() %((365-1) + 1);
  return j;
}

bool is_in(int tab[], int nb){//renvoi true si nb est dans le tableau sinon renvoie false
  int i;
  for(i = 0; i<30; i++){
    if(tab[i] == nb) return true;
    else{}
  }
  return false;
}

void coincidence(int a[]){//calcul le nombre de coincidence dans un tableau
  int cmpt=0,i;
  int b=0;
  int test[30];//test contient les dates qui ont deja ete compter par la fonction
  while(b<30){
    if(!(is_in(test,a[b]))){
      for(i=0;i<30;i++){//compte le nombre de coincidence de la date b dans a
	if(a[i] == a[b]) cmpt++;
	else{}
      }
      printf("nb de coincidence pour le jour %d:%d\n",a[b],cmpt-1);
    }
    else{}
    cmpt = 0;
    test[b] = a[b];
    b++;
  }
}


int main(){
 srand(time(NULL));
  int tab[30],i;
  for(i=0;i<30;i++){//met dans tab 30 dates aleatoire
tab[i]=alea();
  }
  coincidence(tab);
  return 0;
}
