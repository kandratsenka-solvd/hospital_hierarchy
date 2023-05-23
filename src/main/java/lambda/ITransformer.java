package lambda;

public interface ITransformer<T, R> {

    R transform(T element);
}