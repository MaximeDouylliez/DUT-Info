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


?>
