package derivative;

public class Mul implements Derivable {

  private Derivable a;
  private Derivable b;

  public Mul(Derivable a, Derivable b) {
    this.a = a.simplify();
    this.b = b.simplify();
  }

  @Override
  public Derivable simplify() {
    boolean aIsConstant = this.a instanceof Constant;
    boolean bIsConstant = this.b instanceof Constant;

    if (aIsConstant && bIsConstant) {
      Constant ca = (Constant) this.a;
      Constant cb = (Constant) this.b;
      return new Constant(ca.c * cb.c);
    }

    if (aIsConstant) {
      Constant ca = (Constant) this.a;
      if (ca.isOne()) {
        return this.b;
      }
      if (ca.isZero()) {
        return ca;
      }
    }

    if (bIsConstant) {
      Constant cb = (Constant) this.b;
      if (cb.isOne()) {
        return this.a;
      }
      if (cb.isZero()) {
        return cb;
      }
    }

    return this;

  }

  @Override
  public Derivable derive(Variable v) {
    return new Sum(
            new Mul(a.derive(v), b),
            new Mul(a, b.derive(v))).simplify();
  }

  @Override
  public String toString() {
    return a.toString() + "*" + b.toString();
  }

}
