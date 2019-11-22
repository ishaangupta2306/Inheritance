import org.junit.*;
import static org.junit.Assert.*;

public class HW3
{
  /**
   * Test for the State class
   */
  @Test
  public void testLookup()
  {
    State s = new State();
    s.update("r", 5);
    assertEquals("Method is testing no value associated with variable name 't'", new Integer(0), s.lookup("t"));
    assertEquals("Method is testing a value of integer 4 associated with variable name 'x'", new Integer(5), s.lookup("r"));
  }
  
  @Test
  public void testUpdate()
  {    
    State s = new State();
    s.update("r", 5);
    assertEquals("Method is testing assigning value 5 to 'r'", new Integer(5), s.lookup("r"));
  }
  
  /**
   * Test for the Variable class
   */
  
  @Test
  public void testVariableConstructor()
  {
    Variable v = new Variable("x");
    assertEquals("Method is testing assigning value 'x' to variable", "x", v.getName());
  }
  
  @Test
  public void testVariableSetName()
  {
    Variable v = new Variable("x");
    v.setName("g");
    assertEquals("Method is testing assigning value 'x' to variable", "g", v.getName());
  }
  
  @Test
  public void testVariableValue()
  {
    
    State s = new State();
    Variable v = new Variable("x");
    Variable u = new Variable("s");
    s.update("x",4);
    assertEquals("Method is testing looking value 'x' in the State",new Integer(4),v.value(s));
    assertEquals("Method is testing looking value 's' in the State",new Integer(0),u.value(s));
  }
  
    @Test
  public void testVariableGetName()
  {
    Variable v = new Variable("x");   
    assertEquals("Method is testing getting the name of the variable","x",v.getName());
    }
    
  @Test
  public void testVariabletoString()
  {
    Variable v = new Variable("e");
    assertEquals("Method is testing getting string representation of string 'x' from variable instance", "e", v.toString());
  }
  
  
  /**
   * Test for the Number class
   */
    @Test
  public void testNumber()
  {
    Number num = new Number(1);
    assertEquals("Method is testing if constructor properly assigns integer 1 to new number instance", new Integer(1), num.getNumber());
  }
  
  @Test
  public void testGetNumberValue()
  {
    Number num = new Number(1);
    assertEquals("Method is testing getting integer 1 from number instance", new Integer(1), num.getNumber());
  }
  
  @Test
  public void testSetNumberValue()
  {
    Number num = new Number(5);
    num.setNumber(3);
    assertEquals("Method is testing setting integer 3 to number instance test", new Integer(3), num.getNumber());
  }
  
  @Test
  public void testNumberValue()
  {
    State s = new State();
    Number num = new Number(10);
    assertEquals("Method is testing getting the integer of value 10 from number instance test", new Integer(10), num.value(s));
  }
  
  @Test
  public void testToString()
  {
    Number num = new Number(65);
    assertEquals("Method is testing extracting a string representation of integer value of 65 from number instance test", "65", num.toString());
  }
  
  /**
   * Test for the ArithmeticOperation class
   */
  
  @Test
  public void testArithmeticOperation() 
  {
    Number s = new Number(10);
    Number t = new Number(20);
    ArithmeticOperation a = new ArithmeticOperation(ArithmeticOperation.Operator.Add, s, t);
    
    assertEquals("Method is testing whether the constructor assigns value perfectly to operator",ArithmeticOperation.Operator.Add,a.getOperatorAddress());
    assertEquals("Method is testing whether the constructor assigns value perfectly to leftOperand",s,a.getLeftOperand());
    assertEquals("Method is testing whether the constructor assigns value perfectly to operator",t,a.getRightOperand());
  }
  
  @Test
  public void testArithmeticOperationSetLeftOperand() /* Also tests getter method */
  {
    //Since this setter method is common to all operations, thus tested only once here
    State t = new State();
    Number s = new Number(10);
    Variable v = new Variable("v");
    t.update("v",34);
    ArithmeticOperation a = new ArithmeticOperation(ArithmeticOperation.Operator.Add, s, v);
    ArithmeticOperation b = new ArithmeticOperation(ArithmeticOperation.Operator.Sub, s, v);    a.setLeftOperand(b);
    
    assertEquals("Method is testing setter method for leftOperand works perfectly",b,a.getLeftOperand());
  }
  
  @Test
  public void testArithmeticOperationSetRightOperand() /* Also tests getter method */
  {
    //Since this setter method is common to all operations, thus tested only once here
    State t = new State();
    Number s = new Number(10);
    Variable v = new Variable("v");
    t.update("v",34);
    ArithmeticOperation a = new ArithmeticOperation(ArithmeticOperation.Operator.Add, s, v);
    Assignment b = new Assignment(v,s);
    a.setRightOperand(b);    
    assertEquals("Method is testing setter method for rightOperand works perfectly",b,a.getRightOperand());
  }
  
  @Test
  public void testArithmeticOperationSetOperator() /* Also tests getter method */
  {
    //Since this setter method is common to all operations, thus tested only once here
    State t = new State();
    Number s = new Number(10);
    Variable v = new Variable("v");
    t.update("v",34);
    ArithmeticOperation a = new ArithmeticOperation(ArithmeticOperation.Operator.Add, s, v);
    a.setOperator("-");
    assertEquals("Method is testing setter method for string operator works perfectly","-",a.getOperator());
  }
  
  @Test
  public void testArithmeticOperationValue()
  {   
    State state = new State();    
    Variable v = new Variable("v");
    state.update("v",34);
    
    ArithmeticOperation Add = new ArithmeticOperation (ArithmeticOperation.Operator.Add, new Number(12),v);
    assertEquals("Method is testing if the value of the result is integer with value of 18 if operation is addition", new Integer(46), Add.value(state));
        
    ArithmeticOperation Sub = new ArithmeticOperation (ArithmeticOperation.Operator.Sub, Add, new Number(6));
    assertEquals("Method is testing if the value of the result is integer with value of 40 if operation is subtraction", new Integer(40), Sub.value(state));
    
    Variable v1 = new Variable("v1");
    Assignment b = new Assignment(v1,Sub);
    ArithmeticOperation Mult = new ArithmeticOperation (ArithmeticOperation.Operator.Mult, new Number(12), b);
    assertEquals("Method is testing if the value of the result is integer with value of 480 if operation is multiplication", new Integer(480), Mult.value(state));
    
    ArithmeticOperation Div = new ArithmeticOperation (ArithmeticOperation.Operator.Div, new Number(12), new Number(6));
    assertEquals("Method is testing if the value of the result is integer with value of 2 if operation is division", new Integer(2), Div.value(state));
    
    ArithmeticOperation Rem = new ArithmeticOperation (ArithmeticOperation.Operator.Rem, new Number(12), new Number(6));
    assertEquals("Method is testing if the value of the result is integer with value of 0 if operation is modulus division", new Integer(0), Rem.value(state));
  }
  
  @Test
  public void testArithmeticOperationToString()
  {
    ArithmeticOperation Add = new ArithmeticOperation (ArithmeticOperation.Operator.Add, new Number(12), new Number(6));
    assertEquals("Method is testing getting string representation of the arithmetic operation", "12 + 6", Add.toString());
  
    ArithmeticOperation Sub = new ArithmeticOperation (ArithmeticOperation.Operator.Sub, new Number(12), new Number(6));
    assertEquals("Method is testing getting string representation of the arithmetic operation", "12 - 6", Sub.toString());

    
    ArithmeticOperation Mult = new ArithmeticOperation (ArithmeticOperation.Operator.Mult, new Number(12), new Number(6));
    assertEquals("Method is testing getting string representation of the arithmetic operation", "12 * 6", Mult.toString());
     
    ArithmeticOperation Div = new ArithmeticOperation (ArithmeticOperation.Operator.Div, new Number(12), new Number(6));
    assertEquals("Method is testing getting string representation of the arithmetic operation", "12 / 6", Div.toString());
      
    ArithmeticOperation Rem = new ArithmeticOperation (ArithmeticOperation.Operator.Rem, new Number(12), new Number(6));
    assertEquals("Method is testing getting string representation of the arithmetic operation", "12 % 6", Rem.toString());
  }
  
  /**
   * Test for the Comparison class
   */
   @Test
  public void testComparisonConstructor()
  { 
    //Testing number-number as operands
    Number s = new Number(10);
    Number t = new Number(20);
    Comparison c = new Comparison (Comparison.Operator.LT, s, t);
    assertEquals("Method is testing if constructor properly assigned '<' operator to new comparison operation instance", Comparison.Operator.LT, c.getOperatorAddress());
    assertEquals("Method is testing if constructor properly assigned the number expression with address of leftOperand", s, c.getLeftOperand());
    assertEquals("Method is testing if constructor properly assigned the number expression with address of rightOperand", t, c.getRightOperand());
  
    //Testing variable - variable as operands
    State state = new State();
    Variable v = new Variable("x");
    Variable u = new Variable("d");
    state.update("x",12);
    state.update("d",6);
    
    Comparison c1 = new Comparison (Comparison.Operator.LTE, v, u);
    assertEquals("Method is testing if constructor properly assigned '<' operator to new comparison operation instance", Comparison.Operator.LTE, c1.getOperatorAddress());
    assertEquals("Method is testing if constructor properly assigned the number expression with address of leftOperand", v, c1.getLeftOperand());
    assertEquals("Method is testing if constructor properly assigned the number expression with address of rightOperand", u, c1.getRightOperand());
  
    //Testing variable - number as operands
    State state2 = new State();
    Variable v2 = new Variable("x");  
    Number num = new Number(6);
    state2.update("x",12);
   
    
    Comparison c2 = new Comparison (Comparison.Operator.GTE, v2, num);
    assertEquals("Method is testing if constructor properly assigned '<' operator to new comparison operation instance", Comparison.Operator.GTE, c2.getOperatorAddress());
    assertEquals("Method is testing if constructor properly assigned the number expression with address of leftOperand", v2, c2.getLeftOperand());
    assertEquals("Method is testing if constructor properly assigned the number expression with address of rightOperand", num, c2.getRightOperand());
   
   }
   
   @Test
  public void testSetComparisonOperation() /* Also tests Getter method for comparison operation*/
  {
    Comparison c1 = new Comparison (Comparison.Operator.LT, new Number(4), new Number(3));
    c1.setOperatorAddress(Comparison.Operator.LTE);
    assertEquals("Method is testing if setting operation works fine", Comparison.Operator.LTE, c1.getOperatorAddress());
  }
   
     @Test
  public void testComparisonValue()
  {
    State state = new State();
    Variable v = new Variable("x");  
    Number u = new Number(6);
    state.update("x",12);
   
    
    Comparison c1 = new Comparison (Comparison.Operator.LT, v,u); /*testing less than operator*/
    assertFalse("Method is testing if the value of the result is boolean with value of false", c1.value(state));
    c1.setLeftOperand(u);
    c1.setRightOperand(v);
    assertTrue("Method is testing if the value of the result is boolean with value of true if left is 3 and right is 4", c1.value(state));
    
    
    /*testing less than or equal to operator*/
    c1.setOperatorAddress(Comparison.Operator.LTE);  
    assertTrue("Method is testing if the value of the result is true", c1.value(state));
    
    c1.setLeftOperand(new Number(12));
    assertTrue("Method is testing if the value of the result is true if values are same", c1.value(state));   
    
    c1.setLeftOperand(new Number(20));    
    assertFalse("Method is testing if the value of the result is false", c1.value(state));  
    
    
    /*testing Greater than operator*/
    c1.setOperatorAddress(Comparison.Operator.GT);  
    assertTrue("Method is testing if the value of the result is true", c1.value(state));
    
    c1.setLeftOperand(new Number(12));
    assertFalse("Method is testing if the value of the result is true if values are same", c1.value(state));   
    
    c1.setLeftOperand(new Number(1));    
    assertFalse("Method is testing if the value of the result is false", c1.value(state));  
    
   
    /*testing Greater than or Equal to operator*/
    c1.setOperatorAddress(Comparison.Operator.GTE);  
    assertFalse("Method is testing if the value of the result is false", c1.value(state));
    
    c1.setLeftOperand(new Number(12));
    assertTrue("Method is testing if the value of the result is true if values are same", c1.value(state));   
    
    c1.setRightOperand(new Number(1));    
    assertTrue("Method is testing if the value of the result is True", c1.value(state));  
    
    
    /*testing Equality operator*/
    c1.setOperatorAddress(Comparison.Operator.EQ);  
    assertFalse("Method is testing if the value of the result is false", c1.value(state));
    
    c1.setLeftOperand(new Number(1));
    assertTrue("Method is testing if the value of the result is true if values are same", c1.value(state));   
    
    c1.setRightOperand(new Number(12));    
    assertFalse("Method is testing if the value of the result is False", c1.value(state));  
    
    
    
    /*testing Not Equality operator*/
    c1.setOperatorAddress(Comparison.Operator.EQ);  
    assertFalse("Method is testing if the value of the result is false", c1.value(state));
    
    c1.setRightOperand(new Number(1));
    assertTrue("Method is testing if the value of the result is true if values are same", c1.value(state));   
    
    c1.setRightOperand(new Number(12));    
    assertFalse("Method is testing if the value of the result is False", c1.value(state));  
    
     }
     
    @Test
  public void testComparisonToString()
  {
    State s = new State();  
    Variable v = new Variable("x");
    s.update("x",12);
    Number n = new Number(3);
    
    Comparison c1 = new Comparison (Comparison.Operator.LT, v,n);
    assertEquals("Method is testing getting string representation","x < 3", c1.toString());
  }
    
  /**
   * Test for the BooleanOperation class
   */
    @Test
  public void testBooleanOperationConstructor()  
  {
    
    Comparison c1 = new Comparison (Comparison.Operator.LT, new Number(4), new Number(3));
    Comparison c2 = new Comparison (Comparison.Operator.LT, new Number(3), new Number(2));
    
    BooleanOperation b = new BooleanOperation (BooleanOperation.Operator.And,c1,c2);
    assertEquals("Method Tests if constructor properly assigns And operator to new boolean operation instance test", BooleanOperation.Operator.And, b.getOperatorAddress());
    assertEquals("Method Tests if constructor properly assigns '4 < 3' expression address to new boolean operation instance test", c1, b.getLeftOperand());
    assertEquals("Method Tests if constructor properly assigns '3 < 2' expression address to new boolean operation instance test", c2, b.getRightOperand());
  }
    
    @Test
  public void testSetBooleanOperation() /* Also tests Getter method for comparison operation */
  {
    Comparison c1 = new Comparison (Comparison.Operator.LT, new Number(4), new Number(3));
    Comparison c2 = new Comparison (Comparison.Operator.LT, new Number(3), new Number(2));    
    BooleanOperation b = new BooleanOperation (BooleanOperation.Operator.And,c1,c2);
    
    b.setOperatorAddress(BooleanOperation.Operator.Or);
    assertEquals("Method Tests if this method sets operator to '||'", BooleanOperation.Operator.Or, b.getOperatorAddress());
  }
      
    
  @Test
  public void testBooleanOperationValue()
  {
    State state = new State();
    /* Tests for And operator */   
    BooleanOperation b1 = new BooleanOperation (BooleanOperation.Operator.And, new Comparison (Comparison.Operator.LT, new Number(7), new Number(6)), new Comparison (Comparison.Operator.LT, new Number(20), new Number(2))); 
    assertFalse("Method Tests if the value of the result false if left comparison is false and right comparison is false", b1.value(state));
    
    BooleanOperation b2 = new BooleanOperation (BooleanOperation.Operator.And, new Comparison (Comparison.Operator.LT, new Number(25), new Number(36)), new Comparison (Comparison.Operator.LT, new Number(31), new Number(12)));
    assertFalse("Method Tests if the value of the result false if left comparison is true and right comparison is false", b2.value(state));
    
    BooleanOperation b3 = new BooleanOperation (BooleanOperation.Operator.And, new Comparison (Comparison.Operator.LT, new Number(41), new Number(31)), new Comparison (Comparison.Operator.LT, new Number(14), new Number(2)));
    assertFalse("Method Tests if the value of the result is false if left comparison is false and right comparison is true", b3.value(state));
    
    BooleanOperation b4 = new BooleanOperation (BooleanOperation.Operator.And, new Comparison (Comparison.Operator.LT, new Number(33), new Number(45)), new Comparison (Comparison.Operator.LT, new Number(17), new Number(27)));
    assertTrue("Method Tests if the value of the result is true if left comparison is true and right comparison is true", b4.value(state));
    
    
    /* Tests for Or operator */
    BooleanOperation b5 = new BooleanOperation (BooleanOperation.Operator.Or, new Comparison (Comparison.Operator.LT, new Number(42), new Number(33)), new Comparison (Comparison.Operator.LT, new Number(31), new Number(25)));  
    assertFalse("Method Tests if the value of the result is false if left comparison is false and right comparison is false", b5.value(state));
    
    BooleanOperation b6 = new BooleanOperation (BooleanOperation.Operator.Or, new Comparison (Comparison.Operator.LT, new Number(21), new Number(39)), new Comparison (Comparison.Operator.LT, new Number(35), new Number(28)));
    assertTrue("Method Tests if the value of the result is true if left comparison is true and right comparison is false", b6.value(state));
    
    BooleanOperation b7 = new BooleanOperation (BooleanOperation.Operator.Or, new Comparison (Comparison.Operator.LT, new Number(42), new Number(34)), new Comparison (Comparison.Operator.LT, new Number(10), new Number(21)));
    assertTrue("Method Tests if the value of the result true if left comparison is false and right comparison is true", b7.value(state));
    
    BooleanOperation b8 = new BooleanOperation (BooleanOperation.Operator.And, new Comparison (Comparison.Operator.LT, new Number(38), new Number(48)), new Comparison (Comparison.Operator.LT, new Number(10), new Number(29)));
    assertTrue("Method Tests if the value of the result is true if left comparison is true and right comparison is true", b8.value(state));
    
  }
  
  @Test
  public void testBooleanToString()
  {
    BooleanOperation b = new BooleanOperation (BooleanOperation.Operator.And, new Comparison (Comparison.Operator.LT, new Number(44), new Number(36)), new Comparison (Comparison.Operator.LT, new Number(31), new Number(12)));
    assertEquals("Method Tests getting string representation of boolean operation instance", "44 < 36 && 31 < 12", b.toString());
  }
  
  
  /**
   * Test for the Assignment class
   */
  
   @Test
  public void testAssignmentConstructor()
   {
     Variable v = new Variable("x");
     ArithmeticOperation o = new ArithmeticOperation(ArithmeticOperation.Operator.Add, new Number(12), new Number(6));
     Assignment a = new Assignment(v,o);
     assertEquals("Method Tests if constructor assigns the Variable correctly",v,a.getVariable());
     assertEquals("Method Tests if constructor assigns the Expression correctly",o,a.getExpression());
     
   }
   
   @Test
  public void testAssignmentSetExpression() /* Also tests Getter method for Expression */
  {
     Variable v = new Variable("x");
     ArithmeticOperation o = new ArithmeticOperation(ArithmeticOperation.Operator.Add, new Number(12), new Number(6));
     Assignment a = new Assignment(v,o);
     ArithmeticOperation p = new ArithmeticOperation(ArithmeticOperation.Operator.Sub, new Number(12), new Number(6));
     a.setExpression(p);
     assertEquals("Method Tests if this method sets expression correctly",p, a.getExpression());
  }
   
   @Test
  public void testAssignmentSetVariable() /* Also tests Getter method for Variable */
  {
     Variable v = new Variable("x");
     ArithmeticOperation o = new ArithmeticOperation(ArithmeticOperation.Operator.Add, new Number(12), new Number(6));
     Assignment a = new Assignment(v,o);
     Variable u = new Variable("d");     
     a.setVariable(u);
     assertEquals("Method Tests if this method sets expression correctly",u, a.getVariable());
  }
   
   @Test
   public void testAssignmentExecute()
   {
     State s = new State();
     Variable v = new Variable("x");
     ArithmeticOperation o = new ArithmeticOperation(ArithmeticOperation.Operator.Add, new Number(12), new Number(6));
     Assignment a = new Assignment(v,o);
     a.execute(s);
     assertEquals("Tests if this method updates the state with the variable and expression correctly",o.value(s),s.lookup(v.getName()));
   }
   
   @Test
   public void testAssignmentValue()
   {
     State s = new State();
     Variable v = new Variable("x");
     ArithmeticOperation o = new ArithmeticOperation(ArithmeticOperation.Operator.Add, new Number(12), new Number(6));
     Assignment a = new Assignment(v,o);
     Integer b = a.value(s);
     assertEquals("Tests if this method updates the state with the variable and expression correctly",o.value(s),s.lookup(v.getName()));
     assertEquals("Tests if this method returns the expression correctly",o.value(s),b);
   }
   
   @Test
   public void testAssignmentToString()
   {    
     State s = new State();
     Variable v = new Variable("x");
     ArithmeticOperation o = new ArithmeticOperation(ArithmeticOperation.Operator.Add, new Number(12), new Number(6));
     Assignment a = new Assignment(v,o);
     assertEquals("Tests if the the string representation returned is correct","" + v.toString() + " := " + o.toString() + ";\n", a.toString());
   }
   
   @Test
   public void testAssignmentToStringTabbed()  
   {
     //Test 0 means with
     State s = new State();
     Variable v = new Variable("x");
     ArithmeticOperation o = new ArithmeticOperation(ArithmeticOperation.Operator.Add, new Number(12), new Number(6));
     Assignment a = new Assignment(v,o);
     assertEquals("Tests if the the string representation returned is correct","" + v.toString() + " := " + o.toString() + ";\n", a.toStringTabbed(0));
  
     //Test 1 means 1 space tabs
     assertEquals("Tests if the the string representation returned is correct","\t" + v.toString() + " := " + o.toString() + ";\n", a.toStringTabbed(1));
     
     //Test Many means more than 1 space tabs
     assertEquals("Tests if the the string representation returned is correct","\t\t\t" + v.toString() + " := " + o.toString() + ";\n", a.toStringTabbed(3));
   }
   
   
   /**
    * Test for the Return class
    */
  
   @Test
   public void testReturnConstructor()
   {
     ArithmeticOperation a = new ArithmeticOperation(ArithmeticOperation.Operator.Add, new Number(10), new Number(3));
     Return ret = new Return(a);
     
     assertEquals("Tests if the constructor assigns the expression correctly",a,ret.getExpression());
   }
   
   @Test
   public void testReturnSetExpression() /* Also tests Getter method for Expression */
   {
     ArithmeticOperation a = new ArithmeticOperation(ArithmeticOperation.Operator.Add, new Number(10), new Number(3));
     Return ret = new Return(a);
     ArithmeticOperation b = new ArithmeticOperation(ArithmeticOperation.Operator.Sub, new Number(10), new Number(3));
     ret.setExpression(b);
     assertEquals("Tests if the setter method of Expression sets new Expression correctly",b,ret.getExpression());
   }
   
   @Test
   public void testReturnExecute()
   {
     State s = new State();
     ArithmeticOperation a = new ArithmeticOperation(ArithmeticOperation.Operator.Add, new Number(10), new Number(3));
     Return ret = new Return(a);
     ret.execute(s);
     assertEquals("Tests if the execute method updates the expression to return correctly",a.value(s),s.lookup("return"));
   }
   
   @Test
   public void testReturnToString()
   {
     State s = new State();
     ArithmeticOperation a = new ArithmeticOperation(ArithmeticOperation.Operator.Add, new Number(10), new Number(3));
     Return ret = new Return(a); 
     assertEquals("Tests if the string representation of Return is correct","return " + a.toString() + ";\n",ret.toString());
   }
   
   @Test
   public void testReturnToStringTabbed()
   {
     //Test 0
     State s = new State();
     ArithmeticOperation a = new ArithmeticOperation(ArithmeticOperation.Operator.Add, new Number(10), new Number(3));
     Return ret = new Return(a); 
     assertEquals("Tests if the string representation of Return is correct","return " + a.toString() + ";\n",ret.toStringTabbed(0));
     
     //Test 1
     State s1 = new State();
     ArithmeticOperation a1 = new ArithmeticOperation(ArithmeticOperation.Operator.Add, new Number(10), new Number(3));
     Return ret1 = new Return(a1); 
     assertEquals("Tests if the string representation of Return is correct","\treturn " + a1.toString() + ";\n",ret1.toStringTabbed(1));
     
     //Test Many
     State s2 = new State();
     ArithmeticOperation a2 = new ArithmeticOperation(ArithmeticOperation.Operator.Add, new Number(10), new Number(3));
     Return ret2 = new Return(a2); 
     assertEquals("Tests if the string representation of Return is correct","\t\t\treturn " + a2.toString() + ";\n",ret2.toStringTabbed(3));
   }
   
   /**
    * Tests for the ConditionalStatement class
    */
  
   @Test
   public void testConditionalStatementConstructor()
   {
     BooleanOperation b = new BooleanOperation(BooleanOperation.Operator.And,new Comparison(Comparison.Operator.LT, new Number(10),new Number(2)),new Comparison(Comparison.Operator.GT, new Number(10),new Number(2)) );
     Variable v = new Variable("x");
     Assignment a = new Assignment(v, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, new Number(2), new Number(5)));
     Return r = new Return(new Number(8));
     ConditionalStatement c = new ConditionalStatement(b,a,r);
     
     assertEquals("Tests if constructor initializes the condition correctly", b,c.getCondition());
     assertEquals("Tests if constructor initializes the thenStatement correctly",a,c.getThenStatement());
     assertEquals("Tests if constructor initializes the elseStatement correctly",r,c.getElseStatement());
   }
   
   @Test
   public void testSetCondition()/* Also test getter method */
   {
     BooleanOperation b = new BooleanOperation(BooleanOperation.Operator.And,new Comparison(Comparison.Operator.LT, new Number(10),new Number(2)),new Comparison(Comparison.Operator.GT, new Number(10),new Number(2)) );
     Variable v = new Variable("x");
     Assignment a = new Assignment(v, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, new Number(2), new Number(5)));
     Return r = new Return(new Number(8));
     ConditionalStatement c = new ConditionalStatement(b,a,r);
     BooleanOperation b2 = new BooleanOperation(BooleanOperation.Operator.Or,new Comparison(Comparison.Operator.GT, new Number(10),new Number(2)),new Comparison(Comparison.Operator.LT, new Number(10),new Number(2)) );
     c.setCondition(b2);
     assertEquals("Tests if the setter method of the condition works correctly", b2, c.getCondition());
   }
     
     
   @Test
   public void testSetThenStatement() /* Also test getter method */
   {
     BooleanOperation b = new BooleanOperation(BooleanOperation.Operator.And,new Comparison(Comparison.Operator.LT, new Number(10),new Number(2)),new Comparison(Comparison.Operator.GT, new Number(10),new Number(2)) );
     Variable v = new Variable("x");
     Assignment a = new Assignment(v, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, new Number(2), new Number(5)));
     Return r = new Return(new Number(8));
     ConditionalStatement c = new ConditionalStatement(b,a,r);
     Assignment a2 = new Assignment(v, new ArithmeticOperation(ArithmeticOperation.Operator.Sub, new Number(25), new Number(55)));
     c.setThenStatement(a2);
     assertEquals("Tests if the setter method of then statement works correctly",a2,c.getThenStatement());
   }
   
   @Test
   public void testSetElseStatement()/* Also test getter method */
   {
     BooleanOperation b = new BooleanOperation(BooleanOperation.Operator.And,new Comparison(Comparison.Operator.LT, new Number(10),new Number(2)),new Comparison(Comparison.Operator.GT, new Number(10),new Number(2)) );
     Variable v = new Variable("x");
     Assignment a = new Assignment(v, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, new Number(2), new Number(5)));
     Return r = new Return(new Number(8));
     ConditionalStatement c = new ConditionalStatement(b,a,r);
     Return r2 = new Return(new Number(48));
     c.setElseStatement(r2);
     assertEquals("Tests if the setter method of the condition works correctly", r2, c.getElseStatement());
   }
     
     
   
   @Test
   public void testConditionalStatementExecute()
   {
     State s = new State();
     /* If the condition is false */
     BooleanOperation b = new BooleanOperation(BooleanOperation.Operator.And,new Comparison(Comparison.Operator.LT, new Number(10),new Number(2)),new Comparison(Comparison.Operator.GT, new Number(10),new Number(2)) );
     Variable v = new Variable("x");
     Assignment a = new Assignment(v, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, new Number(2), new Number(5)));
     Return r = new Return(new Number(8));
     ConditionalStatement c = new ConditionalStatement(b,a,r);
     c.execute(s);
     assertEquals("Test whether the execute method works correctly",new Integer (8),s.lookup("return"));
     
     /* If the condition is true */
     BooleanOperation b1 = new BooleanOperation(BooleanOperation.Operator.Or,new Comparison(Comparison.Operator.LT, new Number(10),new Number(2)),new Comparison(Comparison.Operator.GT, new Number(10),new Number(2)) );
     Variable v1 = new Variable("x");
     Assignment a1 = new Assignment(v1, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, new Number(2), new Number(5)));
     Return r1 = new Return(new Number(8));
     ConditionalStatement c1 = new ConditionalStatement(b1,a1,r1);
     c1.execute(s);
     assertEquals("Test whether the execute method works correctly",a1.value(s),s.lookup(v.getName()));
   }
   
   
   @Test
   public void testConditionalStatementToString()
   {
     State s = new State();
     BooleanOperation b = new BooleanOperation(BooleanOperation.Operator.And,new Comparison(Comparison.Operator.LT, new Number(10),new Number(2)),new Comparison(Comparison.Operator.GT, new Number(10),new Number(2)) );
     Variable v = new Variable("x");
     Assignment a = new Assignment(v, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, new Number(2), new Number(5)));
     Return r = new Return(new Number(8));
     ConditionalStatement c = new ConditionalStatement(b,a,r);
     assertEquals("Tests if the string representation of conditionalStatement works correctly","if (" + b.toString() + ")\n" + a.toStringTabbed(1) + "else\n" + r.toStringTabbed(1),c.toString());
   }
   
   
    
   @Test
   public void testConditionalStatementToStringTabbed()
   {
     // Test 0 : Test with no space tabs
     State s = new State();
     BooleanOperation b = new BooleanOperation(BooleanOperation.Operator.And,new Comparison(Comparison.Operator.LT, new Number(10),new Number(2)),new Comparison(Comparison.Operator.GT, new Number(10),new Number(2)) );
     Variable v = new Variable("x");
     Assignment a = new Assignment(v, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, new Number(2), new Number(5)));
     Return r = new Return(new Number(8));
     ConditionalStatement c = new ConditionalStatement(b,a,r);
     assertEquals("Tests if the string representation of conditionalStatement works correctly","if (" + b.toString() + ")\n" + a.toStringTabbed(0+1) + "else\n" + r.toStringTabbed(0+1),c.toStringTabbed(0));
  
     // Test 1 : Test with one space tabs
     State s1 = new State();
     BooleanOperation b1 = new BooleanOperation(BooleanOperation.Operator.And,new Comparison(Comparison.Operator.LT, new Number(10),new Number(2)),new Comparison(Comparison.Operator.GT, new Number(10),new Number(2)) );
     Variable v1 = new Variable("x");
     Assignment a1 = new Assignment(v1, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, new Number(2), new Number(5)));
     Return r1 = new Return(new Number(8));
     ConditionalStatement c1 = new ConditionalStatement(b1,a1,r1);
     assertEquals("Tests if the string representation of conditionalStatement works correctly","\tif (" + b1.toString() + ")\n" + a1.toStringTabbed(1+1) + "\telse\n" + r1.toStringTabbed(1+1),c1.toStringTabbed(1));
  
    
     // Test Many : Test with more than one space tabs
     State s2 = new State();
     BooleanOperation b2 = new BooleanOperation(BooleanOperation.Operator.And,new Comparison(Comparison.Operator.LT, new Number(10),new Number(2)),new Comparison(Comparison.Operator.GT, new Number(10),new Number(2)) );
     Variable v2 = new Variable("x");
     Assignment a2 = new Assignment(v2, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, new Number(2), new Number(5)));
     Return r2 = new Return(new Number(8));
     ConditionalStatement c2 = new ConditionalStatement(b2,a2,r2);
     assertEquals("Tests if the string representation of conditionalStatement works correctly","\t\t\tif (" + b2.toString() + ")\n" + a2.toStringTabbed(3+1) + "\t\t\telse\n" + r2.toStringTabbed(3+1),c2.toStringTabbed(3));
   }
   
   /**
    * Test for the Loop class
    */
  
   @Test
   public void testLoopConstructor()
   {
     Variable v = new Variable("x");
     BooleanOperation b = new BooleanOperation(BooleanOperation.Operator.And,new Comparison(Comparison.Operator.LT, new Number(10),new Number(2)),new Comparison(Comparison.Operator.GT, new Number(10),new Number(2)));
     Assignment a = new Assignment(v, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, new Number(2), new Number(5)));
     Loop l = new Loop(b,a);
     assertEquals("Tests if constructor initializes the boolean condition correctly",b,l.getCondition());
     assertEquals("Tests if constructor initializes the Statement correctly",a,l.getBody());
   }
   
   @Test
   public void testLoopSetCondition() /* Also test getter method */
   {
     Variable v = new Variable("x");
     BooleanOperation b = new BooleanOperation(BooleanOperation.Operator.And,new Comparison(Comparison.Operator.LT, new Number(10),new Number(2)),new Comparison(Comparison.Operator.GT, new Number(10),new Number(2)));
     Assignment a = new Assignment(v, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, new Number(2), new Number(5)));
     Loop l = new Loop(b,a);
     BooleanOperation b1 = new BooleanOperation(BooleanOperation.Operator.Or,new Comparison(Comparison.Operator.GT, new Number(10),new Number(2)),new Comparison(Comparison.Operator.GT, new Number(10),new Number(2)));
     l.setCondition(b1);
     assertEquals("Test if the setter method of the condition of the loop works correctly",b1,l.getCondition());
   }
   
   @Test
   public void testLoopSetBody() /* Also test getter method */
   {
     Variable v = new Variable("x");
     BooleanOperation b = new BooleanOperation(BooleanOperation.Operator.And,new Comparison(Comparison.Operator.LT, new Number(10),new Number(2)),new Comparison(Comparison.Operator.GT, new Number(10),new Number(2)));
     Assignment a = new Assignment(v, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, new Number(2), new Number(5)));
     Loop l = new Loop(b,a);
     Assignment a1 = new Assignment(v, new ArithmeticOperation(ArithmeticOperation.Operator.Sub, new Number(24), new Number(5)));
     l.setBody(a1);
     assertEquals("Test if the setter method of the condition of the loop works correctly",a1,l.getBody());
   }
   
   @Test
   public void testLoopExecute()
   {
     /* Test 0 (loop condition is false) */
     State s = new State();
     Variable v = new Variable("x");
     BooleanOperation b = new BooleanOperation(BooleanOperation.Operator.And,new Comparison(Comparison.Operator.LT, new Number(10),new Number(2)),new Comparison(Comparison.Operator.GT, new Number(10),new Number(2)));
     Assignment a = new Assignment(v, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, new Number(2), new Number(5)));
     Loop l = new Loop(b,a);
     l.execute(s);
     assertEquals("Tests execute works correctly",new Integer(0),s.lookup(v.getName()));
     
     /* Test 1 (loop condition gets false after one iteration) */
     State s1 = new State();
     Variable x = new Variable("x");
     Assignment increment = new Assignment(x, new ArithmeticOperation(ArithmeticOperation.Operator.Add, x, new Number(1)));
     s1.update("x",2);
     Variable result = new Variable("result");
     Assignment sumUpdate = new Assignment(result, new ArithmeticOperation(ArithmeticOperation.Operator.Add, result, x));
     Comparison c = new Comparison(Comparison.Operator.LT, x, new Number(3));
     Loop loop = new Loop(c, new CompoundStatement(sumUpdate, increment));     
     loop.execute(s1);
     assertEquals("Tests execute works correctly",new Integer(3),s1.lookup(x.getName()));
     
     /* Test Many (loop condition gets false after more than one iteration) */
     State s2 = new State();
     Variable y = new Variable("y");
     Assignment increment2 = new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Add, y, new Number(1)));
     s2.update("y",2);
     Variable result2 = new Variable("result2");
     Assignment sumUpdate2 = new Assignment(result2, new ArithmeticOperation(ArithmeticOperation.Operator.Add, result2, y));
     Comparison c2 = new Comparison(Comparison.Operator.LT, y, new Number(6));
     Loop loop2 = new Loop(c2, new CompoundStatement(sumUpdate2, increment2));     
     loop2.execute(s2);
     assertEquals("Tests execute works correctly",new Integer(6),s2.lookup(y.getName())); 
   }
    
   @Test
   public void testLoopToString()
   {
     State s = new State();
     Variable v = new Variable("x");
     BooleanOperation b = new BooleanOperation(BooleanOperation.Operator.And,new Comparison(Comparison.Operator.LT, new Number(10),new Number(2)),new Comparison(Comparison.Operator.GT, new Number(10),new Number(2)));
     Assignment a = new Assignment(v, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, new Number(2), new Number(5)));
     Loop l = new Loop(b,a);
     
     assertEquals("Tests if the string representation of the loop is correct","while (" + b.toString() + ")\n" + a.toStringTabbed(1),l.toString());
   }
   
   
   @Test
   public void testLoopToStringTabbed()
   {
     //Test 0 means No tab spaces
     State s = new State();
     Variable v = new Variable("x");
     BooleanOperation b = new BooleanOperation(BooleanOperation.Operator.And,new Comparison(Comparison.Operator.LT, new Number(10),new Number(2)),new Comparison(Comparison.Operator.GT, new Number(10),new Number(2)));
     Assignment a = new Assignment(v, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, new Number(2), new Number(5)));
     Loop l = new Loop(b,a);     
     assertEquals("Tests if the string representation of the loop is correct","while (" + b.toString() + ")\n" + a.toStringTabbed(1),l.toStringTabbed(0));
     
     //Test 1 means One tab spaces     
     State s1 = new State();
     Variable v1 = new Variable("x");
     BooleanOperation b1 = new BooleanOperation(BooleanOperation.Operator.And,new Comparison(Comparison.Operator.LT, new Number(10),new Number(2)),new Comparison(Comparison.Operator.GT, new Number(10),new Number(2)));
     Assignment a1 = new Assignment(v1, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, new Number(2), new Number(5)));
     Loop l1 = new Loop(b1,a1);     
     assertEquals("Tests if the string representation of the loop is correct","\twhile (" + b1.toString() + ")\n" + a1.toStringTabbed(2),l1.toStringTabbed(1));
     
     //Test Many means More than One tab spaces     
     State s2 = new State();
     Variable v2 = new Variable("x");
     BooleanOperation b2 = new BooleanOperation(BooleanOperation.Operator.And,new Comparison(Comparison.Operator.LT, new Number(10),new Number(2)),new Comparison(Comparison.Operator.GT, new Number(10),new Number(2)));
     Assignment a2 = new Assignment(v2, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, new Number(2), new Number(5)));
     Loop l2 = new Loop(b2,a2);     
     assertEquals("Tests if the string representation of the loop is correct","\t\t\twhile (" + b2.toString() + ")\n" + a2.toStringTabbed(4),l2.toStringTabbed(3));
   }
   
   /**
    * Test for the CompoundStatement class
    */
   
   @Test
   public void testCompoundStatementConstructor()
   {
     State s2 = new State();
     Variable y = new Variable("y");
     Assignment increment2 = new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Add, y, new Number(1)));     
     
     Statement statement[] = {increment2};
     CompoundStatement c = new CompoundStatement(statement);
     
     assertArrayEquals("Tests if the constructor assigns the variable length parameter of Statements correctly",statement,c.getStatementArray());
   }
    
   @Test
   public void testSetStatementArray()
   {
     
     State s2 = new State();
     Variable y = new Variable("y");
     Assignment increment2 = new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Add, y, new Number(1))); 
     Statement statement[] = {increment2};
     CompoundStatement c = new CompoundStatement(statement);
     Statement statement1[] = {new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Add, y, new Number(1))),
                               new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Sub, y, new Number(3))),
                               new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, y, new Number(1)))};
     c.setStatementArray(statement1);
     assertArrayEquals("Tests if the setter method works correctly",statement1,c.getStatementArray());
   }
   
   @Test
   public void testCompoundStatementToString()
   {
     State s2 = new State();
     Variable y = new Variable("y");
     Assignment increment2 = new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Add, y, new Number(1)));     
     
     Statement statement[] = {increment2};
     CompoundStatement c = new CompoundStatement(statement);
     
     assertEquals("Tests if the string representation of the CompoundStatement is correct","{\n" + increment2.toStringTabbed(1) + "}\n",c.toString());
   }
   
   @Test
   public void testCompoundStatementToStringTabbed()
   {
     /**
      * Test 0 means no space tabs 
      * This test doesn't makes sense as 0 - 1 = -1 tabs can't be used
      */
     //Test 1 means 1 space tab
     State s2 = new State();
     Variable y = new Variable("y");
     Assignment increment2 = new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Add, y, new Number(1)));  
     Statement statement[] = {increment2};
     CompoundStatement c = new CompoundStatement(statement);     
     assertEquals("Tests if the string representation of the CompoundStatement is correct","{\n" + increment2.toStringTabbed(1) + "}\n",c.toStringTabbed(1));
   
     //Test Many means more than 1 space tab
     State s1 = new State();
     Variable y1 = new Variable("y");
     Assignment increment1 = new Assignment(y1, new ArithmeticOperation(ArithmeticOperation.Operator.Add, y1, new Number(1)));  
     Statement statement1[] = {increment1};
     CompoundStatement c1 = new CompoundStatement(statement1);     
     assertEquals("Tests if the string representation of the CompoundStatement is correct","\t\t{\n" + increment1.toStringTabbed(3) + "\t\t}\n",c1.toStringTabbed(3));
   }            
   
   @Test
   public void testCompoundStatementExecute()
   {
     /**
      * Test 0 means length of array equal 0
      * which doesn't make sense
      */
     //Test 1 means array with length = 1
     State s2 = new State();
     Variable y = new Variable("y");
     Assignment increment2 = new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Add, y, new Number(1)));  
     Statement statement[] = {increment2};     
     CompoundStatement c = new CompoundStatement(statement); 
     c.execute(s2);
     assertEquals("Tests if the execute method of statement works correctly",new Integer(1),s2.lookup("y"));
     
     //Test Many means array with length more than one
     State s3 = new State();
     Variable y1 = new Variable("y");
     Variable v1 = new Variable("v");
     Assignment increment3 = new Assignment(y1, new ArithmeticOperation(ArithmeticOperation.Operator.Add, y1, new Number(1)));  
     Assignment increment4 = new Assignment(v1, new ArithmeticOperation(ArithmeticOperation.Operator.Add, v1, new Number(10))); 
     Statement statement1[] = {increment3,increment4};     
     CompoundStatement c1 = new CompoundStatement(statement1); 
     c1.execute(s3);
     assertEquals("Tests if the execute method of statement works correctly",new Integer(1),s3.lookup("y"));
     assertEquals("Tests if the execute method of statement works correctly",new Integer(10),s3.lookup("v"));
     
   }
     
  
   
   /**
    * Test for the Function class
    */
   @Test
   public void testFunctionConstructor()
   {     
     Variable y = new Variable("y");
     Variable v = new Variable("v");
     Variable array [] = {y,v};
     Assignment increment = new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Add, y, new Number(1)));  
     Function f = new Function("func",increment,array);
     
     assertEquals("Test if the constructor initializes the String correctly","func",f.getName());     
     assertEquals("Test if the constructor initializes the Statement correctly",increment,f.getBody());
     assertArrayEquals("Test if the constructor initializes the array correctly",array,f.getVariableArray());
   }
   @Test
   public void testFunctionSetName() /* Also tests getter method */
   {
     State s = new State();
     Variable y = new Variable("y");
     Variable v = new Variable("v");
     Variable array [] = {y,v};
     Assignment increment = new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Add, y, new Number(1)));  
     Function f = new Function("func",increment,array);
     f.setName("func2");
     assertEquals("Tests setter method of function name works correctly","func2",f.getName());
   }
   
   @Test
   public void testFunctionSetBody() /* Also tests getter method */
   {
     State s = new State();
     Variable y = new Variable("y");
     Variable v = new Variable("v");
     Variable array [] = {y,v};
     Assignment increment = new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Add, y, new Number(1)));  
     Function f = new Function("func",increment,array);
     Assignment increment2 = new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, y, new Number(16)));  
     f.setBody(increment2);
     assertEquals("Test if the setter method works correctly",increment2,f.getBody());
   }
     
   @Test
   public void testFunctionSetVariableArray() /* Also tests getter method */
   {
     State s = new State();
     Variable y = new Variable("y");
     Variable v = new Variable("v");
     Variable array [] = {y,v};
     Assignment increment = new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Add, y, new Number(1)));  
     Function f = new Function("func",increment,array);
     Variable o = new Variable("yt");
     Variable p = new Variable("vt");
     Variable array1 [] = {o,p};
     f.setVariableArray(array1);
     assertArrayEquals("Test if the setter method works correctly",array1,f.getVariableArray());
   }
   
    @Test
   public void testFunctionToString()
    {
     //Test 0 means no element in the array of variables
     State s = new State();   
     Variable y = new Variable("y");
     Variable array [] = {};
     Assignment increment = new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Add, y, new Number(1)));  
     Function f = new Function("func",increment,array);
     assertEquals("Tests if the string representation is correct","function " + f.getName() + "()\n" + f.getBody().toStringTabbed(1),f.toString());
     
     //Test 1 means only 1 element in the array of variables
     State s1 = new State();   
     Variable y1 = new Variable("y");
     Variable v1 = new Variable("v");     
     Variable array1 [] = {y1};
     Assignment increment1 = new Assignment(y1, new ArithmeticOperation(ArithmeticOperation.Operator.Add, y1, new Number(1)));  
     Function f1 = new Function("func",increment1,array1);
     assertEquals("Tests if the string representation is correct","function " + f1.getName() + "(y)\n" + f1.getBody().toStringTabbed(1),f1.toString());
     
     
     //Test many means more than 1 element in the array of variables
     State s2 = new State();   
     Variable y2 = new Variable("y");
     Variable v2 = new Variable("v");     
     Variable array2 [] = {y2,v2};
     Assignment increment2 = new Assignment(y2, new ArithmeticOperation(ArithmeticOperation.Operator.Add, y2, new Number(1)));  
     Function f2 = new Function("funcMany",increment2,array2);
     assertEquals("Tests if the string representation is correct","function " + f2.getName() + "(y ,v)\n" + f2.getBody().toStringTabbed(1),f2.toString());
    }
    
   /**
    * Test for the FunctionCall class
    */
    
    @Test
   public void testFunctionCallConstructor()
   {
     Variable y = new Variable("y");
     Variable v = new Variable("v");
     Variable array [] = {y,v};
     Assignment increment = new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Add, y, new Number(1)));  
     Function f = new Function("func",increment,array);
     Assignment increment2 = new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, y, new Number(1)));
     Assignment increment3 = new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Sub, y, new Number(1)));
     Assignment array1 [] = {increment2,increment3};
     FunctionCall c = new FunctionCall(f,array1);
         
     
     assertEquals("Test if the constructor initializes the Function correctly",f,c.getFunction());     
     assertArrayEquals("Test if the constructor initializes the Statement correctly",array1,c.getExpressionArray());
   }
    
    @Test
   public void testFunctionCallsetFunction() /* Also tests getter method */
   {
     Variable y = new Variable("y");
     Variable v = new Variable("v");
     Variable array [] = {y,v};
     Assignment increment = new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Add, y, new Number(1)));  
     Function f = new Function("func",increment,array);   
     Assignment increment2 = new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, y, new Number(1)));
     Assignment increment3 = new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Sub, y, new Number(1)));
     Assignment array1 [] = {increment2,increment3};   
     FunctionCall c = new FunctionCall(f,array1);
     
     //Creation of new function
     Variable e = new Variable("e");
     Variable r = new Variable("r");
     Variable array2 [] = {e,r};
     Assignment increment5 = new Assignment(e, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, e, new Number(10)));  
     Function f2 = new Function("func2",increment5,array2);
     c.setFunction(f2);
     
     assertEquals("Test the setter Function",f2,c.getFunction());  
   }
    
    @Test
   public void testFunctionCallsetExpressionArray() /* Also tests getter method */
   {
     Variable y = new Variable("y");
     Variable v = new Variable("v");
     Variable array [] = {y,v};
     Assignment increment = new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Add, y, new Number(1)));  
     Function f = new Function("func",increment,array);   
     Assignment increment2 = new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, y, new Number(1)));
     Assignment increment3 = new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Sub, y, new Number(1)));
     Assignment array1 [] = {increment2,increment3};   
     FunctionCall c = new FunctionCall(f,array1);
     
     //Creation of new Array
     Assignment increment4 = new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Div, y, new Number(5)));
     Assignment increment5 = new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Rem, y, new Number(3)));
     Assignment array2 [] = {increment4,increment5}; 
     c.setExpressionArray(array2);
     
     assertArrayEquals("Test the setter Function",array2,c.getExpressionArray());  
   }
    /*
    @Test
    public void testFunctionCallValue()
    {
    }*/
    
    @Test
    public void testFunctionCalltoString()
    {      
     //Test 0 means no element in the array of arguments
     Variable y = new Variable("y");
     Variable v = new Variable("v");
     Variable array [] = {y,v};
     Assignment increment = new Assignment(y, new ArithmeticOperation(ArithmeticOperation.Operator.Add, y, new Number(1)));  
     Function f = new Function("func",increment,array);       
     Assignment array1 [] = {};   
     FunctionCall c = new FunctionCall(f,array1);     
     assertEquals("Tests if the string representation is correct", f.getName().toString() + "()",c.toString());
     
     //Test 1 means one element in the array of arguments
     Variable y1 = new Variable("y");
     Variable v1 = new Variable("v");
     Variable array2 [] = {y1,v1};
     Assignment increment1 = new Assignment(y1, new ArithmeticOperation(ArithmeticOperation.Operator.Add, y1, new Number(1)));  
     Function f1 = new Function("func1",increment,array2);  
     Assignment increment2 = new Assignment(y1, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, y1, new Number(1)));     
     Assignment array3 [] = {increment2};   
     FunctionCall c2 = new FunctionCall(f1,array3);     
     assertEquals("Tests if the string representation is correct", f1.getName().toString() + "(" + increment2.toString() + ")",c2.toString());
    
     //Test Many means one element in the array of arguments
     Variable y2 = new Variable("y");
     Variable v2 = new Variable("v");
     Variable array4 [] = {y2,v2};
     Assignment increment3 = new Assignment(y2, new ArithmeticOperation(ArithmeticOperation.Operator.Add, y2, new Number(1)));  
     Function f2 = new Function("func2",increment,array4);  
     Assignment increment4 = new Assignment(y2, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, y2, new Number(1)));
     Assignment increment5 = new Assignment(y2, new ArithmeticOperation(ArithmeticOperation.Operator.Sub, y2, new Number(1)));  
     Assignment array5 [] = {increment4, increment5};   
     FunctionCall c3 = new FunctionCall(f2,array5);     
     assertEquals("Tests if the string representation is correct", f2.getName().toString() + "(" + increment4.toString() + " ," + increment5.toString() + ")",c3.toString());
   
    }
    
     @Test
    public void testFunctionCalltoStringTabbed()
    {      
     //Test 0 means 0 space tabs
     // This doesnt make sense for 0 - 1 space tabs for { }   
     
     //Test 1 means one space tabs
     Variable y1 = new Variable("y");
     Variable v1 = new Variable("v");
     Variable array2 [] = {y1,v1};
     Assignment increment1 = new Assignment(y1, new ArithmeticOperation(ArithmeticOperation.Operator.Add, y1, new Number(1)));  
     Function f1 = new Function("func1",increment1,array2);  
     Assignment increment2 = new Assignment(y1, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, y1, new Number(1)));     
     Assignment array3 [] = {increment2};   
     FunctionCall c2 = new FunctionCall(f1,array3);     
     assertEquals("Tests if the string representation is correct", "{\n" + c2.toString() + f1.getBody().toStringTabbed(1)+"}\n",c2.toStringTabbed(1));
    
     //Test Many  means more than one space tabs
     Variable y2 = new Variable("y");
     Variable v2 = new Variable("v");
     Variable array4 [] = {y2,v2};
     Assignment increment3 = new Assignment(y2, new ArithmeticOperation(ArithmeticOperation.Operator.Add, y2, new Number(1)));  
     Function f2 = new Function("func2",increment3,array4);  
     Assignment increment4 = new Assignment(y2, new ArithmeticOperation(ArithmeticOperation.Operator.Mult, y2, new Number(1)));
     Assignment increment5 = new Assignment(y2, new ArithmeticOperation(ArithmeticOperation.Operator.Sub, y2, new Number(1)));  
     Assignment array5 [] = {increment4, increment5};   
     FunctionCall c3 = new FunctionCall(f2,array5);     
     assertEquals("Tests if the string representation is correct", "\t{\n" + c3.toString() + f2.getBody().toStringTabbed(2)+"\t}\n",c3.toStringTabbed(2));
   
    }
     
     
    
                  
     
                  
   
     
   
     
   
     
   
   
                                                 
                                                    
                          
  
      
  
  
    
}