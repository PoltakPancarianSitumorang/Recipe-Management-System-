# Recipe-Management-System-

1.	Introduction

Poltak Pancarian Situmorang Software has decided to develop a recipe management system for personal use. The system must be developed using Java Technologies (NetBeans, Swing, Java DB) and a phased implementation strategy will be adopted. This document represents the current state of the design for the Phase 1 system.   

2.	Requirements

Because of the simplicity of the functional requirements, the corresponding use cases are not duplicated here, as would be the case in a normal XYZZY design document.
The purpose of the system is to assist people in recipe selection. A 3 phase development process is envisaged, with the incorporation of recipe details being deferred to a later phase. In the first two phases, the selection process will be restricted to main course recipes.
A Java desktop application is to be developed, driven by a simple Swing GUI. Interaction between the database and the application is to be via JDBC. The NetBeans IDE is to be used for development. Java DB must be used as the database.
The initial functional requirements are:
1.	Start the application and connect to the database
2.	Close the database connection and stop the application
3.	Display all recipes for a particular category (meat, fish, vegetarian)
4.	Display all recipes for a particular category with a  preparation time within a specified range
5.	Display all recipes for a particular category with a  combined preparation and cooking time that is within a specified range
6.	Display the number of recipes that have a specified ingredient as its key ingredient
7.	Add a new recipe to the database.
8.	Clear the display
In addition, the application conform to the MVP architecture.
The database design and sample data are provided in Section 4. Data validation is not required at this stage. However, basic preconditions must be satisfied for each requirement and if these are not satisfied, an appropriate message is to be displayed.  These preconditions are specified in Section 8.

 
3.	Architecture

An MVP conformant three-layered architecture is to be used for the application. Layers are to be modelled as packages – the package structure for the application is illustrated in Figure 1. 
 
4.	Database / Data Access Design

The SQL script that is to be used to create the database’s RECIPES table is given below.
DROP TABLE RECIPES;
CREATE TABLE RECIPES
(
	ID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
	RECIPENAME VARCHAR (60) NOT NULL,
	CATEGORY VARCHAR (10) NOT NULL,
	MAININGREDIENT VARCHAR (10) NOT NULL,
	PREPARATIONTIME INT NOT NULL,
	COOKINGTIME INT NOT NULL
);
INSERT INTO RECIPES (RECIPENAME,CATEGORY,MAININGREDIENT,PREPARATIONTIME,COOKINGTIME)
	VALUES 
('steak tartare','meat','steak',10,0),
('roast chicken','meat','chicken',15,60),
('fish and chips','fish','fish',5,10),
('grilled steak and salad','meat','steak',15,5),
('baked beans on toast','vegetarian','beans',0,5);
As there is only one table, an ERD is not provided. 
Data access will be via JDBC using prepared statements. Java DB must be used as the database.
Normally, in an XYZZY design document, we would specify the queries in this section and relate them to the methods exposed by the RecipesQueries class described in Section 6. However, for this project, we have decided to leave query formulation to the implementers.  Note that if you choose to use SQL’s COUNT() method for Requirement 6, the result set returned when the query is executed consists of a single row with a single column that contains an int. To retrieve this value, use code similar to the following:
 
// execute query here
// resultSet and n have been declared elsewhere
resultSet.next();
n = resultSet.getInt( 1 );

 
5.	GUI Design

Developers are free to use the NetBeans GUI Builder or alternatively, they can hand code the complete GUI. An indicative GUI is presented in Figure 2 and Table 1. Developers are free to use this design as is or to do things differently, for example using menus for data entry. Note that because of the simplicity of the GUI in Figure 2, screen shots for the realisation of each requirement are not shown as would normally occur in an XYZZY design document. Rather, the required actions are summarised in Table 2. When outputting lists of recipes, formatting the data as tables with appropriate headings is not required – you can just use Recipe.toString()  to display the details of each recipe.
 

Functionality	 Swing Components
Output	JTextArea
Input	JLabel, JTextField
Operations	JButton


Requirement	Button	Inputs Required
1	n/a	n/a

2	Exit	None

3	Category	Category

4	Category and Preparation Time	Category and Preparation times – see below

5	Category and Combined Time	Category and Combined Times – see below

6	Main Ingredient	Main Ingredient

7	Add	All, except for right-most Preparation and Cooking times  and Combined Times 
8	Clear	n/a
 
 
8.	Test Plan

The following tests performed prior to acceptance:
Requirement	Test	Comment
1	Operation performs correctly given correct preconditions	
1	Handles no database/incorrect database 	Application is to exit
2	 Operation performs correctly 
	
3	Operation performs correctly given correct preconditions	
3	Handles incomplete field entry
	
4	Operation performs correctly given correct preconditions	No data validation checks required.
4	Handles incomplete field entry
	
4	 Input variants as specified in Section 5 are handled correctly	
5	Operation performs correctly given correct preconditions	No data validation checks required.
5	Handles incomplete field entry
	
5	Input variants as specified in Section 5 are handled correctly	
6	Operation performs correctly given correct preconditions	No data validation checks required.
6	Handles incomplete field entry
	
7	Operation performs correctly given correct preconditions	No data validation checks required.
7	Handles incomplete field entry

