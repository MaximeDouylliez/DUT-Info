#include "ioap123.h"

int ajouter (int a, int b){

  int c=a+b;
  return c;
}

int retirer (int a, int b){
  int c=a-b;
  return c;
}

int multiplier (int a,int b){
  int c=a*b;
  return c;
 }

double diviser (double a,double b){          
      double c=a/b;
 return c;
}

void affiche (int a){
  print_text(" le résultat de votre calcul est : ");
  print_int(a);
}

  void affiche2 (double d){
    print_text (" le résultat de votre calcul est : ");
      print_double(d);
  }

int main(){
  int a,b,c,d=1;
  double resultat;
  print_text(" Bonjour, que voulez-vous faire ? : addition(1),soustraction(2),multiplication(3),division(4) et si t'es débile (5)");
  a=read_int();
  print_text(" Rentrer les deux nombres dont vous aurez besoin de votre calcul : ");
  if  (a==4)
    {
b=read_double();
      print_text (" et ");
      c=read_double();
    }
  else {
    b=read_int();
    print_text (" et ");
    c=read_int();
  }
  if (a==1)
    {resultat=ajouter(b,c);}
  else if(a==2)
    {resultat= retirer(b,c);}
  else if(a==3)
    {resultat=multiplier(b,c);}
  else if (a==4)
    {resultat= diviser(b,c);}
  else
    {while (d!=0)
	{print_text ("MDR");
	  d=d+1;}}

  if ((a==1) || (a==2) || (a==3))
    {affiche(resultat);}
  else {affiche2(resultat);}
  print_newline();
  return 0;

}
