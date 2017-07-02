package ru.geekbrains.gviewer.model.image;

import android.support.annotation.NonNull;
import android.widget.TextView;

public interface ImageLoader<T> {

    void downloadInto(@NonNull String url, @NonNull T placeHolder);

}
