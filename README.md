# word-count
Java CLI application to count the occurrence of each word in a text file. It outputs the result in descending order of count.

##### Sample Content of File
```
This is a test file with dummy content just to test the word count
logic. It is intended to be used in the unit tests for the program.
```

##### Sample Output
```
the: 3
test: 2
is: 2
to :2
a: 1
be: 1
in: 1
count: 1
for: 1
it: 1
... so on..
```


##### Requirements
1. JDK 1.8
2. Maven

##### Steps to Run
1. **mvn clean install** (on the root directory)
2. **cd target/**
3. **java -jar word-count-1.0-SNAPSHOT.jar {path/to/your/file}**