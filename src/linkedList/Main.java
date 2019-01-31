package linkedList;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        // Create a program that implements a playlist for songs
        // Create a Song class having Title and Duration for a song.
        // The program will have an Album class containing a list of songs.
        // The albums will be stored in an ArrayList
        // Songs from different albums can be added to the playlist and will appear in the list in the order
        // they are added.
        // Once the songs have been added to the playlist, create a menu of options to:-
        // Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
        // List the songs in the playlist
        // A song must exist in an album before it can be added to the playlist (so you can only play songs that
        // you own).
        // Hint:  To replay a song, consider what happened when we went back and forth from a city before we
        // started tracking the direction we were going.
        // As an optional extra, provide an option to remove the current song from the playlist
        // (hint: listiterator.remove()

        albums = initAlbums();
        LinkedList<Song> playList = initPlayList();
        play(playList);

    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.size() == 0) {
            System.out.println("No songs in playList");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We have reached the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We have reached the start of the playlist");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the playlist");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().toString());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().toString());
                        } else {
                            System.out.println("Playlist is empty");
                        }
                    } else {
                        System.out.println("Playlist is empty");
                    }
                    break;

                    default:
                        System.out.println("Incorrect action. Try again:");
                        printMenu();
                        break;

            }
        }

    }

    private static ArrayList<Album> initAlbums() {

        Album DanceOfDeath = new Album("Dance Of Death", "Iron Maiden" );
        DanceOfDeath.addSong("Wildest Dreams", 3.52);
        DanceOfDeath.addSong("Rainmaker", 3.48);
        DanceOfDeath.addSong("No More Lies", 7.22);
        DanceOfDeath.addSong("Montsegur", 5.50);
        DanceOfDeath.addSong("Dance of Death", 8.36);
        DanceOfDeath.addSong("Gates of Tomorrow", 5.12);
        DanceOfDeath.addSong("New Frontier", 5.04);
        DanceOfDeath.addSong("Paschendale", 8.28);
        DanceOfDeath.addSong("Face in the Sand", 6.31);
        DanceOfDeath.addSong("Age of Innocence", 6.11);
        DanceOfDeath.addSong("Journeyman", 7.06);

        Album ForThoseAboutToRock = new Album("For Those About to Rock (We Salute You)", "AC/DC" );
        ForThoseAboutToRock.addSong("For Those About to Rock (We Salute You)", 5.44);
        ForThoseAboutToRock.addSong("I Put the Finger on You", 3.26);
        ForThoseAboutToRock.addSong("Let's Get It Up", 3.54);
        ForThoseAboutToRock.addSong("Inject the Venom", 3.31);
        ForThoseAboutToRock.addSong("Snowballed", 3.23);
        ForThoseAboutToRock.addSong("Evil Walks", 4.24);
        ForThoseAboutToRock.addSong("C.O.D.", 3.20);
        ForThoseAboutToRock.addSong("Breaking the Rules", 4.23);
        ForThoseAboutToRock.addSong("Night of the Long Knives", 3.26);
        ForThoseAboutToRock.addSong("Spellbound", 4.39);

        albums.add(DanceOfDeath);
        albums.add(ForThoseAboutToRock);

        return albums;
    }

    private static LinkedList<Song> initPlayList() {
        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("Wildest Dreams", playList);
        albums.get(0).addToPlayList("Dance of Death", playList);
        albums.get(0).addToPlayList("Mana mana", playList);
        albums.get(0).addToPlayList(8, playList);
        albums.get(1).addToPlayList("Snowballed", playList);
        albums.get(1).addToPlayList("Night of the Long Knives", playList);
        albums.get(1).addToPlayList(1, playList);
        albums.get(1).addToPlayList(23, playList);

        return playList;
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 -to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list song in the playlist\n" +
                "5 - print available actions\n" +
                "6 - remove current song from the playlist");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("====================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("====================");
    }
}


