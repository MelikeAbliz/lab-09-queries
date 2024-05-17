package com.cydeo.repository;

import com.cydeo.entity.CartItem;
import com.cydeo.enums.CartState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    //Write a derived query to get the count of all cart items
    Integer countAllBy();
    //Write a derived query to get cart items for specific cart state
    List<CartItem> findAllByCart_CartState(CartState cartState);

    //Write a native query to get cart items for specific cart state and product name
    @Query(value = "select * from CartItem ci join cart c on ci.cart_id=c.id join product p on ci.product_id=p.id " +
            "where c.cart_state=?1 and p.name=?2"
            ,nativeQuery = true)
    List<CartItem> retrieveCartItemsWithStateAndProductName(String cartState, String productName);

    //Write a native query to get cart items for specific cart state and without discount
    @Query(value = "select * from CartItem ci join Cart c on ci.cart_id=c.id where c.cart_state=?1 and c.discount_id is null  ",nativeQuery = true)
    List<CartItem> retrieveCartItemsWithStateAndWithoutDiscount(String cartState);

}
