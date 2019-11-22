/**
 * An Abstract class representing the Statement  
 * @author Ishaan Gupta
 */
public abstract class Statement
{
  /**
   * Abstract method stub to execute 
   * @param s  State where variables and their contents are stored
   */
  public abstract void execute (State s);
  
  /**
   * Abstract method stub to return string representation
   * @return String representation
   */
  public abstract String toString();
  
  /**
   * Returns a string representation along with space tabs
   * @param numTabs  Number of space tabs to be included in the string
   * @return String representation including space tabs
   */  
  public String toStringTabbed(Integer numTabs)
  {
    int i = 0;
    StringBuilder sen = new StringBuilder();    
    
    /**
     * Loop to append space tabs
     * Pre-Condition: numTabs >0
     * Start with i = 0
     * Ends when the number of space tabs to be appended are done
     */
    while(i < numTabs - 1)
    {
      sen.append("\t");
      i++;
    }
    return sen.toString();
  }
  
    

}