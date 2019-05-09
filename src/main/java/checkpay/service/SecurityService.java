package checkpay.service;

/**
 *
 * @author jnap
 */
public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
