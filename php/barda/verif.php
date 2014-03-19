<?php

//la fonction vérification renvoie toujours vrai, il faut la modifier pour qu'elle interroge la base de données AP5 et qu'elle vérifie si l'id et le pwd passés en arguments correspondent à un utilisateur de la table Client
session_start();

function autorisation( $id, $pwd) {
	return true;
}

//verification que le script est appelé depuis un formulaire

if ( isset( $_POST['login'] ) ) 
{
   	$login=$_POST['login'];
	$pwd=$_POST['mdp'];
  	
	if ( autorisation( $login, $pwd) ) {

		echo "Bonjour $login , votre pwd est valide </br>" ;
		//regénération d'un nouvel identifiant de session
		session_regenerate_id();
		//association du login avec la session
		$_SESSION['login'] = $login;
		$_SESSION['nbVisites'] = 1 ;
		echo "Il s'agit de votre  ";
		echo $_SESSION['nbVisites'] . ' ere visite';
		echo '</br>';
	}
	else {
		//traitement de l'utilisateur non autorisé
		//ici redirection vers la page inscription
		header('location: inscription.html');
	}

}
 else {

 	//traitement du cas ou il n'y a pas eu saisie du login et du password (acces direct à la page verif.php)
	//ici redirection vers la page d'autehntification
	header('location: auth.html');
	
}

?>
<br>
<html>
<head><title>Authorisation</title></head>
<body>
<a href="visites.php"> visiter le site</a><br>
<a href="quitter.php"> nous quitter</a><br>
<a href="inscription.html"> créer un nouvau compte</a><br><br>
</body>
</html>


