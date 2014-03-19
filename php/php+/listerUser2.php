<?php
include_once('connexionBD.php');

$requete = "select email,nom,prenom from user";
//definition de la requete

$exec=$connexion->query($requete);
//exécution de la requete


//différentes extractions de l'ensemble dess résultats

//$resultat=$exec->fetchAll(PDO::FETCH_ASSOC);

//$resultat=$exec->fetchAll(PDO::FETCH_BOTH);

//$resultat=$exec->fetchAll(PDO::FETCH_OBJ);

/*affichage des résultats
foreach ($resultat as $ligne){
	print_r($ligne);
	echo "<br/>";
	}
*/

//extraction des résultats individuellement
while ($ligne=$exec->fetch(PDO::FETCH_ASSOC)){
	print_r($ligne);
	echo "<br/>";
	
	}
print_r($resultat);



$chaine="aujourd'hui";
$chaine=$connexion->quote($chaine);
$requete = "insert into user (email,nom,prenom,mdp,groupe) values($chaine,'55','55','55','2')";
//definition de la requete

$resultat=$connexion->exec($requete);
//exécution de la requete

if ($resultat === 0) { echo 'pas de modif';}
else if ($resultat ===FALSE) { die('erruer');}
else { echo $resultat . 'modif ont été faites';}






if ($connexion) {
	$connexion=NULL; //fermeture de la connexion
	}
?>
 
