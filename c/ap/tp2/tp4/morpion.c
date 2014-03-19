#include "ioap123.h"

void initialisation (int Cote,char** tab)//La fonction met des ' ' dans l'ensemble d'une matrice.
{
  int x,y;
  
  for(y=0;y<Cote;y++)
    {
      for(x=0;x<Cote;x++)
	{
	  tab[y][x]=' ';
	  
	}
    }
}


char**  CreationDamier(int Cote)//La fonction qui crée un type damier de la taille souhaité
{
  
  int i;
  char** tab;

  tab=malloc(Cote* sizeof(char*));
  for(i=0;i<Cote;i++)
    {
      tab[i]=malloc(Cote* sizeof(char));
    }
  
  return tab;
}

void espace(int Cote)
{
  int i;
  for(i=0;i<Cote;i++)
    print_char(' ');
}

void affiche(int Cote,char** tab)//La fonction qui affiche une matrice 
{
  int i,j;

  for(j=0; j<Cote; j++)
    {
      espace((80-Cote)/2);     
 print_char('|');
      for(i=0;i<Cote;i++)
	{
	  print_char(tab[j][i]);
	  print_char('|');
	}
      
      print_newline();
    }
}

void Bienvenue()//La fonction qui ne sert à rien 
{
  int Cote=3,i;
  char**sample = CreationDamier(3);
  for(i=0;i<35;i++)
    printf("\n");
  espace(23);
  printf("Bienvenue sur Morpion: le jeu qui gratte !\n\n");
  
  
  sample[0][0]='x';//pour faire un menu plus agréable
  sample[0][1]='o';
  sample[0][2]='x';
  sample[1][0]='x';
  sample[1][1]='x';
  sample[1][2]='o';
  sample[2][0]='o';
  sample[2][1]='o';
  sample[2][2]='x';
  
  affiche(Cote,sample);
  printf("\n\n");
}


int surface()//La fonction qui renvois la taille de damier souhaité
{
  int Cote;

  printf("Nous allons maintenant configurer la partie.\n");
  print_text("Veuillez indiquez la taille de la surface de jeu: ");
  Cote=read_int();
  print_newline();
  
  return Cote;
}





text DemandeJoueur()
{
  print_text("Veuillez indiquer le nom du joueur : ");
  return read_line();
}


void coupjoueur(char** grille, int cote,int j1j2)
{
  int x,y;
  
  printf("Quel est votre coup ?\nx= :");
  x=read_int();
  while((x<1) || (x>=cote+1))
    {
      printf("Ne faites pas votre buse, jouez un tour valide.\n\n");
      printf("Quel est votre coup ?\nx= :");
      x=read_int();
    }
  
  printf("Quel est votre coup ?\ny= :");
  y=read_int();
  while ((y<1) || (y>=cote+1))
    {
      printf("Ne faites pas votre buse, jouez un tour valide.\n\n");
      printf("Quel est votre coup ?\ny= :");
      y=read_int();
    }
  while(grille[y-1][x-1]!=' ')
    {
      printf("case déja prise, veuillez jouer un tour valide\n\n");
      printf("Quel est votre coup ?\nx= :");
      x=read_int();
      while((x<1) || (x>=cote+1))
	{
	  printf("Ne faites pas votre buse, jouez un tour valide.\n\n");
	  printf("Quel est votre coup ?\nx= :");
	  x=read_int();
	}
      
      printf("Quel est votre coup ?\ny= :");
      y=read_int();
      while ((y<1) || (y>=cote+1))
	{
	  printf("Ne faites pas votre buse, jouez un tour valide.\n\n");
	  printf("Quel est votre coup ?\ny= :");
	  y=read_int();
	}
    }
  if(j1j2==1)
    grille[y-1][x-1]='X';
  else
    grille[y-1][x-1]='G';	
}


int TestGagnant(char** damier,int cote,char xo,int joueur)
{
  int i,j,gagnant=0,cpt;
  
  for(j=0;j<cote;j++)//on scanne -------------->
    {                //          -------------->
      if(damier[j][0]== xo)
	{
	  cpt=0;
	  for (i=0;i<cote;i++)
	    {
	      if(damier[j][i]== xo)
		cpt++;
	    }
	}
    }
  
  if(cpt== cote)//partie de code qui se repete qui regarde cpt et qui dit si la grille est gagnante apré le scan
    {
      if(joueur ==1)
	gagnant=1;
      else
	gagnant=2;
    }

  
  if(gagnant==0)
    
    { 
      for(i=0;i<cote;i++)//on scanne        ||
	{                 //                ||
	  if(damier[0][i]== xo)//           ||
	    {                     //        ||
	      cpt=0;                //      ||
	      for (j=0;j<cote;j++)//        ||
		{                         //vv
		  if(damier[j][i]== xo)
		    cpt++;
		}
	    }
	}


      if(cpt== cote){
	if(joueur ==1)
	  gagnant=1;
	else
	  gagnant=2;}
    }
  

  if(gagnant==0)
    {
      for(j=0,i=0,cpt=0;j<cote;j++,i++)//on scanne d'en haut a gauche a en bas a droite
	{
	  if(damier[j][i]== xo)
	    cpt++;
	}
    }
  
  if(cpt== cote){
    if(joueur ==1)
      gagnant=1;
    else
      gagnant=2;}
  
  if(gagnant==0)
    {
      for(j=cote-1,i=0,cpt=0;j>=0;j--,i++)// on scanne d'en bas a gauche a en haut a droite
	{
	  if(damier[j][i]== xo)
	    cpt++;
	}
    }


  if(cpt==cote){
    if(joueur ==1)
      gagnant=1;
    else
      gagnant=2;}
  
  return gagnant;
}



int TourDeJeu(text j1, text j2, char** grille,int cote,int CptTour)//la fonction qui gere une partie
{
  int Gagnant=1,resu,toto=CptTour;

  printf("C'est votre tour %s !\n",j1);//tour et test du joueur 1
  affiche(cote,grille);
  coupjoueur(grille,cote,1);
  toto++;
  Gagnant=TestGagnant(grille,cote,'X',1);
  
  if (Gagnant==1)
    return 1;
  
  else if(toto==cote*cote)//au cas ou la grille serait pleine mais pas de gagnant
    return 0;
  
  else
    {
      printf("C'est votre tour %s !\n",j2);//tour et test du joueur deux
      affiche(cote,grille);
      coupjoueur(grille,cote,2);
      toto++;
      Gagnant=TestGagnant(grille,cote,'G',2);
    }
  
  if (Gagnant==2)
    return 2;
  
  else if(CptTour==cote*cote)
    return 0;
  
  else
    resu=TourDeJeu(j1,j2,grille,cote,toto);
  return resu;
}

void AfficheGagnant(int n,text j1,text j2)//La fonction qui affiche le gagnant
{
  if (n==0)
    printf("Personne n'a gagné");
  
  else if( n==1)
    printf("%s a gagné",j1);
  else
    printf("%s a gagné",j2);

  print_text("\n\nAu revoir!\n\n");
}




void Brain()//la fonction qui sert de main
{
  char** Damier;
  text J1,J2;
  int Gagnant,Cote,CptTour=0;
  
  Bienvenue();
  Cote=surface();
  Damier=CreationDamier(Cote);
  initialisation(Cote,Damier);
  J1=DemandeJoueur();
  J2=DemandeJoueur();
  Gagnant=TourDeJeu(J1,J2,Damier,Cote,CptTour);
  print_newline();;
  affiche(Cote,Damier);
  AfficheGagnant(Gagnant,J1,J2);
}



  int main()
  {
    Brain();
    return 0;
  }
  
  
  
  




