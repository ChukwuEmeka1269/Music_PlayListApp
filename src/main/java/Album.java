import java.util.ArrayList;
import java.util.LinkedList;


public class Album {
    private String albumTitle;
    private String artiste;
    private ArrayList<Music> songs;

    public Album(String albumTitle, String artiste) {
        this.albumTitle = albumTitle;
        this.artiste = artiste;
        this.songs = new ArrayList<Music>();
    }

    public Album() {
    }

    public boolean addSong(String title, double duration){
        if(findSong(title) == null){
            songs.add(new Music(title, duration));
//            System.out.println(title + "Added successfully!");
            return true;
        }else{
            System.out.println(title + "Already exist.");
            return false ;
        }
    }


    public Music findSong(String title){
       for(Music music: songs){
           if(music.getSongTitle().equalsIgnoreCase(title))
               return music;
       }

       return null;
    }

    public boolean addSongToPlaylist(int trackNumber,  LinkedList<Music> playlist){
        int index = trackNumber - 1;
        if(index>0 && index<=this.songs.size()){
            playlist.add(songs.get(index));
            return true;
        }
        System.out.println(trackNumber + "is not available in this able");
        return false;
    }

    public boolean addSongToPlaylist(String title, LinkedList<Music> playlist){
        for(Music music: this.songs){
            if(music.getSongTitle().equals(title)){
                playlist.add(music);
                return true;
            }

        }
        System.out.println(title + "Not found in " + this.songs);
        return false;
    }

}
