package ru.geekbrains.gviewer.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pair;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.util.List;

import ru.geekbrains.gviewer.model.DBData;
import ru.geekbrains.gviewer.model.InfoModel;
import ru.geekbrains.gviewer.view.InfoView;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;

public class InfoPresenterImpl extends MvpBasePresenter<InfoView> implements InfoPresenter {

    @NonNull
    private final InfoModel model;

    @Nullable
    private Subscription observing;

    @Nullable
    private Subscription updating;

    public InfoPresenterImpl(InfoModel model) {
        this.model = model;
    }

    private void tryToUnsubscribe(Subscription subscription) {
        if (isSubscribed(subscription)) {
            subscription.unsubscribe();
        }
    }

    private boolean isSubscribed(Subscription subscription) {
        return subscription != null && !subscription.isUnsubscribed();
    }

    @Override
    public void detachView(boolean retainInstance) {
        if (!retainInstance) {
            tryToUnsubscribe(observing);
            tryToUnsubscribe(updating);
        }
        super.detachView(retainInstance);
    }

    @Override
    public void attachView(InfoView attached) {
        if (!isSubscribed(observing)) {
            observing = model.lifecycle().filter(list -> {
                return !list.isEmpty();
            }).map(list -> list.get(0))
                    .subscribe(s -> {
                        InfoView view = getView();
                        if (isViewAttached()) {
                            view.setData(s);
                            view.showContent();
                        }
                    });
        }
        super.attachView(attached);
    }

    @Override
    public void loadInformation() {
        tryToUnsubscribe(updating);
        updating = model.observeInfo().map(new Func1<List<DBData>, Boolean>() {
            @Override
            public Boolean call(List<DBData> list) {
                return list.isEmpty();
            }
        })
                .doOnNext(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean isEmpty) {
                        getView().showLoading(!isEmpty);
                    }
                })
                .zipWith(model.updateInfo().isEmpty().onErrorReturn(new Func1<Throwable, Boolean>() {
                    @Override
                    public Boolean call(Throwable t) {
                        return true;
                    }
                }), new Func2<Boolean, Boolean, Pair<Boolean, Boolean>>() {
                    @Override
                    public Pair<Boolean, Boolean> call(Boolean a, Boolean b) {
                        return Pair.create(a, b);
                    }
                })
                .subscribe(new Action1<Pair<Boolean, Boolean>>() {
                    @Override
                    public void call(Pair<Boolean, Boolean> pair) {
                        boolean isViewEmpty = pair.first;
                        boolean isErrorCaused = pair.second;
                        if (isErrorCaused && InfoPresenterImpl.this.isViewAttached()) {
                            getView().showError(new Throwable("Error during network operation"), !isViewEmpty);
                        }
                    }
                });
    }
}