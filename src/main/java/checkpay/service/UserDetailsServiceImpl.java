package checkpay.service;

import checkpay.models.Role;
import checkpay.models.User;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    
    static final Logger logger = LoggerFactory.getLogger(UserDetailsService.class);
	
	@Autowired
	private UserService userService;
	
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userService.findByUsername(username);
		logger.info("User : {}", user);
		if(user==null){
			logger.info("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), 
				 true, true, true, true, getGrantedAuthorities(user));
	}

	
	private List<GrantedAuthority> getGrantedAuthorities(User user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(Role role : user.getRoles()){
			logger.info("UserProfile : {}", role);
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
		}
		logger.info("authorities : {}", authorities);
		return authorities;
	}
    /*
    static final Logger logger = LoggerFactory.getLogger(UserDetailsService.class);
    @Autowired
    private UserDao dao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        User user = dao.findByUsername(username);
        logger.info("User : {}", user);
        if (user == null) {
            logger.info("User not found");
            throw new UsernameNotFoundException(username);
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            logger.info("Role : {}", role);
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        logger.info("authorities : {}", grantedAuthorities);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
*/
}
