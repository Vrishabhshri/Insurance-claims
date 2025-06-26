#!/bin/bash
mkdir -p out
javac -d out -cp ".:sqlite-jdbc-3.50.1.0.jar" src/com/fineos/*.java
java -cp "out:sqlite-jdbc-3.50.1.0.jar" com.fineos.Main