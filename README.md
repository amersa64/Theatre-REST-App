To run the application, follow these instructions:


INSTALLING PACKAGES

$ sudo apt install maven
$ sudo apt install python3-numpy
$ sudo apt install python3-requests
$ sudo apt install python3-simplejson
$ sudo add-apt-repository ppa:webupd8team/java
$ sudo apt update; sudo apt install oracle-java9-installer
Hit <OK>, <YES>
$ sudo apt install oracle-java9-set-default

JUNIT TESTING, GENERATING ,jar AND TEST COVERAGE*

$ mvn clean package
$ mvn test
*The test coverage will be in Target/site/jacoco/index.html

STARTING THE SERVER

$ java -jar --add-modules java.xml.bind target/Thalia-0.0.1=SNAPSHOT.jar server configuration yml


