<?php
		
if(isset($_POST['type'])){

$type=$_POST['type'];
//$type="par titre";


if($type == "titre"){
header ('location: affichertitre.php');
}

elseif($type == "album"){
header('location: listeralbum.php');
}

else{
header('location: listerartiste');
}
}
else
echo "Pas de tentative de hack !!"
?>
