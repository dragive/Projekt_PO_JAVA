package Wydawnictwo.KlasyPomocnicze;

import java.io.Serializable;

/**
 * Klasa implementująca pare obiektów
 * @param <A> 1. typ obiektu
 * @param <B> 2. typ obiektu
 */
public class Pair<A, B> implements Serializable {
    /**
     * Pole przechowujące obiekt first;
     */
    private A first;
    /**
     * Pole przechowujące obiekt second;
     */
    private B second;

    /**
     * konstruktor pobierający 2 obiekty
     * @param first pierwszy obiekt typu A
     * @param second drugi obiekt typu B
     */
    public Pair(A first, B second) {
        super();
        this.first = first;
        this.second = second;
    }

    public int hashCode() {
        int hashFirst = first != null ? first.hashCode() : 0;
        int hashSecond = second != null ? second.hashCode() : 0;

        return (hashFirst + hashSecond) * hashSecond + hashFirst;
    }

    /**
     * Porównanie 2 obiektów czy są takie same
     * @param other Obiekt do porównania
     * @return Zwraca wartość ligiczną prawda jak obiekty są takie same
     */
    public boolean equals(Object other) {
        if (other instanceof Pair) {
            Pair otherPair = (Pair) other;
            return
                    ((  this.first == otherPair.first ||
                            ( this.first != null && otherPair.first != null &&
                                    this.first.equals(otherPair.first))) &&
                            (  this.second == otherPair.second ||
                                    ( this.second != null && otherPair.second != null &&
                                            this.second.equals(otherPair.second))) );
        }

        return false;
    }

    /**
     * @return Zwracany jest ciąg znaków reprezentujący zawartość obiektu
     */
    public String toString()
    {
        return "(" + first + ", " + second + ")";
    }

    public A getFirst() {
        return first;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public B getSecond() {
        return second;
    }

    public void setSecond(B second) {
        this.second = second;
    }
}