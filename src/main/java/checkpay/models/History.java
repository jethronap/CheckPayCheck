package checkpay.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jnap
 */
@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "dateOfWork", nullable = false)
    private Date dateOfWork;

    @Column(name = "hoursWorked", nullable = false)
    private float hoursWorked;

    @Column(name = "overtime", nullable = false)
    private float overtime;

    @Column(name = "hoursSunday", nullable = false)
    private float hoursSunday;

    @Column(name = "salary", nullable = false)
    private float salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_empl_id")
    private Employee employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfWork() {
        return dateOfWork;
    }

    public void setDateOfWork(Date dateOfWork) {
        this.dateOfWork = dateOfWork;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public float getOvertime() {
        return overtime;
    }

    public void setOvertime(float overtime) {
        this.overtime = overtime;
    }

    public float getHoursSunday() {
        return hoursSunday;
    }

    public void setHoursSunday(float hoursSunday) {
        this.hoursSunday = hoursSunday;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "History{" + "id=" + id + ", dateOfWork=" + dateOfWork + ", hoursWorked=" + hoursWorked + ", overtime=" + overtime + ", hoursSunday=" + hoursSunday + ", salary=" + salary + '}';
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
