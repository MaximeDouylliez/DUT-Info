#include "ioap123.h"

text Demander_nom_aventurier(){
  int nom,sexe,;

  //Les femmes ne sont pas acceptées, Les non humains non plus.
  print_text(" Etes vous un homme(h) ou une femme(f) ? : ");
  sexe=read_char();
 
  if((sexe != 'h') && (sexe != 4'f')){
    print_text("/n Vous n'êtes pas humain ? Depuis quand les singes savent-ils compiler ?/n");
    print_text("Aussi laid et repoussant que vous puissiez être, l'humanité vous est familiere./n");
    print_text("Homme(21) ou femme(42)? Derniere chance. ");
    sexe=read_char();
    if((sexe != 'h') && (sexe != 'f')){
      print_text(" Nan sérieux va t'acheter une race");
      exit(0);
      else}}
  else return sexe;}


    
    
  print_text("Quel est ton nom Aventurier ? :  ");
  nom=read_line();}
