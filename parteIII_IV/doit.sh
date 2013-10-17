#!/bin/bash


read -p "Inserire 'y' per compilare: "  answer
if [ $answer = 'y' ]
then
	printf "compilando math.g...\n";
	java -cp ../antlr-3.5-complete.jar org.antlr.Tool math.g;
	printf "compilando file ausiliari...\n";
	javac -cp .:../antlr-3.5-complete.jar *.java
fi;

printf "File di input default :\n";
cat input.math | less
printf "\n";
read -p "Per usare l input qua sopra premere y, altrimenti inserire un'espressione terminata da $: "  answer
if [ $answer = 'y' ]
then 
	input=$(cat input.math);
else
	input=$answer;
fi;

read -p "Premere INVIO per creare il file jasmin fileJ.j:" c;

echo "$input" | java -cp .:../antlr-3.5-complete.jar MathTest > fileJ.j;
cat fileJ.j | less ;

read -p "Premere INVIO per creare il file .class :" c;
java -jar jasmin.jar fileJ.j;

read -p "Premere INVIO per eseguire il file .class:" c;
java Output;