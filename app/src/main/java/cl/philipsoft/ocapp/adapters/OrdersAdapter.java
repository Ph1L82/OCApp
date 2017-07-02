package cl.philipsoft.ocapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cl.philipsoft.ocapp.R;
import cl.philipsoft.ocapp.data.OrdersData;
import cl.philipsoft.ocapp.models.Order;

/**
 * Created by phil_ on 28-06-2017.
 */

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.ViewHolver> {

    private Context context;
    private List<Order> orders = new OrdersData().orders();

    public OrdersAdapter() {
    }

    @Override
    public ViewHolver onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_card_view, parent, false);
        ViewHolver viewHolver = new ViewHolver(view);
        return viewHolver;
    }

    @Override
    public void onBindViewHolder(ViewHolver holder, int position) {
        Order order = orders.get(position);
        holder.companyName.setText(order.getProvider().getCompany_name());
        holder.rut.setText(order.getProvider().getRut());
        holder.description.setText(order.getDescription());
        holder.creationDate.setText(order.getCreated_at().toString());
        holder.cost.setText(String.valueOf(order.getTotal()));
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public static class ViewHolver extends RecyclerView.ViewHolder {
        public final View view;
        public final TextView companyName, rut, description, creationDate, cost;

        public ViewHolver(View itemView) {
            super(itemView);
            view = itemView;
            companyName = (TextView) view.findViewById(R.id.oc_provider_name);
            rut = (TextView) view.findViewById(R.id.oc_provider_RUT);
            description = (TextView) view.findViewById(R.id.oc_description);
            creationDate = (TextView) view.findViewById(R.id.oc_creation);
            cost = (TextView) view.findViewById(R.id.oc_cost);
        }
    }
}
