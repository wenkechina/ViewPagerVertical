package wenke.makelove.viewpagervertical;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import wenke.makelove.viewpagervertical.viewpagertransformers.YAccordionTransformer;

public class ViewPagerVActivity extends AppCompatActivity {

    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpagerv);
        VerticalViewPagerAdapter adapter = new VerticalViewPagerAdapter();

        ViewPagerV vViewpager = (ViewPagerV) findViewById(R.id.hv_viewpager);
        vViewpager.setAdapter(adapter);
        vViewpager.setPageTransformer(true, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View view, float position) {
                if ((position < -1.0F) || (position > 1.0F))
                    return;
                view.findViewById(R.id.view_scroller).setTranslationY(-(1.0F * (position * view.getHeight())));
            }
        });

        ViewPagerHV hvViewpager = (ViewPagerHV) findViewById(R.id.hvviewpager);
        hvViewpager.setAdapter(adapter);
        hvViewpager.setPageTransformer(true, new YAccordionTransformer());
    }
    class  VerticalViewPagerAdapter extends  WenPagerAdapter{

        @Override
        public Object wenInstantiateItem(ViewGroup container, int position) {
            switch (position) {
                case 0:
                    view = View.inflate(ViewPagerVActivity.this, R.layout.fragment_1, null);
                    break;
                case 1:
                    view = View.inflate(ViewPagerVActivity.this, R.layout.fragment_2, null);
                    break;
                case 2:
                    view = View.inflate(ViewPagerVActivity.this, R.layout.fragment_3, null);
                    break;
            }

            container.addView(view);
            return view;
        }

        @Override
        public int wenGetCount() {
            return 3;
        }
    }
}
