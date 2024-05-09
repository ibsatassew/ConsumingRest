import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingRestApplication implements CommandLineRunner {

    @Value("${quoters_base_url}")
    private String quotersBaseUrl;

    public static void main(String[] args) {
        SpringApplication.run(ConsumingRestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        
        // Make RESTful API calls and log the output
        String[] endpoints = {"random", "1", "2", "3"};
        
        for (String endpoint : endpoints) {
            String url = quotersBaseUrl + "/api/" + endpoint;
            String response = restTemplate.getForObject(url, String.class);
            System.out.println("Response from " + url + ": " + response);
        }
    }
}
