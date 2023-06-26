package sg.edu.nus.iss.day24_workshop.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Integer orderID;
    private Date orderDate;
    private String customerName;
    private String shipAddress;
    private String notes;
    private Double tax;
    
}
