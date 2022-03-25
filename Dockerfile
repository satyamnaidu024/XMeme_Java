FROM gradle:jdk11
ARG DEBIAN_FRONTEND=noninteractive
RUN apt-get update && apt-get -y upgrade
RUN apt-get -y install git redis-server wget

RUN apt-get install -y gnupg
RUN wget -qO - https://www.mongodb.org/static/pgp/server-5.0.asc | apt-key add -
RUN wget -qO - https://www.mongodb.org/static/pgp/server-5.0.asc | apt-key add -
RUN echo "deb [ arch=amd64,arm64 ] https://repo.mongodb.org/apt/ubuntu bionic/mongodb-org/5.0 multiverse" | tee /etc/apt/sources.list.d/mongodb-org-5.0.list

RUN apt-get update
RUN apt-get install -y mongodb-org
USER root

RUN mkdir code
COPY . /code
RUN cd /code && chmod +x gradlew && ./gradlew bootJar && chmod +x start.sh && chmod +x sample-data/load-sample-data.sh

CMD /code/start.sh

