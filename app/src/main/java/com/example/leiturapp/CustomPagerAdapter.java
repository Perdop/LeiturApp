package com.example.leiturapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class CustomPagerAdapter extends PagerAdapter {

    private Context context;

    public CustomPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 3; // Número de páginas no carrossel atualizado
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
            view = inflater.inflate(R.layout.item_resenhas, container, false); // Nova página
        }

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
