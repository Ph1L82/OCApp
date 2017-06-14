package cl.philipsoft.ocapp.data;

import java.util.List;

import cl.philipsoft.ocapp.models.Account;
import cl.philipsoft.ocapp.models.Budget;

/**
 * Created by phil_ on 13-06-2017.
 */

public class BudgetData {
    public List<Budget> budgets() {
        return Budget.listAll(Budget.class);
    }

    public void handler(Budget[] budgets) {
        for (Budget budget :
                budgets) {
            List<Budget> budgetList = Budget.find(Budget.class, "id = ?", String.valueOf(budget.getId()));
            if (budgetList == null || budgetList.size() == 0) {
                budget.save();
            }
        }
    }
}
