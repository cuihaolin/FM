package com.bing.lan.fm.ui.recommend;

import com.bing.lan.comm.base.mvp.IBaseContract;
import com.bing.lan.comm.base.mvp.fragment.BaseFragmentModule;
import com.bing.lan.fm.ui.recommend.bean.RecBean;

import rx.Observable;
import rx.functions.Func1;

/**
 * @author 蓝兵
 * @time 2017/2/8  10:26
 */
public class RecommendModule extends BaseFragmentModule
        implements IRecommendContract.IRecommendModule {


    private String url = "http://192.168.33.193:8080/fm/reco";

    private  int index =-1;

    public String getUrl() {
      //  Random random = new Random();
      //  int nextInt = random.nextInt(11);

        index++;
        if(index>10) {
            index=0;
        }

        log.d(url + index + ".html");

        return url + index + ".html";


    }


    @Override
    public void loadData(int action, IBaseContract.OnDataChangerListener listener, Object... parameter) {
        switch (action) {
            case RecommendPresenter.LOAD_RECOMD_MAIN:
                loadRecMain(action, listener);
                break;
        }
    }

    private void loadRecMain(int action, IBaseContract.OnDataChangerListener listener) {
        Observable<RecBean> observable = mApiService.getRecResult(getUrl())
                .filter(new Func1<RecBean, Boolean>() {
                    @Override
                    public Boolean call(RecBean recResult) {
                        if (!(recResult.getRet() == 0)) {
                            throw new RuntimeException("请求数据失败,错误信息:" + recResult.getMsg());
                        }
                        return true;
                    }
                });

        subscribe(
                observable,
                action,
                listener,
                "推荐页面");
    }
}
