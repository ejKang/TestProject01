#!/bin/bash

export PATH="$JEUS_HOME/bin:$JEUS_HOME/lib:$PATH"

cp -R -p /home/tmax/install/proobject7/* $PROOBJECT_HOME

# domain.xml DBMS_IP set    
if [ -z $DBMS_IP ]; then
   DBMS_IP=127.0.0.1
fi
   sed -i "s/%DBMS_IP%/${DBMS_IP}/g" ${DOMAIN_HOME}/config/domain.xml

# domain.xml DBMS_PORT set    
if [ -z $DBMS_PORT ]; then
   DBMS_PORT=8629
fi
   sed -i "s/%DBMS_PORT%/${DBMS_PORT}/g" ${DOMAIN_HOME}/config/domain.xml

# domain.xml DBMS_NAME set       
if [ -z $DBMS_NAME ]; then
   DBMS_NAME=tibero6
fi
   sed -i "s/%DBMS_NAME%/${DBMS_NAME}/g" ${DOMAIN_HOME}/config/domain.xml

# domain.xml DBMS_USER set      
if [ -z $DBMS_USER ]; then
   DBMS_USER=scott
fi
   sed -i "s/%DBMS_USER%/${DBMS_USER}/g" ${DOMAIN_HOME}/config/domain.xml

# domain.xml DBMS_PASSWORD set 
if [ -z $DBMS_PASSWORD ]; then
   DBMS_PASSWORD=tiger
fi
   sed -i "s/%DBMS_PASSWORD%/${DBMS_PASSWORD}/g" ${DOMAIN_HOME}/config/domain.xml


#### SysMaster7 for WAS Agent Env. ###
#export VM_OPTION="-agentpath:/home/tmax/jmagent/libJeusManager_NativeAgent.so"

#if [ -z $AGENT_ID ]; then
#    AGENT_ID=`hostname`
#fi
#sed -i "s/%AGENT_ID%/${AGENT_ID}/g" /home/tmax/jmagent/properties/jm.properties

#if [ -z $MASTER_IP ]; then
#    MASTER_IP=127.0.0.1
#fi
#sed -i "s/%MASTER_IP%/${MASTER_IP}/g" /home/tmax/jmagent/properties/jm.properties

#if [ -z $RDB_LOADER_IP ]; then
#    RDB_LOADER_IP=127.0.0.1
#fi
#sed -i "s/%RDB_LOADER_IP%/${RDB_LOADER_IP}/g" /home/tmax/jmagent/properties/jm.properties   
   
# proobject.xml  FILE_PORT set
if [ -z $FILE_PORT ]; then
   FILE_PORT=4445
fi
   sed -i "s/%FILE_PORT%/${FILE_PORT}/g" ${PROOBJECT_HOME}/config/proobject.xml

# proobject.xml PROOBJECT_PORT set   
if [ -z $PROOBJECT_PORT ]; then
   PROOBJECT_PORT=6777
fi
   sed -i "s/%PROOBJECT_PORT%/${PROOBJECT_PORT}/g" ${PROOBJECT_HOME}/config/proobject.xml
 
# proobject.xml SERVERNAME set 
if [ -z $SERVERNAME ]; then
    SERVERNAME=`hostname`
fi
   sed -i "s/%SERVERNAME%/${SERVERNAME}/g" ${PROOBJECT_HOME}/config/proobject.xml

# proobject.xml SERVER_IP set    
if [ -z $SERVER_IP ]; then
   SERVER_IP = ${PUBLICIP} 
fi
   sed -i "s/%SERVER_IP%/${SERVER_IP}/g" ${PROOBJECT_HOME}/config/proobject.xml
 
# proobject.xml BASE_PORT set  
if [ -z $BASE_PORT ]; then
   BASE_PORT=9736
fi
   sed -i "s/%BASE_PORT%/${BASE_PORT}/g" ${PROOBJECT_HOME}/config/proobject.xml

# dbio_config.xml DBMS_IP set    
if [ -z $DBMS_IP ]; then
   DBMS_IP=127.0.0.1
fi
   sed -i "s/%DBMS_IP%/${DBMS_IP}/g" ${PROOBJECT_HOME}/system/config/dbio_config.xml

# dbio_config.xml DBMS_PORT set    
if [ -z $DBMS_PORT ]; then
   DBMS_PORT=8629
fi
   sed -i "s/%DBMS_PORT%/${DBMS_PORT}/g" ${PROOBJECT_HOME}/system/config/dbio_config.xml

# dbio_config.xml DBMS_NAME set       
if [ -z $DBMS_NAME ]; then
   DBMS_NAME=tibero6
fi
   sed -i "s/%DBMS_NAME%/${DBMS_NAME}/g" ${PROOBJECT_HOME}/system/config/dbio_config.xml

# dbio_config.xml DBMS_USER set      
if [ -z $DBMS_USER ]; then
   DBMS_USER=scott
fi
   sed -i "s/%DBMS_USER%/${DBMS_USER}/g" ${PROOBJECT_HOME}/system/config/dbio_config.xml

# dbio_config.xml DBMS_PASSWORD set 
if [ -z $DBMS_PASSWORD ]; then
   DBMS_PASSWORD=tiger
fi
   sed -i "s/%DBMS_PASSWORD%/${DBMS_PASSWORD}/g" ${PROOBJECT_HOME}/system/config/dbio_config.xml

# PoOpsSvr.xml DBMS_USER set   
if [ -z $DBMS_USER ]; then
   DBMS_USER=scott
fi
   sed -i "s/%DBMS_USER%/${DBMS_USER}/g" ${PROOBJECT_HOME}/system/config/PoOpsSvr.xml

# PoOpsSvr.xml DBMS_PASSWORD set  			
if [ -z $DBMS_PASSWORD ]; then
   DBMS_PASSWORD=tiger
fi
   sed -i "s/%DBMS_PASSWORD%/${DBMS_PASSWORD}/g" ${PROOBJECT_HOME}/system/config/PoOpsSvr.xml
   
# PoOpsSvr.xml PROOBJECT_HOME set  			
if [ -z $PROOBJECT_HOME ]; then
   PROOBJECT_HOME=/home/tmax/proobject7
fi
   sed -i s%PROOBJECT_HOME%"${PROOBJECT_HOME}"%g ${PROOBJECT_HOME}/system/config/PoOpsSvr.xml

# PoDevSvr.xml PROOBJECT_HOME set
if [ -z $PROOBJECT_HOME ]; then
   PROOBJECT_HOME=/home/tmax/proobject7
fi
   sed -i s%PROOBJECT_HOME%"${PROOBJECT_HOME}"%g ${PROOBJECT_HOME}/system/config/PoDevSvr.xml

# PoDevSvr.xml DBMS_USER set
if [ -z $DBMS_USER ]; then
   DBMS_USER=scott
fi
   sed -i "s/%DBMS_USER%/${DBMS_USER}/g" ${PROOBJECT_HOME}/system/config/PoDevSvr.xml

# PoDevSvr.xml DBMS_PASSWORD set
if [ -z $DBMS_PASSWORD ]; then
   DBMS_PASSWORD=tiger
fi
   sed -i "s/%DBMS_PASSWORD%/${DBMS_PASSWORD}/g" ${PROOBJECT_HOME}/system/config/PoDevSvr.xml



# topic.xml PASSMASTER_IP set    
if [ -z $PASSMASTER_IP ]; then
   PASSMASTER_IP=127.0.0.1
fi
   sed -i "s/%PASSMASTER_IP%/${PASSMASTER_IP}/g" ${PROOBJECT_HOME}/system/config/topic.xml

# setting.js PASSMASTER_PORT set    
if [ -z $PASSMASTER_PORT ]; then
   PASSMASTER_PORT=8080
fi
   sed -i "s/%PASSMASTER_PORT%/${PASSMASTER_PORT}/g" ${PROOBJECT_HOME}/system/config/topic.xml




# vsftpd.conf FTP Set
echo "pasv_enable=YES" >> /etc/vsftpd.conf
echo "pasv_min_port=50090" >> /etc/vsftpd.conf
echo "pasv_max_port=50099" >> /etc/vsftpd.conf
sed -i 's/#write_enable=YES/write_enable=YES/' /etc/vsftpd.conf


 
