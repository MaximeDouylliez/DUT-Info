#include<stdlib.h>
#include<assert.h>

#include"anasyn.h"
#include"ioap123.h"

const listexpr lexprvide=NULL;

bool est_lexprvide(listexpr lm){
  return(lm==lexprvide);
}

listexpr cons_le (expr e, listexpr lm){
  listexpr res=malloc(sizeof(listexpr));
  res->e1 = e;
  res->next = lm;
  return res;
}

expr head_le(listexpr lm){
  assert(!(est_lexprvide(lm)));
  return lm->e1;
}

listexpr tail_le(listexpr lm){
  assert(!(est_lexprvide(lm)));
  return lm->next;
}


//Construit une expression à partir d'un lexème et de deux expressions
expr build(mot m, expr g, expr d){
  expr e = malloc(sizeof(expr));
  e->fg=malloc(sizeof(expr));
  e->fd=malloc(sizeof(expr));
  e->info=m;
  e->fg=g;
  e->fd=d;
  return e;
}

 
//Pour l'affichage
void print_expr(expr e){
  if (e==NULL) printf("\n");
  else{
    if (e->info.nature==Val) printf("%d   ",e->info.lex.val);
    else if (e->info.nature==Var)
      printf("%c ",e->info.lex.var);
    else{
      printf("%c\n",char_of_operateur(e->info.lex.op));
      print_expr(e->fg);
      print_expr(e->fd);
      print_newline();
    }
  }
}

//Réalise l'analyse syntaxique en utilisant une pile
expr analyse(listmots lm, listexpr p){
  mot m;
  expr e1;
  if (est_lvide(lm) && est_lexprvide(p)) {
    fprintf(stderr,"Erreur de syntaxe 1\n");//cas ou la list de mot et la list expression est vide
    assert(false);
    return NULL;
  }
  else if (est_lvide(lm) && est_lexprvide(tail_le(p))) {//cas ou list de mot vide et reste une exp
      return head_le(p);
    }
  else if (est_lvide(lm)) {//cas ou list de mot es vide
    fprintf(stderr,"Erreur de syntaxe 2\n");
    assert(false);
    return NULL;
  }
  else {//
    m=head(lm);
    if (est_lpar(m)) {
      return analyse (tail(lm), cons_le(build(m,NULL,NULL),p));
    }
    else if (est_rpar(m)) {
      if(!(est_lexprvide(p))&&!(est_lexprvide(tail_le(p)))&& (est_lpar((head_le(tail_le(p)))->info)))
	return analyse (tail(lm), cons_le(head_le(p),tail_le(tail_le(p))));
      else if(!(est_lexprvide(p))&&
	      !(est_lexprvide(tail_le(p)))&& 
	      (est_op((head_le(tail_le(p)))->info))&&
	      !(est_lexprvide(tail_le(tail_le(p))))&&
	      !(est_lexprvide(tail_le(tail_le(tail_le(p)))))&&
	      (est_lpar(head_le(tail_le(tail_le(tail_le(p))))->info))){
	e1=build((head_le(tail_le(p)))->info,head_le(tail_le(tail_le(p))),head_le(p));
	return 
	  analyse (tail(lm), cons_le(e1,tail_le(tail_le(tail_le(tail_le(p))))));
      }
      else{
	fprintf(stderr,"Erreur de syntaxe 3\n");
	assert(false);
	return NULL;
      }
    }
    else 
      return analyse (tail(lm), cons_le(build(m,NULL,NULL),p));
  }
}
