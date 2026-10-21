# Theatrical Players Refactoring Kata
## https://github.com/emilybache/Theatrical-Players-Refactoring-Kata/tree/main

## Noah Pipes
## nmppkb@missouri.edu
## 10/20/2026


### Running the Automated Tests
I used Java JDK 21 to run this project. You can download it from the official Oracle website or use any other JDK distribution that supports Java 21.

Use the command `./gradlew build` to run the automated tests. This will execute all the test cases and provide a summary of the results.


### Three Areas for Improvement and Refactoring (Parts 1 and 2)
The only areas I see improvement are in the StatementPrinter.java file. The Play.java and Performance.java just describe the data structure for the program. The StatementPrinter.java file is where the logic is and where the refactoring should be done. I initially made some edits to Play.java but regretted it later because the testing framework uses it directly, so I backtracked.

1. I am not a huge fan of the switch statement in the StatementPrinter.java file. I think it would be better to use polymorphism to handle the different play types. This would make the code more extensible and easier to maintain.
    + (a). I created a new abstract class called PerformanceCalculator. This class has two subclasses, TragedyCalculator and ComedyCalculator. Each subclass implements the amount() and volumeCredits() methods differently based on the play type. This allows for easy extension in the future if new play types are added.
    + (b) This improved the design of the code by removing the switch statement and using polymorphism instead. This makes the code more extensible and easier to maintain.
    + (c) I verified the behavior was preserved by running the `./gradlew build` command, which builds and tests the Gradle project.

2. My next change is much smaller, but it is to make it easier to understand. Currently, the code uses var to declare variables. I think it would be better to use explicit types for the variables. This would make the code easier to read and understand. This may be more of a personal preference, but it is something that bothered me. Now, variable types are more clear.
    + (a) I changed the var prefix on several lines in StatementPrinter.java to explicit variable types, like int, String, Play, and PerformanceCalculator.
    + (b) The change improves the design because it is easier to read what is being returned from different functions, something that was confusing me. It was not always clear what a variable held.
    + (c) I verified the behavior was preserved by running the `./gradlew build` command, which builds and tests the Gradle project. 

3.  Something discussed in Fowler's Refactoring book is the usage of the variable name "result." He likes using this name because it makes it clear from the get-go that this variable is the result of the function. I chose to adopt his standard after reading up on the chapter in the book. I think it is a good idea to use this standard because it makes the code easier to read and understand.
    + (a) I changed the variable name from "amount" to "result" in ComedyCalculator.java and TragedyCalculator.java. This makes it clear that this variable is the result of the function.
    + (b) The change improves the design because it is easier to read what is being returned from different functions. You do not have to scan the function as much to find all the points the result is being modified.
    + (c) I verified the behavior was preserved by running the `./gradlew build` command, which builds and tests the Gradle project.

### Improve Automated Tests (Part 3)
I am required to add two new automated tests.
1. My first new test tests the total amount of money for if there is a number of people smaller than 30 attending a tragedy play. I would expect it to return $400.00, which it does. I had to create an accepted text file in the `\test\java\theatricalplays` folder. `smallTragedyPlay()`
2. My second new test tests the total amount of money for if there is a number of people right at 31 attending a tragedy play. This tests the boundary of the conditional. I would expect it to return $410.00, which it does. We also expect an extra credit of 1. I had to create an accepted text file in the `\test\java\theatricalplays` folder. `exactTragedyPlay`



### Takeaways or Things I Learned
I learned how to use some basic Markdown formatting. I had never really used it formally before. I was also new to using Gradle, but I am impressed with its capabilities.

### AI Usage
AI was used to help me get the Java versions lined up with Gradle. I had never used Gradle before. Claude Code was used.

Claude Code was also used to guide me through the issue of polymorphism in OOP Java. AI helped with filling out the repetitive parts of the README.
