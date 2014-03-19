


def aff (tableau):


	for i in range(17):
            for j in range(32):
                if i==0 or i==16:
                    if 1<=j<=29 and j%2!=0:
                        print("_"),
                    else:
                        print(" "),
                elif 0<=j<=30 and j%2==0:
                    print("|"),
                else:
                    print(tableau[i-1][j/2-1]),

                if j==31:
                    print("")
                elif 0<=j<=30 and j%2==0:
                    print("|"),


def init_tableau():
    tableau=[]
    for i in range(15):
        tab=[]
        tableau.append(tab)
        for j in range(15):
            tableau[i][j]=" "
    return tableau


             




filename="french.dic"
f = open(filename)

n = 0
for line in f:
    n += 1

f = open(filename)

k=0
liste =[]
while k<=n:
    i=f.readline()
    liste.append(i.strip())
    k+=1






aff(init_tableau())











