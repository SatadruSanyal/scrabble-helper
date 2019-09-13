---This Project is intended to be developed into a full working app---
---Care has been taken to use good encapsulation practices, any advice for improvement welcome---

The Project intends to develop a scrabble helper.
	Current features include searching for a word in the scrabble dictionary,
	finding the best (highest scoring without added tile bonuses) and longest words with given tiles.

	Future features could potentially include allowing the user to consider tile bonuses (these will need to be input)
	
Note: The entire project is in testing phase, the code in the engine is designed to show the user that these features work.
This can easily be extended into a program that asks users which feature they would like to use, but that has been left for when the app is made.


---LAYOUT AND STRUCTURE---
The project uses a Tree Based ADT in Java to store the dictionary in a space efficient way

AlphaNode Class: Alphabet Nodes, each with 26 AlphaNode children (for the 26 characters) all initialised as null.
		Each AlphaNode can be marked as a word by setting its 'word' boolean to true.

Dictionary Class: from a Head AlphaNode, stores words in the dictionary by setting an AlphaNode's word boolean to true.
		The Dictionary contains generic add and find functions as with any Tree Based ADT
		The Dictionary also contains custom functions to return all possible words given user tiles, 
			and following from that functions to return the best and longest words.

Engine Class: Currently being used as main and for testing purposes only. 

Utils Class: To Contain general utility functions such as reading in files, creating the entire dictionary,
	creating a hashmap to store letter points, calculating the score of a word etc.

letter_points.txt - each line contains a letter and its value in scrabble, separated by a space. This is used to create the hashmap that stores letter scores.
scrabble_words.txt - the 2015 Collins Scrabble Dictionary (with headline removed)

---FOR ANY QUESTIONS/COMMENTS/SUGGESTIONS PLEASE EMAIL SS13718@IC.AC.UK---
