/*
Pour réaliser l'analyse lexicale des expressions arithmétiques complètement
parenthèsées.
 */

#include<stdbool.h>

typedef enum  oper { AND, OR, NOT, XOR, IMP, EQU, Lpar, Rpar} operateur;

typedef enum natenum {Var,Ope} nat;

union lexeme {
  char var;
  operateur op;
};

typedef struct udisj{
  nat nature; 
  bool lol;
  union lexeme lex;
} mot;

//Pour traiter les listes de mots
typedef struct llex {
  mot h;
  struct llex * suiv;
}* listmots;

const listmots lvide;

bool est_lvide(listmots lm);


listmots cons (mot m, listmots lm);

mot head(listmots lm);

listmots tail(listmots lm);

// Pour manipuler les mots
char char_of_operateur (operateur o);

operateur operateur_of_char(char c);

bool est_op(mot mo);

bool est_rpar(mot m);

bool est_lpar(mot m);

void affiche_mot(mot m) ;

void affiche_listmots(listmots lm);

int lire_int(char * s, int i, int * res);

//Hypothèse la chaîne contient \0
//Réalise l'analyse lexicale
listmots analex(char * s);
