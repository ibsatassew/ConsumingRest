import org.springframework.web.client.RestTemplate;

public class QuotersClient {

    private final String quotersBaseUrl;

    public QuotersClient(String quotersBaseUrl) {
        this.quotersBaseUrl = quotersBaseUrl;
    }

    public String getRandomQuote() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(quotersBaseUrl + "/api/random", String.class);
    }

    public String getQuoteById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(quotersBaseUrl + "/api/" + id, String.class);
    }

    public static void main(String[] args) {
        String quotersBaseUrl = "http://quoters:8080"; // This assumes you've configured quoters_base_url in application.properties
        QuotersClient client = new QuotersClient(quotersBaseUrl);
        
        // Example: Fetching a random quote
        String randomQuote = client.getRandomQuote();
        System.out.println("Random Quote: " + randomQuote);
        
        // Example: Fetching a quote by ID
        String quoteById = client.getQuoteById(1);
        System.out.println("Quote with ID 1: " + quoteById);
    }
}
