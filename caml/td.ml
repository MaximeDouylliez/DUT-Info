type oper = Plus | Moins | Div | Mult

type expr=
    Nombre of float
  |Variable of string
  |Operation of expr * oper * expr

type env = (string * float) list

exception PasTrouv�e
exception Non_valide


type Rpar =)
type Lpar =(

let (.^) c s = (char.escape c)^s 

let rec associ�e e c = match e with 
| [] -> raise PasTrouv�e
| (c1,v1)::t -> if c=c1 then c
else associ�e t c


let rec eval e ex =
match ex with
|Nombre n -> n
| Operation (ex1,Plus,ex2) -> (eval e ex1) +. (eval e ex2)
| Operation (ex1,Moins,ex2) -> (eval e ex1) -. (eval e ex2)
| Operation (ex1,Div,ex2) -> (eval e ex1) /. (eval e ex2)
| Operation (ex1,Mult,ex2) -> (eval e ex1) *. (eval e ex2)
| Variable v -> 
    try List.assoc v e
	with Not_found ->failwith("la variable "^v^" n'est pas connue")


let ajout_def v n e= (v,n)::e

let rec lire_decimale s i d�j�_lue mult lgs=
maths.[i] with
|' ' | ')'|'+'|'-'|'*'|'/'|';' -> d�j�_lue i
|'0'..'9' -> let d = (( int_of_char s.[i]) - (int_of_char '0')) in 
  let nval=(d *. mult)+d�j�_lue in
  if i+1=lgs then raise Non_valide else
  lire_decimale s (i+1)nval (mult/.10.) lgs

|_ -> raise Non_valide




