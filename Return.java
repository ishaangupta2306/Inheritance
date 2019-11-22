/**
 * A class representing the Return Statement
 * @author Ishaan Gupta
 */
public class Return extends Statement
{
  //Expression to be returned  
  private Expression<Integer> expression;
  
  /**
   * Constructor of the class
   * @param expression to be returned
   */
  public Return (Expression<Integer> expression)
  {
    this.expression = expression;
  }
  
  /**
   * Updates the state with "return" and the value of integer expression in the State
   * execute method stub overriden of Statement
   * @param s  State where the variable is to be stored
   */
  @Override
  public void execute(State s)
  {
    s.update("return",getExpression().value(s));
  }
  
  /**
   * Returns string representation of the Return Statement
   * @return string representation of "return", and the expression
   */
  @Override
  public String toString()
  {
    return "return " + getExpression().toString() + ";\n";
  }
  
  /**
   * Returns string representation of the Return Statement with space tabs
   * @param numTabs  Integer value of tabs to be included in the string
   * @return         string representation of "return" and the expression
   */ 
  @Override
  public String toStringTabbed(Integer numTabs)
  {
    return super.toStringTabbed(numTabs + 1) + this.toString();
  }
  
   /**
   * Getter method for Address of the Expression
   * @return Expression Address
   */  
  public Expression<Integer> getExpression()
  {
    return this.expression;
  }
  
  /**
   * Setter method for Address of the Expression
   * @param expression Expression Address
   */
  public void setExpression(Expression<Integer> expression)
  {
    this.expression = expression;
  }
  
}
  
  
  
  
  
  