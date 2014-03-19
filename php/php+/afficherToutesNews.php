<?php
include('validation.php');
if (($_SESSION['groupe'] == 2)||($_SESSION['groupe'] == 1)||($_SESSION['groupe'] == 0))
{

	include_once('connexionBD.php');

	$requete="select titre,texte,date from news";

	$exec=$connexion->query($requete);
	$tableau=$exec->fetchAll(PDO::FETCH_ASSOC);
	$taille=count($tableau);
	for($i=0; $i<$taille; ++$i)
	{
	    	echo 'date : ' . $tableau[$i][date];
		echo ' titre : ' . $tableau[$i][titre];
		echo ' date : ' . $tableau[$i][texte];
		echo '<br/>';
	}	
	
	include_once('fermetureBD.php');
	
	echo '<a href="demanderDate.php"> retour au choix de la date </a><br>';
	echo '<a href="afficherToutesNews.php"> actualiser </a><br>';
	if ($_SESSION['groupe'] !=2) echo '<a href="ajouterNews.html"> ajouter une news</a><br>';

	echo '<a href="quitter.php"> nous quitter</a><br>';
}
else
{
exit();
}

?>
 
