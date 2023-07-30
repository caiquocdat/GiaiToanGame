package com.example.giaitoan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.giaitoan.R;
import com.example.giaitoan.model.AnswerModel;
import com.example.giaitoan.model.OnSelectAnswer;

import java.util.List;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.AnswerViewHolder> {

    private List<AnswerModel> answerList;
    private Context context;
    private String result;
    private OnSelectAnswer listener;

    public AnswerAdapter(List<AnswerModel> answerList, Context context, String result) {
        this.answerList = answerList;
        this.context = context;
        this.result = result;
    }
    public void updateData(List<AnswerModel> answerList,Context context, String newResult) {
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
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_answer, parent, false);
        return new AnswerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AnswerViewHolder holder, int position) {
        AnswerModel answer = answerList.get(position);
        holder.answerTextView.setText(answer.getText());
        holder.answerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.answerTextView.getText().toString().equals(result)){
                    if (listener!=null){
                        listener.onSelect("true");
                        listener.onSelect("true");
                    }
                }else{
                    if (listener!=null){
                        listener.onSelect("false");
                    }
                }
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