package com.bing.lan.fm.ui.music;

import com.bing.lan.comm.base.mvp.IBaseContract;
import com.bing.lan.comm.base.mvp.activity.BaseActivityModule;
import com.bing.lan.fm.ui.music.bean.PlayResult;

import rx.Observable;

import static com.bing.lan.fm.ui.music.MusicPresenter.LOAD_TRACK;

/**
 * @author 蓝兵
 * @time 2017/2/6  19:12
 */
public class MusicModule extends BaseActivityModule
        implements IMusicContract.IMusicModule {

    @Override
    public void loadData(int action, IBaseContract.OnDataChangerListener listener, Object... parameter) {
        switch (action) {

            case LOAD_TRACK:
                loadTrack(action, listener, (long) parameter[0]);
                break;
        }
    }

    private void loadTrack(int action, IBaseContract.OnDataChangerListener listener, long trackId) {
        Observable<PlayResult> observable = mApiService.getPlayResult(trackId);
        subscribe(observable, action, listener, "专辑播放页面");
    }
}
