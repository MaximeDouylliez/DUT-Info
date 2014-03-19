#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>


/** Cette fonction permet de connaitre la valeur de décalage en prenant en compte l'aspect circulaire de l'alphabet**/
char decalage(char work,char key){
  int decalage;
  int lettre;
  
  decalage=key-'a';
  lettre=work+decalage;
  
  if(lettre >'z'){
    decalage=lettre-'z';
    
    lettre='a'+decalage-1;// -1 car si par exemple pour z b on doit obtenir a mais on place a 'a' ce qui inclu deja un decalage de 1
  }
  return lettre;
}

bool checkey(char* clef){//vérifie que la clé ne contient pas d'espace
  int i=0;
  
  while(clef[i]!='\0' && clef[i]!=' ')
    i++;
  
  if(clef[i]==' ')
    return false;
  else
    return true;
}

void codage (char* texte, char* clef,char** cryp){
  int i,j,k;//i indice texte, j indice clef, k indice phrase codé
  
  if (!checkey(clef)){
    printf("Clef non conforme !\n");
    exit(0);}
  else{
    *cryp=malloc(strlen(texte)*sizeof(char));
    
    
    for(i=0,j=0,k=0;i<strlen(texte)-1;i++,j++,k++){
      
      
      if(texte[i]!=' '){
	if (j>=strlen(clef)-1)//traitement de la fin de clé
	  j=0;
	cryp[0][k]=decalage(texte[i],clef[j]);
      }
      else {//traitement des espaces
	cryp[0][k]=' ';
	j--;
      }
    }
  }
}

int main(){
  char a[80];
  char b[80];
  char* c;
  
  fgets(a,sizeof a,stdin);
  fgets(b,sizeof b,stdin);
  
  codage(a,b,&c);
  printf("le code correpondant est:\n\n%s\n\n",c);
  
  return 0;}

