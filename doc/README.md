If the test files are not compiled, navigate to ECM2414_CA folder in terminal and run following commands:
javac -classpath lib/junit-4.13.2.jar:src src/TestCard.java
javac -classpath lib/junit-4.13.2.jar:src src/TestCardDeck.java
javac -classpath lib/junit-4.13.2.jar:src src/TestCardGame.java
javac -classpath lib/junit-4.13.2.jar:src src/TestPlayer.java
javac -classpath lib/junit-4.13.2.jar:src src/TestBasicWrite.java

To run all tests at once (if in ECM2414_CA folder):
java -classpath lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:bin:.:src org.junit.runner.JUnitCore TestBasicWrite TestCard TestCardDeck TestCardGame TestPlayer
