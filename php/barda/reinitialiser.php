<?php
//script vérifiant le validité d'une session

session_start();
//pour libérer une variable : 
//unset ($_SESSION['nbVisites']);
$_SESSION['nbVisites']=0;

header('location: visites.php');
?>