#!/bin/sh





psql prb3 -tAF: -c "select titreAlbum,titreChanson,durée,nomArtiste,prix from chanson natural join album natural join artiste where $1 = '$2'"


psql prb3 -tAF: -c "insert into rassemble value(idcompile,nomchanson,idalbum),[on recommence pour chaque chanson coché]" 

select sum(prix) from rassemble natural join chanson where idcompile= (idcopile du client)

delete from rassemble where idcompile= and nochanson= and idalbum=

select nomclient from client where

select nomchanson,nombalbum from rassemble natural join chanson order by count( 