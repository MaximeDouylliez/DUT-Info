#host : sert a convertir des nom de site en adresse ip et vice versa


if [ -e ip.list ]
then
rm ip.list
fi


exec 3<univ-serv.txt
exec 4>iptmp


while read -u3 var
do
host $var|grep has|cut -d ' ' -f4 >&4
done

sort -u iptmp >iptmp2


exec 3<&-
exec 4>&-


rm iptmp

exec 5<iptmp2
exec 6>ip.list
while read -u5 var
do
ping $var >&6
done

exec 5<&-
exec 6>&-
rm iptmp2



