package derivative;

public class Main {

  public static void test1() {
    Variable x = new Variable("x");
    Constant five = new Constant(5);
    Constant nine = new Constant(9);
    
    Derivable five_x = new Mul(five, x);
    Derivable five_x_plus_nine = new Sum(five_x, nine);
    
    System.out.println("d(" + five_x_plus_nine + ")/d" + x + " = " + five_x_plus_nine.derive(x));
  }
  
  public static void test2() {
    Variable x = new Variable("x");
    Variable y = new Variable("y");
    Constant five = new Constant(5);
    Constant nine = new Constant(9);
    
    Derivable five_x = new Mul(five, x);
    Derivable nine_y = new Mul(nine, y);
    
    Derivable five_x_plus_nine_y = new Sum(five_x, nine_y);
    
    Derivable d = new Mul(five_x_plus_nine_y, five_x_plus_nine_y);
    System.out.println("d(" + d + ")/d" + x + " = " + d.derive(x));
  }
  
  public static void main(String[] args) {
    test1();
    test2();
  }

}
