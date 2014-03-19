
#include"analex.h"

typedef struct noeud {
  mot info;
  struct noeud* fg;
  struct noeud* fd;
} * expr;

expr build(mot m, expr g, expr d);

//Pour traiter la pile des expressions
typedef struct lexpr {
  expr e1;
  struct lexpr * next;
}* listexpr;

const listexpr lexprvide;

bool est_lexprvide(listexpr lm);

listexpr cons_le (expr e, listexpr lm);

expr head_le(listexpr lm);

listexpr tail_le(listexpr lm);

void print_expr(expr e);

expr analyse(listmots lm, listexpr p);
