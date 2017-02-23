package StreamingVideos;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    processFile("resources/StreamingVideos/example.in", "out/StreamingVideos/example.out");
    //processFile("resources/StreamingVideos/kittens.in", "out/StreamingVideos/kittens.out");
    //processFile("resources/StreamingVideos/me_at_the_zoo.in", "out/StreamingVideos/me_at_the_zoo.out");
    //processFile("resources/StreamingVideos/trending_today.in", "out/StreamingVideos/trending_today.out");
    //processFile("resources/StreamingVideos/videos_worth_spreading.in", "out/StreamingVideos/videos_worth_spreading.out");
  }

  public static void processFile(String inputFilePath, String outputFilePath) {
    final int V, E, R, C, X;
    List<Video> videoList;
    List<CacheServer> cacheList;
    List<CacheServer> usedCaches;
    List<Endpoint> endpointList;
    List<Request> requestList;

    Scanner sc = null;
    PrintWriter pw = null;
    try {
      sc = new Scanner(new File(inputFilePath));
      pw = new PrintWriter(outputFilePath);

      V = sc.nextInt();
      E = sc.nextInt();
      R = sc.nextInt();
      C = sc.nextInt();
      X = sc.nextInt();

      System.out.println("FILE: " + inputFilePath.substring(26));
      System.out.printf("Videos: %d\nEndpoints: %d\nRequests: %d\nCache: %d\nCapacity: %d\n", V, E, R, C, X);

      cacheList = new ArrayList<>(C);
      for (int cacheId = 0; cacheId < C; cacheId++) {
        cacheList.add(new CacheServer(cacheId, X));
      }

      videoList = new ArrayList<>(V);
      for (int videoId = 0; videoId < V; videoId++) {
        videoList.add(new Video(videoId, sc.nextInt()));
      }

      endpointList = new ArrayList<>(E);
      for (int endpointId = 0; endpointId < E; endpointId++) {
        int Ld = sc.nextInt();
        int K = sc.nextInt();
        Endpoint endpoint = new Endpoint(endpointId, Ld);
        for (int connectionId = 0; connectionId < K; connectionId++) {
          int c = sc.nextInt();
          int Lc = sc.nextInt();
          endpoint.addCacheServer(cacheList.get(c), Lc);
          cacheList.get(c).addEndpoint(endpoint);
        }
        endpointList.add(endpoint);
      }

      requestList = new ArrayList<>(R);
      for (int requestId = 0; requestId < R; requestId++) {
        int Rv = sc.nextInt();
        int Re = sc.nextInt();
        int Rn = sc.nextInt();
        Request request = new Request(Rn, Rv, Re);
        requestList.add(request);
        endpointList.get(request.getEndpointID()).addRequest(request);
      }
      sc.close();

      usedCaches = new ArrayList<>();
      for (Endpoint endpoint : endpointList) {
        for (Request request : endpoint.getRequests()) {
          for (Connection connection : endpoint.getConnections()) {
            int videoSize = videoList.get(request.getVideoID()).getSize();
            int dataCenterLatency = endpoint.getLatency();
            int cacheLatency = connection.getLatency();
            int requestQuantity = request.getQuantity();
            int saving = (dataCenterLatency - cacheLatency) * requestQuantity;
            int priority = saving / videoSize;
            // Meter priority a alguna ED
            if (saving > 0) {
              Saving s = new Saving(videoList.get(request.getVideoID()),priority);
              connection.cacheServer.addSavingToPriority(s);
            }
          }
        }
      }

      for (CacheServer cache : usedCaches) {
        cache.fill();
      }

      System.out.println("Number of used caches: " + usedCaches.size());
      pw.println(usedCaches.size());
      for (CacheServer cache : usedCaches) {
        pw.println(cache.toString());
      }
      pw.close();

    } catch (IOException e) {
      System.out.println(e.toString());
      System.exit(0);
    }
  }
}
