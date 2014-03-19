<?php

//verification que le script est appelé depuis un autre formulaire 
if ( isset( $_POST['login'] ) && isset( $_POST['mdp'] ) && isset( $_POST['nom'] ) && isset( $_POST['adresse'] ) ) {

	$id=$_POST['login'];
	$pwd=$_POST['mdp'];
	$adresse = $_POST['adresse'];
	$nom = $_POST['nom'];
	
	//on verifie que les champs sont bien renseignés
	if ( (!empty($id)) && (!empty($pwd)) && (!empty($adresse)) && (!empty($nom))  ) 
	{

	//si oui on insere en base

  	if(!mysql_connect('localhost','root','concombres')){
	{
		Echo 'echec de connexion';
		exit();
	}
	else
	{    
		Echo 'Connexion reussie </br>';
	}

	//selection de la BD test
	Mysql_select_db('ap5');

	//ecriture de la requete
	$requete="insert into Client values('$id','$nom','$adresse','$pwd',2)";

	//execution de la requete
	$exec=mysql_query($requete);
	
	//traitement des erreurs
	if (!$exec) {
		echo "erreur sur la requete";
		echo '<br/><A HREF="inscription.html">retour au formulaire d inscription</A>';
		exit();
	}
	else{
		echo 'utilisateur ajoute';
	}
	
	//fermeture de la connexion
	mysql_close(); 
	}

	// sinon on affiche un message d'erreur	
	else 
	{
		echo 'des champs sont mal renseignes <br/>';
	}
	}


//si pas de login et de mdp, on redirige
else {
	header('location: inscription.php');
}

?>

<a href="inscription.html"> créer un nouvau compte</a><br><br>
<a href="auth.html"> retour à l'authentification</a><br><br>
