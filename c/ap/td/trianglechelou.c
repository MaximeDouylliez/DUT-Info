#include "ioap123.h"

struct mpiece{
  int p1;
  int p2;
  int b5;
  int b10;
  int b20;

typedef struct mpiece piece;

  int rendre(int paye ,int due){
    Piece lol;
    int reste;

    lol.b20= paye/20;
    reste=reste%20;
    lol.b10= paye/10;
    reste=reste%10;
    lol.b5= paye/5;
    reste=reste%5;
    lol.p2= paye/2;
    lol.p1=reste%p2;

   

