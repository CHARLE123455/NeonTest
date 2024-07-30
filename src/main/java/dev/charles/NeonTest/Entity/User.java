package dev.charles.NeonTest.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "usersTable")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private long id;
    @NotNull
    @NotBlank(message = "name must not be empty")
    private String name;

    @NotNull
    @NotBlank(message = "Password must contain a minimum of 8 and a maximum of 13 characters")
    @Size(min = 8, max = 13, message = "Password must contain a minimum of 8 and a maximum of 13 characters")
    @Pattern(regexp ="(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,13}",
            message = "Password must contain at least one lowercase, one uppercase, one digit, one special character, and be between 8 and 13 characters long")
    private String password;

    @NotNull
    @NotBlank(message = "email should not be empty")
    @Email(message = "Invalid email format")
    @Column(unique = true)
    @Pattern(regexp = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
    private String email;
    @NotEmpty
    @NotNull
    @NotBlank(message = "phone number is mandatory")
    @Pattern(regexp = "^\\+234(80|70|90|81)\\d{8}$|^(080|070|090|081)\\d{8}$",
            message = "Invalid phone number format, phone number must start with +23480,23481,23470,23490 or 080,081,070,090")
    private String phone;

    public User() {

    }

    public User(long id, String name, String password, String email, String phone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
