<?php

class humain{
	private $nom;
	private $age;
	private $sexe;
	}

class homme extends humain{
	
	private $barbe;
	public function __construct(){
		$this->sexe=masculin;
		$this->barbe=oui;
		}

	public function affBarbe(){
		return $this->barbe;
		}
}

$ludo = new homme();
echo $ludo->affBarbe();

?>
