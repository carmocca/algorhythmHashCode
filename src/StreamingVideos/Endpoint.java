package StreamingVideos;

import java.util.LinkedList;
import java.util.List;

public class Endpoint {

  int id, latency;
  List<Connection> cacheServerConnections;
  List<Request> videoRequests;

  public Endpoint(int id, int latency) {
    this.id = id;
    this.latency = latency;
    this.cacheServerConnections = new LinkedList<>();
    this.videoRequests = new LinkedList<>();
  }

  public void addCacheServer(CacheServer c,int latency){
    cacheServerConnections.add(new Connection(c,latency));
  }

  public void addRequest(Request request){
    videoRequests.add(request);
  }
}
