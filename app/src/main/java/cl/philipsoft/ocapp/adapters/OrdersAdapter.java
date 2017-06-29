package cl.philipsoft.ocapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cl.philipsoft.ocapp.R;
import cl.philipsoft.ocapp.data.OrdersData;
import cl.philipsoft.ocapp.models.Order;

/**
 * Created by phil_ on 28-06-2017.
 */

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.ViewHolver> {

    private List<Order> orders = new OrdersData().orders();

    @Override
    public ViewHolver onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_card_view, parent, false);
        ViewHolver viewHolver = new ViewHolver(view);
        return viewHolver;
    }

    @Override
    public void onBindViewHolder(ViewHolver holder, int position) {

    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public static class ViewHolver extends RecyclerView.ViewHolder {
        public ViewHolver(View itemView) {
            super(itemView);
        }
    }
}
