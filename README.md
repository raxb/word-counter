# word-counter
Write a library called "WordCounter".  It should have the following two distinct methods:
1.	method that allows you to add words
2.	method that returns the count of how many times a given word was added to the word counter

It should also have the following requirements:
1.	should NOT allow addition of words with non-alphabetic characters
2.	should treat same words written in different languages as the same word, for example if
	adding "flower", "flor" (Spanish word for flower) and "blume" (German word for flower) the counting method should return 3.  You may assume that translation of words will be done via external class provided to you called "Translator" that will have method "translate" accepting word as an argument and it will return English name for it.

Please consider the following:
1.	adopt a TDD manner if possible.
2.	consider the software design principles you are using.  What are they, if any?
3.	are there any design patterns appropriate for all/part of this task? 
4.	think of the most optimal algorithm for storing and counting words.  Be prepared to describe your approach.
5.	do not use persistence or in-memory DB, but consider the memory utilization of your solution.
6.	don’t make any assumptions about the execution context for the “WordCounter” library.

As a further enhancement, please create a microservice to expose the “Word Counter” functionality to external clients.  Consider how clients will access the service.  Where would you host the service?   How would you ensure resiliency of the service?  

Technology stack:
1.	Java 8, JUnit and Mockito to solve the task. 
2.	Gradle or maven as dependency management tool. 
3.	Use your favourite open source libraries including assertion libraries.
4.	Use you favourite IDE
