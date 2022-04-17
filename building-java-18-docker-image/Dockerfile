FROM ubuntu:20.04

ENV PATH=$PATH:./jdk-18/bin

RUN apt-get update
RUN apt-get install -y curl
RUN curl https://download.oracle.com/java/18/latest/jdk-18_linux-x64_bin.tar.gz --output 'jdk-18_linux-x64_bin.tar.gz'
RUN tar -zxvf jdk-18_linux-x64_bin.tar.gz
RUN rm jdk-18_linux-x64_bin.tar.gz
RUN apt-get purge -y curl
RUN apt-get autoremove -y
RUN apt-get clean
