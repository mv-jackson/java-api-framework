# DWP test api framework

This framework interogates a public api and is written in Java.

1. Clone the repository 
2. The test are executed from the restassured package - cd java/restassured/ for the project
3. Run ```mvn compile``` to build the project
4. To run the tests ```mvn test```   
4. Ensure that the Maven runner is set To Java 11 in your IDE. For IntelliJ go to
>IntelliJ> Preferences> Build,Execution,Deployment > BuildTools > Maven > Runner

<img width="1000" alt="Screenshot 2021-05-15 at 10 59 38" src="https://user-images.githubusercontent.com/32160236/118356714-85c14d00-b56e-11eb-88bd-c98c6c29dba4.png">

5. Ensure the correct SDK is set for Java (File > Project Structure)

<img width="1025" alt="Screenshot 2021-05-15 at 11 27 42" src="https://user-images.githubusercontent.com/32160236/118357200-cae67e80-b570-11eb-9e63-ebcde9beff31.png">



Coding standards
The code has been developed according to the folowing recommendations > 
https://gds-way.cloudapps.digital/manuals/programming-languages/java.html#java-style-guide
and implements the GDS Editor Config standards > https://gds-way.cloudapps.digital/manuals/programming-languages/editorconfig

Requires Java 11 and Maven.  To run simply clone the repo down and run ```mvn test```




Project Setup
pom.xml - contains all set and dependencies 
ApiTest.java - test class containing scenarios below


Test 1 returns the number of users

Test 2 returns the number of users who live in London

Test 3 looks for users within 50 miles radius of London and output the result to console/text file.



