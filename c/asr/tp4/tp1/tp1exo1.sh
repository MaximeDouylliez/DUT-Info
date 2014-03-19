#/bin/sh

if [ $# < 2 ]
then
echo " nombre d'argument invalide"
exit 0
fi

if [ ! -e $2 ]
then
echo " nom de répertoire invalide ou n'existe pas"
exit 0
fi

tar czvf $1 $2 