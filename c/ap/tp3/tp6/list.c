#include "list.h"
const list emptylist = NULL;

list cons(candidat v, list tail) {
  list l;
  l= malloc(sizeof(struct cell));
  l->val =v;
  l->next = tail;
  return l;
}

bool isEmpty(list l) {
  return(emptylist==l);
}

candidat head (list l){
  assert (l != emptylist) ;
  return l->val;
}

list tail(list l) {
  assert (l != emptylist);
  return l->next;
}

list add(candidat v, list l){
  
  if(isEmpty(l))
   return cons(v,l);
  
  else if(v.prt<l->val.prt)
   return cons(v,l);
  
  else l->next=add(v,tail(l));

  return l;}

list get(list l){
  return tail(l);}
  
  

void aff_all(list l){

if (!(isEmpty(l))){
  aff_candidat(head(l));
  aff_all(tail(l));}
}
