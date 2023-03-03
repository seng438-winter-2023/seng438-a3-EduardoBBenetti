**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report #3 – Code Coverage, Adequacy Criteria and Test Case Correlation**

| Group \#:      |  4    |
| -------------- | --- |
| Student Names: | Ammar Elzeftawy    |
|                | David San Kim      |
|                | Eduardo Benetti    |
|                | Rayyan Khalil      |

(Note that some labs require individual reports while others require one report
for each group. Please see each lab document for details.)

# 1 Introduction

Text…

# 2 Manual data-flow coverage calculations for X and Y methods

Text…

# 3 A detailed description of the testing strategy for the new unit test

Text…

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

**Method: combine()
Class: Range.java**	
	Previously, we did not create any test units for the combine() method inside the Range class, with that said, after running EclEmma for the first time, the team got 0,0% coverage for branch, line and method types of coverage.  When analysing the function, it is composed by two main if statements (branches) testing if the inputs are null, followed by the creation of two doubles using another pre determined function min() which were further used to return a new Range object. Concluding, that this method is composed of 7 lines to be tested, 3 possible branches and 1 method, this lead the group to create 3 separate test functions that went through all the possible routes of combine(): combineRange1Null(), combineRange2Null() and combineRight()
	
•combineRange1Null() and combineRange2Null() were very similar since both tested the inputs of combine() being null. With these two functions, 2 possible branches of the function would be used (since together they covered both if statements), consequently covering a total of 4 lines and the method itself. 

•combineRight() envisioned testing the remaining part of the method, since none of the inputs were null, forcing the method to create the following two double variables and generating the Range object to be returned. This portion of the function represented the remaining branch to be test along with the 4 last lines of the method.

As a result, the combine() method achieved 100% line, method and branch coverage, consequently increasing overall coverage of the Range.java class. 

![WhatsApp Image 2023-03-02 at 15 45 13](https://user-images.githubusercontent.com/30624408/222608833-1e0b9b21-8c6c-4848-82bf-4fdc97ae7a5f.jpg)



# 5 A detailed report of the coverage achieved of each class and method (a screen shot from the code cover results in green and red color would suffice)

Text…

# 6 Pros and Cons of coverage tools used and Metrics you report

Text…

# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.

Text…

# 8 A discussion on how the team work/effort was divided and managed

Text…

# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the lab

Text…

# 10 Comments/feedback on the lab itself

Text…
