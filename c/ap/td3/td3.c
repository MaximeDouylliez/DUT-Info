bool IsEmpty (file a)
{
  return(f.next==0);
}

bool IsFull ( file a)
{ 
  return(f.next>=f.taille);
}

file creer(int t )
{
  file f;

  f.taille=t;
  f.next=0;
  f.tab=malloc(t*sizeof(elt);

  return f;
}

//priorité plus haute =0
//trouver l'emplacement d'insertion(position)
//decalage a droite de la position a next -1
//insertion
//   occupé mais priorité inférieure    //   position a inserer   mais occupé      //     occupé    //  next(libre)     //on decale et hop
  
void insertion (file *f, elt e)
{
  assert(IsFull(*f));
  
  int i=0,j;
  if(IsEmpty(*f))
    {
      while(e.p < f->tab[i].p)
	i++;

      for(j=next-1;j>i=1;j--)
	f->tab[j+1]=f->tab[j];
      
      f->tab[i]=e;
      f->next++;
    }
}

















void put(file * f, elt e)
{
  if(IsEmpty( a))
    {
      f->data[f->free]=e;
      f->nbelt++;
    }
  else
    print_text("Overflow");
  
  if(f->smax-1==f->free && (!IsFull(file f))
    {
      f->free=0;    //commen remettre a zero
    }
    else 
      f->free++;
    }

    
     
elt get(file * f)
{
  assert(IsEmpty(*f))
    f->next--;
  else
    lol=f->data[f->first];
  return(f->tab[f->next]);
}




     
     affiche(file f)
