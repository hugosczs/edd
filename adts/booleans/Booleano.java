package adts.booleans;

public interface Booleano {

    public static final boolean Verdadero = true;
    public static final boolean Falso = false;

    booleano and(booleano x, booleano y);

    booleano or(booleano x, booleano y);

    booleano not(booleano x);
}