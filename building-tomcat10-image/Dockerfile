FROM mainul35/openjdk:18

RUN 	apt-get update \
        && apt-get upgrade \
        && apt-get install -y curl \
	    && curl https://dlcdn.apache.org/tomcat/tomcat-10/v10.0.18/bin/apache-tomcat-10.0.18.tar.gz --output 'tomcat-10.0.18.tar.gz' \
    	&& tar -zxvf tomcat-10.0.18.tar.gz \
    	&& rm tomcat-10.0.18.tar.gz \
	    && mkdir /opt/tomcat \
    	&& mv apache-tomcat-10.0.18/ /opt/tomcat/ \
    	&& apt-get purge -y curl \
    	&& apt-get autoremove -y \
    	&& apt-get clean \
#        && cd /opt/tomcat/apache-tomcat-10.0.18/bin/
EXPOSE 8080:8080
CMD ["/opt/tomcat/apache-tomcat-10.0.18/bin/catalina.sh", "run"]

