#include "ioap123.h"
#include <stdbool.h>
#include <stdlib.h>
#include "list.h"

int aiguille(char acmp){
  if(acmp=='+')return 0;
  if(acmp=='-')return 1;
  if(acmp=='*')return 2;
  if(acmp=='/')return 3;
  else if((acmp>126) && (acmp<255))return 4;
  else return 5;}

int conversion(text aconvertir){
  int arenvoyer;
  return  arenvoyer=atoi(aconvertir);}

bool verif( text temp){
  return temp[1]=='\0';}

bool verifpile(list l){
   if (l==emptylist)return false;
 return (tail(l)!=emptylist);}

int ajouter (int a, int b){int c;
return  c=b+a;}

int retirer (int a, int b){int c;
return  c=b-a;}

int multiplier (int a,int b){int c;
return  c=b*a;}

int diviser (int a,int b){int c;
return  c=b/a;}

list calcul(int code,list l){
  int a,b;


  if (!verifpile (l)){
    print_text("pas assez de valeur pour continuer l'operation...\n\n");
    return l;}

  int* aa=&a;
  int* bb=&b;

  l=get(l,aa);
  l=get(l,bb);

  switch(code){

  case 0: 
    return  cons(ajouter(a,b),l); break;
  case 1:
    return  cons(retirer(a,b),l); break;
  case 2:
    return  cons(multiplier(a,b),l); break;
  case 3: 
    return  cons(diviser (a,b),l); break;}
}

int main(){
  text valeur;
  char* fin="end";
  int code;
  char val;
  list l=emptylist;
  
  print_text("Bienvenue dans le systeme de calcul polonais d'ivanovitch dosto\n\nVeuillez rentrer deux valeurs pour commencer\n\nVous ne pouvez pas rentrer de valeur supérieure a neuf\n\nLes opérateurs disponibles sont: + - * /\n\ntaper end pour terminer le programme\n\n");
  
  valeur=read_line();
  
  while(strcmp(fin,valeur)!=0)
    {
      if (verif(valeur))
	{
	  val=valeur[0];
	  code=aiguille(val);
	  
	  if(code==4)
	    print_text("rentrez une valeur valide svp!\n\n");
	  else if(code!=5)
	    l=calcul(code,l);
	  else
	    l=cons(conversion(valeur),l);
	  print_text("\n\nla pile est dans l'etat suivant: ");
	      aff_all(l);
	      print_text("\n\n");
	}
      else print_text("une valeur ou un opérateur a la fois svp !\n\n");
      
      print_text("suite svp :\n\n");
      valeur=read_line();
    }
  
  print_text("\n\nAu revoir");
  return 0;}
