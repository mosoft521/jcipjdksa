package javaguide.java.newFeatures.modern;

@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}