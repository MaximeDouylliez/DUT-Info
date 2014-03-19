<?php
class humain{
	private $nom;
	private $age;
	private $sexe;
	public function	__get($attribut){
		echo 'attribut ' . $attribut . ' inexistant';
		}
	}
$ludo = new humain();
echo $ludo->tete;
?>
