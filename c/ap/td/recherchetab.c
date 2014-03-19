int recherche (double *t, int n, double v)
{
  int i=0;
  while((t[i]!=v)&&(t[i]<v)&&(i<n-1))
    {
      i++;
    }
  if(t[i]==v)
    {
      return i;
    }
  else
    {
      return -1;
    }
}


int recherche2(int *t, int n, int v)
{
  int i;
  int bmin=0,bmax=n-1;
  
  i=(n-1)/2;
  
  while (tab[i]!=v)
    {
      if(v>tab[i])
	{
	  bmin=i;
	  i=i+i/2;
	  if(tab[bmin+1]==tab[bmax])
	    return -1;
	  else
	    }
      else
	{
	  bmax=i;
	  i=i-i/2;
	  if(tab[bmax-1]==tab[bmin])
	    return -1;
	  else
	    }
      return i;
    }
}


void insertion(int *t, int taille, int nblmt, int val)
{
  int bobo;
  int lol=taille-1;
  recherche (int *t, int taille, int val,int &bmin,int &bmax)
    for(bobo=(taille-1)-bmax;bobo!=0;bobo--,lol--)
      tab[lol]=tab[lol-1];
  tab[bmax-1]=val;
