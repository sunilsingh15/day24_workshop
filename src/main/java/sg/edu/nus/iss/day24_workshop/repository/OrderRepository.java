package sg.edu.nus.iss.day24_workshop.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.day24_workshop.model.Order;
import sg.edu.nus.iss.day24_workshop.model.OrderDetails;

@Repository
public class OrderRepository {

    @Autowired
    JdbcTemplate template;

    private final String addNewOrderSQL = "insert into orders (order_date, customer_name, ship_address, notes, tax) values (?, ?, ?, ?, ?)";
    private final String addNewOrderDetailsSQL = "insert into order_details (id, product, unit_price, discount, quantity) values (?, ?, ?, ?, ?)";

    public Integer addNewOrder(Order order) {
        KeyHolder generatedKey = new GeneratedKeyHolder();

        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(addNewOrderSQL, new String[] {"order_id"});
                ps.setDate(1, order.getOrderDate());
                ps.setString(2, order.getCustomerName());
                ps.setString(3, order.getShipAddress());
                ps.setString(4, order.getNotes());
                ps.setDouble(5, order.getTax());

                return ps;
            }   
        };

        template.update(psc, generatedKey);

        return generatedKey.getKey().intValue();
    }

    public Boolean addNewOrderDetails(OrderDetails details) {
        int OrderDetailsCreated = template.update(addNewOrderDetailsSQL, details.getId(), details.getProduct(), details.getUnitPrice(), details.getDiscount(), details.getQuantity());
        if (OrderDetailsCreated == 1) {
            return true;
        } else {
            return false;
        }
    }
    
}