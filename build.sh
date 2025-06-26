#!/bin/bash
mkdir -p out
javac -d out -cp ".:sqlite-jdbc-3.36.0.3.jar" src/com/fineos/*.java
java -cp "out:sqlite-jdbc-3.36.0.3.jar" com.fineos.Main