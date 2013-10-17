#!/bin/bash


read -p "Inserire 'y' per compilare: "  answer
if [ $answer = 'y' ]
then
	printf "compilando il lexer...\n";
	javac lexer/*.java;
	printf "compilando il parser...\n";
	javac parser/*.java;
	printf "compilando il valutatore...\n";
	javac evaluator/*.java;
fi;

printf "File di input default :\n";
cat input.txt
printf "\n";
read -p "Per usare l input qua sopra premere y, altrimenti inserire un'espressione terminata da $: "  answer
if [ $answer = 'y' ]
then 
	input=$(cat input.txt);
else
	input=$answer;
fi;

read -p "Premere INVIO per testare il lexer:" c;
echo "$input" | java lexer.LexerTest;

read -p "Premere INVIO per testare il parser:" c;
echo "$input" | java parser.ParserTest;

read -p "Premere INVIO per testare il valutatore:" c;
echo "$input" | java evaluator.EvaluatorTest;