<?php
class humain{
	private $nom;
	private $age;
	private $sexe;
	public function	__call($methode,$param){
		echo 'la methode ' . $attribut . ' inexistante';
		echo 'vos paramètres étaient <br/>';
		foreach ($param as $p){
				echo $p;
				echo '<br/>';
				}
		}
	}
$ludo = new humain();
$ludo->toto('titi','tutu');
?>
