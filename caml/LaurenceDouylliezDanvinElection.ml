(** pour commencer le programme lancer la fonction saisi()*)
let rec compter l =
  match l with
    |[]-> 0
    |(_,x)::t-> x + (compter t )

exception ListeEtatVide
exception PasElement

let rec est_dans el l =
  match l with
    |[]->false
    |(nom,_)::t-> if nom = el then true
      else est_dans el t

let rec get_valeur listeEtat el=
  match listeEtat with
    |[]-> raise PasElement
    |(nom,valeur)::t->if nom = el then valeur else get_valeur t el


let rec creer_assoc listeEtat listeNom listeTmp=
  match listeEtat,listeNom with
  |_,[]->listeTmp
  |[],_->failwith("erreur ListeEtatVide")
  |_,h::t->creer_assoc listeEtat t ((h,(get_valeur listeEtat h))::listeTmp)

let rec liste_indecis_aux lt lr ld ls =
  match lt with
    |[]->ls
    |(nom,nb)::t-> if(not(est_dans nom lr) && not(est_dans nom ld)) then liste_indecis_aux t lr ld ((nom,nb)::ls)
      else liste_indecis_aux t lr ld ls

let liste_indecis lt lr ld = liste_indecis_aux lt lr ld []

let rec traitement listeIndecis bool listeTmp major lResu=
  match listeIndecis,listeTmp,bool with
    |[],_,_ -> lResu
    |h::t,_,false -> traitement t true listeTmp major (traitement t false listeTmp major lResu)
    |h::t,_,true ->
       let x=if ((compter (h::listeTmp)) >= major) 
       then (h::listeTmp)::lResu 
       else lResu 
       in
       ( traitement t true (h::listeTmp) major (
	   traitement t false( h::listeTmp) major x))
	 

let majorite liste = 1 +((compter liste)/2)

let etat = [("alabama",9);("alaska",3);("arizona",8);("arkansas",6);("california",54);("caroline du nord",14);("caroline du sud",8);("colorado",8);("connecticut",8);("dakota du nord",3);("dakota du sud",3);("delaware",3);("district of columbia",3);("florida",25);("georgie",13);("hawai",4);("idaho",4);("illinois",22);("indiana",12);("iowa",7);("kansas",6);("kentucky",8);("louisiane",9);("maine",4);("maryland",10);("massachussets",12);("michigan",18);("minnesota",10);("mississipi",7);("missouri",11);("montana",3);("nebraska",5);("nevada",4);("new hampshire",4);("new jersey",15);("new mexico",5);("new york",33);("ohio",21);("oklahoma",8);("oregon",7);("pennsylvania",23);("rhode island",4);("tennessee",11);("texas",34);("utah",5);("vermont",3);("virginie",13);("virginie occidentale",5);("washington",11);("wisconsin",11);("wyoming",3)];;

let lrepublicain = ["caroline du sud";"georgie";"alabama";"tennessee";"kentucky";"louisiane";"texas";"alaska";"montana";"utah";"arizona";"dakota du sud";"dakota du nord";"idaho";"wyoming"];;

let ldemocrate = ["new hampshire";"massachussets";"rhode island";"connecticut";"vermont";"new york";"new jersey";"maryland";"virginie";"ohio";"indiana";"wisconsin";"iowa";"colorado";"hawai";"oregon"];;


let demarrer lliste=
traitement 
(liste_indecis etat (creer_assoc etat lrepublicain []) (creer_assoc etat ldemocrate [])) 
false 
(creer_assoc etat lliste []) 
(majorite etat)
(traitement (liste_indecis etat (creer_assoc etat lrepublicain []) (creer_assoc etat ldemocrate [])) true (creer_assoc etat lliste []) (majorite etat) [])

let rec ecrire_liste list canal_out =
  match list with
    |[]-> output_char canal_out '\n'; output_char canal_out '\n'; output_char canal_out '\n'; output_char canal_out '\n'
    |(nom,valeur)::t-> output_string canal_out nom; output_char canal_out ' ';
	ecrire_liste t canal_out

let rec compter_combi list cmpt=
  match list with
    |[]->cmpt
    |h::t-> compter_combi t (cmpt+1)

let rec recuperation_aux demarrer canal_out=
  match demarrer with
    |[]->close_out canal_out
    |h::t-> output_string canal_out ("nombre de votes: ");output_string canal_out (string_of_int(compter h));output_char canal_out '\n'; output_string canal_out ("Combinaison: ");ecrire_liste h canal_out;
       recuperation_aux t canal_out


let saisie () =
  let canal ="combinaison.txt" in
  let canal_out=open_out canal in
  print_string("Choisissez votre candidats (republicain/democrate): ");
  let sa = read_line() in
  match sa with
    |"republicain;;"->
	output_string canal_out ("nombre de combinaison trouvée: ");
	output_string canal_out (string_of_int(compter_combi (demarrer lrepublicain) 0));

	output_char canal_out '\n'; output_char canal_out '\n'; output_char canal_out '\n'; output_char canal_out '\n';
	
	recuperation_aux (demarrer lrepublicain) canal_out;
	
	Printf.printf " Chargement de la liste terminée\nVous pouvez voir le résultat dans le fichier combinaison.txt\n"
	  
    |"democrate;;"->
	output_string canal_out ("nombre de combinaison trouvée: ");
	output_string canal_out (string_of_int(compter_combi (demarrer lrepublicain) 0));

	output_char canal_out '\n'; output_char canal_out '\n'; output_char canal_out '\n'; output_char canal_out '\n';

	recuperation_aux (demarrer ldemocrate) canal_out;
	
	Printf.printf " Chargement de la liste terminée.\nVous pouvez voir le résultat dans le fichier combinaison.txt\n"
	  
    |sa->Printf.printf "%s ne fait pas partie des options\n" sa;
	saisie()
