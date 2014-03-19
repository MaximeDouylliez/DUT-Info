#include "ioap123.h"
#include <math.h>

//Douylliez.maxime

struct mdegre_sexa {
double d,m,s; //degré ,minute,seconde
};

typedef struct mdegre_sexa degre_sexa;

degre_sexa cons_degre_sexa(double d,double m,double s){
degre_sexa dgr_sx;
dgr_sx.d=d;                                       //contruction d'une valeur type " sexadecimal"
dgr_sx.m=m;
dgr_sx.s=s;
return dgr_sx;
}





double sexa_vers_dec(degre_sexa valeur_sexa){
double resultat1 ;                                                                                //conversion de sexa vers decimal
resultat1 = valeur_sexa.d + valeur_sexa.m/60.0 + valeur_sexa.s/60.0 ;
return resultat1;
}






degre_sexa dec_vers_sexa(double degre){
degre_sexa conversion ;
conversion.d= floor(degre);
conversion.m=(degre-conversion.d)*60;                                                          //conversion de decimal vers sexa
conversion.s=(conversion.m-floor(conversion.m))*60;                                             //fonction non appelé dans l'exo
   return conversion;
}







degre_sexa cons_sexa_apre(degre_sexa sexa_present){
  degre_sexa sexa_instant_apre;
  sexa_instant_apre.s=sexa_present.s+1;
  sexa_instant_apre.m=sexa_present.m;
  sexa_instant_apre.d=sexa_present.d;


 if(sexa_instant_apre.s==60)
          {sexa_instant_apre.s =0;
	    sexa_instant_apre.m =sexa_present.m+1;}
	                                                 //ajout d'une seconde
 if (sexa_instant_apre.m ==60)
       {sexa_instant_apre.m =0;
       sexa_instant_apre.d=sexa_present.d+1;}

 if (sexa_instant_apre.d ==361)
       {sexa_instant_apre.d =0;
       return sexa_instant_apre;}


else return sexa_instant_apre;}



  void affiche_sexa(degre_sexa sexa){
    print_double (sexa.d);
      print_text(" deg, ");
      print_double(sexa.m);
      print_text (" ' ");                                                                   //affiche avec la bonne nomenclature
      print_double(sexa.s);
      print_text("'");
      }


double demande_lattitude (int a){
double x;

print_text("Veuillez entrer les");

if(a==1){
print_text(" degres : ");
x=read_double();                                                                           //demande les degres
print_newline();}

if (a==2){
print_text(" minutes : ");
x=read_double();                                                                           //demande les minutes
print_newline();}

if (a==3){
print_text(" secondes : ");
x=read_double();                                                                            //demandes les secondes
print_newline();}

return x;}







double test (double a, int b){
double f,j;


if(b==1)
{if ((a>360) || (a<0))  
{print_text("Vous avez entre une mauvaise valeur degre, veuillez recommencer");                          // test pour les degrés
print_newline();
f=demande_lattitude(1);
j=test(f,1);return f;}}

else if(b==2)
{if ((a>59) || (a<0)) 
{print_text("Vous avez entre une mauvaise valeur minute, veuillez recommencer");                           //test pour les minutes
print_newline();
f=demande_lattitude(2);
j=test(f,2);return f;}}

else
{if ((a>59) || (a<0)) 
{print_text("Vous avez entre une mauvaise valeur seconde, veuillez recommencer");                            //test pour les secondes
print_newline();
f=demande_lattitude(3);
j=test(f,3) ;return f;}}
return a;}



 




int main(){
double x,y,z,a,b,c;
degre_sexa sexa,sexa_apre;
double decimal,decimal_apre;

print_text("Veuillez entrer une lattitude sous la forme deg/min/sec :");
print_newline();

a=demande_lattitude(1);
x=test(a,1);
b=demande_lattitude(2);
y=test(b,2);                                   //Recuperation et test des valeurs
c=demande_lattitude(3);
z=test(c,3);


sexa=cons_degre_sexa(x,y,z);                                 //appel des fonctions pour convertir et rajouter une seconde
decimal=sexa_vers_dec(sexa);
sexa_apre=cons_sexa_apre(sexa);
decimal_apre=sexa_vers_dec(sexa_apre);

print_text("la latitude que vous avez entre est : ");
affiche_sexa(sexa);
print_text(" qui est = a : ");
print_double(decimal);
print_newline();                                                                //affichage des 4 résultas
print_newline();
print_text("La latitude d'apre : ");
affiche_sexa(sexa_apre);
print_text(" qui est = a : ");
print_double(decimal_apre);
print_newline();

if (sexa_apre.d==0){if(sexa_apre.m==0){if (sexa_apre.s==0){
      print_newline();
      print_newline();
      print_text("Soit vous aimez les valeurs rondes, soit vous voulez provoquer des erreurs dans le programme de vos eleves");}}}   //au cas ou


return 0;}
