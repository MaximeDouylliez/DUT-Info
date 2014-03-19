/*La calculatrice est capable de gerer une opération normale ( operande + operateur + operande) 
                                            opération rapide  (operande +operateur+operande+operateur+operande... 
                                            
                ne gere pas une opération suplémentaire aprés  la touche égale                            */
                                       
public class Aiguilleur

{
private Ram ddr;
private Processing c2d;
private State etat;
private String ope;
private Skin fen;
public Aiguilleur(Skin a){
ddr=new Ram();
c2d=new Processing();
etat= new State();
fen=a;}


public void refresh(){
if (etat.isFirst()){

fen.aff((String.valueOf (ddr.getOper1())));}
else{

fen.aff((String.valueOf(ddr.getOper2())));}}

public  void ajouterVal(int val){
if(etat.isFirst()){
ddr.chargementTampon1(val);
refresh();}

else {
ddr.chargementTampon2(val);
refresh();}
}
public void ajouterOp(String c){
if (etat.isFirst() ){
     if(ddr.getIndTmp1()>0){
         if(ddr.getIndVirgTmp1()==0 && c.equals(","))
              ddr.setIndVirgTmp1(ddr.getIndTmp1());
         else if(!c.equals(",")){
         ope=c;
         etat.setSecond();}
         else ;}
        }
else{
if(ddr.getIndTmp2()>0){
if(c.equals("=")){
if( !etat.isFirst()){
calcul();}
else;}
        else if(ddr.getIndVirgTmp2()==0 && c.equals(","))
              ddr.setIndVirgTmp2(ddr.getIndTmp2());
         else if(!c.equals(",")){
       
lancerCalculRapide();
fen.aff((String.valueOf (ddr.getOper1())));
ope=c;}
else ;}}

}

public void effectuerOptn(String s){

if(s.equals("clear")){
 ddr.dechargementTampon1();
 ddr.dechargementTampon2();
 ddr.setOper1(0);
 ddr.setOper2(0);
 ope=null;
refresh();}

else if(s.equals("clearl")){
if(etat.isFirst()){
      if (ddr.getIndTmp1()>0){
           
           if(ddr.getIndVirgTmp1()==ddr.getIndTmp1()){
               ddr.setIndVirgTmp1(0);
           
               ddr.transTmp1();
            refresh();}
                 
           else{
              ddr.dechargementChTampon1();
              ddr.transTmp1();
                 refresh();   }refresh();}
       else refresh();     }   
else{   
    if (ddr.getIndTmp2()>0){
            if(ddr.getIndVirgTmp2()==ddr.getIndTmp2()){
               ddr.setIndVirgTmp2(0);
               ddr.transTmp2();}
                 
           else{
              ddr.dechargementChTampon2();
              ddr.transTmp2();}}
       else ;         
              
}   
refresh();}



else if(s.equals("memclear")){ddr.memC();}
else if(s.equals("mrplus")){
ddr.addMem(etat);
refresh();}
else if(s.equals("mrmoin")){
ddr.subMem(etat);
refresh();}

else if(s.equals("memrec")){
ddr.memRec(etat);
refresh();}
}


public void calcul(){
if(ope.equals("+")){
 ddr.setOper2(c2d.addition(ddr.getOper1(),ddr.getOper2())) ;
 
}
else if(ope.equals("-")) {
 ddr.setOper2(c2d.soustraction(ddr.getOper1(),ddr.getOper2())) ;
}
 else if(ope.equals("*")) {
     ddr.setOper2(c2d.multiplication(ddr.getOper1(),ddr.getOper2())) ;
}
else if(ope.equals("/")){
try{
 ddr.setOper2(c2d.division(ddr.getOper1(),ddr.getOper2())) ;
}
 catch(zeroException e){}}
else ;//exception a rajouter
ddr.dechargementTampon1();
 ddr.dechargementTampon2();
refresh();
etat.setFirst();}

public void lancerCalculRapide(){
if(ope.equals("+")){
 ddr.setOper1(c2d.addition(ddr.getOper1(),ddr.getOper2())) ;
 ddr.dechargementTampon2();}
else if(ope.equals("-")) {
 ddr.setOper1(c2d.soustraction(ddr.getOper1(),ddr.getOper2())) ;
 ddr.dechargementTampon2();}
 else if(ope.equals("*")) {
     ddr.setOper1(c2d.multiplication(ddr.getOper1(),ddr.getOper2())) ;
 ddr.dechargementTampon2();}
else if(ope.equals("/")){
try{
 ddr.setOper1(c2d.division(ddr.getOper1(),ddr.getOper2())) ;
 ddr.dechargementTampon2();}
 catch(zeroException e){}}
else ;//exception a rajouter
}


}