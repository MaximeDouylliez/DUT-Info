<?php
include('validation.php');
if (($_SESSION['groupe'] == 2)||($_SESSION['groupe'] == 1))
{
	include_once('connexionBD.php');

	$requete="select titre,texte,date from news";

	$exec=$connexion->query($requete);
	while ($ligne=$exec->fetch(PDO::FETCH_OBJ)){
	echo 'date : ' . $ligne->date . ' titre : ' . $ligne->titre . ' texte : ' . $ligne->texte;
	echo '<br/>';
		
	if ($connexion) {
		$connexion=NULL;
		}
	

	echo '<a href="demanderDate.php"> retour au choix de la date </a><br>';
	echo '<a href="afficherToutesNews.php"> actualiser </a><br>';
	if ($_SESSION['groupe'] !=2) echo '<a href="saisirNews.php"> ajouter une news</a><br>';

	echo '<a href="quitter.php"> nous quitter</a><br>';
}
else
{
exit();
}
?>
 
