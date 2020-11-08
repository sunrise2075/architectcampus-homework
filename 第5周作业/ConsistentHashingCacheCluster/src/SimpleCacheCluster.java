import java.util.concurrent.atomic.AtomicInteger;

public class SimpleCacheCluster {

    private static final int CLUSTER_SERVER_SIZE_MAX = 1024;

    private AtomicInteger size = new AtomicInteger(0);
    private DistributedServerNode[] serverNodes = new DistributedServerNode[CLUSTER_SERVER_SIZE_MAX];

    public boolean addServerNode(DistributedServerNode serverNode) {
        if (this.size.get() > SimpleCacheCluster.CLUSTER_SERVER_SIZE_MAX) {
            return false;
        }

        this.serverNodes[this.size.getAndIncrement()] = serverNode;
        return true;
    }

    public void put(Entry e) {
        int index = e.hashCode() % this.size.get();
        this.serverNodes[index].put(e);
    }

    public Entry get(Entry e) {
        int index = size.hashCode() % this.size.get();
        return this.serverNodes[index].get(e);
    }
}
