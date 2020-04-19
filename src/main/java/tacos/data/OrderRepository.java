package tacos.data;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import tacos.Order;
import tacos.User;

public interface OrderRepository extends CrudRepository<Order, Long> {
//	List<Order> findByDeliveryZip(String deliveryZip);
//
//	List<Order> readOrdersByDeliveryZipAndPlaceAtBetween(String deliveryZip, Date startDate, Date endDate);
//
//	List<Order> findByDeliveryToAndDeliveryCityAllIgnoresCase(String deliveryTo, String deliveryCity);
//
//	List<Order> findByDeliveryCityOrderByDeliveryTo(String city);
//	
//	@Query("Order o where o.deliveryCity='Seattle'")
//	List<Order> readOrdersDeliveredInSeattle();
	List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
