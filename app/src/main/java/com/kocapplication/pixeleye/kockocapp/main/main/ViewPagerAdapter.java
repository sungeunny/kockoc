package com.kocapplication.pixeleye.kockocapp.main.main;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kocapplication.pixeleye.kockocapp.R;

/**
 * Created by Hyeongpil on 2016-10-13.
 */
public class ViewPagerAdapter extends PagerAdapter{
    final static String TAG = "ViewPagerAdapter";
    private LayoutInflater mInflater;
    private int itemCount;

    // imageResources에 사진들 넣고 MainFragment에서 아이템 카운트 맞추기 // 서버에서 가져온 갯수 만큼 itemcount 수정해야함
    private int[] imageResources = {
            R.drawable.main_image0,
            R.drawable.main_image1,
            R.drawable.main_image2
    };

    public ViewPagerAdapter(Context mContext, int itemCount) {
        super();
        mInflater = LayoutInflater.from(mContext);
        this.itemCount = itemCount;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int realPosition = position % itemCount; // 전체 뷰 갯수로 나눠줌 (뷰페이저 순환을 위해)
        View v = null;
        v = mInflater.inflate(R.layout.main_viewpager_item,null);

        ImageView img = (ImageView) v.findViewById(R.id.iv_main_frag_viewpager_item);
        img.setImageResource(imageResources[realPosition]);

        container.addView(v);
        return v;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    public int getRealCount(){
        return itemCount;
    }
}
