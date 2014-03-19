<?php

//verification que le script est appelé depuis un autre formulaire 
if ( isset( $_POST['nom'] ) && isset( $_POST['description'] ) ) {

	$nom=$_POST['nom'];
	$des=$_POST['description'];
	
	
	//on verifie que les champs sont bien renseignés
	if ( (!empty($nom)) && (!empty($des)) ) 
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
	Mysql_select_db('inventaire');

	//ecriture de la requete
	$requete="insert into objet values('$nom','$des',1)";

	//execution de la requete
	$exec=mysql_query($requete);
	
	//traitement des erreurs
	if (!$exec) {
		echo "erreur sur la requete";
	
		exit();
	}
	else{
		echo 'objet ajoute';
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



}

?>

