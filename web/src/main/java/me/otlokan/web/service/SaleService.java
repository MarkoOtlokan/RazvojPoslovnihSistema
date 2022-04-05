package me.otlokan.web.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import me.otlokan.web.domain.Article;
import me.otlokan.web.domain.BestCustomer;
import me.otlokan.web.domain.Customer;
import me.otlokan.web.domain.Sale;
import me.otlokan.web.repository.ArticleRepository;
import me.otlokan.web.repository.CustomerRepository;
import me.otlokan.web.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final CustomerRepository customerRepository;
    private final ArticleRepository articleRepository;
    private final SaleRepository saleRepository;

    public Sale addSale(@NonNull Long customerId, @NonNull Long articleId, @NonNull Long amount) {
        final Customer customer = customerRepository.findById(customerId).orElseThrow();
        final Article article = articleRepository.findById(articleId).orElseThrow();
        final Sale sale = Sale.builder()
                .article(article)
                .customer(customer)
                .amount(amount)
                .build();
        System.out.println("unosim ga u bazu");
        System.out.println(sale);
        return saleRepository.save(sale);
    }

    public Integer countNumberOfSalesForId(final Long articleId) {
        return saleRepository.countNumberOfSalesForId(articleId);
    }

    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

}
