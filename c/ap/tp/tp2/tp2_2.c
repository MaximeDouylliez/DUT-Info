
#include "ioap123.c"

int calcul_grand(int x,int y, int z){
int a,b,c;

if(a>b)
{if(a>c)
    {return a;}
       else return c;}


else if(b>a){
    if(b>c){
        return b;}
         else return c;}

         return ;}


int main (){
int x,y,z,r;

print_text("Veuillez ecrire un nombre : ");
x=read_int();
print_newline();
print_text("Veuillez ecrire un nombre different du premier : ");
y=read_int();
print_newline();
print_text("Veuillez ecrire un nombre different du premier et du second : ");
z=read_int();
print_newline();
r=calcul_grand(x,y,z);
print_text(" le plus grand des trois est : ");
print_int(r);
return 0;
}

