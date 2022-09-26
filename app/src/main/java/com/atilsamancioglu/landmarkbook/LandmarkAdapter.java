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
    
    

    ArrayList<Landmark> landmarkList; //main activity de ulasabilmek için oluşturuldu
    //çünkü return de ArrayList kadar döndürülecek!

    public LandmarkAdapter(ArrayList<Landmark> landmarkList) {
        this.landmarkList = landmarkList;
    }

    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        
        //XML i bağlama işlemi binding burda olur
        
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        //parentgetContext çünkü yukardaki sınıfta ViewGroup parent
        //this üst sınıfa referans verir ve biz aktivitiy içinde değiliz şuan
        //parent a bağlanmasına-false
        
        //ınflate-xml ile kodu birbirine bağlamaya calısıyor
        
        return new LandmarkHolder(recyclerRowBinding); 
        
        //ViewHolder sınıfından bir obje döndermemiz lazım
        //LandMarkHolder-bindingi-recyclerrowbinding
    }

    @Override
    public void onBindViewHolder(LandmarkAdapter.LandmarkHolder holder, int position) {
        
        //Oluşan viewHolder bağlanınca neler olacak!
        
        //layout içinde hangi verileri göstereceğiz!
        
        holder.binding.recyclerViewTextView.setText(landmarkList.get(position).name);
        //findviewbyId yerine kullanılır
        //landmark array de sıra kimdeys (position)
        //istedğimiz  isim,ülke, vs göster

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            
           //TIKLAYINCA NE OLACAK ORASI BURDA!!
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
       //yardımcı sınıf
        //Tek olayı Görünüm tutucudur.

        private RecyclerRowBinding binding;
        //View Binding burda kullanılacak
        //recycler row içinde bir binding oluştu

        public LandmarkHolder(RecyclerRowBinding binding) {
            //landmarkholder her olusunca bir binding isteyecek -
            //ve verilen parametreye göre bağlanır
            super(binding.getRoot()); //görünümü alır
            this.binding = binding;
        }
    }
}
