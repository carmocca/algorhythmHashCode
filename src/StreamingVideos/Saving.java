package StreamingVideos;

public class Saving {

  Video video;
  int priority;

  public Saving(Video video, int priority) {
    this.video = video;
    this.priority = priority;
  }

  public Video getVideo() {
    return video;
  }

  public int getPriority() {
    return priority;
  }
}
