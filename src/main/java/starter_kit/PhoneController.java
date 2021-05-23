package starter_kit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class PhoneController {
    @Autowired
    RestPhone restPhone;
    @GetMapping("/user/{id}")
    public ResponseEntity<UserInformationDto> getUserInfo(@PathVariable Integer id) {
        Integer usrNumber = id;
        UserInformationDto dto = new UserInformationDto();

        dto.setName("Иван Иванов");
     //   dto.setPhone("+7 (495) 111-11-11");
        String list =  restPhone.getPhonesById(id);
        switch (list) {
            case "1": {
                dto.setCode(1);
                break;
            }
            case "2": {
                dto.setCode(2);
                break;
            }
            default: {
                dto.setCode(0);
                dto.setPhone(list);
            }
        }

        return new ResponseEntity<>(dto, HttpStatus.OK);

    }
}
