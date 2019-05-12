# LOL DATA ANALYZER
--------------

## Usage

 ``` shell
   hadoop lol.jar /input path 
 ```
 
## Function

* Champion Win Rate: Calculate every champion's win rate from all game data, print in console.
* Kill/Death/Assist: Calculate every champion's KDA from all game data, print in console.
* Map Control: Calculate camp gold gain and ward time of both teams from all game data, print in .txt file.
* Player's Position: The route image of all players, needs to input game ID manully, print in position-?.png.

## Abstract

* League of Legends, as one of the most popular multiplayer online battle arena video game, attracts millions of thousands of players all over the world. The objective in this game is to defeat opponent's base, in order to do so, players have to level up the champion they played and upgrade their items all the time during the game. As a multiplayer online game, LOL is definitely very successful in not only game area but also some other related business part.
* In this project, I decided to divide the analyzing into four components, In the first part, I analyzed all the champions’ gaming results to calculate the winning percentage. From this result, I can initially determine whether players had a bad draft. In the second part, I analyzed all the champions’ kills, deaths and assists (KDA) in order to determine whether the champions are balanced, meanwhile the statistics can also help to detect whether players have some botting or feeding behaviors. In the third part, I attempted to analyze which team can get advantages more efficiently from the battle map by the statistics of their golds and experience gain from camp, as well as the ward which can provide a sight on that particular part of battle in a period of time. In the last part, I attempted to analyze champions’ positions to detect players’ behaviors during a game by pointing out champions’ positions and linking them in graph for all ten players in different colors. The generated graphic results may help to identify whether players have some botting or feeding behaviors.
