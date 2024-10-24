//Sahej Chawla
//CS2210A

public class Data {
    private String configuration;
    private int score;

    public Data(String configuration, int score) {
        this.configuration = configuration;
        this.score = score;
    }

    public String getConfiguration() {
        return configuration; // Returns the board configuration string
    }

    public int getScore() {
        return score; // Returns the score
    }
}