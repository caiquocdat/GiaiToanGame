package com.caiquocdat.giaitoan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.caiquocdat.giaitoan.model.OnSelectAnswer;

import com.caiquocdat.giaitoan.R;

import java.util.List;

public class AnswerPraAdapter extends RecyclerView.Adapter<AnswerPraAdapter.AnswerViewHolder> {

    private List<String> answerList;
    private Context context;
    private String result;
    private OnSelectAnswer listener;

    public AnswerPraAdapter(List<String> answerList, Context context, String result) {
        this.answerList = answerList;
        this.context = context;
        this.result = result;
    }
    public void updateData(List<String> answerList,Context context, String newResult) {
        this.answerList = answerList;
        this.context=context;
        this.result = newResult;
    }

    public void setListener(OnSelectAnswer listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public AnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_answer_pra, parent, false);
        return new AnswerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AnswerViewHolder holder, int position) {
        String answer = answerList.get(position);
        holder.answerTextView.setText(answer);
        holder.answerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.answerTextView.getText().toString().equals(result)){
                    if (listener!=null){
                        listener.onSelect("true");
                    }
                }else{
                    if (listener!=null){
                        listener.onSelect("false");
                    }
                }
                holder.answerTextView.setBackgroundResource(R.drawable.brg_item_point_pra);
            }
        });
        // Set additional fields here
    }

    @Override
    public int getItemCount() {
        return answerList.size();
    }

    public static class AnswerViewHolder extends RecyclerView.ViewHolder {
        TextView answerTextView;

        public AnswerViewHolder(View view) {
            super(view);
            answerTextView = view.findViewById(R.id.itemResultTv);
            // Initialize additional views here
        }
    }
}