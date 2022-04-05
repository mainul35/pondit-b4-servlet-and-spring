FROM ubuntu:20.04

ENV PATH=$PATH:/opt/java/jdk-18/bin

RUN apt-get update
RUN apt-get install -y curl
RUN mkdir /opt/java
RUN curl https://download.oracle.com/java/18/latest/jdk-18_linux-x64_bin.tar.gz --output 'jdk-18_linux-x64_bin.tar.gz'
RUN tar -zxvf jdk-18_linux-x64_bin.tar.gz
RUN rm jdk-18_linux-x64_bin.tar.gz
RUN mv jdk-18 /opt/java/jdk-18
RUN apt-get purge -y curl
RUN apt-get autoremove -y
RUN apt-get clean
