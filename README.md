# Java_apps
##  Summary:
This repository contains 3 application project that is coded in Java language using frameworks and libraries.
1) **Twitter CLI App :**
This is CLI app to post delete search the tweet from Command Line Interface. The application structure is built in Java and using frameworks and libraries like: Spring framework, Jackson and also included Junit tests. The hierarchy of the application is well structured and is demonstrated using diagram. REST API is in use for Tweet posting, deleting retrieving service.

2) **JDBC App :**
This app demonstrates the link between Database and Java application on how to use and connect app to database. This app is the example for the operation of CRUD CREATE READ UPDATE DELETE for the PostgreSQL database. The basics of the app is to execute the SQL statement using JDBC driver, JDBC connection manger. PostgreSQL is used for the database.

3) **Grep App :**
This app is basically for searching required string line into the files and directory recursively using regex and extract the matching text output into a file.
-------
# Java-Twitter CLI app

### Introduction

The Twitter CLI(command line interface) App allows user to post(create), delete and show(find) the tweet as required. It uses the Twitter API as a point of interaction with Twitters storage and so being said that we need Twitter Developer account and its authorized API key and token secrets to start with which you can get from [https://developer.twitter.com](https://developer.twitter.com)

### Usage
Input depends on the usage requirement of the user like post delete show tweet (capital/small/combinations allowed).

**post**
```post  TweetText  Latitude,Longitude```
```post  HelloWorld  28.0,55.0```
posting has some basic limitations: Tweet must have less than 140 characters, latitude between -90 to 90 and longitude between -180 to 180.

**show**
````show  TweetID  field1,field2,.fieldN````
```show  1153151096686354432  id,text,coordinates```
show has fields for the tweet objects, which can be: `id`, `idStr`, `text`, `entities`, `coordinates`, `retweetCount`, `favoriteCount`, `favorited`, `retweeted`, `createdAt`

**delete**
```delete  TweetID1,TweetID2.TweetIDs```
```delete  1153151096686354432```

### Design and structure:

![twitter.jpg](https://github.com/sumitJRVS/Java_apps/blob/master/diagram/twitter.jpg)

The program is split into main 5 major layers-components as show in the diagram above. The runner interface, service layer, DAO layer, HTTP client, Storage layer. Each of the component has its own function. E.g. of user arguments flow in case of post tweet:

```user args `>>` runner interface `>>` service layer `>>` REST DAO layer `>>` HTTP client(Helper function) `>>` storage layer(Twitter.com)```

While tweet posting, ultimately the HTTP client is used to send the REST API commands to Twitter servers.

### Functionality of layer

1) Runner Interface layer:
This is users lingo. Whatever user want they can input and output the requirement and this interface has main method in file `TwitterCLIRunner.java`. The importance of existence of this file is to check the user argument (kind of filtration, sorting ) for formatting and typo, tweet character limitation with 140 character, coordinates with specific numbers. On a successful argument, the posting tweet will  begin to pass into service layer for further implementations.

2) Service layer:
This layer is called Business logic layer, here all the business logics are applied on upstream data /downstream data. Eg: Tweet cant be posted `null`. Posting tweet must have coordinates in order as latitude and then longitude.  The service layer will take the arguments and send them to a Tweet DAO.

3) TwitterRestDAO layer:
Create a URI as per POST SHOW DELETE requirements.
eg. `post` function works by: ```User creates tweet >> tweet in Java object >> TwitterRestDAO >> converts to JSON string using Jackson lib. >> tweet reached HTTP helper function >> HTTPPOST req is initiated.```
``` ```
eg. `show` function works by: ```Twitter server >> tweet in JSON string >> TwitterRestDAO >> convert tweet in Java Obj using DTO >> tweet passes service layer.```

4) HTTP client helper function layer:
This layer is REST API implementation layer. 
To use the service of the server we have API and that API communicates with client. So for this function to get work we need to implement HttpPost, HttpGet etc request to post/fetch data into HttpResponse form. 
     - Client < - - - - - REST API - - - - - > Server

5) Twitter. com storage / server:
We are not dealing with the Twitter storage directly in this app, for that we are using API key to Read/Write the storage as interface getting help from HTTP client.

### Enhancements and Issues:

1) This app for user is in CLI implementation with some basic functionality and methods inside. For the update, the app will be having additional features like search by the coordinates, search by the time of posting, including external library to check the offensive, or company internal words word check into the service layer.
2) Need to add more feature to Tweet just like the coordinates, posting images and 

-------

# Java-JDBC app

### Introduction: 
This app is built to demonstrate the JDBC flow among `PostgreSQL`, `JDBC driver`, `connection manager`, `JDBC API`, `Java-JDBC-app`. The application is designed for specific database given: hplussport.

The app is based on 4 layers: Java application runner(main method), DAO, DTO, storage PostgreSQL layers. DTO (data transfer object) DAO (data access object).

This app is the example for the operation of CRUD, CREATE| READ| UPDATE| DELETE for the PostgreSQL database.

### Usage:

Syntax:
```JDBCExecutor create field1,field2..fieldn```
Create table
```JDBCExecutor create "ID" "First_name" "Last_name"```
Find by ID
```JDBCExecutor `read "ID"` ```
Delete by ID
```JDBCExecutor delete "ID"```

## Design and structure:


![a](https://github.com/sumitJRVS/Java_apps/blob/master/diagram/jdbc.jpg)

As defined in introduction the application is build with following 3 major layers.

### Functionality of layers:

**DAO:**
Single DAO for each type of data field will be established. It has REST API methods that can creates connection manager. It handles create update delete requests as per query definition. The major part of the logic for the app is covered here.

**DTO:**
It will be created base don the field defined in the table. It has the structure of the table and has getter and setter methods also to string method.

**Storage PostgreSQL:**
It is RDBMS and object orientated SQL storage and it is easy to handle when we have a definite structural data.

**Java Application Runner:**
JDBCjavaExe.java has the main method handles user input/output at endpoint. This layer executes the program.

### Enhancements and Issues:

1) Added PostgreSQL command and basic statements: to run with docker, how to execute sql tables into database etc refer to README.md in jdbc_sql/README.md
2) Added Mockito test for the TwitterServiceImp class which is implemented from interface CrudRepo.

-------
# Java-Grep app

### Introduction: 
This app searches recursively for the given string using RegEx pattern into the folders, files to a matched patter and output the string into a file.

### Usage

```USAGE: regex rootPath outFile```  is very similar to Linux command 
``` egrep -r {regex} {rootPath} > {outFile}```

> **regex**- a special text string for describing a search pattern

> **rootPath**- root directory path

> **outFile** - output file name

Example:   ```JavaGrepImp .*data.* home/centos/dev /tmp/grep.out```

### Design and structure:

### Functionality:
- Used Recursive function to search the data inside.
- Used File Reader, Buffer Reader, Buffer Writer classes.

### Enhancements and Issues:

1) Need to create the argument prompt that ask user to input user argument and automatically open the output file for you.
2) 


-------