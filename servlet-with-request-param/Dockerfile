FROM tomcat:10

RUN rm -rf ./apache-tomcat-10.0.20/webapps/*

COPY ./target/servlet-with-request-param-1.0.0-SNAPSHOT.war ./apache-tomcat-10.0.20/webapps/ROOT.war

CMD ["./apache-tomcat-10.0.20/bin/catalina.sh", "run"]