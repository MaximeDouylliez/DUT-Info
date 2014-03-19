#include"modadd.h"

list modsub(int id,list l){
  list new=l;
  if(new==emptylist)
    return new;

  else if (new->val.id==id){
    print_text(" le candidat suivant sera retiré");
    aff_candidat(new->val);
    print_text("\n\n\n\n\n\n\n");
    return get(new);}

  else new->next=modsub(id,tail(new));

  return new;}

list modsubn(int n,list l){
  list new=l;
  char* nom="admis.txt";
  char* na="nom:";
  char* iden="identifiant:";
  char*  class="classement:";
  FILE * f;


  if((n<1) || (l==emptylist))
    return emptylist;

  else if(1<=n){
    f=fopen(nom,"a");
    fprintf(f,"%s %s %s %d %s %d\n",na,new->val.name,iden,new->val.id,class,new->val.prt);
    fclose(f);
    new->next=modsubn(n-1,tail(new));
  }

  return new;}






    



    
