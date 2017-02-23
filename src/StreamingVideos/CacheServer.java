package StreamingVideos;

public class CacheServer {

  int id;
  int capacity;

  public CacheServer(int id, int capacity) {
    this.id = id;
    this.capacity = capacity;
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
}
