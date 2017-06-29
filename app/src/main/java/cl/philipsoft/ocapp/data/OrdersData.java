package cl.philipsoft.ocapp.data;

import java.util.List;

import cl.philipsoft.ocapp.models.Order;

/**
 * Created by phil_ on 28-06-2017.
 */

public class OrdersData {
    public void handler(Order[] orders){
        for (Order order : orders){
            List<Order> orderList = Order.find(Order.class,"order_id = ?",String.valueOf(order.getOrder_id()));
            if (orderList == null && orderList.size() == 0) {
                order.save();
            }
        }
    }
    public List<Order> orders(){
        return Order.listAll(Order.class);
    }
}
