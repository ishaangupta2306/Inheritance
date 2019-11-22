/**
 * An Abstract class with generic types representing Primary Operations 
 * @author Ishaan Gupta
 */
public abstract class PrimaryOperation<T,K>
{ 
  //String form of Operator  
  private String operator;
    
  //Value of the left operand   
  private K leftOperandValue;
  
  //Value of the right operand
  private K rightOperandValue;
  
  //Address of the expression of left operand   
  private Expression<K> leftOperand;
  
  //Address of the expression of right operand   
  private Expression<K> rightOperand;
  
  
  /**
   * Constructor of the class
   * Sets the field of the class
   * @param leftOperand   Address of the expression of left operand
   * @param rightOperand  Address of the expression of right operand
   */
   public PrimaryOperation(Expression<K> leftOperand, Expression<K> rightOperand)
  {    
    this.leftOperand = leftOperand;
    this.rightOperand = rightOperand;
  }
    
  /**
   * Getter method for leftOperand 
   * @return the address of the leftOperand
   */
  public Expression<K> getLeftOperand()
  {
    return leftOperand;
  }
  
  
  /**
   * Getter method for rightOperand 
   * @return the address of the rightOperand
   */
  public Expression<K> getRightOperand()
  {
    return rightOperand;
  }  
    
  
  /**
   * Getter method for Operator string 
   * @return the operator string
   */
  protected String getOperator ()
  {
    return operator;
  }
  
  
  /**
   * Setter method for Operator 
   * @param  operator the String of the operator
   */
  protected void setOperator(String operator)
  {
    this.operator = operator;
  }
  
  /**
   * Setter method for LeftOperand 
   * @param leftOperand Address of the LeftOperand 
   */  
  public void setLeftOperand(Expression<K> leftOperand)
  {
    this.leftOperand = leftOperand;
  }
  
  /**
   * Setter method for rightOperand 
   * @param rightOperand Address of the rightOperand 
   */ 
  public void setRightOperand(Expression<K> rightOperand)
  {
    this.rightOperand = rightOperand;
  }
  
  
  /**
   * Abstract method for value
   * @param s State 
   * @return the value of the expression
   */
  public abstract T value (State s);
  
 
  
}