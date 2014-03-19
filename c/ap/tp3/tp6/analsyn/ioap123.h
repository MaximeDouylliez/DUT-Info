/* Bibliothèque d'entrées sorties pour faciliter l'apprentissage      *
 * de l'algorithmique.                                                *
 * ioap123 est l'acronyme de Input-Output Algorithmique-Programmation *
 * Auteurs Vincent Poirriez et Philippe Polet                         *
 *                                                                    */
#ifndef IOAP123_H_INCLUDED
#define IOAP123_H_INCLUDED

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

/*
Le type text permet de stocker une chaîne de caractères
il s'agit en fait du type pointeurs de caractère(s)
*/
typedef char *text;

/*
 Affiche le texte txt sur la sortie standard
*/
void print_text(text txt);

/*
renvoie le texte saisie sur l'entrée standard, texte terminé par 
un changement de ligne. La taille maximale du texte est de 256 caractères.
Le changement de ligne n'est pas présent dans le texte renvoyé.
*/
text read_line();


/*
permet de passer à la ligne, affiche un changement de ligne sur la sortie 
standard
*/
void print_newline();


/*
retourne une valeur entiere saisie au clavier, suivie du retour à la ligne
*/
int read_int();

/*
retourne une valeur en virgule flottante saisie au clavier, suivie du retour 
à la ligne. On utilise double pour des raisons idiomatiques de C.
*/
double read_double();

/* 
Les fonctions d'affichages sur la sortie standard, sans passage à la ligne
 */
void print_int(int entier);

void print_double(double v);

void print_char(char c);

//Pour afficher l'adresse d'une variable
void print_addr(void * p);
#endif // IOAP123_H_INCLUDED
