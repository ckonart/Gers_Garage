package Gers_Garage.repositories;

import Gers_Garage.models.Client;
import Gers_Garage.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p")
    List<Product> findAllProducts();

    @Query("SELECT p FROM Product p WHERE p.id_item = :productId")
    List<Product> findProductById(@Param("productId") Integer productId);

    @Query("SELECT p FROM Product WHERE p.item_name = productName")
    List<Product> findProductByName(@Param("productId") String productId);

    @Modifying
    @Query("DELETE p FROM Product p WHERE p.id_item = :productId")
    void deleteProductById(@Param("productId") Integer productId);

    @Modifying
    @Query("DELETE p FROM Product p WHERE p.item_name = :productName")
    void deleteProductByName(@Param("productName") String productName);

    @Modifying
    @Query("UPDATE Product p " +
            "SET p.item_name = :#{#updatedProduct.item_name}, " +
            "p.item_cost = :#{#updatedProduct.item_cost} " +
            "WHERE p.id_item = :itemId")
    void updateProduct(@Param("itemId") Integer itemId, @Param("updatedProduct") Product updatedProduct);
}