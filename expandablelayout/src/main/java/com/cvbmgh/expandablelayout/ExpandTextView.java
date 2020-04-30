package com.cvbmgh.expandablelayout;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.text.StaticLayout;
import android.util.AttributeSet;

/**
 * author : lhl
 * date : 2020/4/13/013
 * desc :
 */
public class ExpandTextView extends AppCompatTextView {
    private Rect lienBound = new Rect();
    /**
     * true：展开，false：收起
     */
    private boolean mExpanded;

    private Callback mCallback;

    /**
     * 源文字内容
     */
    private String mText = "";
    private int maxLineCount = 10;

    public ExpandTextView(Context context) {
        this(context, null);
    }

    public ExpandTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ExpandTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setMaxLineCount(int maxLineCount) {
        this.maxLineCount = maxLineCount;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (mText == null) {
            mText = "";
        }
        StaticLayout staticLayout = new StaticLayout((mText), getPaint(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), Layout.Alignment.ALIGN_CENTER, 1f, 0f, true);

        //总计行数
        int lineCount = staticLayout.getLineCount();
        if (lineCount > maxLineCount) {
            if (mExpanded) {
                if (mCallback != null) {
                    mCallback.onExpand();
                }
                //setText(mText);
                setMaxLines(Integer.MAX_VALUE);
            } else {
                if (mCallback != null) {
                    mCallback.onCollapse();
                }
                lineCount = maxLineCount;
                setMaxLines(lineCount);
            }
        } else {
            if (mCallback != null) {
                mCallback.onLoss();
            }
        }

        int lineHeight = 0;
        for (int i = 0; i < lineCount; i++) {
            //Rect lienBound = new Rect();
            //staticLayout.getLineBounds(i, lienBound);
            getLineBounds(i, lienBound);
            lineHeight += lienBound.height();
        }
        lineHeight += getPaddingTop() + getPaddingBottom();

        setMeasuredDimension(getMeasuredWidth(), lineHeight);
    }

    public void setText(String text, boolean expanded, Callback callback) {
        mText = text;
        mExpanded = expanded;
        mCallback = callback;

        setText(text);
    }

    public void setChanged(boolean expanded) {
        mExpanded = expanded;
        requestLayout();
    }

    public interface Callback {
        void onExpand();

        void onCollapse();

        void onLoss();
    }
}
