<?php
//script vérifiant le validité d'une session

session_start();

if ( !isset( $_SESSION['login']) ) {
	header('location: auth.html');
	exit();
}

?>
