#include "modadd.h"
int main(){
  list classement=emptylist;
  int n=0,x,y;
  candidat nouveau;
  char* txt="listecandidat.txt";


  print_text("voulez vous creer 100 personnes au hazard ? 0=oui ,1=non;");
  y=read_int();
  if(y==0){
    while (n<100){
      nouveau=new_candidat_al();
      nouveau.id=n;
      ajouter_txt(nouveau,txt);
      classement=add(nouveau,classement);
      n++;}
    aff_all(classement);
  }
  
  print_text("voulez vous retirer un candidat? 0=oui,1=non: ");
  y=read_int();
  while(y==0){
    print_text("l'id du candidat svp: ");
    x=read_int();
    classement=modsub(x,classement);
    aff_all(classement);
    print_text("voulez vous retirer un candidat? 0=oui,1=non: ");
    y=read_int();
    
  }
  
  
  print_text("voulez vous ajouter un candidat ? 0=oui 1=non :");
  y=read_int();
  while(y==0)
    {
      nouveau=new_candidat();
      classement=add(nouveau,classement);
      aff_all(classement);
      print_text("voulez vous ajouter un candidat ? 0=oui 1=non :");
      scanf("%d",&y);
} 
    
    

    print_text("voulez vous appliquer un numerus closus? 0=oui 1=non :");
    scanf("%d",&y);
    if(y==0){
      print_text("combien ?: ");
      scanf("%d",&x);
      classement= modsubn(x,classement);
      aff_all(classement);
    }

    print_text("la liste des candidats dans l'orde des id est disponible dans listecandidat.txt et la liste des admis dans l'ordre des rangs  est disponible dans admis.txt\n");
    print_text("veuillez suprimmer les deux fichiers avant de relancer le programme merci!\n");
  return 0;}
