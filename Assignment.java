/**
 * A class representing the Assignment Statement  
 * @author Ishaan Gupta
 */
public class Assignment extends Statement implements Expression<Integer>
{    
  //Address of the Variable used to assign value 
  private Variable variable;
  
  //Address of the Integer expression to be assigned  
  private Expression<Integer> expression;
  
  /**
   * Constructor of the class
   * @param variable      Address of the Variable used to assign value
   * @param expression    Address of the integer expression
   */    
  public Assignment (Variable variable, Expression<Integer> expression)
  {    
    this.variable = variable;
    this.expression = expression;
  }  
   
  /**
   * Updates the variable and the value of integer expression in the State
   * execute method stub overriden of Statement
   * @param s  State where the variable is to be stored
   */
  @Override
  public void execute (State s)
  {    
    s.update(getVariable().getName(),getExpression().value(s));
  }
    
  /**
   * Updates the variable and the value of integer expression in the State
   * @param s  State where the variable is to be stored
   * @return   Integer value stored in the variable which is updated
   */
  public Integer value (State s)
  {
    //execute method of Assignment called
    this.execute(s);
    return getExpression().value(s);
  }
  
  
  /**
   * Returns string representation of the Assignment Statement
   * @return string representation of variable, operator and the expression
   */
  @Override
  public String toString()
  {
    return getVariable().toString() + " := " + getExpression().toString() + ";\n";
  }
  
  
  /**
   * Returns string representation of the Assignment Statement with space tabs
   * @param numTabs  Integer value of tabs to be included in the string
   * @return         string representation of variable, operator and the expression
   */ 
  @Override
  public String toStringTabbed(Integer numTabs)
  {
    //toStringTabbed method of Statement called along with method of Assignment class
    return super.toStringTabbed(numTabs + 1) + this.toString();    
  }
  
  
  /**
   * Setter method for Address of the Expression
   * @param expression Address
   */
  public void setExpression(Expression<Integer> expression)
  {
    this.expression = expression;
  }
  
  /**
   * Getter method for Address of the Expression
   * @return Expression Address
   */
  public Expression<Integer> getExpression()
  {
    return expression;
  }  
  
  
  /**
   * Setter method for Address of the Variable
   * @param variable Address
   */  
  public void setVariable(Variable variable)
  {
    this.variable = variable;
  }
  
  
  /**
   * Getter method for Address of the Variable
   * @return Variable Address
   */
  public Variable getVariable()
  {
    return variable;
  }    
    
}
    
