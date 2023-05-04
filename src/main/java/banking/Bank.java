package banking;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The Bank implementation.
 */
public class Bank implements BankInterface {
    private LinkedHashMap<Long, Account> accounts;
    
    public Bank() {
        accounts = new LinkedHashMap<>();
    }
    
    private Account getAccount(Long accountNumber) {
        return accounts.get(accountNumber);
    }
    
    public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
        Long accountNumber = accounts.size() + 1L;
        Account commercialAccount = new CommercialAccount(company, accountNumber, pin, startingDeposit);
        accounts.put(accountNumber, commercialAccount);
        return accountNumber;
    }
    
    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
        Long accountNumber = accounts.size() + 1L;
        Account account = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
        accounts.put(accountNumber, account);
        return -1L;
    }
    
    public double getBalance(Long accountNumber) {
        Account account = accounts.get(accountNumber);
        return account.getBalance();
    }
    
    public void credit(Long accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        account.creditAccount(amount);
        
    }
    
    public boolean debit(Long accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        return account.debitAccount(amount);
        
    }
    
    public boolean authenticateUser(Long accountNumber, int pin) {
        Account account = accounts.get(accountNumber);
        if(account.getAccountHolder().getIdNumber()==pin){
            return true;
        }
        return false;
    }
    
    public void addAuthorizedUser(Long accountNumber, Person authorizedPerson) {
        Account account = accounts.get(accountNumber);
        if(account instanceof CommercialAccount){
            CommercialAccount account1 = (CommercialAccount) account;
            account1.addAuthorizedUser(authorizedPerson);
        }
    }
    
    public boolean checkAuthorizedUser(Long accountNumber, Person authorizedPerson) {
        Account account = accounts.get(accountNumber);
        if(account instanceof CommercialAccount){
            CommercialAccount account1 = (CommercialAccount) account;
            return account1.isAuthorizedUser(authorizedPerson);
        }
        
        return false;
    }
    
    public Map<String, Double> getAverageBalanceReport() {
        // TODO: complete the method
        return new HashMap<>();
    }
}
