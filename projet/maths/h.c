#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<math.h>

typedef struct{  //structure qui represente les coordonnees d'un point
  float x;
  float y;
}coord;

typedef struct{ //structure qui definis un triangle
  float ab;
  float ac;
  float bc;
}triangle;

float raciine(float nb){ // fonctionne qui calcul la racine de son argument
  float xn,xm;
  int i;
  xn = nb/2;
  for(i=0;i<1000;i++){
    xm = (xn+(nb/xn))/2;
    xn = (xm+(nb/xm))/2;
  }
  if(xn<xm)
    return xn;
  else return xm;
}

float longueur(coord a,coord b){//calcul la longuer du segment [ab]
  float c,res;
  res = ((b.x-a.x)*(b.x-a.x))+((b.y-a.y)*(b.y-a.y));
  c = raciine(res);
  return c;
}


triangle new(){//permet de cree un nouveau triangle 
  triangle d;
  coord a,b,c;
  printf("entrer les coordonnees des points du triangle:\n=>");
  scanf("%f,%f %f,%f %f,%f",&a.x,&a.y,&b.x,&b.y,&c.x,&c.y);

  d.ab = longueur(a,b);
  d.ac = longueur(a,c);
  d.bc = longueur(b,c);

  return d;
}

bool equi(triangle a){//renvoi true si le triangle est equilateral
  if((a.ab==a.ac) && (a.ab==a.bc) && (a.ac==a.bc))
    return true;

  else return false;
}

bool iso(triangle a){//renvoi true si le triangle est isocele
  if((a.ab==a.ac) && (a.ab==a.bc) && (a.ac==a.bc))return false;
  if((a.ab == a.ac)) return true;
  else if((a.ab==a.bc)) return true;
  else if((a.ac==a.bc)) return true;
  else return false;
}

bool rectangle(triangle a){//renvoi true si le triangle est rectangle
  int res1,res2;
  bool t;
  res1 = (a.ab) * (a.ab);
  res2 = ((a.ac)*(a.ac))+((a.bc)*a.bc);

  if(res1 == res2) return true;
  else{
    res1 = (a.ac) * (a.ac);
    res2 = ((a.ab)*(a.ab))+((a.bc)*a.bc);
    
    if(res1 == res2) return true;
    else{
      res1 = (a.bc) * (a.bc);
      res2 = ((a.ac)*(a.ac))+((a.ab)*a.ab);
      
      if(res1 == res2) return true;
      else return false;
    }
  }
  return t;
}
	
 

int main(){
  triangle a;
  bool f;
  a = new();
  f = rectangle(a);
  if(equi(a))
    printf("le triangle est equilatéral!\n");
  else if(iso(a)){
    if(f)
      printf("le triangle est rectangle isocele!\n");
    else printf("le triangle est isocele!\n");
  }
  else{ 
    if(f) printf("le triangle est un triangle rectangle!\n");
    else printf("le triangle est un triangle quelconque!\n");
  } 
  
  return 0;
}
