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
This lab session and report follows a in depth analysis of the coverage techniques and testing performed on the Range and Data Utilities class presented on the last lab assignment. In summary, the lab aims to use the tests created on the last session to enhance their converage, ensuring all possible branches of the methods are securily tested. With that, the group should be able to perform further analysis of the classes and overall test coverage methodologies. 

# 2 Manual data-flow coverage calculations for X and Y methods

Text…

# 3 A detailed description of the testing strategy for the new unit test

Text…

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

**Method: combine(Range range1, Range range2)**    
**Class: Range.java**

Previously, we did not create any test units for the combine() method inside the Range class, with that said, after running EclEmma for the first time, the team got 0,0% coverage for branch, line and method types of coverage.  When analysing the function, it is composed by two main if statements (branches) testing if the inputs are null, followed by the creation of two doubles using another pre determined function min() which were further used to return a new Range object. Concluding, that this method is composed of 7 lines to be tested, 3 possible branches and 1 method, this lead the group to create 3 separate test functions that went through all the possible routes of combine(): combineRange1Null(), combineRange2Null() and combineRight()
	
- combineRange1Null() and combineRange2Null() were very similar since both tested the inputs of combine() being null. With these two functions, 2 possible branches of the function would be used (since together they covered both if statements), consequently covering a total of 4 lines and the method itself. 

- combineRight() envisioned testing the remaining part of the method, since none of the inputs were null, forcing the method to create the following two double variables and generating the Range object to be returned. This portion of the function represented the remaining branch to be test along with the 4 last lines of the method.

As a result, the combine() method achieved 100% line, method and branch coverage, consequently increasing overall coverage of the Range.java class. 

![WhatsApp Image 2023-03-02 at 15 45 13](https://user-images.githubusercontent.com/30624408/222608833-1e0b9b21-8c6c-4848-82bf-4fdc97ae7a5f.jpg)

**Method: expandToInclude(Range range, double value)**       
**Class: Range.java**

As the previous method, expandToInclude() was not part of the chosen functions to be tested previously. With that said, EclEmma displayed a 0% coverage for all types: line, method and branch for this method. Since it is composed by the 4 possible if statements (or branches), the function has to have at least 4 test function. Additionally, it is composed of 7 lines of code and the representing 1 method itself. In order to increase the test coverage of this method, the team created 4 test functions: expandToIncludeLessThanLower(), expandToIncludeValueMoreThanUpper(), expandToIncludeEqual() and expandToIncludeRangeNull(). 

- As for the first if statement, expandToIncludeRangeNull() avoid the function from receiving a null Range argument which can lead to further issues. With that this method, passes a null Range object, leading to increase of branch coverage since the if statement represents the first branch, plus the 2 respective lines of code and the method itself. 
- Secondly, expandToIncludeLessThanLower() passes a value argument of -4 which is lower than the lower bound of the exampleRange (which was set to be a Range from -2 to 3). With that, the second if statement (second branch) is now true. Consequently leading to another tested branch and 2 more lines covered by the test file
- Thirdly, expandToIncludeValueMoreThanUpper() is used on the third if statement. In that case, the value argument (set to 4) is greater than the upper bound of the exampleRange (set to be from -2 to 3). With that, this test method covered another branch of the Range class, in addition to another 2 lines of covered code
- Lastly, the expandToIncludeEqual() receives a value argument with a value which is within the range of the Range object. For that reason, the function will not perform any expansion since the value is within the Range. With a value of 2 and the exampleRange set to be a range from -2 to 3, the method will fall under the last branch, represented by the only else statement in the function. With that, the last possible branch of the method was covered in addition to the last line of the method returning the Range object passed by argument: return range;

As a result, this method went from 0% to 100% coverage for the line, branch and method types, increasing the overall coverage of the Range.java class.

![WhatsApp Image 2023-03-02 at 15 44 54](https://user-images.githubusercontent.com/30624408/222609721-138d7433-5344-4695-b16d-ccbd3dcfe137.jpg)

**Method: scale(Range base, double factor)**       
**Class: Range.java**

Similarly, this method was also not covered on the second assignment of this course, for this reason the team got 0% coverage after running EclEmma. When calling this method, it has mainly two routes, or branches after checking for the condition of the parameters. In case the factor argument is a negative double, it throws an exception, otherwise it will generate a new range based on inputted arguments. With that said, the method is composed of 2 branches, 5 lines and 1 method itself, leading the group to create 2 methods to test this portion of the Range.java class: scalePositive() and scaleNegative().

- scaleNegative() passes exampleRange (which is a Range object ranging from -2 to 3) and -2 as the factor argument. With that, it falls under the first branch of the method, represented by the if statement. In this route, it triggers the IllegalArgumentException, leading to an error in the system. In summary, this method was able to cover tests of 1 branch and 2 lines of code, and of course the method scale itself. 
- scalePositive() was intended not to fall under the first branch of the method. Because of that, it was tested with the same exampleRange object and 2 as the factor value. This forced the function to go into the second branch of the scale method. Through that route, the function generates a new Range object based on the Range boundaries multiplied by the factor value, in this case 2. In summary, this lead the testing unit to cover the second and final branch, and 2 more lines of code. 

Finally, the team was able to increase the line, branch and method coverage of the scale method to 100%, once again bringing the over Range.java class coverage closer to the wanted percentage.

![WhatsApp Image 2023-03-02 at 17 28 16](https://user-images.githubusercontent.com/30624408/222609895-a79b77fc-2dd9-49e3-9d10-689e5da062f2.jpg)


--------------------------------------
**Method: scale(Range base, double factor)**       
**Class: DataUtilities.java**
    
  
   
**Method: scale(Range base, double factor)**       
**Class: DataUtilities.java**



# 5 A detailed report of the coverage achieved of each class and method (a screen shot from the code cover results in green and red color would suffice)

Text…

# 6 Pros and Cons of coverage tools used and Metrics you report

The group used EclEmma as a coverage tool to assess the code coverage of the Java files. EclEmma is a built-in tool in Eclipse IDE, which made the installation process straightforward and fast. During the testing process, we identified both pros and cons of using the software. One disadvantage is that it can be difficult to switch between coverage metrics, which may require some familiarity with the tool. However, once we found the menu to change it, we were able to easily switch between different metrics. Another major disadvantage is that EclEmma does not support statement and condition coverages, which were recommended in the lab proposal. However, we were able to use other types of coverage metrics to replace them, since it was authorize on the lab instructions. On the positive side, we found that EclEmma is very user-friendly, providing clear visual cues to highlight the covered and uncovered code. For example, uncovered code is highlighted in red, while covered code is highlighted in green. Additionally, EclEmma indicates the percentage of code coverage, which allowed us to easily monitor our progress. Overall, we recommend using EclEmma as a coverage tool due to its user-friendly interface and effectiveness in measuring code coverage. Although there are some limitations, we were able to work around them and achieve our testing objectives.

# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.

Text…

# 8 A discussion on how the team work/effort was divided and managed

Text…

# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the lab

Text…

# 10 Comments/feedback on the lab itself

Text…
