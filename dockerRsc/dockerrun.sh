docker run -idt --name test -e SERVER_IP=192.168.15.128 -e DBMS_IP=192.168.15.103 -e DBMS_PORT=8629 -e DBMS_NAME=tibero -e DBMS_USER=tibero -e DBMS_PASSWORD=tmax -e PASSMASTER_IP=10.98.0.18 -e PASSMASTER_PORT=9736 -p 8080:8080 -p 9736:9736 -p 4444:4445 -p 6776:6777 -p 50021:21 -p 20:20 -p 50090-50099:50090-50099  po_devops