<?php
//script vérifiant le validité d'une session

session_start();

if ( !isset( $_SESSION['nbVisites'] ) ){
	$_SESSION['nbVisites']=0;
}
else {
}
?>
