package ru.geekbrains.gviewer.model;

import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;

import java.util.List;

import rx.Observable;

public interface InfoModel {

    @NonNull
    @AnyThread
    Observable<? extends List<DBData>> observeInfo();

    @NonNull
    @AnyThread
    Observable<? extends List<DBData>> lifecycle();

    @NonNull
    @AnyThread
    Observable<? extends List<DBData>> updateInfo();
}