<?php

	//strtok decoupe une chaine selon un delimiteur
	//id récupère la première partie de la string passée par le formulaire
	//$idArtiste=strtok($_POST['mon_champ'],' ');
	
	if(!mysql_connect('localhost','root','concombres'))
	{
		exit();
	}

	Mysql_select_db('ap5');

	$requete="select titreChanson,noChanson,idAlbum from Chanson natural join Album";
 // natural join Album natural join Artiste where idArtiste='$idArtiste'";

	$exec=mysql_query($requete);

	$nb=mysql_numrows($exec);

	$i = 0;
	
	echo 'titre: <br/> ';
	
 	


	$i = 0;

	while ($i < $nb){ //boucle de parcourt des résultats
  	$titreChanson[$i] = mysql_result($exec, $i, "titreChanson");
	$noChanson[$i] = mysql_result($exec, $i, "noChanson");
 	$idAlbum[$i]=mysql_result($exec,$i,"idAlbum");
  	$i++;  
	}

?>
  	<form method="POST" action="afficheralbum.php">
    <select name="mon_champ" size="$nb" multiple>
        <?php
        for ($i=0; $i<$nb;$i++ ){
            echo '<option>' . $idAlbum[$i] . '    ' . $titreChanson[$i] . '</option>';
        }
        ?>
    </select>
    <input type="submit" value="OK"/>
</form>
	}
 
 	
	


 
