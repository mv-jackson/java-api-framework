# DWP test api framework

This framework interogates a public api and is written in Java.

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