package geektime.design.pattern;

public interface ICache {
    Object get(Object key);

    void put(Object key, Object val);

    void delete(Object key);

}
