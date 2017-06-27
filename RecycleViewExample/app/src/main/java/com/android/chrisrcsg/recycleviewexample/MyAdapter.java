package com.android.chrisrcsg.recycleviewexample;

import android.net.sip.SipAudioCall;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ChrisRCSG on 26/06/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private List<String>nombres;
    private int layout;

    // Nos define los iterables
    private onItemClickListener itemClickListener;


    //Constructor
    public MyAdapter(List<String> nombres, int layout, onItemClickListener itemClickListener) {
        this.nombres = nombres;
        this.layout = layout;
        this.itemClickListener = itemClickListener;
    }

    //se encarga de instalar el contenido del item
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(v);
        return viewHolder;
    }

    //Realiza las modificaciones necesarias para cada Utem
    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        holder.bind(nombres.get(position),itemClickListener);
    }

    @Override
    public int getItemCount() {
        return nombres.size();

    }

    //Implementamos la clase estatica ViewHolder para que conrole los iterables
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ViewHolder(View itemView) {
            super(itemView);
            this.name=(TextView)itemView.findViewById(R.id.nombre);
        }

        public void bind(final String name, final onItemClickListener listener){
            this.name.setText(name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Listener.onItemClick(name,getAdapterPosition());
                }
            });
        }
    }

    public interface onItemClickListener{
        void onItemClick(String name, int position);
    }
}
