type lexeme = Lpar | Rpar | Plus | Moins | Div | Mult | Val of int

type expr = V of lexeme | O of lexeme * expr * expr

let is_op_lex lex = match lex with
| Plus | Moins | Div | Mult  -> true
| _ -> false

let char_of_operateur lex = match lex with
| Lpar -> '('
| Rpar -> ')'
| Moins -> '-'
| Plus -> '+'
| Div -> '/'
| Mult -> '*'
| _ -> assert false

let operateur_of_char c = match c with
| ')' -> Rpar
| '(' -> Lpar
| '-'-> Moins
| '+' -> Plus
| '*' -> Mult
| '/' -> Div
| _ -> failwith ("operateur_of_char "^(Char.escaped(c)))

let affiche_mot m = match m with
| Val i -> print_int i
| _ -> print_char(char_of_operateur m)

let affiche_listmots lm =
 List.iter (fun m -> affiche_mot m; print_char ' ') lm

let is_digit c = c>='0' && c<='9'
let int_of_digit d= (Char.code d) - (Char.code '0')
let rec lire_int s i lg res =
 if i = lg then (res , i)
 else if is_digit s.[i] then lire_int s (i+1) lg (10*res+ (int_of_digit s.[i]))
 else (res, i)

let is_op c = 
 match c with
 |'+' |'-'|'('|')'|'/'|'*' -> true
 |_ -> false

let rec string_to_lmots s lg i=
 if lg = i then []
 else if is_digit (s.[i]) then
   let v,j = lire_int s  i lg 0 in
   (Val v)::(string_to_lmots s lg j)
 else if is_op s.[i] then 
  (operateur_of_char s.[i])::(string_to_lmots s lg (i+1))
 else  if s.[i] = ' ' then (string_to_lmots s lg (i+1))
 else failwith("erreur lexicale: "^s^"en position:"^(string_of_int i))
 

let rec analyse_aux lm pile =
  match lm,pile with
  | [], [e] -> e
  | [],_ -> failwith"erreur de syntaxe"
  | Lpar::t,_ -> analyse_aux t ((V Lpar)::pile)
  | Rpar::t, e::(V Lpar)::s -> analyse_aux t (e::s)
  | Rpar::t,ed::(V op)::eg::(V Lpar)::s when is_op_lex op->
      analyse_aux t (O(op,eg,ed)::s)
  | lex::t ,_ ->analyse_aux t ((V lex)::pile)
