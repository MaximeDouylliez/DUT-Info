#include "ioap123.h"
#include "ioap123.c"


bool precision_ovrflw(double a){
double precision =0.1;


if (precision>a)
    {return true;}

else {return false;}

return ;}



int main (){
double x;
bool y;
print_text("Bienvenue dans le test de precision de l'ordinateur !");
print_newline();
print_text ("Veuillez entrez un nombre inferieur a 1 : ");
 x=read_double();
 y=precision_ovrflw(x);

if (y==true)
{print_text ("La valeur entree, ");
print_text ("(");
print_double(x);
print_text("), ");
print_text ("est inferieure a la precision");
print_newline();
print_text("Au revoir !");}

else
{print_text ("La valeur entree, ");
print_text ("(");
print_double(x);
print_text("), ");
print_text ("est superieure a la precision");
print_newline();
print_text("Au revoir !");}

return 0;}


