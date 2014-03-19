bool is_empty(file f){
  return (f==emptylist);
}

file cons(int priorite, elt val; file f){
  file n;
  if (is_empty(f)){
    n=malloc(1+sizeof(cell));
    n->val=val;
    n->priorite=priorite;
    n->next=f;
    return n;
  }
  
 else if(f->priorite>priorite){
   n=malloc(1+sizeof(cell));
   n->val=val;
   n->priorite=priorite;
   n->next=f;
   

   return n;
 }
  
 else return f->next=cons(priorite,val,tail(f));
}
