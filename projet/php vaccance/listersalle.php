
<?php

//ici on recupère la iste des utilisateurs : leur id et leur nom

$connexion = mysql_connect('localhost','','');
  	if(!mysql_connect('localhost','',''))
	{
		exit();
	}

	Mysql_select_db('inventaire');

	$requete="select nom, from Salle";

	$exec=mysql_query($requete);

	$nb=mysql_numrows($exec);
	
	//echo 'nombre de ligne renvoyées : ' . $nb . '<br />';

	$i = 0;
	echo "<br/><br/><br/>Voici la liste des joueurs enregistres, choisissez en un <br/><br/><br/>";
	while ($i < $nb){ //boucle de parcourt des résultats
  	$idsalle[$i] = mysql_result($exec, $i, "idAlbum");
	
 	
  	$i++;  
	}
	 
mysql_close(); 
?>
<?php
// ici on affiche les joueurs dans un menu deroulant
//l'utilisateur choisira un joueur
//puis on fait appel au script afficherunjoueur.php qui affiche toute les info du joueru selectionné
?>
<form method="POST" action="affichesalle.php">
    <select name="mon_champ" size="$nb" multiple>
        <?php
        for ($i=0; $i<$nb;$i++ ){
            echo '<option>' . $idsalle[$i] . '</option>';
        }
        ?>
    </select>
    <input type="submit" value="OK"/>
</form>
