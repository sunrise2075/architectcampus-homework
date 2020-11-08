import org.junit.jupiter.api.Test;

class CacheClusterTest {

    @Test
    public void goTest1(){

        Cluster cluster = new SimpleCacheCluster();
        addServerNodes(cluster);

        Entry[] entries = {
                new Entry("i",new Object()),
                new Entry("have", new Object()),
                new Entry("a", new Object()),
                new Entry("pen", new Object()),
                new Entry("an", new Object()),
                new Entry("apple", new Object()),
                new Entry("applepen", new Object()),
                new Entry("pineapple", new Object()),
                new Entry("pineapplepen", new Object()),
                new Entry("PPAP", new Object())
        };

        for (Entry e : entries)
            cluster.put(e);

        cluster.addServerNode(new DistributedServerNode("192.168.0.6"));

        findEntries(cluster, entries);

    }

    @Test
    public void goTest2(){

        ConsistentHashCacheCluster cluster = new ConsistentHashCacheCluster();
        addServerNodes(cluster);

        Entry[] entries = {
                new Entry("i",new Object()),
                new Entry("have", new Object()),
                new Entry("a", new Object()),
                new Entry("pen", new Object()),
                new Entry("an", new Object()),
                new Entry("apple", new Object()),
                new Entry("applepen", new Object()),
                new Entry("pineapple", new Object()),
                new Entry("pineapplepen", new Object()),
                new Entry("PPAP", new Object())
        };

        for (Entry e : entries)
            cluster.put(e);

        cluster.addServerNode(new DistributedServerNode("192.168.0.6"));

        findEntries(cluster, entries);

    }



    private void findEntries(Cluster cluster, Entry[] entries) {
        for (Entry e : entries) {
            if (e == cluster.get(e)) {
                System.out.println("重新找到了entry:" + e);
            } else {
                System.out.println("entry已失效:" + e);
            }
        }
    }


    private void addServerNodes(Cluster cluster) {
        cluster.addServerNode(new DistributedServerNode("192.168.0.0"));
        cluster.addServerNode(new DistributedServerNode("192.168.0.1"));
        cluster.addServerNode(new DistributedServerNode("192.168.0.2"));
        cluster.addServerNode(new DistributedServerNode("192.168.0.3"));
        cluster.addServerNode(new DistributedServerNode("192.168.0.4"));
        cluster.addServerNode(new DistributedServerNode("192.168.0.5"));
    }

}