package model;

public class One implements Cloneable{
    private Two two;




    public Two getTwo() {
        return two;
    }

    public void setTwo(Two two) {
        this.two = two;
    }

    @Override
    public String toString() {
        return "One{" +
                "two=" + two +
                '}';
    }
}
