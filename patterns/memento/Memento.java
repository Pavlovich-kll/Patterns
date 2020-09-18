package patterns.memento;

public class Memento {
    public static void main(String[] args) {
        Game game = new Game("LEVEL 1", 10000);
        System.out.println(game);
        File file = new File(game.save());
        game.set("LEVEL 2", 200000);
        System.out.println(game);
        game.load(file.getSave());
        System.out.println(game);
    }
}

class Game {
    private String level;
    private int time;

    public Game(String level, int time) {
        this.level = level;
        this.time = time;
    }

    public void set(String level, int time) {
        this.level = level;
        this.time = time;
    }

    public Save save() {
        return new Save(this.level, this.time);
    }

    public void load(Save save) {
        this.level = save.getLevel();
        this.time = save.getTime();
    }

    @Override
    public String toString() {
        return "Game{" +
                "level='" + level + '\'' +
                ", time=" + time +
                '}';
    }
}

class Save {
    private String level;
    private int time;

    public Save(String level, int time) {
        this.level = level;
        this.time = time;
    }

    public String getLevel() {
        return level;
    }

    public int getTime() {
        return time;
    }

}

class File {
    private Save save;

    public File(Save save) {
        this.save = save;
    }

    public Save getSave() {
        return save;
    }
}