package derivative;

public class Mul implements Derivable {

  private final Derivable a;
  private final Derivable b;

  public Mul(Derivable a, Derivable b) {
    this.a = a;
    this.b = b;
  }

  @Override
  public Derivable derive(Variable v) {
    return new Sum(
            new Mul(a.derive(v), b),
            new Mul(a, b.derive(v))
    );
  }

  @Override
  public String toString() {
    return a.toString() + "*" + b.toString();
  }

}
