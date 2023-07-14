package api.authorization;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequestDto {
    //{"type":"USERNAME_OR_EMAIL","username":"dbtest1983@gmail.com","password":"eYUZcEz5GL"}
    String type;
    String username;
    String password;

}
