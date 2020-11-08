import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ConsistentHashCacheCluster implements Cluster{

    private SortedMap<Integer, DistributedServerNode> serverNodes = new TreeMap<Integer, DistributedServerNode>();

    @Override
    public boolean addServerNode(DistributedServerNode serverNode) {
        if (this.size.get() > ConsistentHashCacheCluster.CLUSTER_NODE_COUNT_MAX) {
            return false;
        }
        this.serverNodes.put(serverNode.hashCode(), serverNode);
        this.size.getAndIncrement();

        return true;
    }

    @Override
    public void put(Entry e) {
        DistributedServerNode serverNode = routeServer(e.hashCode());
        serverNode.put(e);
    }

    @Override
    public Entry get(Entry e) {
        DistributedServerNode serverNode = routeServer(e.hashCode());
        return serverNode.get(e);
    }

    public DistributedServerNode routeServer(int hash) {
        if (this.serverNodes.isEmpty())
            return null;

        if (!this.serverNodes.containsKey(hash)) {
            SortedMap<Integer, DistributedServerNode> tailMap = this.serverNodes.tailMap(hash);
            hash = tailMap.isEmpty() ? this.serverNodes.firstKey() : tailMap.firstKey();
        }
        return this.serverNodes.get(hash);
    }

}
