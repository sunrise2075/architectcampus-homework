import org.junit.jupiter.api.Test;

class SimpleCacheClusterTest {

    @Test
    public void goTest(){
        SimpleCacheCluster cluster = createCluster();
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

    private void findEntries(SimpleCacheCluster cluster, Entry[] entries) {
        for (Entry e : entries) {
            if (e == cluster.get(e)) {
                System.out.println("重新找到了entry:" + e);
            } else {
                System.out.println("entry已失效:" + e);
            }
        }
    }

    private SimpleCacheCluster createCluster() {
        SimpleCacheCluster c = new SimpleCacheCluster();
        c.addServerNode(new DistributedServerNode("192.168.0.0"));
        c.addServerNode(new DistributedServerNode("192.168.0.1"));
        c.addServerNode(new DistributedServerNode("192.168.0.2"));
        c.addServerNode(new DistributedServerNode("192.168.0.3"));
        c.addServerNode(new DistributedServerNode("192.168.0.4"));
        c.addServerNode(new DistributedServerNode("192.168.0.5"));
        return c;
    }

}