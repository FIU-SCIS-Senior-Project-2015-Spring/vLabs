#!/bin/bash

#
# Makes router VMs visible from the outside by forwarding all traffic through a 
# given port to the specified address.
#
# It accepts three possible actions: 'list', 'add' and 'del'
#
# Usage: ./vmnat.sh <action> [port in host] [router IP] [router port] [n ports]
#

#   router's IP

if [[ $EUID -ne 0 ]]; then
    echo "You must be root!"
    exit 1
fi

IPTABLES="/sbin/iptables"
VMNATS_FILE="/etc/vmnats"
#PORT_MIN=1025
#PORT_MAX=99999

if [[ $# -lt 1 ]]; then
    echo "Usage: $0 action [local port] [ip] [remote port] [n ports]"
    exit 2
else
    ACTION=$1
    if [[ $ACTION == "add" ]] || [[ $ACTION == "del" ]]; then
	if [[ $# -ne 5 ]]; then
	    echo "Wrong number of arguments for '$ACTION'"
	    exit 3
	else

	    PORT=$2
	    
	#    if [[ $PORT -lt $PORT_MIN ]] || [[ $PORT -gt $PORT_MAX ]]; then
	#	echo "Allowed forwarding ports are [$PORT_MIN to $PORT_MAX]"
	#	exit 4
	#    fi

	    IP=$3
	    RPORT=$4
	    NPORTS=$5
	fi
    elif [[ $ACTION != "list" ]]; then
	echo "Action must be either 'add', 'del' or 'list'"
	exit 5
    fi
fi

ENDPORT=$(($PORT+$NPORTS-1))
ENDRPORT=$(($RPORT+$NPORTS-1))
RULE="(${PORT}-${ENDPORT}) -> $IP:(${RPORT}-${ENDRPORT})"

#echo $RULE
#exit 0

list() {
    
    if [[ -s $VMNATS_FILE ]]; then
	cat $VMNATS_FILE
    else
	echo "No existing vm nats"
    fi
}

add() {

    if [[ ! -f $VMNATS_FILE ]]; then
	touch $VMNATS_FILE
    fi

    # make sure the rule doesn't exist
    if [[ `grep -e "^$RULE$" $VMNATS_FILE | wc -l` -eq 1 ]]; then
	echo "Rule $RULE already exists!!"
	exit 6
    fi

    # add iptables rules
    for i in `seq $NPORTS`; do
	P=$(($PORT+$i-1))
	RP=$(($RPORT+$i-1))
	$IPTABLES -t nat -A PREROUTING -p tcp -m tcp --dport $P -j DNAT --to-destination $IP:$RP
    done

    # for peer1, we need to allow incoming traffic too
    $IPTABLES -A INPUT -p tcp -m tcp --dport $PORT:$ENDPORT -j ACCEPT
    #$IPTABLES -A OUTPUT -p tcp -m tcp -d $IP --dport $RPORT:$ENDRPORT -j ACCEPT

    # register the change in the VMNATS file
    echo "$RULE" >> $VMNATS_FILE

}

del() {
    if [[ ! -f $VMNATS_FILE ]]; then
	echo "There are no vm nats"
	exit 0
    fi

    if [[ `grep -e "^$RULE$" $VMNATS_FILE | wc -l` -eq 1 ]]; then

	for i in `seq $NPORTS`; do
	    P=$(($PORT+$i-1))
	    RP=$(($RPORT+$i-1))
	    # drop rule from iptables
	    $IPTABLES -t nat -D PREROUTING -p tcp -m tcp --dport $P -j DNAT --to-destination $IP:$RP
	done
	
	# remove all INPUT rules (needed for peer1)
	$IPTABLES -D INPUT -p tcp -m tcp --dport $PORT:$ENDPORT -j ACCEPT
	#$IPTABLES -D OUTPUT -p tcp -m tcp -d $IP --dport $RPORT:$ENDRPORT -j ACCEPT

        # remove rule from file
	sed -i "/^$RULE$/d" $VMNATS_FILE
    else
	echo "The rule $RULE doesn't exist"
	exit 7
    fi
}

case $ACTION in
    list)
	list
	;;
    add)
	add
	;;
    del)
	del
	;;
esac
