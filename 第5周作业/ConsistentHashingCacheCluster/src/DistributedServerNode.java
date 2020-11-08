import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DistributedServerNode {
    private String serverName;
    private Map<Entry, Entry> entries;

    public DistributedServerNode(String serverName) {
        this.serverName = serverName;
        this.entries = new HashMap<>();
    }

    public void put(Entry e) {
        this.entries.put(e, e);
    }

    public Entry get(Entry e){
        return this.entries.get(e);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistributedServerNode that = (DistributedServerNode) o;
        return Objects.equals(serverName, that.serverName) && Objects.equals(entries, that.entries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serverName, entries);
    }
}
