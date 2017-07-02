package ru.geekbrains.gviewer.model.image;

import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import ru.geekbrains.gviewer.R;

public class PicassoImageLoader implements ImageLoader<ImageView> {

    @NonNull
    private final Picasso picasso;

    public PicassoImageLoader(Picasso picasso) {
        this.picasso = picasso;
    }

    @Override
    public void downloadInto(String url, ImageView placeHolder) {
        picasso.load(url)
                .placeholder(R.drawable.avatar_circle_grey_64dp)
                .transform(new CircleTransform())
                .into(placeHolder);
    }
}
