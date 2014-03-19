<?php

	//strtok decoupe une chaine selon un delimiteur
	//id récupère la première partie de la string passée par le formulaire
	$idArtiste=strtok($_POST['mon_champ'],' ');
	
	if(!mysql_connect('localhost','root','concombres'))
	{
		exit();
	}

	Mysql_select_db('ap5');

	$requete="select titreChanson from Chanson natural join Album natural join Artiste where idArtiste='$idArtiste'";

	$exec=mysql_query($requete);

	$nb=mysql_numrows($exec);

	$i = 0;
	
	echo 'titre: <br/> ';
	while ($i < $nb){ //boucle de parcourt des résultats
  	$titreChanson = mysql_result($exec, $i, "titreChanson");
	echo  $titreChanson;
	echo '<br/>';

 	
  	$i++;  
	}
 
 	
	

?>
 
