/**
 * A class representing Conditional Statement  
 * @author Ishaan Gupta
 */
public class ConditionalStatement extends Statement
{
  //Boolean Condition    
  private Expression<Boolean> expression;
  
  //Statement to be execute on condition getting true
  private Statement thenStatement;
  
  //Statement to be execute on condition getting false
  private Statement elseStatement;
  
  /**
   * Constructor of the class
   * @param expression : Boolean Condition to be checked
   * @param thenStatement : Statement to be execute on condition getting true
   * @param elseStatement : Statement to be execute on condition getting false
   */  
  public ConditionalStatement(Expression<Boolean> expression, Statement thenStatement, Statement elseStatement)
  {
    this.expression = expression;
    this.thenStatement = thenStatement;
    this.elseStatement = elseStatement;
  }
  
  
  /**
   * Executes statements 
   * execute method stub overriden of Statement
   * If boolean condition gets true, thenStatement executed
   * else elseStatement executed
   * @param s  State used to call the execute methods
   */
  @Override
  public void execute(State s)
  {
    if(getCondition().value(s) == true)
      getThenStatement().execute(s);
    getElseStatement().execute(s);
  }
    
  /**
   * Returns the string representation of condition and statements
   * @return  String representation
   */
  @Override
  public String toString()
  {       
    String sen = "if (" + expression.toString() + ")\n" + getThenStatement().toStringTabbed(1) + "else\n" + getElseStatement().toStringTabbed(1);
    return sen;
  }
  
  /**
   * Returns the string representation of condition and statements along with space tabs
   * @return  String representation
   */
  @Override
  public String toStringTabbed(Integer numTabs)
  {
    return super.toStringTabbed(numTabs + 1) + "if " + "(" + getCondition().toString() + ")\n" + getThenStatement().toStringTabbed(numTabs + 1) + super.toStringTabbed(numTabs + 1) + "else\n" + getElseStatement().toStringTabbed(numTabs + 1);
  }
  
  /**
   * Setter method for Address of thenStatement
   * @param statement Address of thenStatement
   */  
  public void setThenStatement(Statement statement)
  {
    this.thenStatement = statement;
  }
  
  /**
   * Getter method for Address of thenStatement
   * @return statement Address of thenStatement
   */  
  public Statement getThenStatement()
  {
    return this.thenStatement;
  }  
  
  /**
   * Setter method for Address of elseStatement
   * @param statement Address of elseStatements
   */  
  public void setElseStatement(Statement statement)
  {
    this.elseStatement = statement;
  }
  
  /**
   * Getter method for Address of elseStatement
   * @return statement Address of elseStatement
   */  
  public Statement getElseStatement()
  {
    return this.elseStatement;
  }  
  
  /**
   * Setter method for Address of boolean Condition
   * @param expression Address of boolean Condition
   */  
  public void setCondition(Expression<Boolean> expression)
  {
    this.expression = expression;
  }
  
  /**
   * Getter method for Address of boolean Condition
   * @return expression Address of boolean Condition
   */  
  public Expression<Boolean> getCondition()
  {
    return expression;
  }
}