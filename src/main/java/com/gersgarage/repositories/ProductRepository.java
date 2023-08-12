package Gers_Garage.repositories;

import Gers_Garage.models.Product;
import jakarta.transaction.Transactional;
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

    @Query("SELECT p FROM Product p WHERE p.item_name = :productName")
    List<Product> findProductByName(@Param("productName") String productId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Product p WHERE p.id_item = :productId")
    void deleteProductById(@Param("productId") Integer productId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Product p WHERE p.item_name = :productName")
    void deleteProductByName(@Param("productName") String productName);

    @Transactional
    @Modifying
    @Query("UPDATE Product p " +
            "SET p.item_name = :#{#updatedProduct.item_name}, " +
            "p.item_cost = :#{#updatedProduct.item_cost} " +
            "WHERE p.id_item = :itemId")
    void updateProduct(@Param("itemId") Integer itemId, @Param("updatedProduct") Product updatedProduct);

}