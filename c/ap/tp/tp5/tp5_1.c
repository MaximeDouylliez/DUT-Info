#include"ioap123.h"

void mul(int deb, int fin){
  int a,y,z;
  for(a=deb;a<=fin;a=a+1){
  for(y=0;y<=10;y=y+1){
    print_int(a);
    print_text(" * ");
    print_int(y);
    print_text(" = ");
    z=a*y;
    print_int(z);
    print_newline();}
  print_newline();}}

void test(int y,int z){
  if (y>z){
    print_text("Non NOn Non ");
    int main();}}

int main(){
  int y,z;
print_text("a quel nombre souhaitez vous commencer la table ? : ");
  y=read_int();
print_text("a quel nombre souhaitez vous terminer la table ? : ");
  z=read_int();
  test(y,z);
  mul(y,z);
  return 0;}



