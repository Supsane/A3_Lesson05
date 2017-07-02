package ru.geekbrains.gviewer.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.MvpLceViewStateActivity;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.RetainingLceViewState;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmConfiguration;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.geekbrains.gviewer.R;
import ru.geekbrains.gviewer.model.DBData;
import ru.geekbrains.gviewer.model.InfoModelImpl;
import ru.geekbrains.gviewer.model.api.GithubService;
import ru.geekbrains.gviewer.model.image.ImageLoader;
import ru.geekbrains.gviewer.model.image.PicassoImageLoader;
import ru.geekbrains.gviewer.presenter.InfoPresenter;
import ru.geekbrains.gviewer.presenter.InfoPresenterImpl;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class InfoActivity extends MvpLceViewStateActivity<LinearLayout, DBData, InfoView, InfoPresenter> implements InfoView {

    private static final String UNKNOWN_ERROR_MESSAGE = "Unknown error";
    private static final String USER = "supsane";

    @BindView(R.id.avatar)
    ImageView avatar;

    @BindView(R.id.login)
    TextView login;

    @BindView(R.id.name_user)
    TextView nameUser;

    @BindView(R.id.location)
    TextView location;

    @BindView(R.id.company)
    TextView company;

    @BindView(R.id.email)
    TextView email;

    @BindView(R.id.site)
    TextView site;

    @BindView(R.id.about)
    TextView about;

    private ImageLoader<ImageView> imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setContentView(R.layout.screen_info);
        ButterKnife.bind(this);
        imageLoader = new PicassoImageLoader(Picasso.with(this));
    }

    @NonNull
    @Override
    public InfoPresenter createPresenter() {
        GithubService api = new Retrofit.Builder().baseUrl("https://api.github.com/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService.class);
        return new InfoPresenterImpl(new InfoModelImpl(USER, api, new RealmConfiguration.Builder().build(), AndroidSchedulers.mainThread()));
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        String errorMessage = e.getMessage();
        return errorMessage == null ? UNKNOWN_ERROR_MESSAGE : errorMessage;
    }

    @Override
    public void setData(DBData data) {
        runOnUiThread(() -> {
            login.setText("@" + data.getLogin());
            nameUser.setText(data.getName());
            location.setText(data.getLocation());
            company.setText(data.getCompany());
            email.setText(data.getEmail());
            site.setText(data.getSite());
            about.setText(data.getBio());
            imageLoader.downloadInto(data.getAvatarURL(), avatar);
        });
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        getPresenter().loadInformation();
    }

    @Override
    public LceViewState<DBData, InfoView> createViewState() {
        return new RetainingLceViewState<>();
    }

    @Override
    public DBData getData() {
        return new DBData();
    }
}
