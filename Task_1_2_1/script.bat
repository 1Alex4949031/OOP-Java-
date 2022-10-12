javadoc -d .\make\ -sourcepath .\src\main\java -subpackages ru.nsu.a.seleznev

javac -d .\make\bin\ -sourcepath .\src\main\java .\src\main\java\ru\nsu\a\seleznev\Stack.java

mkdir .\make\jar
jar cf .\make\jar\Stack.jar -C .\make\bin .

java -classpath .\make\jar\Stack.jar ru.nsu.a.seleznev.Stack