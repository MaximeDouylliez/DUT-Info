let listeEtatRep =[1;2;3;4;5;6;7;8;9;10]

let listeEtatDem =[11;12;13;14;;15;16;17;18;19;20;21]


let rec creerListeEtatAux accu liste=
match accu with
|x when x =42  -> liste
|x when x < 22 -> creerListeEtatAux (accu+1) ((x,25)::liste)
|_ -> creerListeEtatAux (accu+1) ((accu,10)::liste)

let creerListeEtat = creerListeEtatAux 1 []




let rec isNotIn lCouple elt  =
 match lCouple,elt with
 |[],_ -> true
 |(h1,_)::t,_ -> if (h1 = elt)
                 then false
                 else (isNotIn t elt)




let rec creerListeIndeciAux l1 l2 l3 =
match l1,l2 with
|_,[] -> l3
|[],_ -> l3
|_,h::t -> if (isNotIn l1 h) 
 then creerListeIndeciAux l1 t (h::l3)
 else creerListeIndeciAux l1 t l3

let creerListeIndeci lRep lDem lEtat=
creerListeIndeciAux lEtat lRep ( creerListeIndeciAux lEtat lDem []) 


let rec getNbGrandElecteur lEtat etat=
match lEtat with 
|[] -> 0
|(h1,h2)::t -> if (h1 = etat)
               then h2
               else getNbGrandElecteur t etat


let rec getMaj lEtat accu =
match lEtat with
|[] -> accu
|(_,h)::t -> getMaj t (accu+h)


let rec win lComb lIndeci llCombGagnante maj  =
