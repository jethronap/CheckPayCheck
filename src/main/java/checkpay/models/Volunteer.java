package checkpay.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author jnap
 */

@Entity
@Table(name = "volunteer")
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 3, max = 50)
    @Column(name = "fname", nullable = false)
    private String fname;

    @Size(min = 3, max = 50)
    @Column(name = "lname", nullable = false)
    private String lname;

    @Size(min = 3, max = 50)
    @Column(name = "profession", nullable = false)
    private String profession;

    @Size(min = 3, max = 50)
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "passHashed", nullable = false)
    private String passHashed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassHashed() {
        return passHashed;
    }

    public void setPassHashed(String passHashed) {
        this.passHashed = passHashed;
    }

    @Override
    public String toString() {
        return "Volunteer{" + "id=" + id + ", fname=" + fname + ", lname=" + lname + ", profession=" + profession + ", email=" + email + ", passHashed=" + passHashed + '}';
    }
    
    
}
