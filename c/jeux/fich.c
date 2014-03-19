#include "ioap123.h"
#include "stdio.h"
#include "stdlib.h"

int cmpp (char acmp,char* sentence)
{
  int i=0;
  print_int(5);
  while(sentence[i]!='\0' && acmp!=sentence[i]) i++;
  print_int(5);
  if(sentence[i]==acmp)
    return 1;
  return -1;
}
void aff (char* phrase){
  FILE* f;

  f=fopen("caca.txt","w");
  fprintf(f,"%d",read_int());
  fclose(f);
}

int main (){
  char* lol;
  scanf("%s",lol);
  print_int(9);
  print_int(cmpp('j',lol));
    }
