public class Main {
    public static void main(String[] args) {
        QuoteService test = new QuoteService();

//        System.out.println(test.getAllAuthors());
        System.out.println(test.getRandomQuote());
//        System.out.println(test.getAllQuotes());
        test.setFavorite(4442);
        test.setFavorite(5396);
        System.out.println(test.getFavorites());
        System.out.println(test.getQuotesForAuthor("Rene Descartes"));
    }
}
