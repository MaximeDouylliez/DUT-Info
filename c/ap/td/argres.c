#include <stdio.h>

void addition( int* a){
  *a=*a+1;
}

int main (){

  int x;
  int* px =&x;
  printf("envoi la sauce ! :");
  scanf( "%d",&x);
  addition(px);
  printf(" le resultat est %d",x);

  return 0;
}
