package Exercise3;

public class Animal implements Interface{
    private String walk;
    private String talk;
    private String eat;


    @Override
    public String walk() {
        return walk;
    }

    @Override
    public String talk() {
        return talk;
    }

    @Override
    public String eat() {
        return eat;
    }

    public Animal(String walk, String talk, String eat){
        this.walk = walk;
        this.eat = eat;
        this.talk = talk;
    }
}
