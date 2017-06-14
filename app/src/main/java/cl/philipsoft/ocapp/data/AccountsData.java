package cl.philipsoft.ocapp.data;

import java.util.List;

import cl.philipsoft.ocapp.models.Account;

/**
 * Created by phil_ on 13-06-2017.
 */

public class AccountsData {
    public List<Account> accounts() {
        return Account.listAll(Account.class);
    }

    public void handler(Account[] accounts) {
        for (Account account :
                accounts) {
            List<Account> accountList = Account.find(Account.class, "id = ?", String.valueOf(account.getId()));
            if (accountList == null || accountList.size() == 0) {
                account.save();
            }
        }
    }
}
