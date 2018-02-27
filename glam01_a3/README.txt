Name: Gia Vinh Lam
CIS2430 Assignment 3
November 2016
glam01@mail.uoguelph.ca
Student ID: 0925571

***********
User Guide
***********
When running the program, provide an input file as an argument (data.txt, included in the main folder).
Begin by choosing a command as described by the Welcome Screen.

When adding products, the required fields are the name, product ID, and year. The other fields may remain empty.
The productID is composed of 6 digits and the year and price must be logical (cannot contain letters for example).
For further information, mousing over the text areas will give you extra help.

Pressing 'add' in the adding products page will submit the information you have written down and attempt to store the product.
Any issues will be printed to the output box below.

When searching, any of the fields given can be empty. There are some restrictions though (productID must be 6 digits, start year cannot be bigger than end year, years must be between 1000 and 9999 inclusive). If you would like to specify more than one keyword, simply seperate keywords with a space.

Pressing 'search' in the searching products page will submit the information you have written down and attempt to search for and return the corresponding products. Any issues will be printed to the output box below.

The reset buttons in both classes will reset the input text areas.

In order to save your list of products, choose 'Quit' from the Commands menu.

Building:
GUI programmed through Java Swing. There are three classes, Add, Search, and MainMenu which represent the three different pages you can go on during program execution. Each implements ActionListener and have a variety of different elements (JLabel, JTextField, JComboBox...etc.) in order to fulfill the features as requested by the Assignment Outline.

The three classes, Book, Electronics, and Product, all have accessor and mutator methods to retrieve and store data.
They also have constructors for creating objects and exception handling. The two classes, Book and Electronics, are
"derived" or "children" classes of the parent class Product (similar methods and members that apply to both children classes will go to the Product class).

ArrayLists were used to store information and HashMaps were used to search for information easily.
File I/O necessary to save information on the hard drive (used in beginning and end of the program).

********************
The Program/Problem
********************
We are to design a program which manages a store (list) containing books and electronics. 
This program has a GUI, making it easy for the user to add items and search for them through
the various search filters offered.

Main Aspects for Creation:
The GUI for this program has been implemented using Java Swing. ArrayLists and HashMaps were used in order to store information as well as search for them. Inheritance was also used in order to reduce and simplify code (parent class, Product, has two children classes: Book and Electronics). File I/O was used in order to save the products list and load it even after closing the program.

****************************************
Assumptions, Constraints, Default Cases
****************************************
Did not utilize the horizontal scroll bar on my JTextArea as I wrap the text instead and I feel like it's a better design this way.

The input file has correct format as listed in the assignment pdf (ex. all required fields are there, optional fields 
like price which are missing are defaulted to "N/A", the values are all contained inside the double quotation marks, 
different products seperated by empty line...etc.)

Order of prevalence in the input file is from top to bottom (example, if two products contain same ID, the one that comes
from the top first will be added while the other one will not be added).

Price and year can be stored as Strings (Used Integer.valueOf() for error checking).

Cases do not matter for key words (not case sensitive).

Assumed an argument at command-line which represents the text file (in this case, data.txt is my input file as included).

Other incorrect values in the input file (ex. year = "fdsa" or name = "") will throw an exception, print a message to console, and quit the program.

**********************
Possible Improvements
**********************
Code could've been more efficient in some areas.
Some of the code could have also been turned into functions in order to reduce the lines of code.
Could've implemented certain things I used statics for differently.

**********
Test Plan
**********
For input file
--------------------------------------------------------------
1. Input file where required fields have nothing entered.
Example line in input file:
name: = ""
Program will print to console 'Error with input file formatting. Please fix and try again.' and then exit.

2. Input file where fields have values that don't make sense.
Ex. year = "fdsa"
Program will print to console 'Error with input file formatting. Please fix and try again.' and then exit.

3. Input file with products which have the same product ID.
Example text in input file:
type = "book"
productID = "000025"
name = "Absolute Java"
year = "2015"
publisher = "Pearson"

type = "electronics"
productID = "000025"
name = "fdsa"
year = "2013"
maker = "Apple Inc."

Program will print to console saying 'Electronic xname from input file will not be added to the list.' and will not add that product to the list. Program will continue as normal. after.

4. Invalid 'type' name.
Example text in input file:
type = "book"
fdsafdsafsa = "000025"
name = "Absolute Java"
year = "2015"
publisher = "Pearson"

Program will print to console with an error message and the program will exit.

In Add GUI
--------------------------------------------------------------
1. Testing with very incorrect inputs
Firstly: Program will only output the error message for the first error encountered.

	- Letters instead of numbers for price and year
	Ex. Year: '81dsa' where text inside single quotation marks is input for the text area
	Program prints "Year must consist of digits only. Product not added." to output text area and doesn't add product.

	- Entering nothing for an input when it's required
        Ex. ProductID: ''
	Program prints "Product ID must be filled in. Product not added." to output text area
	For other required fields, a similar output will appear only if that's the only error with the inputs.
        Otherwise, it'll only output an error message for the first error encountered. This goes for all these errors.
	
	- Entering incorrect input for optional field price
	Ex. Price: 'fa'
	Program prints "Price can only contain digits. Product not added." to output text area and doesn't add product.
	
2. Testing the three correct inputs for Price
Price: '89' (a number) or Price: '81.9' (number with decimals)
Program runs successfully upon clicking the 'Add' button if there are no other input errors.

Entering nothing for optional fields
Ex. Price: ''
Program runs successfully upon clicking the 'Add' button if there are no other input errors.

4. Testing regular input to see if it gets printed to the text file correctly at the end of the program.
Type: book
ProductID: 123212 (where a product with this ID doesn't already exist in the list)
Name: Hi
Price: 1800
Year: 1900
Authors:
Publisher:

Program runs successfully when you 'Add' product and pressing 'Quit' in Commands Menu quits program and saves list to text file.

5. When printing to text file at the end of program, making sure to make optional fields which I defaulted to "N/A" not be printed.
When book was added without an author or publisher input and program was exited via the quit command, it successfully does not have those fields in the text file but has the others.

6. Text file with empty line at the end vs. text file with no empty line at end.
Program still successfully recognizes the last product.

7. Tested with wrong input file name / non-existing file name for argument.
Program prints "Unable to find input file." to console and exits.

In Search GUI:
--------------------------------------------------------------
1. Searching for key words (one key word vs multiple key words with products stored that contain one of those key words vs. all of them)
Program runs and finds the products successfully.

2. Testing each filter (productID, year, keywords) by itself (as in only 1/4 of those variables have user input).
Ex. ProductID: 201569 and all other fields empty
Case 1: Products found -> Program runs and prints out the correct products
case 2: No products match description -> Program prints "No products found" to the output text area

3. Testing different combinations of two of them
Ex. Keywords: Java, Start Year: 1900, all the other fields are left empty
Program runs and finds the products successfully.

4. Testing different combinations of the year ranges with combinations of the other inputs:
Case 1: Start Year: 1000, End Year left blank --> Products returned correctly have years above or equal to 1000
Case 2: Start Year left blank, End Year = 2000 --> Products returned correctly have years lower or equal to 2000
Case 3: Both left blank --> Products returned correctly without filtering any years
Case 4: Start Year: 1000, End Year: 2000 --> Products returned correctly with years between that range (inclusive)
Case 5: Start Year: 2015, End Year: 2015 (equal values) --> Products returned correctly with only year 2015
Case 6: Start Year: 2000, End Year: 1000 (start year > end year) --> Program prints error message to output text area (given that is the only error with the search inputs)

5.  Incorrect values for ProductID
ProductID: fdsa --> Program prints error message to output text area.

Extreme Cases that would likely fail:
1. Corrupt input file