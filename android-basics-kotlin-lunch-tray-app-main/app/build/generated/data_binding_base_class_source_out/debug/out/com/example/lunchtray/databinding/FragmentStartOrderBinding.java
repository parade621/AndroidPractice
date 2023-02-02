// Generated by data binding compiler. Do not edit!
package com.example.lunchtray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.lunchtray.R;
import com.example.lunchtray.ui.order.StartOrderFragment;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentStartOrderBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout layoutStartOrder;

  @NonNull
  public final Button startOrderBtn;

  @Bindable
  protected StartOrderFragment mStartOrderFragment;

  protected FragmentStartOrderBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ConstraintLayout layoutStartOrder, Button startOrderBtn) {
    super(_bindingComponent, _root, _localFieldCount);
    this.layoutStartOrder = layoutStartOrder;
    this.startOrderBtn = startOrderBtn;
  }

  public abstract void setStartOrderFragment(@Nullable StartOrderFragment startOrderFragment);

  @Nullable
  public StartOrderFragment getStartOrderFragment() {
    return mStartOrderFragment;
  }

  @NonNull
  public static FragmentStartOrderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_start_order, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentStartOrderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentStartOrderBinding>inflateInternal(inflater, R.layout.fragment_start_order, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentStartOrderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_start_order, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentStartOrderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentStartOrderBinding>inflateInternal(inflater, R.layout.fragment_start_order, null, false, component);
  }

  public static FragmentStartOrderBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentStartOrderBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentStartOrderBinding)bind(component, view, R.layout.fragment_start_order);
  }
}
