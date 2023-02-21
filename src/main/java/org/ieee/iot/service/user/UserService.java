package org.ieee.iot.service.user;

import org.ieee.iot.domain.User;
import org.ieee.iot.helper.req_model.NewUserModel;


/*************************************************
 * Copyright (c) 2023-2-18 Abdullah Sayed Sallam.
 ************************************************/

public interface UserService {
    String signupNewUser(NewUserModel userModel);
    String loginUser(String username, String password);
    boolean hasRoom(Long roomId, User user);
}
