<?php
//appel au script de vérification de la session
include('validation.php');

$_SESSION['nbVisites'] = $_SESSION['nbVisites'] + 1 ;

echo "il s'agit de votre ";
echo $_SESSION['nbVisites'] . 'eme(s) visite(s)';

?>

<html>
<head><title>jeux</title></head>
<body>
<br>
<a href="typerecherche.php"> effectuer une recherche</a><br/>
<a href="visites.php"> continuer la visite</a><br/>
<a href="reinitialiser.php"> reinitialiser</a><br/>
<a href="quitter.php"> nous quitter</a>
</body>
</html>
