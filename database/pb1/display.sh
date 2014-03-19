#!/bin/sh

echo ""
echo ""
psql prb1 -tAF: -c "select nom,ip from ipbase"|while IFS=: read  nom ip
do
echo  "$nom ($ip) "
echo -n "Last OK on "
echo  `psql prb1 -tAF: -c "select date from hystory where nom='$nom' and etat='OK' order by date desc limit 1"`
echo -n "Last NOK on "
echo   `psql prb1 -tAF: -c "select date from hystory where nom='$nom' and etat='NOK' order by date desc limit 1"`
echo -n "Last was "
echo  -n `psql prb1 -tAF: -c "select etat from hystory where nom='$nom' order by date desc limit 1"`
echo  -n " on "
echo  `psql prb1 -tAF: -c "select date from hystory where nom='$nom' order by date desc limit 1"`
echo " "
done


