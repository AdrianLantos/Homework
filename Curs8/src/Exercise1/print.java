package Exercise1;

public class print implements AddInterface{
    public String getAdd() {
        return add;
    }

    private String add;

    @Override
    public void giveAdd(String add) {
        this.add = add;
    }
}
