package derivative;

public class Sum implements Derivable {

  private final Derivable a;
  private final Derivable b;

  public Sum(Derivable a, Derivable b) {
    this.a = a;
    this.b = b;
  }

  @Override
  public Derivable derive(Variable v) {
    return new Sum(a.derive(v), b.derive(v));
  }

  public String toString() {
    return "(" + a.toString() + "+" + b.toString() + ")";
  }
}
