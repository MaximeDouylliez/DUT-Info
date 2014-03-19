#include "data.h"
#include <time.h>

int alea (int bmin, int bmax)
{                                                          
  int nombre;                                              
                                                          
    nombre = bmin + rand() % (bmax - bmin + 1);
    return nombre;
}


candidat new_candidat()
{
 candidat new;
 char namecandidat[80];
 print_text("id svp: ");
 scanf("%i",&new.id);
 print_text("name svp: ");
 scanf("%s",namecandidat);
 new.name=malloc(1+strlen(namecandidat));
 strcpy(new.name,namecandidat);
 print_text("prt svp: ");
 scanf("%i",&new.prt);

 return new;
}

candidat new_candidat_al(){
  candidat new;
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
}



void aff_candidat(candidat bartender)
{
  printf("le candidat s'appele %s \nson id est %i \nsa prt est %i \n",bartender.name,bartender.id,bartender.prt);
}

void ajouter_txt(candidat ajouter,char* nom){
  
  FILE * f;
  char* na="nom:";
  char* iden="identifiant:";
  char* class="classement:";
  f=fopen(nom,"a");
  fprintf(f,"%s %s %s %d %s %d\n",na,ajouter.name,iden,ajouter.id,class, ajouter.prt);
  fclose(f);
}

  
