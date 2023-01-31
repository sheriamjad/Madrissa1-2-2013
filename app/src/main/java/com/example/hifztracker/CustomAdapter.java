package com.example.hifztracker;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    private ArrayList ids , names,sabak,sabki,manzil,date;
    CustomAdapter(Context _context,ArrayList _ids,ArrayList _names,ArrayList _sabak,ArrayList _sabki,ArrayList _manzil,ArrayList _date){
        this.context = _context;
        this.ids = _ids;
        this.names = _names;
        this.sabak = _sabak;
        this.sabki = _sabki;
        this.manzil= _manzil;
        this.date = _date;

    }
    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {

        holder.txtID.setText(String.valueOf(ids.get(position)));
        holder.txtName.setText(String.valueOf(names.get(position)));
        holder.txtSabak.setText(String.valueOf(sabak.get(position)));
        holder.txtSabki.setText(String.valueOf(sabki.get(position)));
        holder.txtManzil.setText(String.valueOf(manzil.get(position)));
        holder.txtDate.setText(String.valueOf(date.get(position)));
    }

    @Override
    public int getItemCount() {
        return ids.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtID;
        TextView txtName;
        TextView txtSabak;
        TextView txtSabki;
        TextView txtManzil;
        TextView txtDate;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtID = itemView.findViewById(R.id.studentId);
            txtID = itemView.findViewById(R.id.sName);
            txtID = itemView.findViewById(R.id.cSabak);
            txtID = itemView.findViewById(R.id.cSabki);
            txtID = itemView.findViewById(R.id.cManzil);
            txtID = itemView.findViewById(R.id.cDate);
        }
    }
}

//    private Context context;
//    private Activity activity;
//    private ArrayList book_id, book_title, book_author, book_pages;
//
//    CustomAdapter(Activity activity, Context context, ArrayList book_id, ArrayList book_title, ArrayList book_author,
//                  ArrayList book_pages){
//
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
////        LayoutInflater inflater = LayoutInflater.from(context);
////        View view = inflater.inflate(R.layout.my_row, parent, false);
////        return new MyViewHolder(view);
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.M)
//    @Override
//    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
//        holder.book_id_txt.setText(String.valueOf(book_id.get(position)));
//        holder.book_title_txt.setText(String.valueOf(book_title.get(position)));
//        holder.book_author_txt.setText(String.valueOf(book_author.get(position)));
//        holder.book_pages_txt.setText(String.valueOf(book_pages.get(position)));
//        //Recyclerview onClickListener
//        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, UpdateActivity.class);
//                intent.putExtra("id", String.valueOf(book_id.get(position)));
//                intent.putExtra("title", String.valueOf(book_title.get(position)));
//                intent.putExtra("author", String.valueOf(book_author.get(position)));
//                intent.putExtra("pages", String.valueOf(book_pages.get(position)));
//                activity.startActivityForResult(intent, 1);
//            }
//        });
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return book_id.size();
//    }
//
//    class MyViewHolder extends RecyclerView.ViewHolder {
//
//        TextView book_id_txt, book_title_txt, book_author_txt, book_pages_txt;
//        LinearLayout mainLayout;
//
//        MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//            book_id_txt = itemView.findViewById(R.id.book_id_txt);
//            book_title_txt = itemView.findViewById(R.id.book_title_txt);
//            book_author_txt = itemView.findViewById(R.id.book_author_txt);
//            book_pages_txt = itemView.findViewById(R.id.book_pages_txt);
//            mainLayout = itemView.findViewById(R.id.mainLayout);
//            //Animate Recyclerview
//            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
//            mainLayout.setAnimation(translate_anim);
//        }
//
//    }


