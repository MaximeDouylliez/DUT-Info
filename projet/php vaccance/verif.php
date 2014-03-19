<?php

//la fonction vérification renvoie toujours vrai, il faut la modifier pour qu'elle interroge la base de données AP5 et qu'elle vérifie si l'id et le pwd passés en arguments correspondent à un utilisateur de la table Client


session_start();

function autorisation( $id, $pwd) {
mysql_connect('localhost','root','concombres');

Mysql_select_db('ap5');

$requete="select * from Client where email='$id' AND password='$pwd'";
$exec=mysql_query($requete);
global $groupe;
 $groupe= mysql_result($exec,0,"groupe");


if (mysql_num_rows (mysql_query("select * from Client where email='$id'"))==1 && mysql_num_rows ($exec)==0){
//echo "mauvais mot de passe";
return false;
}

elseif( mysql_num_rows ($exec)==0)
{
//echo "Votre compte n'existe pas</br>";
return false;
}
else{

return true;

}
	
}

//verification que le script est appelé depuis un formulaire

if ( isset( $_POST['login'] ) ) 
{
   	$login=$_POST['login'];
	$pwd=$_POST['mdp'];
	if ( autorisation( $login, $pwd) ) {

		session_regenerate_id();
		echo "Bonjour $login , votre pwd est valide </br>" ;
echo "groupe: $groupe";
		//regénération d'un nouvel identifiant de session
		//association du login avec la session
		$_SESSION['login'] = $login;
		$_SESSION['nbVisites'] = 1 ;
		$_SESSION['groupe']=$groupe;
		$_SESSION['panier']=array();
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


