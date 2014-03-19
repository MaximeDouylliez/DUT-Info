#include"ioap123.h"
#include<assert.h>
#include<stdlib.h>
#include<time.h>


void Swap(double tab[],int i1,int i2)
{
  double var;

  var= tab[i1];
  tab[i1]=tab[i2];
  tab[i2]=var;
}





int Partition( double tab[], int gauche, int droite)
{
    int g, d;
    double p;
    p = tab[gauche];
    g = gauche-1;
    d = droite+1;
    while(1)
    {
    do
         d--;
    while ( tab[d] > p );
    do
         g++;
    while ( tab[g] < p );
    if ( g < d)
         Swap( tab, g, d );
    else
         return d;
    }
}
void Quicksort(double tab[], int gauche, int droite)
{
      int pivot;
    if ( droite > gauche )
    {
    pivot = Partition( tab, gauche, droite);
    Quicksort( tab, gauche, pivot);
    Quicksort( tab, pivot+1, droite);
    }
}


void selection(double tab[],int MAX)
{
  int i, min, j ;
  double x;
  for(i = 0 ; i < MAX - 1 ; i++)
  {
       min = i;
       for(j = i+1 ; j < MAX ; j++)
              if(tab[j] < tab[min])
                      min = j;
       if(min != i)
       {
              x = tab[i];
              tab[i] = tab[min];
              tab[min] = x;
       }
  }
}

void insertion(double *t, int max)
{
   int i,p,j;
   double x;
   for (i = 1; i < max; i++)
   {
        x = t[i];
        for(p = 0; t[p] < x; p++);
                 for (j = i-1; j >= p; j--)
                          { t[j+1] = t[j]; }
        t[p] = x;
   }
}

const int LGMAX=50000;

/* Affiche le contenu des cases d'un tableau entre deux indices*/
void affiche(double tableau[], int deb, int fin){
  int i;
  for (i=deb;i<=fin;i++) {print_double(tableau[i]);print_char(' ');}
  print_newline();
}


double alea(int borne) { 
    return((double)(((double)rand()/(double)RAND_MAX)*borne)); 
} 


void genere(double tableau[],int lg, int borne){
  int i;
  for (i=0;i<lg;i++) tableau[i]=alea(borne);
}


int main(){
  double tabd1[LGMAX];
 double tabd2[LGMAX];
 double tabd3[LGMAX];

                //compteur de boucle
  double tps ;         // variable contenant le temps ecoule
  clock_t debut,fin ;
  int n,borne ;



  
  print_text("Quelle taille de tableau?\n");
  n = read_int();
  print_text("quelle borne?\n");
  borne=read_int();
  assert(n<=LGMAX);
  genere(tabd1,n,borne);
 



  print_newline();
  print_newline();
  

  print_newline();
  print_newline();


  debut=clock() ;


  selection(tabd1,n);

  fin=clock();                      // instant de fin
  print_text("selection");
  tps=(100*(fin-debut)/CLOCKS_PER_SEC) ; // calcul de la durée en ms
  print_text(" le temps ecoule est : ") ;
  print_double(tps);
  print_newline();
  print_newline();




  debut=clock() ;


  insertion(tabd2,n);

  fin=clock();                      // instant de fin
  print_text("insertion");
  tps=(100*(fin-debut)/CLOCKS_PER_SEC) ; // calcul de la durée en ms
  print_text(" le temps ecoule est : ") ;
  print_double(tps);
  print_newline();
  print_newline();




  debut=clock() ;
  

  Quicksort(tabd3,0,n-1);

  fin=clock();       
  print_text("quicksort");               // instant de fin
  tps=(100*(fin-debut)/CLOCKS_PER_SEC) ; // calcul de la durée en ms
  print_text(" le temps ecoule est : ") ;
  print_double(tps);
  print_newline();
  print_newline();


 
  
  return 0;
}

