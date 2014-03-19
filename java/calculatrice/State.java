public class State {

private static Boolean isFirstOp;
private static Boolean isSecOp;
private static Boolean isWaitingOp;

public State(){//statut de base , on commence toujours par écrire la premier opérande
isFirstOp=true;
isSecOp=false;
isWaitingOp=true;}

public void setFirst(){// quand on saisit la premiere operande
isFirstOp=true;
isSecOp=false;
isWaitingOp=true;}

public void setOp(){// l'operateur
isFirstOp=false;
isSecOp=false;
isWaitingOp=true;}

public void setSecond(){//la seconde opérande
isFirstOp=false;
isSecOp=true;
isWaitingOp=false;}


public Boolean isFirst(){return isFirstOp==true;}
public Boolean isSec(){return isSecOp==true;}
public Boolean isWaiting(){return isWaitingOp==true;}
}
 