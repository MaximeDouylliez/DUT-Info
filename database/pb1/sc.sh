#!/bin/sh

psql prb1 -tAF: -c "select nom,ip from ipbase"|while IFS=: read name ip
do
echo -n $name $ip:
if ping -c1 $ip > /dev/null
then
psql prb1  -c "insert into hystory values('$name','OK',CURRENT_TIMESTAMP)"
else
psql prb1 -c "insert into hystory values('$name','NOK',CURRENT_TIMESTAMP)"
fi
done
