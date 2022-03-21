package se2203b.assignments.adminapp;

public class Pair<Y, N>
{
    private Y key;
    private N value;

    public Pair(Y year, N name)
    {
        this.key = year;
        this.value = name;
    }

    public void setKey(Y key) { this.key = key; }
    public void setValue(N value) { this.value = value; }
    public Y getKey() { return key; }
    public N getValue() { return value; }

    @Override
    public String toString()
    {
        return (this.getKey() + ": " + this.getValue());
    }

}