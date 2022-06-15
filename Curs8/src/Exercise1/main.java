package Exercise1;

public class main {
    public static void main(String[] args) {
        facebook facebookAdd1 = new facebook();
        email emailAdd1 = new email();
        print printAdd1 = new print();

        facebookAdd1.giveAdd("This is a facebook add");
        emailAdd1.giveAdd("This is an email add");
        printAdd1.giveAdd("This is a print add");

        System.out.println(facebookAdd1.getAdd());
        System.out.println(emailAdd1.getAdd());
        System.out.println(printAdd1.getAdd());
    }
}
