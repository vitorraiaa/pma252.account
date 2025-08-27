package store.account;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface AccountController {
    
    @PostMapping("/account")
    public AccountOut create(AccountIn in);

    @GetMapping("/account/{id}")
    public AccountOut findById(
        @PathVariable("id") String id
    );

    @GetMapping("/account")
    public List<AccountOut> findAll();

    @DeleteMapping("/account/{id}")
    public Void delete(
        @PathVariable("id") String id
    );

}
