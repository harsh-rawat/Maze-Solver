# Maze-Solver
In this project, we use A* and BFS algorithm to find the path from start to end position in a two-dimensional maze.

# Input

	$ java FindPath maze search-method

The first argument, maze, is the path to a text file containing the input maze as described below.

The second argument, search-method, can be either “bfs” or “astar” indicating whether the search method to be used is breadth-first search (BFS) or A* search, respectively.

# The Maze

A maze will be given in a text file as a matrix in which the start position is indicated by “S”, the goal position is indicated by “G”, walls are indicated by “%”, and empty positions where the robot can move are indicated by “ “. The outer border of the maze, i.e., the entire first row, last row, first column and last column will always contain “%” characters. 

A robot is allowed to move only horizontally or vertically, not diagonally.

# Output

After a solution is found, we print out on separate lines:
	
	1. The maze with a “.” in each square that is part of the solution path

	2. The length of the solution path
	
	3. The number of nodes expanded (i.e., the number of nodes removed from Frontier, including the goal node)

	4. The maximum depth searched

	5. The maximum size of Frontier at any point during the search.
	
	If the goal position is not reachable from the start position, the standard output should contain the line “No Solution” and nothing else.
