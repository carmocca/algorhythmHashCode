package StreamingVideos;

public class Request {
  int quantity, videoID,endpointID;

  public Request(int quantity, int videoID, int endpointID) {
    this.quantity = quantity;
    this.videoID = videoID;
    this.endpointID = endpointID;
  }

  public int getQuantity() {
    return quantity;
  }

  public int getVideoID() {
    return videoID;
  }

  public int getEndpointID() {
    return endpointID;
  }
}
