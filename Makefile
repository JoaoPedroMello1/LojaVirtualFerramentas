compile:
	javac -d build -cp .:./lib/mysql-connector-j-9.4.0.jar src/Main.java src/Menu.java src/Pet.java src/Tutor.java src/conector/*.java

run:
	java -cp build:./lib/mysql-connector-j-9.4.0.jar Main

clean:
	rm -rf build/*

.PHONY: compile run clean
