/**
 * A class representing the Loop
 * @author Ishaan Gupta
 */
public class Loop extends Statement
{
  // Address of the Boolean Condition   
  private Expression<Boolean> expression;  
  
  // Address of the body Statement  
  private Statement bodyStatement;

   /**
   * Constructor of the class
   * @param expression : Address of the Boolean Condition
   * @param bodyStatement : Address of the body Statement
   */
  public Loop(Expression<Boolean> expression, Statement bodyStatement)
  {
    this.expression = expression;
    this.bodyStatement = bodyStatement;    
  }
  
  /**
   * Updates the variable and the value of integer expression in the State
   * execute method stub overriden of Statement
   * If the boolean condition gets true, executes the body statement
   * Else terminates the loop
   * @param s  State where the variable is to be stored
   */
  public void execute (State s)
  {
    //Local Variable to control the loop
    char flag = 'T';
    
    /**
     * Loop to check the boolean condition
     * Iterates till the boolean condition is true
     */
    while(flag == 'T')
    {
      if(getCondition().value(s) == true)
        getBody().execute(s);
      else
        flag = 'F';
    }
  }
  
  /**
   * Returns string representation of the Loop and body Statement
   * @return string representation of loop and body statement
   */
  @Override
  public String toString()
  {
    String sen = "";
    sen += "while (" + getCondition().toString() + ")\n" + getBody().toStringTabbed(1);
    return sen;
  }
  
  /**
   * Returns string representation of the Loop and body Statement with space tabs
   * @param numTabs  Integer value of tabs to be included in the string
   * @return         string representation of of the Loop and body Statement
   */ 
  @Override 
  public String toStringTabbed(Integer numTabs)
  {
    return super.toStringTabbed(numTabs + 1) + "while (" + getCondition().toString() + ")\n" + getBody().toStringTabbed(numTabs + 1);
  }
  
  /**
   * Setter method for Address of the Condition
   * @param expression Condition Address
   */
  public void setCondition(Expression<Boolean> expression)
  {
    this.expression = expression;
  }
  
  /**
   * Setter method for Address of the body Statement
   * @param bodyStatement  Address of the body Statement
   */
  public void setBody(Statement bodyStatement)
  {
    this.bodyStatement = bodyStatement;
  }
  
  /**
   * Getter method for Address of the Condition
   * @return Condition Address of the Condition
   */
  public Expression<Boolean> getCondition()
  {
    return this.expression;
  }
  
  /**
   * Getter method for Address of the Body Statement
   * @return Condition Address of the Body Statement
   */
  public Statement getBody()
  {
    return this.bodyStatement;
  }
}
      
  