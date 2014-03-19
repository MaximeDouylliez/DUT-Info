<?php
class humain{
	private $nom;
	private $age;
	private $sexe;
	public function	__set($attribut,$valeurPassee){
		echo 'attribut ' . $attribut . ' inexistant';
		}
	}
$ludo = new humain();
$ludo->tete=2;
?>
