package sg.edu.nus.iss.day24_workshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.nus.iss.day24_workshop.model.Order;
import sg.edu.nus.iss.day24_workshop.model.OrderDetails;
import sg.edu.nus.iss.day24_workshop.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    OrderRepository repository;

    @Transactional
    public Boolean newOrderService(Order order, OrderDetails details) {

        Boolean isOrderCreated = false;
        Integer orderKey = repository.addNewOrder(order);

        if (orderKey != null) {
            isOrderCreated = true;
        }

        details.setId(orderKey);

        Boolean isOrderDetailsCreated = false;

        if (repository.addNewOrderDetails(details)) {
            isOrderDetailsCreated = true;
        }

        if (isOrderCreated && isOrderDetailsCreated) {
            return true;
        } else {
            return false;
        }
    }

}
