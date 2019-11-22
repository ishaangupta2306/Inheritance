/**
 * A class representing the Function call
 * @author Ishaan Gupta
 */
public class FunctionCall implements Expression<Integer> // necessary
{
  //Function    
  private Function function;
  
  //Arguments of Function Call   
  private Expression<Integer> expression[];
  
  
  /**
   * Constructor of the class
   * @param function : Address of the function instance
   * @param expression : List of arguments of the function call
   */
  public FunctionCall(Function function, Expression<Integer>... expression)
  {
    this.function = function;
    this.expression = expression;
  }
  
  /**
   * Creates new state
   * Updates the new State with the argument name and corresponding value from the expression stored in original State
   * Executes function body using new State
   * @param  s  state where value of argument are stored
   * @return Integer value stored in "return" argument
   */
  public Integer value(State s)
  {
    //Creation of a new State
    State temp = new State();
    
    /**
     * Loop to traverse in the array of Arguments
     * Starts from first element
     * Stops at the last element in the array
     * Updates the new State with the argument name and corresponding value from the expression stored in original State
     */
    for(int i = 0; i < getFunction().getVariableArray().length; i++)    
      temp.update(getFunction().getVariableArray()[i].toString(), getExpressionArray()[i].value(s));
    
    //Function body executed using new State
    getFunction().getBody().execute(temp);
    return temp.lookup("return");
  }
  
  
  /**
   * Returns string representation of the Function Name,Function Call with each arguments
   * @return string representation of the Function,Function Call with each arguments
   */
  public String toString() 
  { 
    //Local Variable to store the string representation
    StringBuilder sen = new StringBuilder();
    
    //String representation of Function name stored along with  
    sen.append(getFunction().getName() + "(");
    
    //Local Variable for counter in the loop
    int i = 0;    
    
    //Checking th condition to avoid Out of Bound Index Error for last element
    if(getExpressionArray().length != 0)
    {
    /**
     * Loop to traverse in the array of Expression
     * Starts from first element
     * Stops at the second last element in the array
     * The toString method of each Expression is called and appended in the string
     */
      while(i < getExpressionArray().length-1)
     {
       sen.append(getExpressionArray()[i].toString() + " ,");
       i++;
     }  
      
     //Appending the last element of the array to avoid comma after it 
     sen.append(getExpressionArray()[getExpressionArray().length-1].toString());
    }
    sen.append(")");
    return sen.toString();
  }
  
  public String toStringTabbed(int numTabs)
  {
    //Local variable to form a string representation
    StringBuilder sen = new StringBuilder();
    
    int i = 0;
    StringBuilder tabs = new StringBuilder();        
    /**
     * Loop to append space tabs
     * Pre-Condition: numTabs >0
     * Start with i = 0
     * Ends when the number of space tabs to be appended are done
     */
    while(i < numTabs - 1)
    {
      tabs.append("\t");
      i++;
    }   
    
    sen.append(tabs);  
    sen.append("{\n");    
    sen.append(this.toString() + getFunction().getBody().toStringTabbed(numTabs));      
    sen.append(tabs);  
    sen.append("}");
    sen.append("\n");
    
    return sen.toString();
  }
  
  
   /**
    * Getter method of Address of Arguments
    * @return expression : Address of Arguments
    */
  public Expression<Integer>[] getExpressionArray()
  {
    return expression;
  }
  
   /**
    * Getter method of Address of Function
    * @return expression : Address of Function
    */
  public Function getFunction()
  {
    return function;
  }
  
   /**
    * Setter method of Address of Arguments
    * @param expression Address of Arguments
    */
  public void setExpressionArray(Expression<Integer>[] expression)
  {
    this.expression = expression;
  }
  
   /**
    * Setter method of Address of Function
    * @param function Address of Function
    */
  public void setFunction(Function function)
  {
    this.function = function;
  }
  
}
    
      
  