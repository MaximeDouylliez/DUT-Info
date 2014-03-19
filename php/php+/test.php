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
	
	public function __toString(){
		echo 'hey tu veux ma photo';
	}
	public function affSexe(){
		return $this->sexe;	
		}

	public function affBarbe(){
		return $this->barbe;
		}
}

$ludo = new homme();
echo $ludo->affSexe();
echo $ludo->affBarbe();

?>
