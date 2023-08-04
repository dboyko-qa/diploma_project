package ru.intelinvest.api.authorization;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequestDto {
    private String type;
    private String username;
    private String password;
}
