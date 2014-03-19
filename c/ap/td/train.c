double demandernombreentre (double bmin,double bmax){
   double nombresaisi;
   print_text("saisi un nombre connard de maxime et surtout entre ");
   print_double(bmin);
   print_text(" et ");
   print_double(bmax);
   nombresaisi=read_double();
   while((nombresaisi < bmin) || (nombresaisi >bmax)){
       print_text("valeur incorrecte try again!");
   print_newline();
   nombresaisi=read_double();}
   print_text("correct");
   return nombresaisi;
}

int main(){
  double n;
  n=demandernombreentre(-5,12);
  print_double(n);
  return 0;
}
