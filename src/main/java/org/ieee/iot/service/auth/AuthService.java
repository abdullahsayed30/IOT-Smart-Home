package org.ieee.iot.service.auth;

import org.ieee.iot.domain.User;
import org.ieee.iot.domain.req.NewUserModel;

public interface AuthService {
    String signupNewUser(NewUserModel userModel);
    String loginUser(String username, String password);
}
