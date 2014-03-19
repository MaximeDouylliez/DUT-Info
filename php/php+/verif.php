<?php

//la fonction vérification renvoie toujours vrai, il faut la modifier pour qu'elle interroge la base de données AP5 et qu'elle vérifie si l'id et le pwd passé en argument correspondent à un utilisateur de la table Client
session_start();

//function autorisation modifiée pour fonctionner sans DB


function autorisation( $id, $pwd) {
	
  	include_once('connexionBD.php');
	global $groupe;

	$requete="select * from user where email='$id' and mdp='$pwd' ";

	$exec=$connexion->query($requete);
	$result=$exec->fetchAll(PDO::FETCH_ASSOC);
	
	include_once('fermetureBD.php'); 
	
	if (count($result)==1){
		$groupe=$result[0][groupe];
		return TRUE;
		}
	else {
		return FALSE;
		}
	
}

//verification que le script est appelé depuis un formulaire

if ( isset( $_POST['login'] ) ) 
{
   	$login=$_POST['login'];
	$pwd=$_POST['mdp'];
  	
	if ( autorisation( $login, $pwd) > 0) {

		echo "Bonjour $login , votre identité est vérifiée </br>";
		if ($groupe ==0) echo "votre role est administrateur </br>" ;
		else if ($groupe ==1) echo "votre role est redacteur </br>" ;
			else if ($groupe ==2) echo "votre role est lecteur </br>" ;
		//regénération d'un nouvel identifiant de session
		session_regenerate_id();
		//association du login avec la session
		$_SESSION['login'] = $login;
		$_SESSION['groupe']=$groupe;
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
<a href="quitter.php"> nous quitter</a><br>
<a href="demanderDate.php"> Afficher les news pour une date choisie</a><br>
<a href="afficherToutesNews.php"> Afficher toutes les news</a><br>
<?php
if (($groupe ==1)||($groupe==0)) echo '<a href="saisirNews.php"> ajouter une news</a><br>';
?>

</body>
</html>


