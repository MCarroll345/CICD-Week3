package ie.atu.week3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private List<Product> products = new ArrayList<>();
    public ProductController(){
        products.add(new Product("Tv", "Made by Phony", 899,100));
        products.add(new Product("Radio", "Made by Phony", 79,101));
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts(){
        return products;
    }

    @PostMapping("addProduct")
    public ResponseEntity addProduct(@RequestBody Product product){
        products.add(product);
        return ResponseEntity.ok(products);
    }

    @PutMapping("changeProduct/{id}")
    public ResponseEntity changeProduct(@PathVariable long id, @RequestBody Product product){
        int num = (int) id;
        for(int count = 0;count < products.size(); count++){
            if(products.get(count).getId() == num){
                products.set(count, product);
            }
        }

        return ResponseEntity.ok(products);
    }

    @DeleteMapping("deleteProduct/{id}")
    public ResponseEntity deleteProduct(@PathVariable long id){
        int num = (int) id;
        for(int count = 0;count < products.size(); count++){
            if(products.get(count).getId() == num){
                products.remove(count);
            }
        }
        return ResponseEntity.ok(products);
    }
}
