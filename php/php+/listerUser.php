<?php
$login='igi';
$mdp='igi';
$hote='localhost';
$bd='td1';
$dsn="mysql:host=$hote;dbname=$bd";
//$connexion= new PDO($dsn,$login,$mdp,array(PDO::ATTR_PERSISTENT=>TRUE));
//persistence de la connexion

try {
	$connexion= new PDO($dsn,$login,$mdp);


}
catch (PDOException $e){
	echo "erreur de type : " . $e->getMessage() . "<br/>";
	die();
}


$requete = "select nom,prenom from user";
$exec=$connexion->query($requete);
$resultat=$exec->fetchAll(PDO::FETCH_ASSOC);
print_r($resultat);
echo '<br/>';
echo '<br/>';

$requete = "select nom,prenom from user";
$exec=$connexion->query($requete);
$resultat=$exec->fetchAll(PDO::FETCH_BOTH);
print_r($resultat);
echo '<br/>';
echo '<br/>';

$requete = "select nom,prenom from user";
$exec=$connexion->query($requete);
$resultat=$exec->fetchAll(PDO::FETCH_OBJ);
print_r($resultat);
echo '<br/>';
echo '<br/>';

$requete = "select nom,prenom from user";
$exec=$connexion->query($requete);
while ($ligne=$exec->fetch()){
	print_r($ligne);
	
	}
print_r($resultat);












if ($connexion) {
	$connexion=NULL; //fermeture de la connexion
	}
?>
 
