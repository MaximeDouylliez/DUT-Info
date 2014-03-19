#include "ioap123.h"
#include <time.h>

struct mtroisdes {
  int d1;
  int d2;
  int d3;
}; typedef struct mtroisdes troisdes;


int alea (int bmin, int bmax)
{                                                           //creation d'une valeur aléatoire
  int nombre;                                              //pour le choix du bot entre bmin et bmax
                                                          
    nombre = bmin + rand() % (bmax - bmin + 1);
    return nombre;
}

troisdes lancer (){
  troisdes j;

  j.d1=alea(1,6);
  j.d2=alea(1,6);
  j.d3=alea(1,6);

  return j;
}

void aff_des(troisdes n){
 


  print_text("de1: ");
  print_char(' ');
  print_int(n.d1);
  print_text("; de2: ");
  print_char(' ');
  print_int(n.d2);
  print_text("; de3: ");
  print_char(' ');
  print_int(n.d3);
  print_char(';');
}





troisdes trie(troisdes at){
  troisdes t;

  if((at.d1==at.d2) &&(at.d2==at.d3))
    t=at;
  else if(at.d1 <= at.d2){
    if(at.d2<=at.d3)
      t=at;
      else{
	if(at.d1>=at.d3)
	  {
	    t.d1=at.d3;
	    t.d2=at.d1;
	    t.d3=at.d2;}
	else{
	      t.d1=at.d1;
	      t.d2=at.d3;
	      t.d3=at.d2;
	}}}
  else{

      if(at.d1<=at.d3)
	{t.d1=at.d2;
	 t.d2=at.d1;
	 t.d3=at.d3;}
      else{
	if(at.d2 <= at.d3){
	  t.d1=at.d2;
	  t.d2=at.d3;
	  t.d3=at.d1;}
	else{
	  t.d1=at.d3;
	  t.d2=at.d2;
	  t.d3=at.d1;}
      }}
  return t;
}


/*ecrire une fonction est_trie qui prend en argument un save de type troisdes et renvoie un type bool qui dit que si la save est trié ou non*/
bool est_trie(troisdes n){
  bool x;

  if((n.d1<=n.d2) && (n.d2<=n.d3)){
    x=true;}
  else {x=false;}

return x;
}

bool est_qvu(troisdes jetded){
  bool x;

  if ((jetded.d3==4) && (jetded.d2==2) && (jetded.d1==1))
    x=true;
 else 
   x=false;
  return x;}


bool est_fiche(troisdes k){
  bool x;

  if ((k.d3!=1) && (k.d2==1) && (k.d1==1))
    x=true;
 else 
   x=false;
  return x;}


bool est_triple(troisdes n){
  bool x;

  if ((n.d1==n.d2) && (n.d2==n.d3))
    x=true;
 else 
   x=false;
  return x;
}

bool est_suite(troisdes n){
  bool b;
if((n.d2==n.d1+1) && (n.d3==n.d2+1))
  b=true;
 else
   b=false;
return b;
}

int valeur(troisdes tr){
  int point;
  bool a,b,c,d;

  a=est_qvu(tr);
  b=est_suite(tr);
  c=est_triple(tr);
  d=est_fiche(tr);

  if(a==true)
    point=50;
  else if (b==true)
    point=tr.d3+20;
  else if(d==true)
    point=tr.d3+40;
  else if(c==true)
    point=tr.d1+30;
  else
    point=tr.d1 +tr.d2 + tr.d3;	
  return point;
}

troisdes rejouer(troisdes idk){
  troisdes ikn=idk;
  int x;
 

  aff_des(idk);

  print_newline();
  print_newline();
  print_text("voulez vous garder ");
  print_int(ikn.d1);
  print_text(" [oui/non] [0/1] ?: ");
  x=read_int();

    if(x==1)
      ikn.d1=alea(1,6);
    else
      ikn.d1=ikn.d1;

    print_text("voulez vous garder ");
    print_int(ikn.d2);
    print_text(" [oui/non] [0/1] ?: ");
    x=read_int();
   
    
    if(x==1)
      ikn.d2=alea(1,6);
   
    else
      ikn.d2=ikn.d2;



    print_text("voulez vous garder ");
    print_int(ikn.d3);
    print_text(" [oui/non] [0/1] ?: ");
    x=read_int();
   
    
    if(x==1)
      ikn.d3=alea(1,6);
    else
      ikn.d3=ikn.d3;
    

    return ikn;
}
void tour_de_jeu(){
  troisdes t;
  int point;
  int x;
  print_newline();
  print_newline();
  print_newline();
  print_text("Lancer Initial : ");
  t=trie(lancer());
  aff_des(t);
  print_text("->");
  point=valeur(t);
  print_int(point);
  print_newline();
  print_newline();
  print_newline();
  print_text("Vous gardez [0] ou vous relancez [1]? [Oui/Non]: ");
  x=read_int();
  print_newline();
  print_newline();
  print_newline();
  if (x==0){
      }

  else{
  t=rejouer(t);
  print_newline();
  print_newline();
  print_newline();
  print_text("Deuxieme Lancer : ");
  t=trie(t);
  aff_des(t);
  print_text ("->");
  point=valeur(t);
  print_int(point);
  print_newline();
  print_newline();
  print_newline();
  print_text("Vous gardez [0] ou vous relancez [1] [Oui/Non]: ");
  x=read_int();
  print_newline();
  print_newline();
  print_newline();}

  if (x==0){
    aff_des(t);
  print_text("->");
  point=valeur(t);
  print_int(point); 
print_newline();}
  else{
    t=rejouer(t);
    t=trie(t);
    print_newline();
    print_newline();
    aff_des(t);
    print_text("->");
    point=valeur(t);
    print_int(point);
    print_newline();
    print_newline();
}
}
int main(){
  srand(time(NULL));
  tour_de_jeu();

return 0;
}




