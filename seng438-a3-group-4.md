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

![DU pair](https://user-images.githubusercontent.com/30624408/222652916-8e2d87a9-8c47-48a6-9e4b-9a08253d0934.jpg)


# 3 A detailed description of the testing strategy for the new unit test

Text…

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

**1) Method: combine(Range range1, Range range2)**    
**Class: Range.java**

Previously, we did not create any test units for the combine() method inside the Range class, with that said, after running EclEmma for the first time, the team got 0,0% coverage for branch, line and method types of coverage.  When analysing the function, it is composed by two main if statements (branches) testing if the inputs are null, followed by the creation of two doubles using another pre determined function min() which were further used to return a new Range object. Concluding, that this method is composed of 7 lines to be tested, 3 possible branches and 1 method, this lead the group to create 3 separate test functions that went through all the possible routes of combine(): combineRange1Null(), combineRange2Null() and combineRight()
	
- combineRange1Null() and combineRange2Null() were very similar since both tested the inputs of combine() being null. With these two functions, 2 possible branches of the function would be used (since together they covered both if statements), consequently covering a total of 4 lines and the method itself. 

- combineRight() envisioned testing the remaining part of the method, since none of the inputs were null, forcing the method to create the following two double variables and generating the Range object to be returned. This portion of the function represented the remaining branch to be test along with the 4 last lines of the method.

As a result, the combine() method achieved 100% line, method and branch coverage, consequently increasing overall coverage of the Range.java class. 

![WhatsApp Image 2023-03-02 at 15 45 13](https://user-images.githubusercontent.com/30624408/222608833-1e0b9b21-8c6c-4848-82bf-4fdc97ae7a5f.jpg)

**2) Method: expandToInclude(Range range, double value)**       
**Class: Range.java**

As the previous method, expandToInclude() was not part of the chosen functions to be tested previously. With that said, EclEmma displayed a 0% coverage for all types: line, method and branch for this method. Since it is composed by the 4 possible if statements (or branches), the function has to have at least 4 test function. Additionally, it is composed of 7 lines of code and the representing 1 method itself. In order to increase the test coverage of this method, the team created 4 test functions: expandToIncludeLessThanLower(), expandToIncludeValueMoreThanUpper(), expandToIncludeEqual() and expandToIncludeRangeNull(). 

- As for the first if statement, expandToIncludeRangeNull() avoid the function from receiving a null Range argument which can lead to further issues. With that this method, passes a null Range object, leading to increase of branch coverage since the if statement represents the first branch, plus the 2 respective lines of code and the method itself. 
- Secondly, expandToIncludeLessThanLower() passes a value argument of -4 which is lower than the lower bound of the exampleRange (which was set to be a Range from -2 to 3). With that, the second if statement (second branch) is now true. Consequently leading to another tested branch and 2 more lines covered by the test file
- Thirdly, expandToIncludeValueMoreThanUpper() is used on the third if statement. In that case, the value argument (set to 4) is greater than the upper bound of the exampleRange (set to be from -2 to 3). With that, this test method covered another branch of the Range class, in addition to another 2 lines of covered code
- Lastly, the expandToIncludeEqual() receives a value argument with a value which is within the range of the Range object. For that reason, the function will not perform any expansion since the value is within the Range. With a value of 2 and the exampleRange set to be a range from -2 to 3, the method will fall under the last branch, represented by the only else statement in the function. With that, the last possible branch of the method was covered in addition to the last line of the method returning the Range object passed by argument: return range;

As a result, this method went from 0% to 100% coverage for the line, branch and method types, increasing the overall coverage of the Range.java class.

![WhatsApp Image 2023-03-02 at 15 44 54](https://user-images.githubusercontent.com/30624408/222609721-138d7433-5344-4695-b16d-ccbd3dcfe137.jpg)

**3) Method: scale(Range base, double factor)**       
**Class: Range.java**

Similarly, this method was also not covered on the second assignment of this course, for this reason the team got 0% coverage after running EclEmma. When calling this method, it has mainly two routes, or branches after checking for the condition of the parameters. In case the factor argument is a negative double, it throws an exception, otherwise it will generate a new range based on inputted arguments. With that said, the method is composed of 2 branches, 5 lines and 1 method itself, leading the group to create 2 methods to test this portion of the Range.java class: scalePositive() and scaleNegative().

- scaleNegative() passes exampleRange (which is a Range object ranging from -2 to 3) and -2 as the factor argument. With that, it falls under the first branch of the method, represented by the if statement. In this route, it triggers the IllegalArgumentException, leading to an error in the system. In summary, this method was able to cover tests of 1 branch and 2 lines of code, and of course the method scale itself. 
- scalePositive() was intended not to fall under the first branch of the method. Because of that, it was tested with the same exampleRange object and 2 as the factor value. This forced the function to go into the second branch of the scale method. Through that route, the function generates a new Range object based on the Range boundaries multiplied by the factor value, in this case 2. In summary, this lead the testing unit to cover the second and final branch, and 2 more lines of code. 

Finally, the team was able to increase the line, branch and method coverage of the scale method to 100%, once again bringing the over Range.java class coverage closer to the wanted percentage.

![WhatsApp Image 2023-03-02 at 17 28 16](https://user-images.githubusercontent.com/30624408/222609895-a79b77fc-2dd9-49e3-9d10-689e5da062f2.jpg)

**4) Method: equal(double[][] a, double[][] b)**       
**Class: DataUtilities.java**


This method was not covered in assignment 2, it is a new method introduced in DataUtilities class. Therefore, a 0% coverage was obtained after running EclEmma. This method checks for equality of 2 arrays, and the way this method is implemented is by checking if the 2 arrays are not equal through more than if branches, if not, then 2 arrays are equal. The method has 4 if branches where one of them will be visited in an execution of this method. 5 test cases were made for this method to allow the test of all branches and routes:

- testEqualWithEqualArrays(): this test case is given 2 equal arrays to execute the method equal() on. This test skips all if branches and enters the for loop without visiting the if branch inside, and reaches the end where the method return true. This cover reaching the end of the method successfully.

- testEqualWithNullArrays(): this test case is given two null arrays to execute the method equal() on. this test covers the first if branch in the code of the method.

- testEqualWithOneNullandNonNull(): this test case is given one null array and one non null array to execute the method equal() on. this test covers the second if branch in the code of the method.

- testEqualWithDifferentLengthArrays(): this test case is given two valid arrays with different lengths or sizes to execute the method equal() on. this test covers the third if branch in the code of the method.

- testEqualWithSameLengthDifferentArrays():this test case is given two valid arrays with same size but different elements to execute the method equal() on. this test covers the fourth if branch in the code of the method, which is inside the for loop.
  
![image](https://user-images.githubusercontent.com/30624408/222861666-634391da-21c6-446b-98be-b0bf617e9361.png)

   
**5) Method: calculateColumnTotal(Values2D data, int column, int[] ValidRows)**       
**Class: DataUtilities.java**

This method was also not covered in assignment 2 and had no test cases for it, therefore a 0% coverage on the three metrics: statement, branch, and method, was obtained. The method calculates the total sum of entries in a column only in the rows specified in the validrows int[]. The branches and routes in the implementation of this method were summarized to 3 cases by examining the code:

-testCalculateColumnTotalWithValidRowsSpecified(): this test case is given an int array containing a list of valid rows in the table. this covers reaching the end of the method successfully, but leaves some branches unvisited and not tested.

-testCalculateColumnTotalWithInValidRows(): this test case is given an int array with invalid rows. this covers the first if branch in the for loop.

-testCalculateColumnTotalWithValidRowsNullValues(): this test case is given an int array with a list of valid rows found in the table, however the entries in some of those rows are null. this covers the inner (second) if branch in the for loop

![image](https://user-images.githubusercontent.com/30624408/222861889-9f22f2fd-e30f-4d7b-82ef-55c867beb12c.png)

# 5 A detailed report of the coverage achieved of each class and method (a screen shot from the code cover results in green and red color would suffice)

**Range Class:**                

![image](https://user-images.githubusercontent.com/90352983/222763959-8d46e59d-770e-40fd-8be7-db104b47d26f.png)
![image](https://user-images.githubusercontent.com/90352983/222764038-3b66463d-2ca3-4358-b408-36af149a9f75.png)
![image](https://user-images.githubusercontent.com/90352983/222764347-5dec76df-2981-4c7d-b954-fed165af32f5.png)
![image](https://user-images.githubusercontent.com/90352983/222764445-1aaaab62-41a8-451a-af79-2997f288f60c.png)
![image](https://user-images.githubusercontent.com/90352983/222764506-e3e684db-1b37-42b9-9dd4-117be7b21c48.png)
![image](https://user-images.githubusercontent.com/90352983/222764556-1083f695-757a-4309-8458-dcac1456b72e.png)
![image](https://user-images.githubusercontent.com/90352983/222764639-bdaa1184-abe6-4036-b5ad-b05dca97dda3.png)
![image](https://user-images.githubusercontent.com/90352983/222764707-7a73b872-6dbc-4d60-a5b9-194af78e6a4e.png)
![image](https://user-images.githubusercontent.com/90352983/222764774-5732b278-68b6-4307-b9c6-36a383221194.png)
![image](https://user-images.githubusercontent.com/90352983/222764850-ea5ff7a6-0f00-4f0d-82f0-51d651093d34.png)
![image](https://user-images.githubusercontent.com/90352983/222764935-00f32286-2219-4e2d-9da6-a67e253b88c4.png)
![image](https://user-images.githubusercontent.com/90352983/222764996-0e3ec7ec-82d4-48a9-bfe5-24d7eb830381.png)
![image](https://user-images.githubusercontent.com/90352983/222765074-4554024c-06a9-441a-b7d2-1e33edc90dae.png)
![image](https://user-images.githubusercontent.com/90352983/222765145-552423e8-351d-4918-90e9-78bbb655d319.png)
![image](https://user-images.githubusercontent.com/90352983/222765249-c6708d98-4ee9-4c9a-b647-ee73c3ce3b55.png)

**DataUtilities Class**

<img width="627" alt="Screen Shot 2023-03-03 at 12 56 53 PM" src="https://user-images.githubusercontent.com/66806345/222815652-ad76d5f3-197d-4c21-97b1-c93154dfe485.png">
<img width="627" alt="Screen Shot 2023-03-03 at 12 57 13 PM" src="https://user-images.githubusercontent.com/66806345/222815692-92a509e5-433a-4f2b-8721-968bffcbe50d.png">
<img width="627" alt="Screen Shot 2023-03-03 at 12 57 22 PM" src="https://user-images.githubusercontent.com/66806345/222815738-b58c47df-a7e4-405b-9bd6-2a6b82cad185.png">

<img width="627" alt="Screen Shot 2023-03-03 at 12 57 51 PM" src="https://user-images.githubusercontent.com/66806345/222815755-3ec7ab79-4ce6-4944-a15b-28e66680fa84.png">

<img width="627" alt="Screen Shot 2023-03-03 at 12 58 10 PM" src="https://user-images.githubusercontent.com/66806345/222815769-97cad5a5-6491-4dfe-a87c-0d1c3df70642.png">

<img width="627" alt="Screen Shot 2023-03-03 at 12 58 25 PM" src="https://user-images.githubusercontent.com/66806345/222815786-0353b4c0-9ee4-496d-bbb5-8e34a3579f42.png">

<img width="627" alt="Screen Shot 2023-03-03 at 12 58 39 PM" src="https://user-images.githubusercontent.com/66806345/222815901-29d06188-25e3-437b-a533-d4c1e625c5a1.png">


# 6 Pros and Cons of coverage tools used and Metrics you report

The group used EclEmma as a coverage tool to assess the code coverage of the Java files. EclEmma is a built-in tool in Eclipse IDE, which made the installation process straightforward and fast. During the testing process, we identified both pros and cons of using the software. One disadvantage is that it can be difficult to switch between coverage metrics, which may require some familiarity with the tool. However, once we found the menu to change it, we were able to easily switch between different metrics. Another major disadvantage is that EclEmma does not support statement and condition coverages, which were recommended in the lab proposal. However, we were able to use other types of coverage metrics to replace them, since it was authorize on the lab instructions. On the positive side, we found that EclEmma is very user-friendly, providing clear visual cues to highlight the covered and uncovered code. For example, uncovered code is highlighted in red, while covered code is highlighted in green. Additionally, EclEmma indicates the percentage of code coverage, which allowed us to easily monitor our progress. Overall, we recommend using EclEmma as a coverage tool due to its user-friendly interface and effectiveness in measuring code coverage. Although there are some limitations, we were able to work around them and achieve our testing objectives.

# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.

Requirements-based test generation and coverage-based test generation are two popular approaches for generating test cases. On one hand, requirements-based test generation ensures complete test coverage by analyzing the requirements and tracing the generated test cases back to the requirements, allowing for early detection of defects and better validation of the system. However, it can be costly and time-consuming, and lastly, its scopee may be limited. On the other hand, coverage-based test generation is a cost-effective and efficient approach that covers all aspects of the system, but it may not provide complete test coverage, comprehensive validation of the system against the requirements, or easy traceability of the test cases back to the requirements. Ultimately, the choice between these two approaches will depend on the specific requirements and constraints of the project at hand.

In summary:
Requirement-based approach
PROS
- complete test coverage
- early defect detection
CONS
- High cost
- Time consuming

Coverage-based approach
PROS
- Cost effective
- Efficient for a specific set fo criterias
CONS
- Incomplete test coverage
- Limited validations

# 8 A discussion on how the team work/effort was divided and managed

The team divided the work equally among all members. Similar to the previous assignment, Rayyan and Ammar were resposible for the deliverables related to the DataUtilities class while Eduardo and David worked on the Range class. After finishing every deliverable, the team shared their work amongst each other and the main highlights of their parts. With that, the team was able to spot possible mistakes and ways to improve our results and analysis. Just like the previous assignment, the teamwork was very important to ensure we had the best develirable possible. Having more people review our work, was certainly very helpful to get suggestions, correct possible errors, come up with different solutions and overall produce a better lab experience. Additionally, the team consistantly communicated on our group chat to ensure everyone was at the same page, reducing the possibility of not very all develirables ready by the deadline.


# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the lab

Besides being able to effectively work on the lab exercise throughly, the group had some issues on the way, mostly related to the setup of the program. This can be cause by dependencies of the project, libraries used, version of the coverage applications and many more. One example was that the group was initially not able to run the test files as the hamcrest external library was corrupted, it took us a lot of time and effort to notice that, after we did we had to get the one from assignment 2. Another difficulty we faced was trying to use different tools (CodeCover, Clover), it was giving us errors related to compatability (not the code) so we had to work with Eclemma and do Branch, Line, Method coverages. Lessons learned was to work in pairs to ensure more than one person would look for possible mistakes, fix bugs and write tests to increase coverage.

# 10 Comments/feedback on the lab itself

Overall this lab experience was very effective to give students hands-on software testing experience. It was really interesting to see the many ways testing a software can be something very effective. After completing assignment 2, the team believed that the methods had a very good converage, being able to spot all possible errors that the system could trigger. Nevertheless, after briefly testing the JUnits files with EclEmma, we were able to see that there were lots of room for improvements. Using these software coverage application is also very helpful since they provide almost real time feedback on how the coverage rate changes. In summary, it was a very interesting lab were we were able to get a glance of how is the testing process in the professional environment. However, the setup for this assignment has some room for improvements, possibly saving some time for students to focus on developing their testing skills rather than debugging a series of dependencies and library issues.   
