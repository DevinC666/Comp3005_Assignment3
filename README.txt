Name: Shuo Chen
Student ID: 101222045
Video link:

Project files：
	sql/schema.txt
	src/main/java/org/example/Main.java
   	.gitgnore
	pom.xml
	README.txt

1. Open the Main.java in the intellij
	- you can find the Main.java under src/main/java/org/example


2.create the database in pgAdmin
	 -open pgAdmin
	 -create a new database called studentsdb
	 -open schema under sql folder
	 -copy and paste the code into the query tool 


3.Run the program
	- In intellij click run button
	- select the function you would like to test
	- switch to pgAdmin and check the table output



4.How to check the table:
	-open pgAdmin4 
 	-on the left side open studentsdb
 	-open schemas
 	-left click public
 	-left click tables 
 	-right click students and choose view data and select all rows
 	-Copy and paste follow statement into the query and press F5 to see the table  

		SELECT student_id, first_name, last_name, email, enrollment_date
		FROM students
		ORDER BY student_id;
