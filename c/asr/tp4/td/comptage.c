#include <signal.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <stdio.h>
#include <unistd.h>

int i=0;



void handler(){
  i++;
}


int main(){
int nb;
int useless=0;
double res;
int  Nb_Signals_Send =11111;
signal(SIGUSR1,handler);
pid_t fils=fork();

 if(fils==0){
   for(nb=0;nb<Nb_Signals_Send;nb++){
     kill(getppid(),SIGUSR1);
     sleep(1);
   }
   exit(0);
 }
   else{
     wait(&useless);
     res=(double)i/(double)Nb_Signals_Send;
     printf("\n%d signaux ont été envoyés\n%d signaux ont été reçus\nLe rapport est de %lf\n\n",Nb_Signals_Send,i,res);}
  
 return 0;
   }
