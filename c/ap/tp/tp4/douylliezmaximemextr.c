int demarage(){ 
  print_text(" Quand vous voudrez arrêter, entrez un entier négatif : ");}



struct mxtrm{
  int g;
  int p;
};

  typedef struct mxtrm xtrm;


xtrm limitedebase(){
  int x,y;
  xtrm lim;
  print_newline();
  print_text("Entrez un entier : ");
  x=read_int();
  print_text("Entrez un entier : ");
  y=read_int();

  if(x<y){
    lim.p=x;
    lim.g=y;
  }
  else{
    lim.p=y;
    lim.g=x;
  }
  return lim;}







