#!/bin/sh

export SM_ENV=false
export PORTE_ENV=false

. /home/tmax/script/env.sh
. /home/tmax/script/po7_env.sh

service vsftpd start

## standalone start script
# startCloudServer -u username -p password -server servername (jeusb-b210)
#${JEUS_HOME}/bin/startCloudServer -u $JEUS_USER -p $PASSWORD -domain domain1 -server ${SERVERNAME} ${SCF_GROUP_ID} ${ADD_START_OPT}

# jeus8-b166xxx
${JEUS_HOME}/bin/startStandaloneServer -u $JEUS_USER -p $PASSWORD -domain domain1 -server ${SERVERNAME} ${SCF_GROUP_ID} ${ADD_START_OPT}
