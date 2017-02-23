package StreamingVideos;

import sun.misc.Cache;

import java.util.ArrayList;
import java.util.List;

public class CacheServer {

  int id;
  int capacity;
  List<Endpoint> endpoints;

  public CacheServer(int id, int capacity) {
    this.id = id;
    this.capacity = capacity;
    endpoints = new ArrayList<>();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public void addEndpoint(Endpoint e){
    this.endpoints.add(e);
  }

  public List<Endpoint> getEndpoints() {
    return endpoints;
  }
}
