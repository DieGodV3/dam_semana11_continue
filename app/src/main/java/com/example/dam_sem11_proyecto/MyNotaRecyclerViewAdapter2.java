package com.example.dam_sem11_proyecto;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dam_sem11_proyecto.databinding.FragmentItem2Binding;

import java.util.List;


public class MyNotaRecyclerViewAdapter2 extends RecyclerView.Adapter<MyNotaRecyclerViewAdapter.ViewHolder> {

    private final List<Nota> mValues;
    private final NotasInteraccionListener mListener;
    public MyNotaRecyclerViewAdapter(List<Nota> items, NotasInteraccionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(parent);
//        return new ViewHolder(parent, FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.tvTitulo.setText(holder.mItem.getTitulo());
        holder.tvContenido.setText(holder.mItem.getContenido());
        if(holder.mItem.isFavorita()) {
            holder.ivFavorita.setImageResource(R.drawable.baseline_star_border_24);
        }
        holder.ivFavorita.setOnClickListener((v)->{
            if(null != mListener){
                mListener.favoritaNotaClick(holder.mItem);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public  View mView;
        public final TextView tvTitulo;
        public final TextView tvContenido;
        public final ImageView ivFavorita;

        public Nota mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvTitulo = view.findViewById(R.id.textViewTitulo);
            tvContenido = view.findViewById(R.id.textViewContenido);
            ivFavorita = view.findViewById(R.id.imageView);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvTitulo.getText() + "'";
        }
    }
}