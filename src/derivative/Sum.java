package derivative;

public class Sum implements Derivable {

  private final Derivable a;
  private final Derivable b;

  public Sum(Derivable a, Derivable b) {
    this.a = a.simplify();
    this.b = b.simplify();
  }

  @Override
  public Derivable derive(Variable v) {
    return new Sum(a.derive(v), b.derive(v)).simplify();
  }

  public String toString() {
    return "(" + a.toString() + "+" + b.toString() + ")";
  }

  @Override
  public Derivable simplify() {
    boolean aIsConstant = this.a instanceof Constant;
    boolean bIsConstant = this.b instanceof Constant;

    if (aIsConstant && bIsConstant) {
      Constant ca = (Constant) this.a;
      Constant cb = (Constant) this.b;
      return new Constant(ca.c + cb.c);
    }

    if (aIsConstant) {
      Constant ca = (Constant) this.a;
      if (ca.isZero()) {
        return this.b;
      }
    }
    
    if (bIsConstant) {
      Constant cb = (Constant) this.b;
      if (cb.isZero()) {
        return this.a;
      }
    }
    
    return this;
  }
}
