#!/bin/sh

if [ $1 == buffalo ]
then
       ipmitool -I lanplus -H $1-adm.cs.fiu.edu -U admin -a shell
else
       ipmitool -I lanplus -H $1-adm.cs.fiu.edu -U root -a shell
fi

