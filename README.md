# popularRepo - coding challenge

Description
-------------

1. This spring boot application provides APIs to discover popular repositories on GitHub.
2. Spring boot reactive framework is used for this application
3. API with resource path as "/repos/sort/stars" provides a
   list of the most popular repositories, sorted by number of stars.
4. There is an option to view the top N (top 50,100,200) repositories with uri repos/sort/stars/{pageSize}.
5. API with path repos/sort/stars/date/{fromDate} is used to retrive the most popular repositories created from this date
   ( eg : http://localhost:8080/repos/sort/stars/date/2019-01-10T10:42:31Z)
7. We have an option to filter the repostories based on the programming language as well. We can use uri
  /sort/stars/language/{programmingLanguage} for this (eg : /sort/stars/language/JavaScript)



Technologies Used
-----------------

1. Java SE 17

2. Spring boot 3.2.3

3. projectreactor

Improvements
------------
1. Junit tests are missing
2. Scope for Docker file or similar to run the application in a container.
3. Extensive documentation
 

 
 Thank you!
