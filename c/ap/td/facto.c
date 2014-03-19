#include "ioap123.h"


int demander(){
  int x;
  print_text("veuillez donner un entier svp : ");
  x=read_int();
  return x;}

int facto(int x){
  int r;
  assert(x>=0);
  if(x==0){
    return 1;}

  else{
    r=x*facto(x-1);
    return r;}

  
int suite1(int n){
int u=2;


while (n!=0){
u=u+3;
n=n-1;
}
return u;}

int suite2(int n,a,b,c){
int u=a;

while(n!=0){
u=b+c*u;
n=n-1;}
return u;

int triangle (int n){
int x=1,y=1
while(n!=1){
while (








