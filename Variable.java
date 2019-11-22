/**
 * A class representing Variable 
 * @author Ishaan Gupta
 */
public class Variable implements Expression<Integer>
{
 
  //String name of the variable 
  private String name;
  
  
  /**
   * Constructor of the class
   * Sets the field of the class
   * @param name Name of the variable
   */
  public Variable(String name)
  {
    this.name = name;
  }
  
  
  /**
   * Searches the Name of the variable in the Hashtable
   * If variable name found, returns the value stored in it
   * @param s State instance which contains the Hashtable where the name is to be searched
   * @return Integer value stored in the variable, otherwise 0
   */
  public Integer value (State s)
  {
    return s.lookup(this.getName());
  }
  
  /**
   * Returns the Name of the Variable
   * @return the Name of the Variable
   */
  public String getName()
  {
    return this.name;
  }
  
  
  /**
   * Returns the Name of the Variable
   * @return the Name of the Variable
   */
  public String toString()
  {
    return this.name;
  }
  
  /**
   * Setter method for Name
   * @param name Name of the Variable
   */
  public void setName(String name)
  {
    this.name = name;
  }
  
}


  
  