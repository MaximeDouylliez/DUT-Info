#Makefile pour analyse syntaxique des expression arithmétiques complètement 
#parenthèsées
SOURCE=analex.c anasyn.c ioap123.c 
ENTETES=$(SOURCE:.c=.h)

MAIN=arbsyn.c

CC=gcc
OPTIONS= -c -Wall

EXE= tans

OBJETS=$(SOURCE:.c=.o) $(MAIN:.c=.o)

tans: $(OBJETS)
	$(CC) -o $(EXE) $(OBJETS)

.c.o:
	$(CC) $(OPTIONS)  $<

clean:
	rm -f  *.o $(EXE) 

clean-all: clean
	rm -f *~





analex.o: analex.c analex.h
anasyn.o: anasyn.c anasyn.h analex.h ioap123.h
arbsyn.o: arbsyn.c ioap123.h analex.h anasyn.h
ioap123.o: ioap123.c ioap123.h
