FROM fabric8/java-jboss-openjdk8-jdk:1.2.3

RUN mkdir -p C:/Users/Evgeney/IdeaProjects/lesson_2/tests-testng/usr/src/app
WORKDIR C:/Users/Evgeney/IdeaProjects/lesson_2/tests-testng/usr/src/app

COPY . C:/Users/Evgeney/IdeaProjects/lesson_2/tests-testng/usr/src/app
RUN pip install --no-cache-dir -r requirements.txt

EXPOSE 8080

CMD ["java", "GetOtusTest.java"]

