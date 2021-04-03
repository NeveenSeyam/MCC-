package com.example.mccanals;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.NewViewHolder> {
    Context mcontext;
    List<DataItem> mdata;
    String cat ;
    public NewAdapter(Context mcontext, List<DataItem> mdata, String cat) {
        this.mcontext = mcontext;
        this.mdata = mdata;
        this.cat=cat;
    }
    @NonNull
    @Override
    public NewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View layout;
        layout = LayoutInflater.from(mcontext).inflate(R.layout.view_item, viewGroup, false);
        return new NewViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull NewViewHolder holder, int position) {
        //bind Data here

        if (position == mdata.size() / 2 /* calculate middle element position */) {
            NewViewHolder.setIsInTheMiddle(true);
            holder.tv_title.setText(mdata.get(position).title);
            holder.tv_content.setText(mdata.get(position).content);
            holder.tv_rate.setText(mdata.get(position).rate);
            holder.contener.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("aaaa" , "cliced");
                    final Intent intent=new Intent(mcontext,ShowActivity.class);
                    intent.putExtra("postion",mdata.get(position).toString());
                    intent.putExtra("cat" ,cat );
                    mcontext.startActivity(intent);
                }
            });
        } else {
            NewViewHolder.setIsInTheMiddle(false);
            holder.tv_title.setText(mdata.get(position).title);
            holder.tv_content.setText(mdata.get(position).content);
            holder.tv_rate.setText(mdata.get(position).rate);
        }

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }


    public static class NewViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title, tv_content, tv_rate;
        ConstraintLayout contener ;
        // We'll use this field to showcase matching the holder from the test.
        private static boolean mIsInTheMiddle = false;

        public NewViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_content = itemView.findViewById(R.id.tv_content);
            contener = itemView.findViewById(R.id.container);
            tv_rate = itemView.findViewById(R.id.tv_rate);
        }

        public TextView getTv_title() {
            return tv_title;
        }

        public TextView getTv_content() {
            return tv_content;
        }

        public TextView getTv_rate() {
            return tv_rate;
        }

        boolean getIsInTheMiddle() {
            return mIsInTheMiddle;
        }

        static void setIsInTheMiddle(boolean isInTheMiddle) {
            mIsInTheMiddle = isInTheMiddle;
        }

    }
}
