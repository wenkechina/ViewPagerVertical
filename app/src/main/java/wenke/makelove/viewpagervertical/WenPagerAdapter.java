package wenke.makelove.viewpagervertical;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by wenke on 2016/3/7.
 */
public abstract class WenPagerAdapter extends PagerAdapter {
    public WenPagerAdapter() {
        super();
    }
    @Override
    public int getCount() {
        return wenGetCount();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
       return wenInstantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
    public abstract Object wenInstantiateItem(ViewGroup container, int position);
    public abstract  int wenGetCount();

}
