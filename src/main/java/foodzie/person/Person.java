package foodzie.person;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
// Persistence
@Entity
@Table(name = "person")
public class Person implements Serializable {

  @Id
  @Column(unique = true)
  @GeneratedValue
  long id;

  @Column(name = "first_name")
  @NotNull
  String firstName;

  @Column(name = "last_name")
  @NotNull
  String lastName;

  @Column(name = "email", unique = true)
  @NotNull
  String email;

  @Column(name = "date_of_birth")
  @JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
  @NotNull
  LocalDate dateOfBirth;

  @Column(name = "username", unique = true)
  @NotNull
  String username;

  @Column(name = "password")
  @NotNull
  String password;

}
