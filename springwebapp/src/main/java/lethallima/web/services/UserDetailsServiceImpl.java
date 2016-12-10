package lethallima.web.services;

import lethallima.web.dao.UserDAO;
import lethallima.web.entities.Role;
import lethallima.web.entities.User;
import lethallima.web.entities.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by LethalLima on 11/8/16.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User loggedInUser = userDAO.getUserByUsername(username);

        return new UserPrincipal(loggedInUser.getId(), loggedInUser.getUsername(),
                loggedInUser.getPassword(), buildUserAuthorities(loggedInUser.getRoles()));
    }

    private Collection<? extends GrantedAuthority> buildUserAuthorities(Set<Role> roles) {
        Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();

        roles.forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole())));

        return grantedAuthorities;
    }
}
