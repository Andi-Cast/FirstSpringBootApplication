package SpringBoot.FirstProject.member;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Member {
    @Id
    @SequenceGenerator(
            name = "member_sequence",
            sequenceName = "member_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "member_sequence"
    )
    private Long id;
    private String email;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    @Transient
    private Integer age;

    public Member() {
    }
    public Member(Long id,
                  String email,
                  String firstname,
                  String lastname,
                  LocalDate dateOfBirth) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
    }

    public Member(String email,
                  String firstname,
                  String lastname,
                  LocalDate dateOfBirth) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                '}';
    }
}
