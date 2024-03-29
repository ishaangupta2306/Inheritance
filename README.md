# Inheritance
 The purpose of this code is to design the underlying model used for a simple Scratch-like programming language. Classes represent different programming language strucrures, and then a user can program by combining the different structures together.

The seven types included in the project

State: The state represents the variables and their contents. Because language is geared to true novices, the only type allowed is integer types. Since everything is an integer, we will not have errors if a variable is used before it is assigned a value.
The State contains a Hashtable from the Java API. The key of the hashtable is set to be String (this will represent the names of the variables) and the values of the hashtable to be type Integer (this will represent the values stored in the variables. That is, State is represented as a Hashtable<String, Integer>. The State class  have the following methods: 

update takes a variable name and a variable value. The name and value pair should be added to the hash table.
lookup takes a variable name and returns the int/Integer value of the variable, as stored in the hashtable. If there is no such variable in the hashtable, the value returned should be 0. (No error should be given because we want to avoid all errors in our language.)


Variable: The Variable type represents a variable in program. A Variable type instance is created with one argument: a string name, and the type have the following methods: 
value: takes a state as input and returns the int/Integer value associated with this variable name that is stored in the input state.
getName: returns the name of the variable.
toString: returns the name of the variable.


Number: The Number type represents a whole number. A Number type instance is created with one argument: an int/Integer value, and the type have the following methods: 
value: takes a state as input and returns the int/Integer value of the number.
toString: returns a string representation of the numeric value of the number.


ArithmeticOperation: The ArithmeticOperation represents an arithmetic operation between two values. The ArithmeticOperation type contains the following enum type to represent the possible operations for the language 

public enum Operator { Add, Sub, Mult, Div, Rem; }
The operators represent the +, -, *, /, and % operations.

An ArithmeticOperation type instance is created with three arguments: an operation that is from the above Operator enum type, and two expressions that represent the left operand expression and the right operand expression. The type allows any language structure that has an int/Integer value to be a possible expression. The ArithmeticOperation type has the following methods: 

value: takes a state as input and returns the int/Integer value that is the result of applying the operation to the values of each of the operand expressions. The state is used to get the values of the expressions.
toString: returns a string that first contains a string representation of the left operand followed by a space, a string representation of the operator, a space, and the string representation of the right operand.



Comparison: The Comparison type represents a comparison between two expressions. The Comparison type contains the following enum type to represent the possible comparisons for the langauge: 
public enum Operator { LT, LTE, GT, GTE, EQ, NEQ; }
The operators represent the < <=, >, >=, ==, and != operations.

The Comparison type instance is created with three arguments: an operation that is from the above Operator enum type, and two expressions that represent the left operand expression and the right operand expression. The type allows any language structure that has an int/Integer value to be a possible expression. The Comparison type has the following methods: 

value: takes a state as input and returns the boolean/Boolean value that is the result of applying the operation to the values of each of the operand expressions. The state should be used to get the values of the expressions.
toString: returns a string that first contains a string representation of the left operand followed by a space, a string representation of the operator, a space, and the string representation of the right operand.



BooleanOperation: The BooleanOperation type represents a boolean operation between two boolean conditions. The BooleanOperation type  contains the following enum type to represent the possible operations for the language: 
public enum Operator { And, Or; }
The operators represent the && and || operations.

An BooleanOperation type instance is created with three arguments: an operation that is from the above Operator enum type, and two boolean conditions that represent the left operand and the right operand. The type allows any language structure that has a boolean/Boolean value to be a possible condition. The BooleanOperation type has the following methods: 

value: takes a state as input and returns the boolean/Boolean value that is the result of applying the operation to the values of each of the operand conditions. The state should be used to get the values of the conditions.
toString: returns a string that first contains a string representation of the left operand followed by a space, a string representation of the operator, a space, and the string representation of the right operand.


Assignment: The Assignment type represents an assignment operation/statement in the language. An Assignment type instance is created with two arguments, a variable and an expression. Any language structure that has an int/Integer value is allowed as the expression. The Assignment type has the following methods: 

execute: takes a state and returns nothing. The method updates the state to set the value of the variable to be the value of the expression. The state is used to get the value of the expression.
value: takes a state and returns a int/Integer. The method updates the state to set the value of the variable to be the value of the expression. The state i used to get the value of the expression. The value of the expression is also returned from the method.
toString: returns a string that contains the variable's string value, followed by a space, followed by ":=" character, followed by a space, followed by a string representation of the expression followed by the newline character.
toStringTabbed: takes an int as input and returns a string. The returned string is indentical to what is returned by toString except that the string is prefixed by a number of tab characters equal to the value of the input int. 



Return: The Return type represents a return statement in the language. A Return type instance is created with one argument, an expression. Any language structure that has an int/Integer value is allowed as the expression. The Return type has the following methods: 
execute: takes a state and returns nothing. The method updates the state to set the value of a special variable called "return" to have the value of the expression. The state is used to get the value of the expression.
toString: returns a string that contains the text "return", followed by a space, followed by a string representation of the expression followed by the newline character.
toStringTabbed: takes an int as input and returns a string. The returned string is indentical to what is returned by toString except that the string is prefixed by a number of tab characters equal to the value of the input int. 



ConditionalStatement: The ConditionalStatement type represents a conditional statement (if) in the language. A ConditionalStatement type instance is created with three arguments, a boolean condition and two statements representing the then statement and the else statement. Any language structure that has an boolean/Boolean value is allowed as the condition, and any language structure that represents a statement is allowed as either statement. The ConditionalStatement type has the following methods: 

execute: takes a state and returns nothing. The state is used to get the value of the condition. If the condition's value is true the state is used to executed the then statement. Otherwise the state is used to execute the the else statement.
toString: returns a string that contains the text "if", followed by a space, followed by a "(", followed by the string representation of the conditional, followed by a ")", followed by a newline character, followed by the result of calling toStringTabbed with input 1 on the then statement, followed by a "else", followed by a newline character, followed by the result of calling toStringTabbed with input 1 on the else statement.
toStringTabbed: takes an int as input and returns a string. The returned string is indentical to what is returned by toString except that both the "if" and the "else" are prefixed by a number of tab characters equal to the value of the input int, and the toStringTabbed methods for the then and else statements are called with an input that is one more than the input to this method. 



Loop: The Loop type represents a loop statement (while) in the language. A Loop type instance is created with two arguments, a boolean condition and one statement representing the loop body. Any language structure that has an boolean/Boolean value is allowed as the condition, and any language structure that represents a statement is allowed as the body. The Loop type has the following methods: 

execute: takes a state and returns nothing. The method has a loop. At each iteration of the loop, the state is used to get the value of the condition. If the condition's value is true the state is used to executed the body statement. If the condition evaluates to false, the loop terminates and the method exits.
toString: returns a string that contains the text "while", followed by a space, followed by a "(", followed by the string representation of the conditional, followed by a ")", followed by a newline character, followed by the result of calling toStringTabbed with input 1 on the body statement.
toStringTabbed: takes an int as input and returns a string. The returned string is indentical to what is returned by toString except that the "while" is prefixed by a number of tab characters equal to the value of the input int, and the toStringTabbed method for the body statement is called with an input that is one more than the input to this method. 



CompoundStatement: The CompoundStatement type represents a compound statement/block of code in the language. A CompoundStatement type instance is created with one variable length parameter of statements. Any language structure that represents a statement is allowed as the body. The CompoundStatement type has the following methods: 
execute: takes a state and returns nothing. The method has a loop. At each iteration of the loop, the state is used to execute each of the statements in the array of statements, in order.
toString: returns a string that contains a text "{", followed by a newline character, followed by the result of calling the toStringTabbed method with input 1 on each of the statements in the list of statements, in order, followed by a "}", followed by the newline character.
toStringTabbed: takes an int as input and returns a string. The returned string is indentical to what is returned by toString except that the "}" and "{" are prefixed by a number of tab characters equal to one less than the value of the input int, and the toStringTabbed method for each statement in the list is called with an input that is equal to the input to this method. 

Unlike in Java, any variable declared in the compound statement will still exist after the compound statement ends. 



Function: The Function type represents a function definition in the language. A Function type instance is created with three inputs: a string name, a statement that is the function body, and a variable length parameter of variables that will be this function's parameters. Any language structure that represents a statement is allowed as the body. The Function type has the following method: 

toString: returns a string that contains a text "function", followed by the function's name, followed by "(", followed by each of the variables of the function, separated by a space and a comma (except the last one), followed by a ")", followed by the newline character, followed by the result of calling the toStringTabbed method of the body of the function with input 1.
Unlike Java functions will not be able to access any variables declared outside of the function. It's no not implement that here. It will be taken care of in the FunctionCall type described below. 



FunctionCall: The FunctionCall type represents a function call in the language. A FunctionCall type instance is created with two inputs: a Function and a variable length parameter of expressions that will be the arguments of this function call. Any language structure that produces an int/Integer value is allowed as an expression. The FunctionCall type has the following methods: 
value: should take a state and return an int/Integer. The method should create a new empty state. For each variable in the function's list of parameters, the new state should be updated with this variable and the value from the corresponding argument. The original state should be used to get the value of the argument. If there is no corresponding argument, the value of 0 should be used for the update. Then, the function's body should be executed using the new state. Finally, the value of the keyword "return" should be looked up in the new state and returned from this function.
toString: should return a string that contains the function's name, followed by "(", followed by the string representation of each of the arguments of the function call, separated by a space and a comma (except the last one), followed by a ")".
toStringTabbed: takes an int as input and returns a string. The returned string should be indentical to what is returned by toString except that the "}" and "{" are prefixed by a number of tab characters equal to one less than the value of the input int, and the toStringTabbed method for each statement in the list is called with an input that is equal to the input to this method. You may assume the input value is not negative.
