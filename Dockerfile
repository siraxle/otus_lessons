FROM java:1.8.0_221

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY . /usr/src/app

CMD ["java", "otus.java"]