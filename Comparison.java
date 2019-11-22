/**
 * A class representing the Comparison Operations  
 * @author Ishaan Gupta
 */
public class Comparison extends PrimaryOperation<Boolean, Integer> implements Expression<Boolean> 
{  
  
   //Address of the Operator used for the Comparison Operations   
   private Operator operator; 
  
  /**
   * Comparison Operators used for the Operation
   * A class with private constructor 
   */
  public enum Operator { LT, LTE, GT, GTE, EQ, NEQ; }
  
  /**
   * Constructor of the class
   * @param operator      Address of the Operator used for the Comparison Operations 
   * @param leftOperand   Adress of the leftOperand
   * @param rightOperand  Adress of the rightOperand
   */
  public Comparison (Operator operator, Expression<Integer> leftOperand, Expression<Integer> rightOperand)
  {    
   super(leftOperand, rightOperand);
    this.operator = operator;  
  }
  
  
  /**
   * Calculates value of Comparison operation
   * value method stub overriden of PrimaryOperation   
   * @param  s  state where operands are stored
   * @return Boolean value of the final result after operation
   */
  @Override
  public Boolean value(State s)
  {
    //Local variable to store the final resutlt of the operation     
    boolean finalValue = false;
    
    //local variable  storing the value of the left operand
    Integer leftOperandValue  = getLeftOperand().value(s);
    
    //local variable  storing the value of the right operand
    Integer rightOperandValue = getRightOperand().value(s);
    
    //Switch to check the Operator and perform operation
    switch (operator)
    { 
      
      case LT  : finalValue =  leftOperandValue <  rightOperandValue; break;                               
      case LTE : finalValue =  leftOperandValue <= rightOperandValue; break;                                
      case GT  : finalValue =  leftOperandValue >  rightOperandValue; break;                               
      case GTE : finalValue =  leftOperandValue >= rightOperandValue; break;                               
      case EQ  : finalValue =  leftOperandValue == rightOperandValue; break;                               
      case NEQ : finalValue =  leftOperandValue != rightOperandValue; break;
    }
    return finalValue;
  }
  
  
  /**
   * Returns string representation of the Comparison operation   
   * @return string representation of left operand, operator and right operand
   */
  public String toString()
  { 
     //Switch to check and set the string representation of Operator
      switch (operator)
      {       
      case LT  : setOperator("<");break;                               
      case LTE : setOperator("<="); break;                                
      case GT  : setOperator(">");break;                               
      case GTE : setOperator(">=");break;                               
      case EQ  : setOperator("==");break;                               
      case NEQ : setOperator("!=");break;
    }
   
    return "" + getLeftOperand().toString() + " " + getOperator() + " " + getRightOperand().toString() + "";
  }
  
  /**
   * Getter method for Address of the Operator
   * @return operator addresss
   */
  public Operator getOperatorAddress()
  {
    return this.operator;
  }
  
   /**
    * Setter method for Address of the Operator
    * @param operator address
    */
   
    public void setOperatorAddress(Operator operator)
   {
     this.operator = operator;
   }
  
  
}