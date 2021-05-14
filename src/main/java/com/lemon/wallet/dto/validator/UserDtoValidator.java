package com.lemon.wallet.dto.validator;

import com.lemon.wallet.dto.UserDto;
import com.lemon.wallet.exception.ApiException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

@Component
public class UserDtoValidator {

    public void validate(UserDto user) {
        StringBuilder sb = new StringBuilder();

        Boolean valid = true;

        if(Strings.isBlank(user.getAlias())) {
            sb.append("Alias must be a mandatory attribute");
            valid = false;
        }

        if(Strings.isBlank(user.getEmail())) {
            sb.append("Email must be a mandatory attribute");
            valid = false;
        }

        if(!valid) {
            throw new ApiException(sb.toString());
        }
    }
}
