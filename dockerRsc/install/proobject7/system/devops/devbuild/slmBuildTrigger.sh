#!/bin/bash

DEVOPS_HOME=${PROOBJECT_HOME}/system/devops
export DEVOPS_HOME

CLASSPATH=${CLASSPATH}:$DEVOPS_HOME/jenkins/devclient/proobject-devclient-7.0.0.0.jar
CLASSPATH=${CLASSPATH}:$DEVOPS_HOME/binary/proobject-devserver-7.0.0.0.jar
CLASSPATH=${CLASSPATH}:$DEVOPS_HOME/binary/proobject-devserver-dto-7.0.0.0.jar
CLASSPATH=${CLASSPATH}:$DEVOPS_HOME/jenkins/script/3rdPartyLib/proobject-srcgen-7.0.0.0-jar-with-dependencies.jar
CLASSPATH=${CLASSPATH}:$DEVOPS_HOME/jenkins/script/3rdPartyLib/proobject-client-7.0.0.0-jar-with-dependencies.jar

java -classpath ${CLASSPATH} com.tmax.proobject.devclient.build.SlmBuildDeployCall "192.168.15.103" "8888" $1 $2 $3 $4 $5 $6

