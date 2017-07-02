package cl.philipsoft.ocapp.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import cl.philipsoft.ocapp.R;
import cl.philipsoft.ocapp.views.MainActivity;
import cl.philipsoft.ocapp.views.tabs.BudgetFragment;
import cl.philipsoft.ocapp.views.tabs.HistoryFragment;
import cl.philipsoft.ocapp.views.tabs.OrdersFragment;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private Context context;

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                OrdersFragment ordersFragment = new OrdersFragment();
                return ordersFragment;
            case 1:
                return BudgetFragment.newInstance();
            case 2:
                return HistoryFragment.newInstance();
            default:
                return OrdersFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getResources().getString(R.string.pending_orders_tab);
            case 1:
                return context.getResources().getString(R.string.budget_tab);
            case 2:
                return context.getResources().getString(R.string.history_orders_tab);
        }
        return null;
    }
}
