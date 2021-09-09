package by.alex.threads.ex15resource_pool;

public class AudioChannel {

    private int channelId;

    public AudioChannel(int id) {
        super();
        this.channelId = id;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int id) {
        this.channelId = id;
    }

    public void using() {
        try {
            // использование канала
            Thread.sleep(new java.util.Random().nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
