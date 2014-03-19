#include<stdlib.h>
#include<string.h>
#include<stdbool.h>
#include<assert.h>
#include"ioap123.h"

#include"anasyn.h"


//Evalue une expression dans un environnement
  int eval(expr e, int env[128] ){
  int vg,vd,v;
  if (e->info.nature==Val) v=e->info.lex.val;
  else if (e->info.nature==Var) v=env[(int) e->info.lex.var];
  else{// cas d'un opérateur
    vg=eval(e->fg,env);
    vd=eval(e->fd,env);
    switch (e->info.lex.op) {
    case Plus : {v=vg+vd;break;}
    case Moins : {v=vg-vd;break;}
    case Div : {
      if (vd==0) {
	fprintf(stderr,"Division par 0\n");
	assert (false);
      }
      else v=vg/vd;
      break;}
    case Mult : {v= vg * vd;break;}
    default: assert(false);
    }
  }
  return v;
}
void variables(expr e, int env [128]){
  if (e->info.nature==Var) env[(int) e->info.lex.var]=1;
  else if (e->info.nature==Ope){// cas d'un opérateur
    variables(e->fg,env);
    variables(e->fd,env);
  }
}

void rens_env(int env[128]){
  int i;
  for (i=0;i<128;i++)
    if (env[i]==1) {
      printf("quelle valeur pour %c?:",(char) i);
      env[i]=read_int();
    }
  }
int main(int argc, char * argv[]){
  expr expr0;
  listmots lm;
   char s[20] = "((1+(23 /12)) - 7)";
  char e[340];
  int env[128];
  int i;

  for (i=0;i<128;i++) env[i] = 0;

  if (argc==1) strcpy(e,s);
  else strcpy(e,argv[1]);
  
  lm= analex(e);
  affiche_listmots(lm);

  expr0=analyse(lm,lexprvide);
  print_expr(expr0);
  print_newline();
  variables(expr0,env);
  rens_env(env);

  printf("valeur: %d\n",eval(expr0,env))  ;

  return 0;
}

