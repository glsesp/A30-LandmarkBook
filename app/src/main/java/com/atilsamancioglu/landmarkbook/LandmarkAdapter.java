package com.atilsamancioglu.landmarkbook;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.atilsamancioglu.landmarkbook.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder> { //landmarkadapter'in içindeki landmark holder.
    //inheritance yapıldı ki o sınıfın kodlarını kullanalım!
    //viewHolder görünüm tutucudur(sınıf)
    //methodlarını uygula(3 tane)
    
    

    ArrayList<Landmark> landmarkList;

    public LandmarkAdapter(ArrayList<Landmark> landmarkList) {
        this.landmarkList = landmarkList;
    }

    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //XML i bağlama işlemi binding burda olur
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LandmarkHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(LandmarkAdapter.LandmarkHolder holder, int position) {
        
        //Oluşan viewHolder bağlanınca neler olacak!
        
        //layout içinde hangi verileri göstereceğiz!
        
        holder.binding.recyclerViewTextView.setText(landmarkList.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),DetailActivity.class);
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenLandmark(landmarkList.get(position));
                //intent.putExtra("landmark",landmarkList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { //XML in kaç kez olusacagını gösterir
        return landmarkList.size(); //listede ne kadarsa o kadar oluştur
    }

    public class LandmarkHolder extends RecyclerView.ViewHolder {
        //Tek olayı Görünüm tutucudur.

        private RecyclerRowBinding binding;

        public LandmarkHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
