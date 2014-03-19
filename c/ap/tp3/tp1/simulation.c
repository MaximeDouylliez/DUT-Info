bool occur(double p) { return (((double)rand())/RAND_MAX)<p;}

files creer_simu(int p,int * clientvenu){

files couloir;

couloir=CreateFifo();

for (i=0;i<=8*60*60-1;i++){
if(occur(p))
*clientvenu++;
add_fifo(couloir,creer_client(i));
}
return couloir;}

int exasperation (files listclient, int p){
int clientexa=0,clientid=0,i;

for(t=0;t<=8*60*60-1;t++){
i=clientid;
if(listclient.client[i].ha>t)
;
else
if (listclient.client[i].hd<t){
clientexa++;
clientid++;
}
else{
t=t+occur(p);
clientid++;
 }}

return clientexa;
 }
 
int  main(){
  files simu;
  int resu,ratio;
  int clvenu,clientexa;
  print text("proba entre 0 et 1");
  res=read_int();
  simu=creer_simu(res,&clvenu);
  clientexa=exasperation(simu,res);
  
  ratio=clvenu/clientexa;
  print_int(ratio);
  
  return 0;
}
