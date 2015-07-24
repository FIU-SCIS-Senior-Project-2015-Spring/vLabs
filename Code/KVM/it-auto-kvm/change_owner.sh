#!/bin/bash

if [[ $EUID -ne 0 ]]; then
    echo "You must be root!"
    exit 1
fi

if [[ $# -lt 1 ]]; then
    echo "Usage: $0 [restore_file]"
    exit 2
else
    RESTOREFILE=$1
    echo $RESTOREFILE 

fi
chown portal $RESTOREFILE

exit 0
