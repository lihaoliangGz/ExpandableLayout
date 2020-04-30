package com.cvbmgh.expandablelayout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * author : lhl
 * date : 2020/4/13/013
 * desc :
 */
public class ExpandableLayout extends LinearLayout {
    private ExpandTextView etvContext;
    private TextView stateTv;
    private OnExpandListener mListener;

    public ExpandableLayout(Context context) {
        this(context, null);
    }

    public ExpandableLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ExpandableLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOrientation(VERTICAL);
        LayoutInflater.from(getContext()).inflate(R.layout.expand_layout, this, true);
        etvContext = findViewById(R.id.expandable_text);
        stateTv = findViewById(R.id.expand_collapse);

        etvContext.setLineSpacing(0, 1.3f);

        etvContext.requestLayout();
        stateTv.requestLayout();

    }

    public void setText(String text, boolean expand, OnExpandListener onExpandListener) {
        mListener = onExpandListener;
//        setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mListener != null) {
//                    mListener.expandChange();
//                }
//            }
//        });
        stateTv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.expandChange();
                }
            }
        });

        etvContext.setChanged(expand);
        etvContext.setText(text, expand, new ExpandTextView.Callback() {
            @Override
            public void onExpand() {
                stateTv.setVisibility(VISIBLE);
                stateTv.setText("收起");
                stateTv.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null,
                        getDrawable(getContext(), R.drawable.ic_article_detail_up), null);
            }

            @Override
            public void onCollapse() {
                stateTv.setVisibility(VISIBLE);
                stateTv.setText("展开");
                stateTv.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null,
                        getDrawable(getContext(), R.drawable.ic_article_detail_expand), null);
            }

            @Override
            public void onLoss() {
                stateTv.setVisibility(GONE);
            }
        });

    }

    private Drawable getDrawable(@NonNull Context context, @DrawableRes int resId) {
        Resources resources = context.getResources();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return resources.getDrawable(resId, context.getTheme());
        } else {
            return resources.getDrawable(resId);
        }
    }

    public interface OnExpandListener {
        void expandChange();
    }
}
