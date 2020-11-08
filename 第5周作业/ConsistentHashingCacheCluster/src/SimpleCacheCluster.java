import java.util.concurrent.atomic.AtomicInteger;

public class SimpleCacheCluster implements Cluster{

    private DistributedServerNode[] serverNodes = new DistributedServerNode[CLUSTER_NODE_COUNT_MAX];

    @Override
    public boolean addServerNode(DistributedServerNode serverNode) {
        if (this.size.get() > CLUSTER_NODE_COUNT_MAX) {
            return false;
        }

        this.serverNodes[this.size.getAndIncrement()] = serverNode;
        return true;
    }

    @Override
    public void put(Entry e) {
        int index = e.hashCode() % this.size.get();
        this.serverNodes[index].put(e);
    }

    @Override
    public Entry get(Entry e) {
        int index = size.hashCode() % this.size.get();
        return this.serverNodes[index].get(e);
    }
}
