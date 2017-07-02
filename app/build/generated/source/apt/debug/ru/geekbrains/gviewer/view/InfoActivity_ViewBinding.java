// Generated code from Butter Knife. Do not modify!
package ru.geekbrains.gviewer.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import ru.geekbrains.gviewer.R;

public class InfoActivity_ViewBinding<T extends InfoActivity> implements Unbinder {
  protected T target;

  @UiThread
  public InfoActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.avatar = Utils.findRequiredViewAsType(source, R.id.avatar, "field 'avatar'", ImageView.class);
    target.login = Utils.findRequiredViewAsType(source, R.id.login, "field 'login'", TextView.class);
    target.nameUser = Utils.findRequiredViewAsType(source, R.id.name_user, "field 'nameUser'", TextView.class);
    target.location = Utils.findRequiredViewAsType(source, R.id.location, "field 'location'", TextView.class);
    target.company = Utils.findRequiredViewAsType(source, R.id.company, "field 'company'", TextView.class);
    target.email = Utils.findRequiredViewAsType(source, R.id.email, "field 'email'", TextView.class);
    target.site = Utils.findRequiredViewAsType(source, R.id.site, "field 'site'", TextView.class);
    target.about = Utils.findRequiredViewAsType(source, R.id.about, "field 'about'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.avatar = null;
    target.login = null;
    target.nameUser = null;
    target.location = null;
    target.company = null;
    target.email = null;
    target.site = null;
    target.about = null;

    this.target = null;
  }
}
