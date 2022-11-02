package com.example.learn_android_layout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class FirstBehavior extends CoordinatorLayout.Behavior<TextView> {
    private String TAG = "FirstBehavior";

    public FirstBehavior() {

    }

    public FirstBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent,
                                         TextView child, MotionEvent ev) {
        // Hàm này nhận sự kiện Touch (down) ban đầu khi nhấn trong CoordinatorLayout
        // Behavior ghi đè lên phương thức onInterceptTouchEvent() của CoordinatorLayout
        child.setText(ev.getAction() + "|" + (int) ev.getX() + "|" + (int) ev.getY());

        //Nếu thiết lập trả về true thì onToucheEvent sẽ nhận các sự kiện
        //Tiếp theo và các View con khác không nhận được Touch, ko scroll dc
        return false;
    }

    @Override
    public boolean onTouchEvent(CoordinatorLayout parent,
                                TextView child, MotionEvent ev) {
        // khi move mouse
        child.setText(ev.getAction() + "|" + (int) ev.getX() + "|" + (int) ev.getY());
        return true;
    }

    // CoordinatorLayout gọi bất kỳ View nào có khả năng Nested Scrolll bắt đầu đăng ký quá trình
    // Nested Scroll trong CoordinatorLayout, ví dụ này chỉ nhận Nested Scrolll từ
    // RecylerView có ID :  R.id.mylistview_2
    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout,
                                       @NonNull TextView child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        Log.i(TAG, "onStartNestedScroll:" + target.getId());
        if (target.getId() == R.id.mylistview_2)
            return true;
        return false;
    }

    // Gọi khi View con scroll
    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        Log.i(TAG, "onNestedScroll:" + target.getId());
        ((TextView) coordinatorLayout.findViewById(R.id.txtTest)).setText("Scroll:" + dyConsumed);
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
    }

    @Override
    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView child, @NonNull View target, int type) {
        Log.i(TAG, "onStopNestedScroll:" + target.getId());
        ((TextView) coordinatorLayout.findViewById(R.id.txtTest)).setText("StopScroll");
        super.onStopNestedScroll(coordinatorLayout, child, target, type);
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        Log.i(TAG, "onNestedPreScroll");
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
    }

    // onNestedPreFling: Được View con gọi khi chuẩn bị fling, nó gọi hàm này để kiểm tra điều kiện thực hiện fling
    // nếu Behavior trả về true, nghĩa là nó dùng fling và dẫn tới View con không fling nữa
    @Override
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView child, @NonNull View target, float velocityX, float velocityY) {
        Log.i("XXX", "onNestedPreFling");
        return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);
    }

    // onNestedFling gọi khi View con thực hiện fling
    @Override
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView child, @NonNull View target, float velocityX, float velocityY, boolean consumed) {
        Log.i("XXX", "onNestedFling");
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }
}
