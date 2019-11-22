# Inheritance
 The purpose of this code is to design the underlying model used for a simple Scratch-like programming language. Classes represent different programming language strucrures, and then a user can program by combining the different structures together.

The seven types included in the project
State: The state represents the variables and their contents. Because our language is geared to true novices, the only type we will allow is integer types. Since everything is an integer, we will not have errors if a variable is used before it is assigned a value.
The State should contain a Hashtable from the Java API. You should set the key of the hashtable to be String (this will represent the names of the variables) and the values of the hashtable to be type Integer (this will represent the values stored in the variables. That is, you will represent the state as a Hashtable<String, Integer>. The State class should have the following methods: 
update takes a variable name and a variable value. The name and value pair should be added to the hash table.
lookup takes a variable name and returns the int/Integer value of the variable, as stored in the hashtable. If there is no such variable in the hashtable, the value returned should be 0. (No error should be given because we want to avoid all errors in our language.)

Variable: The Variable type represents a variable in our program. A Variable type instance should be created with one argument: a string name, and the type should have the following methods: 
value: takes a state as input and returns the int/Integer value associated with this variable name that is stored in the input state.
getName: should return the name of the variable.
toString: should return the name of the variable.

Number: The Number type represents a whole number. A Number type instance should be created with one argument: an int/Integer value, and the type should have the following methods: 
value: takes a state as input and returns the int/Integer value of the number.
toString: returns a string representation of the numeric value of the number.

ArithmeticOperation: The ArithmeticOperation represents an arithmetic operation between two values. The ArithmeticOperation type should contain the following enum type to represent the possible operations for the language (you are free to add additional operators if you wish): 
public enum Operator { Add, Sub, Mult, Div, Rem; }
The operators represent the +, -, *, /, and % operations.

An ArithmeticOperation type instance should be created with three arguments: an operation that is from the above Operator enum type, and two expressions that represent the left operand expression and the right operand expression. The type should allow any language structure that has an int/Integer value to be a possible expression. The ArithmeticOperation type should have the following methods: 
value: takes a state as input and returns the int/Integer value that is the result of applying the operation to the values of each of the operand expressions. The state should be used to get the values of the expressions.
toString: should return a string that first contains a string representation of the left operand followed by a space, a string representation of the operator, a space, and the string representation of the right operand.

Comparison: The Comparison type represents a comparison between two expressions. The Comparison type should contain the following enum type to represent the possible comparisons for the langauge (you are free to add additional operators if you wish): 
public enum Operator { LT, LTE, GT, GTE, EQ, NEQ; }
The operators represent the < <=, >, >=, ==, and != operations.

The Comparison type instance should be created with three arguments: an operation that is from the above Operator enum type, and two expressions that represent the left operand expression and the right operand expression. The type should allow any language structure that has an int/Integer value to be a possible expression. The Comparison type should have the following methods: 
value: takes a state as input and returns the boolean/Boolean value that is the result of applying the operation to the values of each of the operand expressions. The state should be used to get the values of the expressions.
toString: should return a string that first contains a string representation of the left operand followed by a space, a string representation of the operator, a space, and the string representation of the right operand.

BooleanOperation: The BooleanOperation type represents a boolean operation between two boolean conditions. The BooleanOperation type should contain the following enum type to represent the possible operations for the language (you are free to add additional operators if you wish): 
public enum Operator { And, Or; }
The operators represent the && and || operations.

An BooleanOperation type instance should be created with three arguments: an operation that is from the above Operator enum type, and two boolean conditions that represent the left operand and the right operand. The type should allow any language structure that has a boolean/Boolean value to be a possible condition. The BooleanOperation type should have the following methods: 
value: takes a state as input and returns the boolean/Boolean value that is the result of applying the operation to the values of each of the operand conditions. The state should be used to get the values of the conditions.
toString: should return a string that first contains a string representation of the left operand followed by a space, a string representation of the operator, a space, and the string representation of the right operand.

Assignment: The Assignment type represents an assignment operation/statement in the language. An Assignment type instance should be created with two arguments, a variable and an expression. Any language structure that has an int/Integer value should be allowed as the expression. The Assignment type should have the following methods: 
execute: takes a state and returns nothing. The method updates the state to set the value of the variable to be the value of the expression. The state should be used to get the value of the expression.
value: takes a state and returns a int/Integer. The method updates the state to set the value of the variable to be the value of the expression. The state should be used to get the value of the expression. The value of the expression is also returned from the method.
toString: should return a string that contains the variable's string value, followed by a space, followed by ":=" character, followed by a space, followed by a string representation of the expression followed by the newline character.
toStringTabbed: takes an int as input and returns a string. The returned string should be indentical to what is returned by toString except that the string is prefixed by a number of tab characters equal to the value of the input int. You may assume the input value is not negative.

Return: The Return type represents a return statement in the language. A Return type instance should be created with one argument, an expression. Any language structure that has an int/Integer value should be allowed as the expression. The Return type should have the following methods: 
execute: takes a state and returns nothing. The method updates the state to set the value of a special variable called "return" to have the value of the expression. The state should be used to get the value of the expression.
toString: should return a string that contains the text "return", followed by a space, followed by a string representation of the expression followed by the newline character.
toStringTabbed: takes an int as input and returns a string. The returned string should be indentical to what is returned by toString except that the string is prefixed by a number of tab characters equal to the value of the input int. You may assume the input value is not negative.

ConditionalStatement: The ConditionalStatement type represents a conditional statement (if) in the language. A ConditionalStatement type instance should be created with three arguments, a boolean condition and two statements representing the then statement and the else statement. Any language structure that has an boolean/Boolean value should be allowed as the condition, and any language structure that represents a statement should be allowed as either statement. The ConditionalStatement type should have the following methods: 
execute: takes a state and returns nothing. The state is used to get the value of the condition. If the condition's value is true the state is used to executed the then statement. Otherwise the state is used to execute the the else statement.
toString: should return a string that contains the text "if", followed by a space, followed by a "(", followed by the string representation of the conditional, followed by a ")", followed by a newline character, followed by the result of calling toStringTabbed with input 1 on the then statement, followed by a "else", followed by a newline character, followed by the result of calling toStringTabbed with input 1 on the else statement.
toStringTabbed: takes an int as input and returns a string. The returned string should be indentical to what is returned by toString except that both the "if" and the "else" are prefixed by a number of tab characters equal to the value of the input int, and the toStringTabbed methods for the then and else statements are called with an input that is one more than the input to this method. You may assume the input value is not negative.

Loop: The Loop type represents a loop statement (while) in the language. A Loop type instance should be created with two arguments, a boolean condition and one statement representing the loop body. Any language structure that has an boolean/Boolean value should be allowed as the condition, and any language structure that represents a statement should be allowed as the body. The Loop type should have the following methods: 
execute: takes a state and returns nothing. The method has a loop. At each iteration of the loop, the state is used to get the value of the condition. If the condition's value is true the state is used to executed the body statement. If the condition evaluates to false, the loop terminates and the method exits.
toString: should return a string that contains the text "while", followed by a space, followed by a "(", followed by the string representation of the conditional, followed by a ")", followed by a newline character, followed by the result of calling toStringTabbed with input 1 on the body statement.
toStringTabbed: takes an int as input and returns a string. The returned string should be indentical to what is returned by toString except that the "while" is prefixed by a number of tab characters equal to the value of the input int, and the toStringTabbed method for the body statement is called with an input that is one more than the input to this method. You may assume the input value is not negative.

CompoundStatement: The CompoundStatement type represents a compound statement/block of code in the language. A CompoundStatement type instance should be created with one variable length parameter of statements. Any language structure that represents a statement should be allowed as the body. The CompoundStatement type should have the following methods: 
execute: takes a state and returns nothing. The method has a loop. At each iteration of the loop, the state is used to execute each of the statements in the array of statements, in order.
toString: should return a string that contains a text "{", followed by a newline character, followed by the result of calling the toStringTabbed method with input 1 on each of the statements in the list of statements, in order, followed by a "}", followed by the newline character.
toStringTabbed: takes an int as input and returns a string. The returned string should be indentical to what is returned by toString except that the "}" and "{" are prefixed by a number of tab characters equal to one less than the value of the input int, and the toStringTabbed method for each statement in the list is called with an input that is equal to the input to this method. You may assume the input value is not negative.
Note that, unlike in Java, any variable declared in the compound statement will still exist after the compound statement ends. (You do not have to try implement this feature, it will occur automatically.) 

Function: The Function type represents a function definition in the language. A Function type instance should be created with three inputs: a string name, a statement that is the function body, and a variable length parameter of variables that will be this function's parameters. Any language structure that represents a statement should be allowed as the body. The Function type should have the following method: 
toString: should return a string that contains a text "function", followed by the function's name, followed by "(", followed by each of the variables of the function, separated by a space and a comma (except the last one), followed by a ")", followed by the newline character, followed by the result of calling the toStringTabbed method of the body of the function with input 1.
Note, that unlike Java functions will not be able to access any variables declared outside of the function. You should not implement that here. It will be taken care of in the FunctionCall type described below. 

FunctionCall: The FunctionCall type represents a function call in the language. A FunctionCall type instance should be created with two inputs: a Function and a variable length parameter of expressions that will be the arguments of this function call. Any language structure that produces an int/Integer value should be allowed as an expression. The FunctionCall type should have the following methods: 
value: should take a state and return an int/Integer. The method should create a new empty state. For each variable in the function's list of parameters, the new state should be updated with this variable and the value from the corresponding argument. The original state should be used to get the value of the argument. If there is no corresponding argument, the value of 0 should be used for the update. Then, the function's body should be executed using the new state. Finally, the value of the keyword "return" should be looked up in the new state and returned from this function.
toString: should return a string that contains the function's name, followed by "(", followed by the string representation of each of the arguments of the function call, separated by a space and a comma (except the last one), followed by a ")".
toStringTabbed: takes an int as input and returns a string. The returned string should be indentical to what is returned by toString except that the "}" and "{" are prefixed by a number of tab characters equal to one less than the value of the input int, and the toStringTabbed method for each statement in the list is called with an input that is equal to the input to this method. You may assume the input value is not negative.
