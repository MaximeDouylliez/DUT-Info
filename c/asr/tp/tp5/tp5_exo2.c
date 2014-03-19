#include<unistd.h>
#include<stdio.h>
#include<stdlib.h>

main(int argc, char *argv[])
{
int compteur=0;
int i;
int fils;
int valeur=atoi(argv[1]);
int pidpere=getpid();
for(i=0;i<valeur;i++)
{
if(getpid()==pidpere)
{
fils=fork();
compteur++;
if(fils==0) printf("fils %d piud %d compteur %d\n",i,getpid(),compteur);
}
}
if(getpid()==pidpere) printf("pere pid %d compteur %d\n",pidpere,compteur);
}

