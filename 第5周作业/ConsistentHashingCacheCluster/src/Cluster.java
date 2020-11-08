import java.util.concurrent.atomic.AtomicInteger;

public interface Cluster {

    static final int CLUSTER_NODE_COUNT_MAX = 1024;
    AtomicInteger size = new AtomicInteger(0);

    void put(Entry e);

    Entry get(Entry e);

    boolean addServerNode(DistributedServerNode serverNode) ;
}
