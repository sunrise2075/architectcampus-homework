package geektime.design.pattern;

public class CacheClient {
    private ICache iCache;

    public CacheClient(ICache iCache) {
        this.iCache = iCache;
    }
}
