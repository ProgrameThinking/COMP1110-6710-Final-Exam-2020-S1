***Answers to the coding section of COMP1110-6710 Final Exam 2020 S1***

***@author:SakurakojiSaika,chatgpt 3.5***  

***@Version:java 17.0.4.1 junit5***  

***If it's helpful for you, please give me a star.***

# Description

The questions provided here comprise the final exam for COMP1110/6710 in Semester
1 of 2020.   These are provided for you as sample questions.  Notice that some
questions have multiple variations, labelled 'A', 'B', etc...   When you sit a
real exam, you would only get one variation.

_Please note that subsequent exams may have different structures and be different in style._

The text below this line is taken from the Semester 1 2020 exam.

---

Exam period: 3 hours 15 minutes

You should attempt to answer all questions.
Questions total 80 marks. Questions are not of equal value.

You will find six questions in the exam.  The first five questions have coding elements, totalling eight subquestions, and for each of these, you will find a separate Java class with FIXME notes indicating what you need to do.  The number of marks per question varies.
There is one unit test provided for each question which you may use to
test your answer.   If a question is worth five marks, you will find that there are five unit tests.

For coding questions, the specification of each method you are required to implement is provided in the Javadoc comment immediately above the method. You must adhere to that specification.
You may use any part of the [Java standard API](https://docs.oracle.com/en/java/javase/13/docs/api/index.html) in your solutions, but you may not use other non-standard libraries (such as Apache libraries).
All coding questions are auto-graded; you will be graded according to how many tests you pass. The tests used to grade your work may differ slightly from the tests provided in this repository. Incorrect answers that pass tests will be penalized accordingly.

Fork this repo within GitLab and then clone your copy from within IntelliJ.
Once you have forked the exam:
- answer each question by completing the provided answer file(s) according to the instructions you will find in the file README.md;
- test your answer to each programming question using the provided unit tests; and
- after you complete each question, commit and push your work to GitLab.

The last commit that you push to GitLab before the end of the exam will be used for marking. **Any commits pushed after the end time of the exam will be ignored and will not count towards your exam mark.** You may commit and push as many times as you wish during the exam time; only the final on-time commit will be marked.

## Question 1  [15 Marks] 

### Imperative Programming in Java
 
### Q1.1 A  [5 Marks]  Basic Imperative Programming

Using the incomplete template for [Q1Tao.java](src/comp1110/exam/Q1Tao.java), complete the unimplemented method `tao()`. Use the tests provided to test your solution, and then commit and push your changes to GitLab.

### Q1.1 B  [5 Marks]  Basic Imperative Programming

Using the incomplete template for [Q1Factors.java](src/comp1110/exam/Q1Factors.java), complete the unimplemented method `factors()`. Use the tests provided to test your solution, and then commit and push your changes to GitLab.

### Q1.2 A [5 Marks]  Recursion

Using the incomplete template for [Q1Rain.java](src/comp1110/exam/Q1Rain.java), complete the unimplemented method `avg()`. Use the tests provided to test your solution, and then commit and push your changes to GitLab.

### Q1.2 B [5 Marks]  Recursion

Using the incomplete template for [Q1FamilyTree.java](src/comp1110/exam/Q1FamilyTree.java), complete the unimplemented method `getAncestry()`. Use the tests provided to test your solution, and then commit and push your changes to GitLab.


### Q1.3 A [5 Marks]  Abstract Data Types, Search

Using the incomplete template for [Q1CropRotation.java](src/comp1110/exam/Q1CropRotation.java), complete the unimplemented method `getAllRotations()`. Use the tests provided to test your solution, and then commit and push your changes to GitLab.

### Q1.3 B [5 Marks]  Abstract Data Types, Search

Using the incomplete template for [Q1MealPlan.java](src/comp1110/exam/Q1MealPlan.java), complete the unimplemented method `getAllRotations()`. Use the tests provided to test your solution, and then commit and push your changes to GitLab.

### Q1.3 C [5 Marks]  Abstract Data Types, Search

Using the incomplete template for [Q1Sudoku.java](src/comp1110/exam/Q1Sudoku.java), complete the unimplemented method `getAllRotations()`. Use the tests provided to test your solution, and then commit and push your changes to GitLab.

## Q2  [5 Marks]  File I/O

Using the incomplete template for [Q2Awk.java](src/comp1110/exam/Q2Awk.java), complete the unimplemented method `extractColumnCSV()`. Use the tests provided to test your solution, and then commit and push your changes to GitLab.

## Question 3  [25 Marks]  Wiki
 
### Q3.1  [20 Marks]  Software Implementation
 
 Using the incomplete template for [Q3Wiki.java](src/comp1110/exam/Q3Wiki.java), complete *all unimplemented methods*.
 
 You must complete your solution as **a single file, [Q3Wiki.java](src/comp1110/exam/Q3Wiki.java)**. You are encouraged to create additional classes as required to solve the problem; any additional classes must be implemented as **nested classes** within the `Q3Wiki` class.
 
 Use the tests provided to test your solution, and then commit and push your changes to GitLab.
 
### Q3.2  [5 Marks]  Software Testing
 
 Using the incomplete template for [Q3GetMaxArticlesInCategoryTest.java](src/comp1110/exam/Q3GetMaxArticlesInCategoryTest.java), write one or more unit tests for the `getMaxArticlesInCategory()` method. You must complete your solution as a single file, `Q3GetMaxArticlesInCategoryTest.java`. When writing the tests, you may assume that the provided methods in the `Q3Wiki` class are correctly implemented.
 
 The specification of the `getMaxArticlesInCategory()` method is provided in the Javadoc comment immediately above the method. This question is auto-graded; your tests will be run against multiple implementations of the `getMaxArticlesInCategory()` method, some of which are correct and some incorrect. You will be graded according to how many correct implementations successfully pass your tests and how many incorrect implementations fail your tests.
 
 Once you have completed your tests, commit and push your changes to GitLab.
 
## Question 4 A [10 Marks]  Data Structures
 
 Using the incomplete template for [Q4ArrayQueue.java](src/comp1110/exam/Q4ArrayQueue.java), complete the unimplemented methods `isEmpty()`, `enqueue()`, `dequeue()`, `first()`, `contains()`, and `toString()`.
Your solution must implement the data structure from first principles (as was done in lectures), avoiding use of Java's collection classes such as `java.util.List`.
 *Solutions that ignore this requirement will be penalized accordingly.*
 
 Use the tests provided to test your solution, and then commit and push your changes to GitLab.
 
## Question 4 B [10 Marks]  Data Structures
  
  Using the incomplete template for [Q4ArrayStack.java](src/comp1110/exam/Q4ArrayStack.java), complete the unimplemented methods `isEmpty()`, `push()`, and `pop()`, `peek()`, `contains()`, and `toString()`.
 Your solution must implement the data structure from first principles (as was done in lectures), avoiding use of Java's collection classes such as `java.util.Stack`.
  *Solutions that ignore this requirement will be penalized accordingly.*
  
  Use the tests provided to test your solution, and then commit and push your changes to GitLab.
  
 
## Question 5 A  [5 Marks]  Hash Codes
 
 Using the incomplete template for [Q5PackageSpecification.java](src/comp1110/exam/Q5PackageSpecification.java), complete the overridden methods `hashCode()` and `equals()` correctly, according to the contract of these methods. Your hash function should be as uniform as possible. Use the tests provided to test your solution, and then commit and push your changes to GitLab.
 
## Question 5 B [5 Marks]  Hash Codes
  
 Using the incomplete template for [Q5StringHash.java](src/comp1110/exam/Q5StringHash.java), complete the unimplemented method `hash()`, **without using Java's built-in `hashCode()` method**. Your hash function should be as uniform as possible. Use the tests provided to test your solution, and then commit and push your changes to GitLab.
