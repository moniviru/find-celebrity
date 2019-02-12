# Find the Celebrity - Project

This project was created to implement the algorithm "Find the celebrity".

## Installing and Deployment

* You can clone the project or download the sources as a ZIP.
* Open the command console.
* Locate the root of the project in the command console.
* Execute (Windows): 
```
mvnw package
```
* After that, get into target folder
```
cd target
```
* Find the generated .jar file
```
dir *.jar
```
* Execute the jar file, example: 
```
java -jar find-celebrity-0.0.1-SNAPSHOT.jar
```
* In the browser, open the URL http://localhost:8080/search/celebrity

## How to use the application?

* First you need to create a file in Text/Plain format.
```
input.txt
```
* You must enter in the file the names of a group of people. Example:
```
Annie
Bob
Marc 
Kathy
```
* Upload the file and then click in the "Find the celebrity" button.
* A page with the name and id of the celebrity and also the matrix of responses will be displayed.
* If you want to upload another group of people and find the celebrity, you can click on the "Try Again" button.
* Supposed and rules: (You can also see them on the home page) 
```
Supposed

- There is always a celebrity in the group of people.

Rules

- Not allowed empty files.
- File lines with more than 15 characters or empty will be omitted.
```

## Built With

* Spring Boot
* Bootstrap

## Author

* [moniviru](https://github.com/moniviru)
