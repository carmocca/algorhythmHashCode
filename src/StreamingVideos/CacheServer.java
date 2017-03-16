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
    savings = new PriorityQueue<>();
    videos = new HashSet<>();
  }

  public void addEndpoint(Endpoint e) {
    this.endpoints.add(e);
  }

  @Override
  public String toString() {
    String str = "" + id;
    for (Video video : videos) {
      str += " " + video.getId();
    }
    return str;
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
