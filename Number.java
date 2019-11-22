/**
 * A class representing Number
 * @author Ishaan Gupta
 */
public class Number implements Expression<Integer> 
{  
  //Integer value of the number  
  private Integer num;  
  
  /**
   * Constructor of the class
   * Sets the field num
   * @param num  Integer value of the number
   */
  public Number (Integer num)
  {
    this.num = num;
  }
   
  /**
   * Returns the Integer value of the Number
   * @param s  State where the number is stored
   * @return the Integer value of the Number
   */
  public Integer value (State s)
  {
    return getNumber();
  }
  
  
  /**
   * Returns the String representation value of the Number
   * @return the String representation value of the Number
   */  
  public String toString()
  {
    return ("" + getNumber() + "");
  }
  
  /**
   * Setter method for number
   * @param num number to be set
   */
  public void setNumber(Integer num)
  {
    this.num = num;
  }
  
  
  /**
   * Getter method for number
   * @return number to obtain
   */
  public Integer getNumber()
  {
    return num;
  }
}
  


