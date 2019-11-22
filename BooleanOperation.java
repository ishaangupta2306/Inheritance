/**
 * A class representing the Boolean Operations  
 * @author Ishaan Gupta
 */
public class BooleanOperation extends PrimaryOperation<Boolean, Boolean> implements Expression<Boolean>
{  
  
  //Address of the Operator used for the Boolean Operations 
  private Operator operator; 
  
  /**
   * Boolean Operators used for the Operation
   * A class with private constructor 
   */
  public enum Operator { And, Or; }
  
  
  /**
   * Constructor of the class
   * @param operator      Address of the Operator used for the Boolean Operations 
   * @param leftOperand   Address of the leftOperand
   * @param rightOperand  Address of the rightOperand
   */
  public BooleanOperation (Operator operator, Expression<Boolean> leftOperand, Expression<Boolean> rightOperand)
  {    
   super(leftOperand, rightOperand);
    this.operator = operator;  
  }
  
  
  /**
   * Calculates value of boolean operation
   * value method stub overriden of PrimaryOperation 
   * @param  s  State where operands are stored
   * @return Boolean value of the final result after operation
   */
  @Override
  public Boolean value(State s)
  {
    //Local variable to store the final resutlt of the operation
    boolean finalValue = false;
    
    //local variable  storing the value of the left operand
    Boolean leftOperandValue  = getLeftOperand().value(s);
    
   //local variable  storing the value of the right operand
    Boolean rightOperandValue = getRightOperand().value(s);
    
    //Switch to check the Operator and perform operation
    switch (operator)
    { 
      case And : finalValue =  leftOperandValue && rightOperandValue;break;
      case Or  : finalValue =  leftOperandValue || rightOperandValue;break;
    }
    return finalValue;
  }  
  
  /**
   * Returns string representation of the boolean operation   
   * @return string representation of left operand, operator and right operand
   */
  public String toString()
  { 
    //Switch to check and set the string representation of Operator
    switch (operator)
    {      
      case And  : setOperator("&&");break;                       
      case Or   : setOperator("||");break;       
    }
   return "" + getLeftOperand().toString() +" " + getOperator() + " " + getRightOperand().toString() + "";
  }
  
  /**
   * Getter method for Address of the Operator
   * @return Operator addresss
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