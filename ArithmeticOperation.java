/**
 * A class representing the Arithmetic Operations  
 * @author Ishaan Gupta
 */
public class ArithmeticOperation extends PrimaryOperation<Integer, Integer> implements Expression<Integer>
{
  
  //Address of the Operator used for the Arithmetic Operations 
  private Operator operator; 
  
    
  /**
   * Arithmetic Operators used for the Operation
   * A class with private constructor 
   */
   public enum Operator { Add, Sub, Mult, Div, Rem; }  
  
   
  /**
   * Constructor of the class
   * @param operator      Address of the Operator used for the Arithmetic Operations 
   * @param leftOperand   Adress of the leftOperand
   * @param rightOperand  Adress of the rightOperand
   */
  public ArithmeticOperation(Operator operator, Expression<Integer> leftOperand, Expression<Integer> rightOperand)
  { 
    super(leftOperand, rightOperand);
    this.operator = operator;    
  }
     
  
  /**
   * Calculates value of arithmetic operation
   * value method stub overriden of PrimaryOperation
   * @param  s  state where operands are stored
   * @return Integer value of the final result after operation
   */
  @Override
  public Integer value(State s)
  {
    //Local variable to store the final resutlt of the operation     
    int finalValue = 0;
    
  
    //local variable  storing the value of the left operand
    Integer leftOperandValue  = getLeftOperand().value(s);
    
    //local variable  storing the value of the right operand
    Integer rightOperandValue = getRightOperand().value(s);
    
    //Switch to check the Operator and perform operation
    switch (getOperatorAddress())
    {      
      case Add  : finalValue =  leftOperandValue + rightOperandValue;break;                         
      case Sub  : finalValue =  leftOperandValue - rightOperandValue;break;
      case Mult : finalValue =  leftOperandValue * rightOperandValue;break;  
      case Div  : finalValue =  leftOperandValue / rightOperandValue;break;
      case Rem  : finalValue =  leftOperandValue % rightOperandValue;break;                            
    }
    return finalValue;
  }    
  
  /**
   * Returns string representation of the arithmetic operation   
   * @return string representation of left operand, operator and right operand
   */
  public String toString()
  { 
    //Switch to check the operator and set the string
    switch (getOperatorAddress())
    {      
      case Add  : setOperator("+");break;                       
      case Sub  : setOperator("-");break;       
      case Mult : setOperator("*");break;       
      case Div  : setOperator("/");break;       
      case Rem  : setOperator("%");break;       
    }
    return "" + getLeftOperand().toString() + " " + getOperator() + " " + getRightOperand().toString() + "";
  }
 
   /**
    * Getter method of Address of the Operator
    * @return operator : Address of the Operator
    */
   public Operator getOperatorAddress()
  {
    return this.operator;
  }
   
   /**
    * Setter method of Address of the Operator
    * @param operator : Address of the Operator
    */
    public void setOperatorAddress(Operator operator)
   {
     this.operator = operator;
   }
  
    
 
}