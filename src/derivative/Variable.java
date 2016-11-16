package derivative;

public class Variable implements Derivable {

  String name;

  public Variable(String name) {
    this.name = name;
  }

  public boolean isSameVariable(Variable v) {
    return this.name.equals(v.name);
  }

  @Override
  public Derivable derive(Variable v) {
    if (this.name.equals(v.name)) {
      return new Constant(1);
    } else {
      return new Constant(0);
    }
  }

  @Override
  public String toString() {
    return this.name;
  }

}
