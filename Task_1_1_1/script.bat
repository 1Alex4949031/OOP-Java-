javadoc -d .\make\ -sourcepath .\src\main\java -subpackages ru.nsu.a.seleznev

javac -d .\make\bin\ -sourcepath .\src\main\java .\src\main\java\ru\nsu\a\seleznev\HeapSort.java

mkdir .\make\jar
jar cf .\make\jar\HeapSort.jar -C .\make\bin .