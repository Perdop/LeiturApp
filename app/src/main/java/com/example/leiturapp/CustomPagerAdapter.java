package com.example.leiturapp;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class CustomPagerAdapter extends PagerAdapter {

    private Context context;
    private ViewPager viewPager;
    private Handler handler;
    private Runnable runnable;
    private static final int PAGE_DELAY = 2000; // 3 segundos

    public CustomPagerAdapter(Context context, ViewPager viewPager) {
        this.context = context;
        this.viewPager = viewPager;
        handler = new Handler();

        // Runnable para mudar de página automaticamente
        runnable = new Runnable() {
            @Override
            public void run() {
                int nextItem = (viewPager.getCurrentItem() + 1) % getCount();
                viewPager.setCurrentItem(nextItem, true);
                handler.postDelayed(this, PAGE_DELAY);
            }
        };
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;

        if (position == 0) {
            view = inflater.inflate(R.layout.item_curiosidade, container, false);
        } else if (position == 1) {
            view = inflater.inflate(R.layout.item_resumo, container, false);
        } else {
            view = inflater.inflate(R.layout.item_resenhas, container, false);
        }

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    public void startAutoScroll() {
        handler.postDelayed(runnable, PAGE_DELAY);
    }

    public void stopAutoScroll() {
        handler.removeCallbacks(runnable);
    }
}
