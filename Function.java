/**
 * A class representing the Function
 * @author Ishaan Gupta
 */
public class Function
{
  //Function Name   
  private String name;
  
  //Function Body
  private Statement statement;
  
  //Function Parameters
  private Variable[] variable;
  
  
  /**
   * Constructor of the class
   * @param name : String name of the Function 
   * @param statement : Function body   
   * @param variable : List of variable parameters of the function
   */
  public Function(String name, Statement statement, Variable... variable)
  {
    this.name = name;
    this.statement = statement;
    this.variable = variable;
  }
  
  
  /**
   * Returns string representation of the Function
   * Checks the arithmetic operator
   * @return string representation of left operand, operator and right operand
   */
  public String toString()
  {
    //Local Variable to store the string representation
    StringBuilder sen = new StringBuilder();
    sen.append("function " + this.getName() + "(");    
    
    int i = 0;    
        
    //Checking th condition to avoid Out of Bound Index error
    if(getVariableArray().length != 0)
    {
    /**
     * Loop to traverse in the array of Variables
     * Starts from first element
     * Stops at the second last element in the array
     * The toString method of each variable is called and appended in the string
     */
      while(i < getVariableArray().length - 1)
     {
       sen.append(getVariableArray()[i].toString() + " ,");
       i++;
     }  
    
    //Appending the last element of the array to avoid comma after it
    sen.append(getVariableArray()[getVariableArray().length - 1].toString()); 
    }
    sen.append(")\n" + getBody().toStringTabbed(1));
    
    return sen.toString();
  }
  
   /**
    * Getter method of Name of the function
    * @return name : Name of the function
    */
  public String getName()
  {
    return name;
  }
  
   /**
    * Setter method of Name of the function
    * @param name : String Name of the function
    */
  public void setName(String name)
  {
    this.name = name;
  }
  
  
  
  /**
   * Getter method of body of the function
   * @return name : Address of body of the function
   */
  public Statement getBody()
  {
    return statement;
  }
  
  /**
   * Setter method of Body of the function
   * @param statement String Name of the function
   */
  public void setBody(Statement statement)
  {
    this.statement = statement;
  }
  
  
  /**
   * Getter method of Variable parameters of the function
   * @return name : Address of Array of Variable the function
   */
  public Variable[] getVariableArray()
  {
    return variable;
  }
  
  
  /**
   * Setter method of variable of the function
   * @param variable : Address of array of variables of the function
   */
  public void setVariableArray(Variable... variable)
  {
    this.variable = variable;
  }
  
}
    
  
  