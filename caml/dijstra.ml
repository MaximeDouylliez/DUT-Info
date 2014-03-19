let  lancer_traitement matAdj matLg ptDepart ptArri  =
lancer_traitement_aux matAdj  matLg 0 1 []



let rec get_ligne_aux ligne matLg cpt lResu=
if cpt >= matLg 
then lResu
else get_ligne_aux ligne matLg (cpt+1) ((ligne.(cpt))::lResu)

let  get_ligne matAdj j=
get_ligne_aux  (matAdj.(nbcol)) matLg  0  []


let set_val tab i j valeur=
  tab.(j).(i) <- valeur;
  tab
