#include "clients.h"
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>
#include <assert.h>
#include "ioap123.h"
#include "files.h"


struct cl{
  int ha;
  int hd;};





int uniform(int min , int max ) {
int d = max-min ;
return ( (int) ( ( ( double ) rand ( ) / ( double )RAND_MAX) * d)+min ) ; }




client creer_client(int ar){
  client c;

  c.ha=ar;
  c.hd=ar + uniform(180,1800);

  return c;
}









int main (){
  int depart=0;
  client george;
  george=creer_client(depart);

 return 0;
}

  
  
