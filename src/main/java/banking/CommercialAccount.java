package banking;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Account implementation for commercial (business) customers.
 * The account's holder is a {@link Company}.
 */
public class CommercialAccount extends Account {
    private List<Person> authorizedUsers;
    
    public CommercialAccount(AccountHolder accountHolder,
                             Long accountNumber,
                             int pin,
                             double startingDeposit) {
        super(accountHolder, accountNumber, pin, startingDeposit);


    }

//    public CommercialAccount(Company company, Long accountNumber, int pin, double startingDeposit) {
//        //AccountHolder accountHolder, Long accountNumber, int pin, double startingDeposit
//        super(company1,accountNumber,pin,startingDeposit);
//        AccountHolder company1 = company;
//
//        // TODO: complete the constructor
//    }
    
    /**
     * Add person to list of authorized users.
     *
     * @param person The authorized user to be added to the account.
     */
    protected void addAuthorizedUser(Person person) {
        if (Objects.isNull(authorizedUsers)) {
            authorizedUsers = new ArrayList<>();
        }
        authorizedUsers.add(person);
    }
    
    /**
     * Verify if the person is part of the list of authorized users for this account.
     *
     * @param person
     * @return <code>true</code> if person matches an authorized user in {@link #authorizedUsers}; <code>false</code> otherwise.
     */
    public boolean isAuthorizedUser(Person person) {
        Optional<Person> first = authorizedUsers.stream()
                                                .filter(x -> x.getFirstName()
                                                              .equals(person.getFirstName()) && x.getLastName()
                                                                                                 .equals(person.getLastName()))
                                                .findFirst();
        
        if (first.isPresent()) {
            return true;
        }
        return false;
    }
}
