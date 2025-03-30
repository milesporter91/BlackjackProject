# Blackjack Project

## Overview
This is a Blackjack app that allows the user to play a simplified version of Blackjack against the dealer. Betting, Splitting, and Soft Aces are not a part of this version of the game.



## Run the Program
1. Running the program will deal a hand to both player and dealer
2. If any starting hand wins, the program will announce it and deal a new hand
3. Player chooses to hit or stay
4. Once player chooses to stay, Dealer will take its turn, hitting if its hand has a value of less than 17
5. The program will determine who has the highest hand without going over 21, and print the hands and winner
6. The program will continue dealing new hands until the deck has fewer than 10 cards remaining
7. Once the deck reaches fewer than 10 cards remaining, the program will prompt the user to either shuffle and keep playing, or exit the program

- *While in real Blackjack, double Aces would equal 12, in this verion they equal to 22, creating a feaux bust for whomever draws two aces on the starting hand*
## Technologies / Concepts Used
- Java 
- Enums 
- Encapsulation
- Polymorphism
- Abstract methods
- Inheritance

 [UML Map](https://github.com/milesporter91/BlackjackProject/blob/main/Blackjack%20Project%20UML.pdf)
---

## Lessons Learned
1. *Figuring out how to print player/dealer hands without accessing their cards from outside their encapsulation took a bit of trial and error; Ultimately I ended up chaining methods from the player class down to the card class to retrieve the rank and suits of the hands, and using those chained methods to print the toString for the Card objects.*

2. *I ran into an issue with the loop closing if either starting hand had a winning condition; This was a result of my checkDeckSize method being inside of an else statement that was never being reached if the starting hand ended the game; I fixed this by un-nesting the checkDeckSize method from the else statement so that it would check the deck size after the end of each hand*

3. *I learned alot about maintaining encapsulation through chained method calls to access private fields without using getters and setters.*

4. *Designing the UML for the program was very insightful in the planning process, helping understand the distribution of classes and methods depending on what variables the program needs*
