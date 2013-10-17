#!/bin/bash


read -p "Inserire 'y' per compilare: "  answer
if [ $answer = 'y' ]
then
	printf "compilando Expr...\n";
	java -cp ../antlr-3.5-complete.jar org.antlr.Tool Expr.g
	printf "compilando ExprEvaluator...\n";
	java -cp ../antlr-3.5-complete.jar org.antlr.Tool ExprEvaluator.g 
	printf "compilando EvaluatorEBNF...\n";
	java -cp ../antlr-3.5-complete.jar org.antlr.Tool EvaluatorEBNF.g 
	printf "compilando file ausiliari...\n";
	javac -cp .:../antlr-3.5-complete.jar *.java
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

read -p "Premere INVIO per testare il parser Expr:" c;
echo "$input" | java -cp .:../antlr-3.5-complete.jar ExprTest;

read -p "Premere INVIO per testare il valutatore :" c;
echo "$input" | java -cp .:../antlr-3.5-complete.jar ExprEvaluatorTest ;

read -p "Premere INVIO per testare il valutatore EBNF:" c;
echo "$input" | java -cp .:../antlr-3.5-complete.jar EvaluatorEBNFTest;