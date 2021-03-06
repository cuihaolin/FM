package com.bing.lan.fm.ui.category;

import com.bing.lan.comm.base.mvp.fragment.IBaseFragmentContract;
import com.bing.lan.fm.ui.category.bean.CategoryListBean;

import java.util.List;

/**
 * @author 蓝兵
 * @time 2017/2/8  10:26
 */
public interface ICategoryContract {

    interface ICategoryView extends IBaseFragmentContract.IBaseFragmentView<ICategoryPresenter> {
        void setRecyclerViewDatas(List<CategoryListBean.ListBean> list);
    }

    interface ICategoryPresenter extends
            IBaseFragmentContract.IBaseFragmentPresenter<ICategoryView, ICategoryModule> {
    }

    interface ICategoryModule extends IBaseFragmentContract.IBaseFragmentModule {
    }
}
