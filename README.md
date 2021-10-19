Prerequisites:
---------------
*	Java jdk-1.8 or higher
*	Apache Maven 3 or higher
*	Please refer for any help in Maven. 
* 	http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
* 	http://www.tutorialspoint.com/maven/maven_environment_setup.htm

Build and Test:
---------------
*	Clone the repository. >>  git clone https://git.kotakcherry.in/sdet_kotak_digital/kotakcherrytestautomation.git
*	Open command prompt and go to directory.
*	To run on local environment use command >> mvn clean test -DsuiteXmlFile=TestXML/cherryApp_PreLogin.xml -DdevicePlatform=android
*   mvn clean package -DskipTests=true - AWS Config , Disable app,


Supported Platforms
-------------------------
* Android
* IOS
* Web Application