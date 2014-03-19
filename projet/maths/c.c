#include <stdio.h>
#include <stdlib.h>
#include <time.h>

typedef struct{
  int num;
  int den;
}fraction;

typedef struct{
  fraction fraction1;
  fraction fraction2;
}resultat;


int pgcd(int a, int b)
{
  int r;
  while (b != 0){
      r = a%b;
      a = b;
      b = r;
}
  return a;
}

fraction somme_fraction(fraction frac1, fraction frac2){
  fraction resu;
  if (frac1.den==frac2.den) {
  resu.num=frac1.num+frac2.num;
  resu.den=frac1.den;
  }
    else {
    frac1.num=frac1.num*frac2.den;
    frac2.num=frac2.num*frac1.den;
    resu.den=(frac1.den*frac2.den);
    resu.num=frac1.num+frac2.num;
  }
  return resu;
}


fraction produit_fraction(fraction frac1, fraction frac2){
  fraction resu;
    resu.num=frac1.num*frac2.num;
    resu.den=frac1.den*frac2.den;
    return resu;
}

fraction rendre_irreductible(fraction frac){
  fraction frac1;
  frac1.num=(frac.num/(pgcd(frac.num,frac.den)));
  frac1.den=(frac.den/(pgcd(frac.num,frac.den)));
  return frac1;
}

resultat resultat_final(fraction frac1,fraction frac2){
  resultat resu;
  resu.fraction1=somme_fraction(frac1,frac2);
  resu.fraction1=rendre_irreductible(resu.fraction1);
  printf("le resultat de l'addition des fractions est : %d / %d \n", resu.fraction1.num,resu.fraction1.den);
  resu.fraction2=rendre_irreductible(produit_fraction(frac1,frac2));
  printf("le resultat du produit des fractions est : %d / %d \n", resu.fraction2.num,resu.fraction2.den);
  return resu;
}


int main (){
  fraction frac1;
  fraction frac2;
  resultat resu;
  printf("Entrez le numerateur de votre 1er fraction : \n");
  scanf("%d",&frac1.num);
  printf("Entrez le denominateur de votre 1er fraction : \n");
  scanf("%d",&frac1.den);
  printf("Entrez le numerateur de votre 2eme fraction : \n");
  scanf("%d",&frac2.num);
  printf("Entrez le denominateur de votre 2eme fraction : \n");
  scanf("%d",&frac2.den);
  double tps;
  clock_t debut,fin ;
  debut=clock(); 
  resu=resultat_final(frac1,frac2);
  fin=clock();
  tps=(100*(fin-debut)/CLOCKS_PER_SEC);
  printf("le temps de calcul est de : %lf ms \n",tps);
  return 0;
}
  

 
