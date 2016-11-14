package derivative;

public interface Derivable {
  Derivable derive(Variable v);
  Derivable simplify();
}
