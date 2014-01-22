package pl.burningice.burningconfig.formatters

public interface Formatter<T> {

    public T fromString(String source)

    public String toString(T source)

}
