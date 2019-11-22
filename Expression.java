/**
 * An abstract generic class representing the Expression
 * @author Ishaan Gupta
 */
public interface Expression<T>{
  
 /**
   * Calculates value of operations
   * Method stub in every Operation
   * @param  s  State where operands are stored
   * @return Generic value of the final result after operation
   */
  public T value(State s);
  
  /**
   * Returns string representation of the arithmetic operation
   * Method stub in every Operation 
   * @return string representation according to each operation
   */  
  public String toString();
  
}
  