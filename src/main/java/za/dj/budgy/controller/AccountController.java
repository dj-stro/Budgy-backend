package za.dj.budgy.controller;

import org.springframework.web.bind.annotation.*;
import za.dj.budgy.model.Account;
import za.dj.budgy.service.AccountService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
@CrossOrigin("*")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAll(){
        return accountService.getAll();
    }

    @GetMapping("/accounts")
    public Optional<Account> getAccounts(@RequestParam List<Long> userIds) {
        return accountService.findByUserIdIn(userIds);
    }

    @PostMapping
    public Account create(@RequestBody Account account){
        return accountService.save(account);
    }

    @GetMapping("/{id}")
    public Account getById(@RequestBody Long id){
        return accountService.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        accountService.delete(id);
    }
}
