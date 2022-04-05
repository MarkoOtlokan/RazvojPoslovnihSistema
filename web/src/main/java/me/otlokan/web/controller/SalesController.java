package me.otlokan.web.controller;

import lombok.RequiredArgsConstructor;
import me.otlokan.web.domain.BestCustomer;
import me.otlokan.web.domain.BestCustomerComparator;
import me.otlokan.web.domain.Customer;
import me.otlokan.web.domain.Sale;
import me.otlokan.web.service.SaleService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("api/sales")
@RequiredArgsConstructor
public class SalesController {

    private final SaleService service;

    @PostMapping
    public Sale add(@RequestParam(name = "customerId") final Long customerId,
                    @RequestParam(name = "articleId") final Long articleId,
                    @RequestParam(name = "amount") final Long amount) {
        Sale uspesnost =  service.addSale(customerId, articleId, amount);
        System.out.println(uspesnost);
        return uspesnost;
    }

    @GetMapping
    public List<Sale> findAll() {
        return service.findAll();
    }

    @GetMapping("number-of-sales")
    public Integer countNumberOfSalesForId(@RequestParam("articleId") final Long articleId) {
        return service.countNumberOfSalesForId(articleId);
    }

    @GetMapping("bestcustomers")
    public List<BestCustomer> best() {
        System.out.println("Pogodjen");
        List<Sale> lista = service.findAll();
        List<BestCustomer> bestCustomers = new LinkedList<BestCustomer>();
        boolean a = false;
        for (Sale l: lista) {
            System.out.println(l);
            Long cusId = l.getCustomer().getId();
            a = false;
            for( BestCustomer b: bestCustomers){
                if(b.getCustomerid() == cusId){
                    b.setSpend(b.getSpend() + l.getAmount()*l.getArticle().getPrice());
                    a = true;
                    break;
                }
            }
            if(!a){
                bestCustomers.add(new BestCustomer(l.getCustomer().getId(), l.getCustomer().getFirstName(), l.getCustomer().getLastName(), l.getAmount() * l.getArticle().getPrice()));
                a = false;
            }
        }


        Collections.sort(bestCustomers, new Comparator<BestCustomer>() {
            @Override
            public int compare(BestCustomer o1, BestCustomer o2) {
                return (int) (o2.getSpend() - o1.getSpend());
            }
        });

        return bestCustomers;
    }

}
