# Theatrical Players Refactoring Kata
## https://github.com/emilybache/Theatrical-Players-Refactoring-Kata/tree/main

## Noah Pipes
## nmppkb@missouri.edu
## 10/20/2026
#### Description: A refactoring of the Theatrical-Players-Refactoring-Kata that led to better readability and maintainability through the usage of polymorphism for different types of plays and their cost/amount calculators.

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

4. I noticed that the StatementPrinter.java file was using the NumberFormat class to format the currency. It technically did this twice in the program, and the code looked messy because it was unclear why there was a division by 100.
    + (a) I extracted the formatting operation to a protected static function in the class to simplify the main print() function in StatementPrinter.java. The extracted is called usd() because it converts the integer representing the cents to a formatted string in USD (United States Dollars).
    + (b) The change improves the design because a fellow programmer reading the code can better understand the purpose of `usd(thisAmount)` than `frmt.format(thisAmount / 100)`
    + (c) I verified the behavior was preserved by running the `./gradlew build` command, which builds and tests the Gradle project.

### Improve Automated Tests (Part 3)
I am required to add two new automated tests.
1. My first new test tests the total amount of money for if there is a number of people smaller than 30 attending a tragedy play. I would expect it to return $400.00, which it does. I had to create an accepted text file in the `\test\java\theatricalplays` folder. `smallTragedyPlay()`
2. My second new test tests the total amount of money for if there is a number of people right at 31 attending a tragedy play. This tests the boundary of the conditional. I would expect it to return $410.00, which it does. We also expect an extra credit of 1. I had to create an accepted text file in the `\test\java\theatricalplays` folder. `exactTragedyPlay`

### Extend the Application (Part 4)
I was able to efficiently add the historical plays by creating another class like the others and calling it `HistoricalCalculator`.

My two new tests test the boundary of the conditional with audience sizes of 20 and 21. For 20, amount is $500 and volume credits are 4. For 21, amount is $515 and volume credits are still 4.

### Final Test Results (printout for Part 5)

```
./gradlew build

> Task :test

StatementPrinterTests > exactTragedyPlay() PASSED

StatementPrinterTests > size20HistoricalPlay() PASSED

StatementPrinterTests > exampleStatement() PASSED

StatementPrinterTests > statementWithNewPlayTypes() PASSED

StatementPrinterTests > size21HistoricalPlay() PASSED

StatementPrinterTests > smallTragedyPlay() PASSED

BUILD SUCCESSFUL in 1s
```

### Reflection (Part 5)
+ The biggest refactoring that most improved the design was the usage of polymorphism to delineate between different kinds of plays. The refactoring targeted the switch statement that existed in the StatementPrinter.java's print() function. This switch statement would have become grossly large and cumbersome had even more types of plays been added. By splitting off plays by their type, it is easier to fine-tune the calculations of their different costs. A future developer can now easily add more types of plays, like pastoral or cynical without any fear of breaking the statement printer. In fact, if you think about the goal of the statement printer, its main purpose is to print out a statement (duh), not calculate the total cost. It uses the total cost, but it should be able to enlist the help of other functions to find the value it needs for its report. In Fowler's book, this separation of tasks makes a future requirement much easier. In the first chapter, he chooses to update the requirements and begin generating HTML reports of the statement. The original printer can only plain text, so Fowler creates an HTML "printer." Because the calculation portion has been removed to an external handling function, this addition of the HTML report generator is quite seamless. Fowler defines good code as code that can be easily understood and changed to meet new requirements.
+ My new design with polymorphism helped me add historical plays quickly. Historical plays were added by creating their own HistoricalCalculator, which is returned from the static factory method PerformanceCalculator. I did not have to edit a switch statement in the StatementPrinter's switch statement, rather I edited a switch statement in the PerformanceCalculator to help it to decide which type of calculator it should return.
+ A maintainability issue that was resolved was the issue of being able to add new types of plays. Previously, the process was painful and required lengthening the switch block in the StatementPrint.java's print() function. Now, the individual play types can be maintained as separate files. They could even be placed in their own folder to clean up the directory (an example of extracting a package/module/folder).


### Takeaways or Things I Learned
I learned how to use some basic Markdown formatting. I had never really used it formally before. I was also new to using Gradle, but I am impressed with its capabilities.

### AI Usage
AI was used to help me get the Java versions lined up with Gradle. I had never used Gradle before. Claude Code was used.

Claude Code was also used to guide me through the issue of polymorphism in OOP Java. AI helped with filling out the repetitive parts of the README.
