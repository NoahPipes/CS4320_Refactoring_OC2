# Theatrical Players Refactoring Kata

## Noah Pipes
## nmppkb@missouri.edu
## 10/20/2026

### Running the Automated Tests
I used Java JDK 21 to run this project. You can download it from the official Oracle website or use any other JDK distribution that supports Java 21.

Use the command `./gradlew test` to run the automated tests. This will execute all the test cases and provide a summary of the results.


### Three Areas for Improvement
The only areas I see improvement are in the StatementPrinter.java file. The Play.java and Performance.java just describe the data structure for the program. The StatementPrinter.java file is where the logic is and where the refactoring should be done.

1. I am not a huge fan of the switch statement in the StatementPrinter.java file. I think it would be better to use polymorphism to handle the different play types. This would make the code more extensible and easier to maintain.

2. 



### AI Usage
AI was used to help me get the Java versions lined up with Gradle. I had never used Gradle before. Claude Code was used.

Claude Code was also used to guide me through the issue of polymorphism in OOP Java.
