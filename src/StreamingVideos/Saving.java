package StreamingVideos;

public class Saving implements Comparable{

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

  @Override
  public int compareTo(Object o) {
    Saving other = (Saving) o;
    if(priority > other.getPriority()){
      return -1;
    }else{
      if(priority < other.getPriority()){
        return 1;
      }else{
        return 0;
      }
    }
  }
}
