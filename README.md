# robot-treasure-hunt-game
simple robot treasure hunt game on imaginary game board

Rules:
- Game consist of 10 turns
- It is a single player game.
- At the beginning of the game the size of the board is determined by the player, board size
cannot be less than 5 cells in width and height.
- After the size is set, two tree objects, a house object, a treasure object, a robot object and a
player object is placed randomly on the board
- In each turn the application informs the player about its position and asks which x and y position
it wants to move

  If it hits the robot after a move,the player loses the game
  If it hits a tree or the house, player cannot move and game skips to the next turn after moving the robot
  If it hits the treasure, the player wins the game
  After player moves,the robot moves to alocation randomly, if the robot hits the treasure, the player loses the game. Robot     isn’t effected by tree and house objects

- After each turn the application informs the player if it is getting closer or far to the treasure.
------------------------------
Imaginary Board

![alt text](https://github.com/yspolat/robot-treasure-hunt-game/blob/master/imaginary_board_v2.png?raw=true)

------------------------------
Class Diagram

![alt text](https://github.com/yspolat/robot-treasure-hunt-game/blob/master/class_diagram.png?raw=true)



------------------------------
Example Game

Please enter the board size:
5

Turn:1

You are in position x:2 y:2

Please enter position x for player:
3

Please enter position y for player:
4

You are getting closer to the treasure

Turn:2

You are in position x:3 y:4

Please enter position x for player:
2

Please enter position y for player:
4

You are getting far to the treasure

Turn:3

You are in position x:2 y:4

Please enter position x for player:
5

Please enter position y for player:
2

You cannot go three, there is a House

Robot found the treasure!

You lost the game




Have fun!

<b>Reference: Altuğ Tanaltay/Sabanci University</b>
