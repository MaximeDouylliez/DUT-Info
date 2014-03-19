#!/usr/bin/python3.2


"""
val=input()

if int(val)% 4 == 0 and int(val)% 100 == 0 and int(val)% 400 == 0 :
    print("Cette annee est bissextuelle")
elif int(val)% 4 == 0 and int(val)% 100 != 0:
    print("Cette annee est bissextuelle")
else:
    print("Cette annee n'est pas si bissextuelle que ca")
"""



"""
caca0=['0','1','2']
caca1=['00','11','22']
caca2=['000','111','222']
cacagen=[caca0,caca1,caca2]

for i in cacagen:
    for j in i:
        print(j)
"""
"""
val=5
nom = 'jean'
pr = 'moulin'

print( str(val)+" "+nom+ " "+pr)
"""




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
             print(" "),

         if j==31:
             print("")


             


 
