package ru.netcracker.travelplanner.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name="Users")
@Table(name="users")
public class User {
    @Id
    @Column(name="id", length = 6, nullable = false)
    @GeneratedValue(generator = "increment")
//    @OneToMany(mappedBy = "user_id")
    private long id;
    @Column(name="email", nullable = false)
    private String Email;
    @Column(name="first_name", length = 50, nullable = false)
    private String FirstName;
    @Column(name="last_name", length = 50, nullable = false)
    private String LastName;
    @Column(name="birth_date")
    private Date BirthDate;
    @Column(name="is_admin", nullable = false)
    private boolean IsAdmin;
    @Column(name="registration_date", nullable = false)
    private Date RegistrationDate;
    @Column(name="password", nullable = false)
    private String Password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Email='" + Email + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", BirthDate=" + BirthDate +
                ", IsAdmin=" + IsAdmin +
                ", RegistrationDate=" + RegistrationDate +
                ", Password='" + Password + '\'' +
                '}';
    }
}
