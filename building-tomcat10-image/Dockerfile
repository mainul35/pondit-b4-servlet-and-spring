FROM jdk:18

RUN apt-get update
RUN apt-get upgrade -y
RUN apt-get install -y curl
RUN curl https://dlcdn.apache.org/tomcat/tomcat-10/v10.0.18/bin/apache-tomcat-10.0.18.tar.gz --output 'tomcat-10.0.18.tar.gz'
RUN tar -zxvf tomcat-10.0.18.tar.gz
RUN rm tomcat-10.0.18.tar.gz
RUN mkdir /opt/tomcat
RUN mv apache-tomcat-10.0.18/ /opt/tomcat/
RUN apt-get purge -y curl
RUN apt-get autoremove -y
RUN apt-get clean

WORKDIR /opt/tomcat/apache-tomcat-10.0.18/bin/

EXPOSE 8080:8080

CMD ["catalina.sh", "run"]

