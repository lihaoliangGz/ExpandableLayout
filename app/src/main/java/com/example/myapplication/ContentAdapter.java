package com.example.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cvbmgh.expandablelayout.ExpandableLayout;

import java.util.List;

/**
 * author : lhl
 * date : 2020/4/13/013
 * desc :
 */
public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.MyViewHolder> {

    public List<ContentModel> data;

    public ContentAdapter(List<ContentModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_content, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        final ContentModel content = data.get(i);
        myViewHolder.layout.setText(content.getContent(), content.isExpanded(), new ExpandableLayout.OnExpandListener() {
            @Override
            public void expandChange() {
                content.setExpanded(!content.isExpanded());
                notifyItemChanged(i);

//                if (content.isExpanded()) {
//                    //当收起时
//                    LinearLayoutManager layoutManager = (LinearLayoutManager) getregetRecyclerView().getLayoutManager();
//                    int first = layoutManager.findFirstCompletelyVisibleItemPosition();
//                    if (first > 0) {
//                        layoutManager.scrollToPosition(0);
//                    }
//                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        ExpandableLayout layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.expandLayout);
        }
    }
}
