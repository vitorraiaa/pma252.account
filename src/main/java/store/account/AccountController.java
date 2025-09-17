package store.account;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "account", url = "http://account:8080")
public interface AccountController {
    
    @PostMapping("/account")
    public ResponseEntity<AccountOut> create(
        @RequestBody AccountIn in
    );

    @GetMapping("/account/{id}")
    public ResponseEntity<AccountOut> findById(
        @PathVariable("id") String id
    );

    @PostMapping("/account/login")
    public ResponseEntity<AccountOut> findByEmailAndPassword(
        @RequestBody AccountIn in
    );

    @GetMapping("/account")
    public ResponseEntity<List<AccountOut>> findAll();

    @DeleteMapping("/account/{id}")
    public ResponseEntity<Void> delete(
        @PathVariable("id") String id
    );

    @GetMapping("/account/whoami")
    public ResponseEntity<AccountOut> whoAmI(
        @RequestHeader(value = "id-account", required = true) String idAccount
    );

}
