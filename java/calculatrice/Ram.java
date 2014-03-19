import java.util.*;
import java.lang.Math;


public class Ram{



private int[] tampon1;
private int indTmp1=0;
private int indVirgTmp1=0;
private int[] tampon2;
private int indTmp2=0;
private int indVirgTmp2=0;

private double oper1=0;
private double oper2=0;
private double mem;


public  Ram(){
tampon1=new int[15];
tampon2=new int[15];
}



public void chargementTampon1(int a){// on choisira ici d'ignorer la saisie en cas de depassement de memoire
if(indTmp1>=14);
else{
tampon1[indTmp1]=a;
indTmp1++;
transTmp1();
}
}

public void chargementTampon2(int a){
if(indTmp2>=14);
else{
tampon2[indTmp2]=a;
indTmp2++;
transTmp2();}
}

public void transTmp1(){
int i;
if(indVirgTmp1!=0){
for(i=indTmp1,oper1=0;i>-1;i--){
oper1=oper1 + tampon1[i]*Math.pow((double)10,(double)indVirgTmp1-1-i);
}}
else{
for(i=0,oper1=0;i<indTmp1;i++){
oper1=oper1*10 + tampon1[i];
}}
}



public void transTmp2(){//methode pour passer de int[] a double avec gestion de la virgule
int i;

if(indVirgTmp2!=0){
for(i=indTmp2,oper2=0;i>-1;i--){
oper2=oper2 + tampon2[i]*Math.pow((double)10,(double)indVirgTmp2-1-i);
}}
else{
for(i=0,oper2=0;i<indTmp2;i++){
oper2=oper2*10 + tampon2[i];
}}
}

public void dechargementChTampon1(){

tampon1[indTmp1-1]=0;
indTmp1--;
transTmp1();}

public void dechargementChTampon2(){

tampon1[indTmp2]=0;
indTmp2--;}
public void dechargementTampon1(){
int i;
indTmp1=0;
indVirgTmp1=0;
for(i=0;i<15;i++)
tampon1[i]=0;
}


public void dechargementTampon2(){
int i;
indTmp2=0;
indVirgTmp2=0;
for(i=0;i<15;i++)
tampon2[i]=0;
}


public void addMem(State e){
if(e.isFirst())
mem=mem+oper1;
else 
mem=mem+oper2;}



public void subMem(State e){
if(e.isFirst())
mem=mem-oper1;
else 
mem=mem-oper2;}


public void memC(){
mem=0;}

public void memRec(State e){
if(e.isFirst()){

oper1=oper1+mem;
}


else {
oper2=oper2+mem;
}
}





public int getIndVirgTmp1(){return indVirgTmp1;}
public int getIndTmp1(){return indTmp1;}
public int getIndVirgTmp2(){return indVirgTmp2;}
public int getIndTmp2(){return indTmp2;}
public double getOper1(){return oper1;}
public double getOper2(){return oper2;}

public void setIndVirgTmp1(int a){indVirgTmp1=a;}
public void setIndVirgTmp2(int a){indVirgTmp2=a;}
public void setIndTmp1(int a){indTmp1=a;}
public void setIndTmp2(int a){indTmp2=a;}
public void setOper1(double a){oper1=a;};
public void setOper2(double a){oper2=a;};
}

