interface Playable {
    void play();
}

class Guitar implements Playable {
    public void play() {
        System.out.println("Playing the guitar");
    }
}

class Piano implements Playable {
    public void play() {
        System.out.println("Playing the piano");
    }
}

public class MusicDemo {
    public static void main(String[] args) {
        Playable guitarPlayer = new Guitar();
        Playable pianoPlayer = new Piano();

        guitarPlayer.play();  
        pianoPlayer.play();   
    }
}
