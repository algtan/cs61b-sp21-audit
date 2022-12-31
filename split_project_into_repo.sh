#!/bin/sh

SUBDIR=$1

if [ $SUBDIR = "proj0" ]
then
    NEWDIR="game2048"
elif [ $SUBDIR = "proj1" ]
then
    NEWDIR="deques"
elif [ "$SUBDIR" = "proj2" ]
then
    NEWDIR="gitlet"
elif [ $SUBDIR = "proj3" ]
then
    NEWDIR="build-your-own-world"
else
    echo "$SUBDIR is not a valid argument"
    exit
fi

cd ..
rm -rf $NEWDIR
mkdir $NEWDIR
cd $NEWDIR
git clone https://github.com/algtan/cs61b-sp21-audit.git .
git filter-repo --subdirectory-filter $SUBDIR
git remote add origin "https://github.com/algtan/${NEWDIR}.git"
git push --force origin main
