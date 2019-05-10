package checkpay.models;

import java.io.Serializable;

/**
 *
 * @author jnap
 */
public enum RoleType implements Serializable {
    
    USER("USER"),
    EMPLOYEE("EMPLOYEE"),
    ADMIN("ADMIN");

    String roleType;

    private RoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleType() {
        return roleType;
    }
}
