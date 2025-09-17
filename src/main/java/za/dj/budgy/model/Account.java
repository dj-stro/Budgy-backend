package za.dj.budgy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private BigDecimal balance;

    private BigDecimal budgetBalance;

    //private BigDecimal budgetAvailable;

    private BigDecimal budgetAllowed;

    @ManyToOne
    @JsonIgnoreProperties({"password", "email", "accounts", "transactions"})
    private AppUser user;
}
