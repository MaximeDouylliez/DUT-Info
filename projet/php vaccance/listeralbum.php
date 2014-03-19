
<?php

//ici on recupère la iste des utilisateurs : leur id et leur nom

$connexion = mysql_connect('localhost','root','concombres');
  	if(!mysql_connect('localhost','root','concombres'))
	{
		exit();
	}

	Mysql_select_db('ap5');

	$requete="select idAlbum,titreAlbum from Album";

	$exec=mysql_query($requete);

	$nb=mysql_numrows($exec);
	
	//echo 'nombre de ligne renvoyées : ' . $nb . '<br />';

	$i = 0;
	echo "<br/><br/><br/>Voici la liste des joueurs enregistres, choisissez en un <br/><br/><br/>";
	while ($i < $nb){ //boucle de parcourt des résultats
  	$idAlbum[$i] = mysql_result($exec, $i, "idAlbum");
	$titreAlbum[$i] = mysql_result($exec, $i, "titreAlbum");
 	
  	$i++;  
	}
	 
mysql_close(); 
?>
<?php
// ici on affiche les joueurs dans un menu deroulant
//l'utilisateur choisira un joueur
//puis on fait appel au script afficherunjoueur.php qui affiche toute les info du joueru selectionné
?>
<form method="POST" action="afficheralbum.php">
    <select name="mon_champ" size="$nb" multiple>
        <?php
        for ($i=0; $i<$nb;$i++ ){
            echo '<option>' . $idAlbum[$i] . '    ' . $titreAlbum[$i] . '</option>';
        }
        ?>
    </select>
    <input type="submit" value="OK"/>
</form>
