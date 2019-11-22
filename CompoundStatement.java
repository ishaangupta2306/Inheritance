/**
 * A class representing Compound Statement  
 * @author Ishaan Gupta
 */
public class CompoundStatement extends Statement
{
  //List of statement
  private Statement statement[];
  
  /**
   * Constructor of the class
   * @param statement  Variable length parameter of Statement
   */
  public CompoundStatement(Statement... statement)
  {
    this.statement = statement;
  }  
  
  /**
   * Executes each statement of the list of statements
   * execute method stub overriden of Statement
   * @param s  State where the variable is to be stored
   */
  @Override
  public void execute (State s)
  {
    //Local Variable for counter in the loop
    int i = 0;
    
    /**
     * Loop to traverse in the array of Statements
     * Starts from first element
     * Stops at the end of the loop
     * The execute method of each statement is called
     */
    while(i < getStatementArray().length)
    {
      getStatementArray()[i].execute(s);
      i++;
    }
  }
  
  /**
   * Returns the string representation of each statement
   * @return  String representation
   */
  @Override
  public String toString()
  {
    //Local Variable to store the strings     
    StringBuilder sen = new StringBuilder();
    sen.append("{\n");
    
    //Local variable used for counter in the loop     
    int i = 0;
    
    /**
     * Loop to traverse in the array of Statements
     * Starts from first element
     * Stops at the last element in the array
     * The toStringTabbed method of each statement is appended in the string
     */
    while(i < getStatementArray().length)
    {
      sen.append(getStatementArray()[i].toStringTabbed(1));
      i++;
    }
    
    sen.append("}\n");
    return sen.toString();    
  }
  
  
  /**
   *Returns the string representation of each statement along with space tabs
   *@return  String representation
   */
  @Override
  public String toStringTabbed(Integer numTabs)
  {
    //Local Variable for counter of the loop
    int i = 0;
    
    //Local variable to form a string representation
    StringBuilder sen = new StringBuilder();
    
    //toStringTabbed method called of Statement for space tabs
    sen.append(super.toStringTabbed(numTabs)); 
    sen.append("{");
    sen.append("\n");
    
    /**
     * Loop to traverse in the array of Statements
     * Starts from first element
     * Stops at the last element in the array
     * The toStringTabbed method of each statement is appended in the string
     */
    while(i < getStatementArray().length)
    {
      sen.append(getStatementArray()[i].toStringTabbed(numTabs));
      i++;
    }
    
    //toStringTabbed method called of Statement for space tabs
    sen.append(super.toStringTabbed(numTabs)); 
    sen.append("}");
    sen.append("\n");
    
    return sen.toString();
 }
      
  
  /**
   * Getter method for Address of the Array of Statements
   * @return Address of the Array of Statements
   */
  public Statement[] getStatementArray()
  {
    return this.statement;
  }
  
  /**
   * Setter method for Address of the Array of Statements
   * @param statement Address of the Array of Statements
   */
  public void setStatementArray(Statement... statement)
  {
    this.statement = statement;
  }
    
}