package com.iluk.git.mainProj.data.auth;

import com.iluk.git.mainProj.data.user.PlatformUser;
import com.iluk.git.mainProj.data.user.PlatformUserRequest;
import com.iluk.git.mainProj.data.user.PlatformUserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SiqnUpRestController {
    private final PlatformUserService platformUserService;
    public SiqnUpRestController(PlatformUserService platformUserService) {
        this.platformUserService = platformUserService;
    }
    public PlatformUser siqnupPlatformUser(@RequestBody PlatformUserRequest platformUserRequest) {
         return platformUserService.signUp(platformUserRequest);
    }
}
