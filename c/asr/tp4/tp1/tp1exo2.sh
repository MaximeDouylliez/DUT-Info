#/bin/bash


if [ $# != 1 ]
then
echo " nombre d'argument invalide"
exit 0
fi

tar  zxvf backup/$1
