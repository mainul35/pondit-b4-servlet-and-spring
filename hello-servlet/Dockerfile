FROM mainul35/tomcat:10

RUN rm -rf /usr/local/tomcat/webapps/*

EXPOSE 8080:8080

COPY ./target/hello-servlet-1.0.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

CMD ["/opt/tomcat/apache-tomcat-10.0.18/bin/catalina.sh", "run"]