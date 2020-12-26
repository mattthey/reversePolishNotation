For create *.jar file enter<br>
`mvn clean package assembly:single`<br>
В папке target будет *.jar файл
----
Использование:<br>
`java -jar ./target/reversePolishNotation-1.0-SNAPSHOT-jar-with-dependencies.jar`<br>
Входите в меню, теперь можно вводить любое выражение в стиле обратной польской записи. Например:<br>
`1 -1 +`<br>
Чтобы завершить необходимо ввести:<br>
`close()`