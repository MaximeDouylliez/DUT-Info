#include "data.h"
#include <time.h>

int alea (int bmin, int bmax)
{                                                       
  int nombre;                                              
                                                          
    nombre = bmin + rand() % (bmax - bmin + 1);
    return nombre;
}


elt new_candidat()
{
 elt new;
 char namecandidat[80],tel[80],prenom[80];
 int age;

 print_text("prenom svp: ");
 scanf("%s",prenom);
 new.prenom=malloc(1+strlen(prenom));
 strcpy(new.prenom,prenom);
 print_text("nom svp: ");
 scanf("%s",namecandidat);
 new.nom=malloc(1+strlen(namecandidat));
 strcpy(new.nom,namecandidat);
 print_text("tel svp: ");
 scanf("%s",tel);
 new.tel=malloc(1+strlen(tel));
 strcpy(new.tel,tel);
 print_text("age svp: ");
 scanf("%d",&age);
 new.age=age;

 return new;
}

/*elt new_candidat_al(){
  elt new;
  int nb=alea(2,99),i=0;
  char* nomal="listenom.txt";
  char mem[50];
  char nom[50];
  FILE *f;

  f=fopen(nomal,"r");

  while((i!=nb) && (!feof(f))){
    fscanf(f,"%s",mem);
    i++;
}

  fscanf(f,"%s",nom);
  printf("%s",nom);
  
  fclose(f);
  new.name=malloc(1+strlen(nom));
  strcpy(new.name,nom);
  new.prt=alea(1,100);
 
 
 
 return new;
 }*/



void aff_candidat(elt bartender)
{
  printf("le candidat s'appele %s %s \nson tel est %s \nson age est %d \n",bartender.nom,bartender.prenom,bartender.tel,bartender.age);
}


/*
void ajouter_txt(candidat ajouter,char* nom){
  
  FILE * f;
  char* na="nom:";
  char* iden="identifiant:";
  char* class="classement:";
  f=fopen(nom,"a");
  fprintf(f,"%s %s %s %d %s %d\n",na,ajouter.name,iden,ajouter.id,class, ajouter.prt);
  fclose(f);
  }*/

  
