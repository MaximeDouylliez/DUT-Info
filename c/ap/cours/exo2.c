#include "ioap123.h"
#include "ioap123.c"

struct mdate{   //creation du modele de date
int j ;   //jour
int m ;     //mois
int a ;        //anné

};

typedef struct mdate date;


 //creation du nom de type

date cons_dte(int j, int m, int a){
date dte;
 dte.j=j;
 dte.m=m;
 dte.a=a;
return dte; //envoi une date sous la bonne forme
}

void affiche_date(date dte){

    print_int(dte.j);
    print_text(" / ");
    print_int(dte.m);
    print_text(" / ");
    print_int(dte.a);
    return ;
    }

int lire_un_entier(){
int x;
print_text("Veuillez donner une date sous la forme jour: ");
print_newline();
x=read_int();
return x;
}


int main(){
date daate;
int x,y,z;
x=lire_un_entier();
y=lire_un_entier();
z=lire_un_entier();
daate=cons_dte(x,y,z);
print_newline();
print_text("nous sommes le : ")
affiche_date(daate);
print_newline();
return 0;
}

