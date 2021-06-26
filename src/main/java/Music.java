public class Music {
    String songTitle;
    double duration;

    public Music(String songTitle, double duration) {
        this.songTitle = songTitle;
        this.duration = duration;
    }

    public Music() {
    }

    public String getSongTitle() {
        return songTitle;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Music{" +
                "songTitle='" + songTitle + '\'' +
                ", duration=" + duration +
                '}';
    }
}
