package com.example.blade.template;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Blade on 2018/1/3.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private List<OrderEntity> mOrders;

    private TextView orderId;

    private TextView userAddress;

    private TextView recipientAddress;

    private TextView recipientName;

    private TextView recipientNumber;

    private TextView orderTime;



    static class ViewHolder extends RecyclerView.ViewHolder {
        View orderView;
        ImageView itemImage;
        TextView orderId;
        TextView rName;
        Spinner sp;

        public ViewHolder(View view) {
            super(view);
            orderView = view;
            //itemImage = (ImageView)view.findViewById(R.id.item_image);
            orderId = (TextView) view.findViewById(R.id.order_id);
            rName = (TextView) view.findViewById(R.id.recipent_name);
            sp = (Spinner)view.findViewById(R.id.spinner);
        }


    }

    public OrderAdapter(List<OrderEntity> lOrders) {
        mOrders = lOrders;
    }


    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_layout, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                OrderEntity orderEntity = mOrders.get(position);
                //OrderIdEntity orderIdEntity = mOrdersId.get(position);
                //set new Intent here to view order detail
                Toast.makeText(view.getContext(), "you just clicked" + orderEntity.getOrder_id(), Toast.LENGTH_SHORT).show();
                showDialog(parent.getContext(), position);


            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        OrderEntity orders = mOrders.get(position);
        //OrderIdEntity orderId = mOrdersId.get(position);
        //int itemPicture = Integer.parseInt(orders.getItempic());
        //holder.itemImage.setImageResource(itemPicture);
        String orderId = String.valueOf(orders.getOrder_id());
        //String orderid = String.valueOf(orderId.getOrderId()) ;

        holder.orderId.setText(orderId);
        holder.rName.setText(orders.getRecipentname());

    }

    @Override
    public int getItemCount() {
        return mOrders.size();
    }

    public void showDialog(Context context, int position) {
        OrderEntity orderEntity = mOrders.get(position);
        final AlertDialog builder = new AlertDialog.Builder(context, R.style.Dialog).create();
        //String orderId = String.valueOf(orderEntity.getOrder_id());
        builder.show();
        //builder.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        builder.getWindow().setContentView(R.layout.order_detail_layout);
        orderId=(TextView)builder.findViewById(R.id.order_id);
        userAddress = (TextView) builder.findViewById(R.id.user_address);
        recipientAddress=(TextView)builder.findViewById(R.id.recipent_address);
        recipientName=(TextView)builder.findViewById(R.id.recipent_name);
        recipientNumber=(TextView)builder.findViewById(R.id.recipent_number);
        orderTime=(TextView)builder.findViewById(R.id.order_time);
        orderId.setText(String.valueOf(orderEntity.getOrder_id()));
        userAddress.setText(orderEntity.getUseraddress());
        recipientAddress.setText(orderEntity.getRecipentaddress());
        recipientName.setText(orderEntity.getRecipentname());
        recipientNumber.setText(orderEntity.getRecipentnumber());
        orderTime.setText(String.valueOf(orderEntity.getOrdertime()));
        builder.getWindow()
                .findViewById(R.id.btn_confirm)
                .setOnClickListener(new View.OnClickListener() {  //按钮点击事件
                    @Override
                    public void onClick(View v) {
                        builder.dismiss();
                    }
                });
    }

}
