FROM 192.168.15.110:5000/local_jeus8:b162106

ENV PROOBJECT_HOME=/home/tmax/proobject7
COPY domain.xml /home/tmax/jeus8/domains/domain1/config/domain.xml
COPY tibero6-jdbc.jar /home/tmax/jeus8/lib/datasource/tibero6-jdbc.jar
COPY proobject7 /home/tmax/proobject7
COPY install /home/tmax/install
COPY po7_env.sh /home/tmax/script/po7_env.sh
COPY start.sh /home/tmax/script/start.sh


USER root
RUN chown -R tmax:tmax /home/tmax/install
RUN chown -R tmax:tmax /home/tmax/proobject7
RUN chmod -R 755 /home/tmax/script
RUN chmod -R 755 /home/tmax/proobject7
RUN echo 'tmax:tmax' | chpasswd

ENV TINI_VERSION v0.18.0
ADD https://github.com/krallin/tini/releases/download/${TINI_VERSION}/tini /sbin/tini
RUN chmod +x /sbin/tini
RUN apt-get update
RUN apt-get -y install vim net-tools vsftpd



ENTRYPOINT ["/sbin/tini", "--"]
CMD ["/home/tmax/script/start.sh"]
