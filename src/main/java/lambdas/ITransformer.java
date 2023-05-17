package lambdas;

public interface ITransformer<T, R> {

    R transform(T element);
}