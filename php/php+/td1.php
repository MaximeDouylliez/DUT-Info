<?php

$login='nainsomniak';
define('MDP','concombres');
$bd='td1';

define('DSN','mysql:host=localhost;dbname='.$bd);
try {
	$connexion=new PDO(DSN,$login,MDP);
}
	catch (PDOException $e){
	echo "erreur de type : " . $e->getMessage() . "<br/>";
	die();
}




$requete = "select titre,texte from news";
$exec=$connexion->query($requete);
$resultat=$exec->fetch(PDO::FETCH_ASSOC);
print_r($resultat);
echo '<br/>';
echo '<br/>';



?>
