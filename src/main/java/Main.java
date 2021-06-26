import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Album> albums = new ArrayList<>();

        Album album = new Album("God Can", "Alvin Slaughter");
        album.addSong("Yes He Can", 3.5);
        album.addSong("He is All", 4.5);
        album.addSong("Streams of Joy", 3.6);
        albums.add(album);

        Album burnaBoy = new Album("African Giant", "Burna Boy");
        burnaBoy.addSong("Odogwu", 2.9);
        burnaBoy.addSong("Ye", 3.2);
        burnaBoy.addSong("African Giant", 3.4);
        albums.add(burnaBoy);

        LinkedList<Music> playlist1 = new LinkedList<>();
        albums.get(0).addSongToPlaylist("Yes He Can", playlist1);
        albums.get(1).addSongToPlaylist("Ye", playlist1);
        albums.get(1).addSongToPlaylist("Odogwu", playlist1);

        play(playlist1);
    }


    public static void play(LinkedList<Music> playlist){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Music> listIterator = playlist.listIterator();
        if(playlist.size()==0){
            System.out.println(playlist + "has not song");
        } else{
            System.out.println( listIterator.next().toString()+" Now playing" );
            printMenu();
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action){
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }

                    if(listIterator.hasNext()){
                        System.out.println(listIterator.next().toString() + " Now playing");
                    }else{
                        System.out.println("End of playlist");
                        forward = false;
                    }

                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println(listIterator.previous().toString()+" Now playing");
                    }else{
                        System.out.println("This is the first song");
                        forward = false;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println(listIterator.previous().toString()+" Now playing");
                            forward=false;
                        }else{
                            System.out.println("AT the start of playlist");
                        }

                    }else {
                        if(listIterator.hasNext()){
                            System.out.println(listIterator.next().toString()+" Now playing");
                            forward = true;
                        } else{
                            System.out.println("End of playlist");
                        }
                    }
                    break;

                case 4:
                    printSongList(playlist );
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playlist.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println(listIterator.next().toString()+" Now playing");
                        }else{
                            if(listIterator.hasPrevious()){
                                System.out.println(listIterator.previous().toString()+" Now playing.");

                            }
                        }
                    }

            }
        }

    }

    public static void printMenu(){
        System.out.println("Options \n press");
        System.out.println("0 -  to quit\n"
                + "1 -  to play next song \n"
                +"2 - to play previous\n"+
                "3 - to replay current song\n" +
                "4 - for list of all songs \n" +
                "5 -  All option\n" +
                "6 - Delete current song ");
    }

    public static void printSongList(LinkedList<Music> playlist){
        Iterator<Music> iterator = playlist.iterator();
        System.out.println("--------------------");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("-------------------- ");
    }
}
