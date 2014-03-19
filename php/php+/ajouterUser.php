<?php
include_once('connexionBD.php');
if ( isset( $_POST['login'] ) && isset( $_POST['mdp'] ) && isset( $_POST['nom'] ) && isset( $_POST['prenom'] )){
	$id=$_POST['login'];
	$pwd=$_POST['mdp'];
	$nom = $_POST['nom'];
	$prenom = $_POST['prenom'];
	if ( (!empty($id)) && (!empty($pwd)) && (!empty($nom)) && (!empty($prenom)) ){
		$requete="insert into user values('$id','$nom','$prenom','$pwd',2)";

		//execution de la requete
		$action=$connexion->exec($requete);

		if ($action===NULL) {
			echo "erreur sur execution de la requete";
			echo '<A HREF="inscription.html">retour au formulaire d inscription</A>';
			//exit();
			}
		else if ($action==1){
			echo 'utilisateur ' . $id . ' ajoute';
			}
			else {
				echo 'utilisateur non ajoute';
				}
		include_once('fermetureBD.php');
		}
	else{
		echo 'des champs sont mal renseignes <br/>';
		}

}
else {
	header('location: inscription.html');
	}
?>
