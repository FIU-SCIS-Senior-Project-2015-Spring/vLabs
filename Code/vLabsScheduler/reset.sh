#!/bin/bash
str="`ps -ef | grep java | grep portal | grep -v grep | sed 's/  / /g' | sed 's/  / /g' | cut -d' ' -f2`"
echo kill $str
kill $str
str="`ps -ef | grep java | grep portal | grep -v grep | sed 's/  / /g' | sed 's/  / /g' | cut -d' ' -f2`"
len=`expr length 1$str`
echo "The process number is $str..."
for (( ; $len>1; ))
do
	echo "Sleeping for 1 second..."
	sleep 1
	str="`ps -ef | grep java | grep portal | grep -v grep | sed 's/  / /g' | sed 's/  / /g' | cut -d' ' -f2`"
	len=`expr length 1$str`
	echo "The process number is $str..."
done
/usr/local/axis2-1.5/bin/axis2server.sh >> /tmp/axis1.log 2>&1 &
tail -f /tmp/axis1.log
