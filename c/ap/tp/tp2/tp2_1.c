#include "ioap123.h"
#include "ioap123.c"

void mention_calcul (int une_note){


  if (une_note>=18)
    print_text("vous avez recu les felicitations du jurry !");

  else  if(une_note>=16)
    print_text("vous avez recu la mention tres bien");

  else if(une_note>=14)
    print_text("vous avez recu la mention bien");

  else if (une_note>=12)
    print_text("vous avez recu la mention asse bien");

  else if (une_note>=10)
    print_text("vous avez recu la mention passable");

  else
    print_text("vous etes recale");

}

int main(){
  int note_tappe;
  print_text("Bonjour.Veuillez entrer votre note : ");
  note_tappe=read_int();
  mention_calcul(note_tappe);
  print_newline();
  print_text("Au revoir !");
  return 0;
}



