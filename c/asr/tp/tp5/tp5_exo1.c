#include <stdlib.h>
#include <stdio.h>

int main (int argc, char ** argv)
{
  FILE* fic=fopen(argv[2],"r");
  int lol=atoi(argv[1]),i;
  char tab;

  for(i=0;i<lol;i++)
    {
      fscan(fic,"%c",&tab);
      printf("%c",tab);
    }
  fclose(fic);
