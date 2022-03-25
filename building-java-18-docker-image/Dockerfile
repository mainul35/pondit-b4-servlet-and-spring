FROM ubuntu:20.04

ENV PATH=$PATH:/opt/java/jdk-18/bin

RUN  apt-get update \
	&& apt-get upgrade \
	&& apt-get install -y curl \
	&& mkdir /opt/java \
	&& curl https://download.oracle.com/java/18/latest/jdk-18_linux-x64_bin.tar.gz --output 'jdk-18_linux-x64_bin.tar.gz' \
	&& tar -zxvf jdk-18_linux-x64_bin.tar.gz \
	&& rm jdk-18_linux-x64_bin.tar.gz \
	&& mv jdk-18 /opt/java/jdk-18 \
	&& apt-get purge -y curl \
    	&& apt-get autoremove -y \
    	&& apt-get clean
