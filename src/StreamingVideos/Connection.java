package StreamingVideos;

public class Connection {
  CacheServer cacheServer;
  int latency;

  public Connection(CacheServer cacheServer, int latency) {
    this.cacheServer = cacheServer;
    this.latency = latency;
  }

  public CacheServer getCacheServer() {
    return cacheServer;
  }

  public int getLatency() {
    return latency;
  }
}
