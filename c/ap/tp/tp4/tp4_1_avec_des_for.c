#include "ioap123.h"

void espace (int n){
  int b;
  for(b=n;b!=0;b=b-1){
    print_char(' ');
    }}

void etoile (int n){
  int b;
  for(b=n;b!=0;b=b-1){
    print_char('*');
    }}

void trait (int n){
 int b;
  for(b=n;b!=0;b=b-1){
    print_char('-');
    }}

void base (int n){
  int b;
  for(b=n;b!=0;b=b-1){
    print_char('_');
    }}

void  mur(int nombre_despace,int espaceentre,int j){
  int b;
  for(b=nombre_despace;b!=0;b=b-1){   
    espace(j);   
    print_char('|');
    espace(espaceentre);
    print_char('|');
    print_newline();
    }}

void  tri(int hauteur){
  int b,j=1;     //j=espace entre les slash
  for(b=hauteur;b!=0;b=b-1,j=j+2){ 
    espace(b);   
    print_char('/');
    espace(j);
    print_char('\\');
    print_newline();
    }}


void cercle(int j){
  espace(j); 
  espace(1);
  etoile(3);
  espace(1);
  print_newline();
  espace(j);
  etoile(1);
  espace(3);
  etoile(1);
  print_newline();
  espace(j);
  espace(1);
  etoile(3);
  espace(1);}

void circon(){
  int b=6;
  espace(b);
  print_char('^');
  print_newline();
  tri(b-1);}

void triangle(){
  circon();
  print_char('/');
  base(11);
  print_char('\\');
  print_newline();}

void maison(){
  triangle();
  mur(4,11,0);
  print_char('|');
  base(11);
  print_char('|');}

void rectangle(){ 
  mur(4,11,0);
  print_char('|');
  base(11);
  print_char('|');
  print_newline();}


void femme(){
cercle(4);
 print_newline();
 espace(5);
 mur(1,1,0);
 triangle();
 mur(4,9,1);}

void immeuble(int n){
int b=n;
triangle();
while(b!=0){
  rectangle();
  b=b-1;}}

 void affichedessins(int x){
   int n;
   if(x==1){maison();}
   if(x==2){femme();}
   if(x==3){cercle(0);}
   if(x==4){triangle();}
   if(x==5){rectangle();}
   if(x==6){trait(15);}
   if(x==7){
 print_text("combien d etages ?");
 n=read_int();
 immeuble(n);}}





int main(){
  int x;
  print_text("Salut ! Entrez votre selection:");
  print_newline();
  print_text("-Une maison ? 1");
  print_newline();
  print_text("-Une femme ? 2");
  print_newline();
  print_text("-Un cercle ? 3");
  print_newline();
  print_text("-Un triangle ? 4");
  print_newline();
  print_text("-Un rectangle ? 5");
  print_newline();
  print_text("-Un trait ? 6");
  print_newline();
  print_text("-Un immeuble de n etages ? 7 ");
  x=read_int();
  affichedessins(x);
  print_newline();
  return 0;}





  


    
