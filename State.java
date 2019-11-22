import java.util.Hashtable;

/**
 * A memory pool represeting variables and their contents
 * @author Ishaan Gupta
 */
public class State 
{
  //Initialization and Declaration of Instance of Hashtable   
  private Hashtable<String, Integer> hash = new Hashtable<String,Integer>();
  
  
  /**
   * This method takes a string and integer value and puts them into the hashtable
   * @param varName Name of the variable
   * @param varValue Value stored in the variable
   */
  public void update (String varName, Integer varValue)
  {    
    hash.put(varName,varValue);
  }
  
  /**
   * This method checks the parameter passed into the hashtable
   * If the varibale name is found, returns value stored in the variable name
   * If the variable name isnt found, returns value 0
   * @param varName  Name of the variable to be searched
   * @return Intger value stored in the variable or 0
   */
  
  public Integer lookup (String varName)
  {
     if(hash.containsKey(varName) == true)
      return hash.get(varName);
     return 0;
  }      
  
}

    
  