type oper = Plus | Moins | Div | Mult

type expr =
    | Nombre of float
    | Variable of string
    | Operation of expr*oper*expr

type env = ( string * float) list

exception PasTrouvee
exception Non_valide

let rec associee e c = match e with
| [] -> raise PasTrouvee
| (c1,v1)::t when c1 = c -> v1
| _::t -> associee t c

let rec eval e exp = match exp with
| Nombre n -> n
| Operation (exp1,Plus,exp2) -> (eval e exp1)+.(eval e exp2)
| Operation (exp1,Moins,exp2) -> (eval e exp1)-.(eval e exp2)
| Operation (exp1,Div,exp2) -> (eval e exp1)/.(eval e exp2)
| Operation (exp1,Mult,exp2) -> (eval e exp1)*.(eval e exp2)
| Variable v ->
    try List.assoc v e
	with Not_found -> failwith ("La variable " ^ v ^ " n'est pas connue.")


let rec ajout_def v n e = (v,n)::e




let rec lire_vrai_decimale s i deja_lue mult lgs=
match s.[i] with
|' ' | ')'|'+'|'-'|'*'|'/'|';' -> deja_lue,i
|'0'..'9' -> let d =float_of_int (( int_of_char s.[i]) - (int_of_char '0')) in 
  let nval=(d *. mult) +. deja_lue in
  if i+1=lgs then raise Non_valide else
  lire_decimale s (i+1) nval (mult/.10.) lgs 
|_ -> raise Non_valide


let rec lire_decimale s i deja_lue mult lgs =
match s.[i] with
|' ' | ')'|'+'|'-'|'*'|'/'|';' -> deja_lue,i
|'0'..'9' -> let d =float_of_int (( int_of_char s.[i]) - (int_of_char '0')) in 
  let nval=(deja_lue *. mult) +. d  in
  if i+1=lgs then raise Non_valide else
  lire_decimale s (i+1) nval mult lgs 
|'.'-> lire_vrai_decimale s (i+1) deja_lue (1/.10) lgs
|_ -> raise Non_valide





type mot = LPar | RPar | V of string |Op of oper |Nb of float




let rec anal_lex_aux s lg i  = 
  if i = lg then failwith "anal_lex manque ;"
  else 
    match s.[i] with 
    | ';' -> []
    | '(' -> LPar::(anal_lex_aux s lg (i+1))
    | ')' -> RPar::(anal_lex_aux s lg (i+1))
    | '0'..'9' -> let n,j = (lire_decimale s i 0. 1. lg) in (Nb n)::(anal_lex_aux s lg j)
    | '+' -> (Op Plus)::(anal_lex_aux s lg (i+1))
    | '-' -> (Op Moins)::(anal_lex_aux s lg (i+1))
    | '*' -> (Op Mult)::(anal_lex_aux s lg (i+1))
    | '/' -> (Op Div)::(anal_lex_aux s lg (i+1))
    | 'a'..'z' -> V (Char.escaped s.[i])::(anal_lex_aux s lg (i+1))
    | _ -> anal_lex_aux s lg (i+1)



let anal_lex s = 
  anal_lex_aux s (String.length s) 0


type lme = M of mot | E of expr

let rec anal_syn_aux l_mot lme =
  match (l_mot,lme) with 
  |([],[E e]) -> e
  |([],((E e1)::(M (Op o))::(E e2)::slme))->anal_syn_aux [] ((E (Operation(e1,o,e2)))::slme)
  |([],_)->failwith("erreur de syntaxe1")
  |(LPar::slm,_)->anal_syn_aux slm (M LPar::lme)
  |(Op o::slm,_)->anal_syn_aux slm (M (Op o)::lme)
  |(Nb n ::slm,[])->anal_syn_aux slm (E (Nombre n)::lme)
  |(Nb n ::slm,M LPar::_)->anal_syn_aux slm (E (Nombre n)::lme)
  |((Nb n ::slm),(M Op o)::(E e)::slme)->anal_syn_aux slm (E(Operation(e,o,(Nombre n)))::slme)
  |(RPar::slm,E e::M LPar::slme)->anal_syn_aux slm (E e::slme)
  |_,_-> failwith("erreur de syntaxe2")

let anal_syn phrase =
  anal_syn_aux (anal_lex phrase)  []



