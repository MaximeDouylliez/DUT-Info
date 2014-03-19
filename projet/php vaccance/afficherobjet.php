<?php

	//strtok decoupe une chaine selon un delimiteur
	//id récupère la première partie de la string passée par le formulaire
	$idAlbum=strtok($_POST['mon_champ'],' ');
	
	if(!mysql_connect('localhost','root','concombres'))
	{
		exit();
	}

	Mysql_select_db('ap5');

	$requete="select nomobjet from salle natural join ojet where idsalle='$idsalle'";

	$exec=mysql_query($requete);

	$nb=mysql_numrows($exec);

	$i = 0;
	
echo 'titre: <br/> ';
	while ($i < $nb){ //boucle de parcourt des résultats
  	$objet = mysql_result($exec, $i, "nomobjet");
	echo $objet;
echo '<br/>';

 	
  	$i++;  
	}
 
 	
	

?>
 
