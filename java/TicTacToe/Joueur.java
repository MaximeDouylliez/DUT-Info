public abstract class Joueur{

String nom;
int score;

public Joueur(String s){
score=0;}

public abstract void jouerTour();

public  String getName(){return nom;}
public  int getScore(){return score;}


public  void setScore(int a){score=a;}}
