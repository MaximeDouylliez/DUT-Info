<?php
session_start();
include_once('connexionBD.php');

$titre=$_POST['titre'];
$texte=$_POST['texte'];
$date=date('Y-m-d');

$requete="insert into news (date,titre,texte) values ('$date','$titre','$texte')";
$exec=$connexion->exec($requete);

include_once('fermetureBD.php');
?>



