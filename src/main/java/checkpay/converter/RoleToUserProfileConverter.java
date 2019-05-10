package checkpay.converter;

import checkpay.models.Role;
import checkpay.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author jnap
 */
/**
 * A converter class used in views to map id's to actual role objects.
 */
@Component
public class RoleToUserProfileConverter implements Converter<Object, Role>{
    static final Logger logger = LoggerFactory.getLogger(RoleToUserProfileConverter.class);
    @Autowired
	RoleService roleService;

	/**
	 * Gets Role by Id
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	public Role convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		Role role= roleService.findById(id);
		logger.info("Role : {}",role);
		return role;
	}
}
