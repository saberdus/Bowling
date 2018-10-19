# Bowling Application

# Introduction
A java application that manages a bowling game. Two to six players (bowlers) can sign up for a game.
They take turn for a frame and throw one or two balls (or three in last frame).
The application informs which bowler is to take turn and asks for the number of pins knocked down in one
throw by user input. After each throw the score will be shown in form of a simple text output by the application.

# Game Rules
1- The number of bowlers is limited by minimum 2 and maximum 6.
2- The game is played in 10 turns. The turn of one bowler is called FRAME. There are 10 pins present in every frame.
3- A bowler rolls the ball one or two times in a frame (there is an exception: the last frame can consist of a third roll).

# Game description
A bowler A rolls the first ball and knocks down same pins by maximum 10 pins in each frame. If all 10 pins are knocked down,
then this roll is called a STRIKE. In this case the frame is completed for the mentioned bowler A and bowler B takes turn.
If one or more pins remain then bowler A rolls the ball a second time for the remaining pins. Are all remaining pins knocked 
down then this second roll is called A SPARE.  
The score of a bowler is determined by the number of pins knocked down in each frame. In case of a Spare in a frame, the result 
of the next roll is added to the result of the current Spare frame. That means result of current frame is equal 10 + result of next roll.
In case of a Strike, both the result of the next two rolls is added to the current Strike frame (Strike frame result = 10 + next roll + after next roll).
Summary: in case of a Spare or a Strike the score can't be calculated until the bowler rolls for one or two times the ball.

The last frame is a special frame in the bowling game: if a bowler rolls a Strike or a spare then he will get the bonus 
to roll for a third time. 

# UML diagram
Please take a look on the attached class diagram.    
     

  


