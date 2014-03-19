#include"ioap123.h"
#include <math.h>


//douylliez maxime

typedef struct{
  int a;
  int b;
  int c;}Poly2;

typedef struct{
  int a;
  double b;
  double c;}Racine2;

Poly2 creer_poly2(){
  Poly2 poly;

 print_text("Entrez votre polynome");
 print_text("entrez le coef de x^2 : "  );
 poly.a=read_int();
 print_text("entrez le coef de x : "  );
 poly.b=read_int();
 print_text("entrez le coef de la cte : "  );
 poly.c=read_int();
 return poly;
}

double eval_poly(Poly2 eval, double x){
  double q;
  q=(eval.a*(x*x))+(eval.b*x)+(x);
  return q;}


Poly2 add_poly2(Poly2 p1, Poly2 p2){
  Poly2 caca;
  caca.a =p1.a+p2.a;
  caca.b =p1.b+p2.b;
  caca.c =p1.c+p2.c;
  return caca;}

Racine2 resoudre(Poly2 eq){
  Racine2 solu;
  int discriminant;
  discriminant=((eq.b*eq.b)-4*(eq.a*eq.c));
		
  if(discriminant==0){
    solu.a=1;
    solu.b=(0-eq.b)/(2*eq.a);
    return solu;}

  else if(discriminant<0){
   solu.a=0;
   return solu;}

  else{
  solu.a=2;
  solu.b=(((0-eq.b)+sqrt(discriminant))/2*eq.a);
  solu.c=(((0-eq.b)-sqrt(discriminant))/2*eq.a);
  return solu;}}


Poly2 derive_poly2(Poly2 p){
  Poly2 derive;
  derive.a=p.a+p.a;
  derive.b=p.b;
  derive.c=0;
  return derive;}

int main(){
  Poly2 p,d;
  Racine2 r;
  p=creer_poly2();
  r=resoudre(p);
 if(r.a==0){
   print_text("Il n'y a pas de solution !");}
 else if(r.a==1){
   print_text("La solution de votre polynome est : ");
   print_double(r.b);}
 else {
      print_text("Les deux solutions de vos polynome sont : ");
print_text("x1: ");
 print_double(r.b);
 print_text(" et x2: ");
 print_double(r.c);}

 print_newline();
 print_text("La derivé de votre polynome est : ");
 d=derive_poly2(p);
 print_int(d.a);
 print_char('x');
 print_char('+');
 print_int(d.b);

 print_newline();
 return 0;}








