package com.iluk.git.mainProj.data.user;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class PlatformUserDetailsService implements UserDetailsService {
    private final PlatformUserRepository platformUserRepository;
    public PlatformUserDetailsService(PlatformUserRepository platformUserRepository) {
        this.platformUserRepository = platformUserRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var platformUser = platformUserRepository.findByUsername(username);
        if (platformUser.isPresent()) {
            var platformUserObject = platformUser.get();
            return User.builder()
                    .username(platformUserObject.getUsername())
                    .password(platformUserObject.getPassword())
                    .roles(platformUserObject.getRole().name())
                    .build();
        } else {
            throw new UsernameNotFoundException(username);
        }

    }
}
