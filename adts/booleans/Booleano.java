public interface Booleano {

    public static final boolean Verdadero = true;
    public static final boolean Falso = false;

    Booleano and(Booleano x, Booleano y);

    Booleano or(Booleano x, Booleano y);

    Booleano not(Booleano x);
}