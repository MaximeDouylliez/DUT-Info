
let descripteur =open_in "grille.txt"

exception Format_exception of string



let rec printListe l=
match l with
|[]->Printf.printf "end of list"
|h::t-> Printf.printf h;printListe t

let rec printListeListe l=
match l with
|[1]-> Printf.printf "end of list"
|h::t-> printListe h; printListeListe t








let rec getGrilleAux d l p=
  try
   match (input_char d),l,p with
   |_,_,true -> getGrilleAux d l (not p)
   |x,_,_ when (x>='1' && x<='9')->  getGrilleAux d (x::l) (not p)
   |_,_,_  -> raise (Format_exception " fichier non valide") ;[]
  with
   End_of_file -> l
  

let getGrille= List.rev(  getGrilleAux  (open_in "grille.txt") [] false)







let rec  getLigneAux listenombre listeliste listeligne borne  accu   =
 match accu,listenombre with
  |_,[]->listeligne::listeliste
  |x,_ when x>=borne -> getLigneAux listenombre (listeligne::listeliste) [] borne 1
  |_,t::q -> getLigneAux q listeliste (t::listeligne) borne (accu+1) 


let rec getLigne lnb borne=getLigneAux lnb [] [] borne 0 






let rec getColAux listenombre listeligne idcol accu =
 match accu,listenombre with
 |x,_ when x>=9 -> getColAux listenombre listeligne idcol 1
 |_,[] -> listeligne
 |x,h::t when x=idcol ->  getColAux t (h::listeligne) idcol (accu+1)

let rec getColAux2 listenombre listeliste borne accu=
if accu <= borne
then
  getColAux2 listenombre ((getColAux listenombre [] accu 1)::listeliste) borne (accu +1)
else
listeliste

 let rec getCol listenombre=
getColAux2 listenombre [] 9 1












let rec getZoneAux listenombre listeliste liste1 liste2 liste3 cptswitch cptliste=
match cptswitch,cptliste,listenombre with
|_,_,[] -> listeliste
|x,_,_ when x>3 -> getZoneAux listenombre listeliste liste2 liste3 liste1 1 cptliste
|_,x,_ when x>27 ->getZoneAux listenombre  ( liste3  :: liste2 :: liste1 :: listeliste) [] [] [] cptswitch 1
|_,_,h::t ->getZoneAux  t  listeliste  (h::liste1) liste2 liste3  (cptswitch+1) (cptliste+1)

let getZone listenombre  = 
getZoneAux listenombre [] [] [] [] 1 1




let rec isIn c l=
match c,l with
|_,[] -> false
|c,h::t when c=h -> true
|_,h::t -> isIn c t

let rec isValidAux l temp=
match l,temp with
|[],_ -> true
|h::t,[] -> isValidAux t (h::[])
|h::t,_ when ( not (isIn h temp))-> isValidAux t (h::temp)
|_,_ -> false

let isValid l=isValidAux l []


let rec  isValidListeListe ll=
match ll with
|[]-> true
|h::t when (isValid h)-> isValidListeListe t
|_ ->false

let isAllValid listelignes listecols listezones=
if (isValidListeListe listelignes && isValidListeListe listecols && isValidListeListe listezones)
then
true
else
false

let checkSudoku listenombre = isAllValid (getLigne listenombre 9) (getCol listenombre) (getZone listenombre)

let check= checkSudoku getGrille




