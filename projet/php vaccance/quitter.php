<?php

//appel du script de validation de la session
include('validation.php');

//destruction de la session
session_destroy();

?>

<html>
<head><title>bybye</title></head>
<body>
Aurevoir<br>
<a href="auth.html"> retour à l'authentification</a><br><br>
<a href="inscription.html"> créer un nouvau compte</a><br><br>
</body>
</html>
