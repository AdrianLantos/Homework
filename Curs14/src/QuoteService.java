import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuoteService {
    private List<Quote> allQuotes;
    private List<Quote> favoriteQuotes = new ArrayList<>();

    {
        try {
            allQuotes = readFromFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private List<Quote> readFromFile() throws IOException {
        List<Quote> result = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("Files/quotes.txt"));
        String line;
        int id = 1;
        while ((line = reader.readLine()) != null) {
            String[] token = line.split("~");
            result.add(new Quote(token[0], token[1], id++));
        }
        return result;
    }

    public List<String> getAllQuotes() {
        List<String> results = new ArrayList<>();
        for (Quote quote : allQuotes) {
            results.add(quote.getQuote());
        }
        return results;
    }

    public List<String> getAllAuthors() {
        List<String> results = new ArrayList<>();
        for (Quote quote : allQuotes) {
            results.add(quote.getAuthor());
        }
        return results;
    }

    public List<Quote> getQuotesForAuthor(String author) {
        boolean getException = true;
        List<Quote> result = new ArrayList<>();
        for (Quote quote : allQuotes) {
            if (author.equals(quote.getAuthor())) {
                result.add(quote);
                getException = false;
            }
        }
        if(getException){
            throw new NoQuoteFoundException("No author with that name found.");
        }
        return result;
    }

    public void setFavorite(int id) {
        boolean getException = true;
        for (Quote quote : allQuotes) {
            if (id == quote.getId()) {
                quote.setFavourite(true);
                favoriteQuotes.add(quote);
                getException = false;
                break;
            }
        }
        if(getException){
            throw new NoQuoteFoundException("No quote with that id found");
        }
    }

    public List<Quote> getFavorites() {
        return favoriteQuotes;
    }

    public String getRandomQuote() {
        Random random = new Random();
        int randomId = random.nextInt(allQuotes.size() + 1);
        while (randomId == 0) {
            randomId = random.nextInt(allQuotes.size() + 1);
        }
        //E mai eficient sa fac allQuotes.get(randomId);
        for (Quote quote : allQuotes) {
            if(randomId == quote.getId()){
                return String.valueOf(quote.getId() + ". ") + quote.getQuote();
            }
        }
        return null;
    }

}
