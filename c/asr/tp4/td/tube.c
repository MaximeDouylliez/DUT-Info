#include <signal.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <stdio.h>
#include <unistd.h>

int main(){
  
  int tb[2];
  int val[4];
  int i=0;
  pipe(tb); //déclarer le pipe avant le fork
  pid_t fils=fork();
  
  if(fils==0){
    close(tb[0]);
    for(i=0;i<5;i++){
    val[i]=i;
    }

    write(tb[1],val,sizeof(int)*2); //envoyer une adresse mémoire; et le nombre d'octet

  }

  else{
    close(tb[1]);
    read(tb[0],val,sizeof(int)*2);// recevoir une adresse memoire et le nombre d'octet
    printf(" %d, %d, %d, %d, %d ",val[0],val[1],val[2],val[3],val[4]);
  }
  return 0;}
