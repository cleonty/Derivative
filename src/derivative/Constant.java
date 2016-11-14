package derivative;

public class Constant implements Derivable {

  int c;

  public Constant(int c) {
    this.c = c;
  }

  @Override
  public Derivable derive(Variable v) {
    return new Constant(0);
  }

  @Override
  public String toString() {
    return Integer.toString(this.c);
  }

}
