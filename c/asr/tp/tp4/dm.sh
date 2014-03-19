echo        " Choississez l'action a effectuer" 
echo " ============================================="
echo "[1] trouver les noms de domaines references dans un site web"
echo "[2] trouver les adresses ip actives des noms de domaines"
echo "[3] trouver les adresses ip inactives des noms de domaines"
echo "[4] Quitter"
echo "============================================="

read var

case $var in
    
    1)
	rm -f *.html*
	echo "donnez le site web a tester"
	read site 
	echo "analyse de $site"
	wget $site -o fsite
	
	echo "`grep *.html fsite |cut -d"." -f-3|cut -d" " -f4|head -n 1 |cut -c3- |cut -d"." -f1`".html>nom
	
	echo $site |cut -d'.' -f2,3 > domaine
	grep "href=" `cat nom` | cut -d"/" -f3 | grep `cat domaine` |sort -u|cut -d'"' -f1 > univ-serv.txt;;
    
    
    
    2)
	{
	    for hostname in $(cat univ-serv.txt)
	    do
		host $hostname|grep "has address"|cut -d" " -f4|sort -u
	    done
	    }>ip_part.txt
	cat ip_part.txt |sort -u >ip_list.txt
	echo 74.125.230.84>>ip_list.txt
	echo "Debut du test d'activité sur les adresses ip, veuillez patienter..."
	{
	    for ip in $(cat ip_list.txt)
	    do
		ping $ip -c 2 -W 2 | grep ttl|cut -d":" -f1|cut -d" " -f4|sort -u
	    done
	} > ping.txt
	echo " Fin du test, les adresses ip actives sont:"
	cat ping.txt;;
    
    3)
	exec 4<ip_list.txt 
	exec 5<ping.txt 
	exec 3>ip.down.txt
	while read -u5 var1
do
while read -u4 var2
 if [ $var1 != $var2 ]
then echo $var2 >&3
fi
 ;;

    4) exit 1;;
    *) echo "Erreur de saisie, au revoir"
	exit 1 ;;
esac