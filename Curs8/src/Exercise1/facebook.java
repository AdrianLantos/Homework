package Exercise1;

public class facebook implements AddInterface{
    private String add;

    public String getAdd() {
        return add;
    }

    @Override
    public void giveAdd(String add) {
        this.add = add;
    }
}
