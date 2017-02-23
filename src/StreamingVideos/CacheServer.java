package StreamingVideos;

import java.util.*;

public class CacheServer {

  int id;
  int capacity;
  int size = 0;
  List<Endpoint> endpoints;
  PriorityQueue<Saving> savings;
  Set<Video> videos;

  public CacheServer(int id, int capacity) {
    this.id = id;
    this.capacity = capacity;
    endpoints = new ArrayList<>();
    savings = new PriorityQueue<Saving>();
    videos = new HashSet<>();
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

  public void addEndpoint(Endpoint e) {
    this.endpoints.add(e);
  }

  public List<Endpoint> getEndpoints() {
    return endpoints;
  }

  public void addVideo(Video v) {
    this.videos.add(v);
  }

  @Override
  public String toString() {
    String str = "" + id;
    for (Video video : videos) {
      str += " " + video.getId();
    }
    return str;
  }

  public Queue<Saving> getSavings() {
    return savings;
  }

  public Set<Video> getVideos() {
    return videos;
  }

  public void addSavingToPriority(Saving s) {
    savings.add(s);
  }

  public void fill() {
    while (!savings.isEmpty()) {
      Saving saving = savings.poll();
      if (!videos.contains(saving.getVideo()) && size + saving.getVideo().getSize() < capacity) {
        size += saving.getVideo().getSize();
        videos.add(saving.getVideo());
      }
    }
  }
}
