package me.otlokan.web.repository;

import me.otlokan.web.domain.BestCustomer;
import me.otlokan.web.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("select count(S.id) from Sale S where S.article.id = ?1")
    Integer countNumberOfSalesForId(Long articleId);

}
