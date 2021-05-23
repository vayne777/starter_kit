package starter_kit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class RestPhone {
    @Autowired
    private RestTemplate restTemplate;

    public String getPhonesById(Integer id) {
        String url = System.getenv("rs.endpoint");
        try {
            ResponseEntity<String[]> responseEntity = restTemplate.getForEntity(url + "/api/v1/phones/" + id, String[].class);
            if (responseEntity.getStatusCode().value() == 200) {
                List<String> list = Arrays.asList(responseEntity.getBody());
                return list.get(0);
            }
            else
            {
                return "+7 (495) 111-11-11";
            }
        } catch (HttpStatusCodeException ex) {
            return "2";
        }
        catch (IllegalArgumentException ex) {
            return "1";
        }
    }

}
