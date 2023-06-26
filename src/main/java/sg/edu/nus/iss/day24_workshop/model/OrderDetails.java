package sg.edu.nus.iss.day24_workshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {

    private Integer id;
    private String product;
    private Double unitPrice;
    private Double discount;
    private Integer quantity;
   
    }


