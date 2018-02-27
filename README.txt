Name: Gia Vinh Lam
CIS2430 Assignment 3
November 2016
glam01@mail.uoguelph.ca
Student ID: 0925571

********************
The Program/Problem
********************
We are to design a program which manages a store (list) containing books and electronics. 
We can add items and search for them using filters as given by the menu options.

We are creating this via an arraylist (products), which contains both books and electronics.
We are also implementing hash maps to help with the search algorithm, inheritance to reduce and simplify code, as well
as File I/O in order to save the products list and load it even after closing the program.

****************************************
Assumptions, Constraints, Default Cases
****************************************

The input file has correct format as listed in the assignment pdf (ex. all required fields are there, optional fields 
like price which are missing are defaulted to "N/A", the values are all contained inside the double quotation marks, 
different products seperated by empty line...etc.)
If a required field does end up still being missing for whatever reason, when printed it'll print null instead.

Order of prevalence in the input file is from top to bottom (example, if two products contain same ID, the one that comes
from the top first will be added while the other one will not be added).

Price and year can be stored as Strings (Used Integer.valueOf() for error checking).

Cases do not matter for key words (not case sensitive).

Assumed an argument at command-line which represents text file (ex. data.txt).

Incorrect values in the input file (ex. year = "fdsa" or name = "") will throw an exception, print a message to console, and quit the program.
Others such as in the case of duplicate ID, the second product with an ID that already exists will not be added.

**********************
Possible Improvements
**********************
Code could've been more efficient in some areas (regarding search algorithm).
Some of the code could have also been turned into functions in order to reduce the lines of code.
Constructors (though with mutators and accessors I felt that I didn't need to use constructors (although they help with memory).
Ordered methods/variables by alphabetical order for more organization.

**********
Test Plan
**********
For inputs:
1. Input file with some non-required fields missing (optional fields beocme "N/A")
-> Author: "" <- no input

Program ran successfully.


2. Input file with products which have the same product ID (only the first product will be added with that duplicate ID).
3. Testing with very incorrect inputs 
	- Letters instead of numbers for price and year
	- Entering nothing for an input when it's required
	- Entering incorrect/impossible input for optional field(s) then entering nothing when prompted again
4. Testing regular input to see if it gets printed to the text file correctly at the end of the program.
5. When printing to text file at the end of program, making sure to make optional fields which I defaulted to "N/A" not be printed.
6. Text file with empty line at the end vs. text file with no empty line at end (still recognizes that it's the last product)
7. Tested with wrong input file name for argument

For searching:
1. Searching for key words (one key word vs multiple key words with products stored that contain one of those key words vs. all of them)
2. Testing each filter (productID, year, keywords) by itself (as in only 1/3 of those variables have user input).
3. Testing different combinations of two of them (3C2 -> 3!/2! = 3 different combinations I can test if choosing 2 out of 3)
4. Testing all three of the filters at the same time (user inputs info for all) with different year ranges (ex. 2005, -2005, 2005-, 2005-2009)
5.  Incorrect values for ProductID and years
6. Start year > End year, start year = end year, start year < end year

Most bad inputs are caught from error checking via if statements are try and catch blocks (ex. for FileNotFoundException)

Extreme Cases that would fail:
1. Corrupt input file
2. Messed up format in input file (ex. no '=' for one of the lines, no value ex. type = ) -> ArrayIndexOutOfBoundsException

***********
User Guide
***********

Different keywords are to be seperated via a space.

The names that the user defines for the information are logical.

Having a main in EStoreSearch is fine.

As it is difficult to test every possible case, there may be some issues regarding the search algorithm (however found none).

Also mention non-requiredfields, tooltip stuff, format of inputs..

After compiling and running the program:
You'll be shown 3 choices (add/search/quit) in which you may enter a corresponding number to choose the desired function.

Building:
The two classes (Book and Electronics) should have accessor and mutator methods (to retrieve and store data).
They are both "derived" or "children" classes of a parent class called Product (similar methods that apply to both children classes will go to the Product class)
EStoreSearch class manages one array list which is composed of objects from the Book and Electronic Class.

Integrated the command-line argument in Eclipse via run configuration (putting name of text file 'data.txt' in the arguments section).
Also need HashMap and File I/O for faster searching and to save information on hard drive.