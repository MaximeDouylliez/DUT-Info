#include<assert.h>
#include<stdlib.h>
#include<stdio.h>

#include"analex.h"
#include"ioap123.h"

const listmots lvide=NULL;

bool est_lvide(listmots lm){
  return(lm==lvide);
}

listmots cons (mot m, listmots lm){
  listmots res=malloc(sizeof(struct llex));

  res->h=m;
  res->suiv=lm;
  return res;
}

mot head(listmots lm){
  assert(!(est_lvide(lm)));
  return lm->h;
}

listmots tail(listmots lm){
  assert(!(est_lvide(lm)));
  return lm->suiv;
}

//Pour faciliter l'impression et la reconnaissance
char char_of_operateur (operateur o){
  char c;
  switch (o){
  case AND: c='A'; break;  
  case NOT: c='N';break;  
  case OR: c='O';break;
  case XOR: c='X';break;
  case IMP:c= 'I'; break;
  case EQU:c='E' ;break;
  case Lpar: c='(';break;
  case Rpar: c=')';break;
  default: {printf("%d\n",o);assert( false);}
  }
  return c;
}

operateur operateur_of_char(char c){
  operateur o;
  switch (c){
  case 'A': o=AND;break;
  case 'N': o=NOT;break;
  case 'X': o=XOR;break;
  case 'O': o=OR;break;
  case '(': o=Lpar;break;
  case ')': o=Rpar;break;
  case 'I': o=IMP;break;
  case 'E': o=EQU;break;
  default: {printf("%c\n",c);assert( false);}
  }
  return o;
}

bool est_op(mot mo){
  bool b ;
  if (mo.nature==Ope) {
    switch (mo.lex.op) {
    case AND: case NOT: case XOR: case OR: case IMP: case EQU:  b=true; break;
    default:b = false;
    }
  }
  else b=false;
  return b;
}

bool est_rpar(mot m){
  return (m.nature==Ope && m.lex.op==Rpar);
}
bool est_lpar(mot m){
  return (m.nature==Ope && m.lex.op==Lpar);
}

void affiche_mot(mot m) {
  if (m.nature==Var) printf("%c ",m.lex.var);
  else printf("%c ",char_of_operateur(m.lex.op));
}

void affiche_listmots(listmots lm){
  if (!(est_lvide(lm))) {
    affiche_mot(head(lm));
    affiche_listmots(tail(lm));
  }
  else printf("\n");
}

listmots string_to_listmots(char * s, int i){
  mot m;
  int j;
  if (s[i]=='\0') return lvide;
  else if(s[i]==' '||s[i]=='\t'||s[i]=='\n') 
    return string_to_listmots(s,i+1);
  else if(((s[i]=='A') && (s[i+1]=='N')) || ((s[i]=='N') && (s[i+1]=='O'))  ||  ((s[i]=='X') && (s[i+1]=='O'))  ||((s[i]=='O') && (s[i+1]=='R'))   || ((s[i]=='I') && (s[i+1]=='M')) || ((s[i]=='E') && (s[i+1]=='Q')))  {
    m.nature = Ope;
    m.lex.op=operateur_of_char(s[i]);
    if(s[i]=='O')
      return cons(m,string_to_listmots(s,i+2));
    return cons(m, string_to_listmots(s,i+3));
  }
  else if ((s[i]=='(') || (s[i]==')')){
   m.nature = Ope;
    m.lex.op=operateur_of_char(s[i]);
    return cons(m, string_to_listmots(s,i+1));}
  
  else if ((s[i]>='a' && s[i]<='z')||(s[i]>='A' && s[i]<='Z'))
    {
      int pp;
      printf("bool %c true =1 ?:",s[i]);
      scanf("%d",&pp);
      if(pp==1)
	m.lol=true;
      m.lol=false;
      m.nature = Var;
      m.lex.var=s[i];
      return cons(m, string_to_listmots(s,i+1));
    }
  else {
    fprintf(stderr,"caract�re illicite en position %d:%c\n",i,s[i]);
    assert(false);
    return lvide;
  }
  
}

listmots analex(char * s){
  affiche_listmots(string_to_listmots(s,0));  
return string_to_listmots(s,0);
}


int main(){
  char phrase[20];
  listmots lol;

  printf("salut les amis ! :");
  scanf("%s",phrase);
 lol=analex(phrase);
  return 0;}
