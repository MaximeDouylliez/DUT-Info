#include "list.h"

list cons(elt v, list tail) {
  list l;
  list r;
  l.val=v;
  l.next = tail.next;
  tail.next=&l;
  r=tail;
  return r;
}

list vide(){
  list l;
  l.next=NULL;
  return l;}

elt head (list l){
  assert (l.next !=NULL) ;
  return l.next->val;
}



void get(list l,elt* val){
  list* temp=l.next;
  *val=head(l); 
  if(l.next->next==NULL)
    l.next=NULL;
  else
    l.next=l.next->next;
  free(temp);
  }
  
  

void aff_all(list l){
  if(l.next!=NULL){
  aff(head(l));
  aff_all(*l.next);}
}

bool est_dans(list l, elt v){
  if (l.next==NULL)
    return false;

  else if(strcmp(l.next->val.nom,v.nom)==0 && strcmp(l.next->val.prenom,v.prenom)==0)
    return true;

  else return est_dans(*l.next,v);}

list ajouter_etudiant(list l, elt v){

  if (!est_dans(l,v)){
 list r=cons(v,l);
 return r;}

  else return l;
}

int cardinal (list l){
  
  if (l.next=NULL)
    return 0;
  
  else
    return 1+cardinal(*l.next);}

list Union(list une,list deux){
  
  if(!(deux==NULL)){
    if(!est_dans(une,deux.next->val)){
      une=cons(deux.next->val,une);
      return Union(une,*deux.next);}
    else
      return Union(une,*deux.next);}
  else 
    return une;}

bool Inclusion(list une,list deux){
  
  if(deux==NULL)
    return true;
  if (!(est_dans(une,deux.next->val)))
    return false;
  else return Inclusion(une,*deux.next);
}

bool Egal(list une,list deux){

  if(incu (une,deux)&& incu(deux,une))
    return true;
  return false;
}

list Intersection(list une,list deux){
  if(une.next==NULL ||deux.next==NULL)
    return NULL;

  else if (est_dans(une,deux.next->val))
    return cons(deux.next->val,Intersection(une,*deux.next));

  else 
    return Intersection(une,*deux.next->val);
}

list Difference(list deux, list une){
 if(une.next==NULL ||deux.next==NULL)
    return NULL;

 else if (!(est_dans(une,deux.next->val)))
    return cons(deux.next->val,Intersection(*deux.next,une));

  else 
    return Intersection(*deux.next->val,une);
}

// etant donné que je ne modifie la tete de l'ensemble dans mon cons je ne peux pas faire la 15 ; 

int main(){

  list lol=init();


  print text("     hjhhjhj" );

