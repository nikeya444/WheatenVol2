package ua.dp.wheaten.site.root.services;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 08.08.15
 * Time: 22:42
 * To change this template use File | Settings | File Templates.
 */
public interface Converter<T> {
    T convert(Object source);
}
