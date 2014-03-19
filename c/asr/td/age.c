#include "ioap123.h"
int main(void)
{
  int age;
  
  double ht;
  print_text("Entrez votre âge (entier positif)");
  age=read_int();
  print_text("Entrez votre hauteur ");
  ht=read_double();
  if (age>=18 && (ht<1.5 || ht>2.0))
    
    print_text("Hauteur non standard");
  else
    print_text("Hauteur standard");
  print_text("fin");
  return 0;
  
}
