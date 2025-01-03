// Generated by view binder compiler. Do not edit!
package com.example.anonymmsg.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.anonymmsg.R;
import com.google.android.material.textfield.TextInputEditText;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnCopy;

  @NonNull
  public final Button btnMsgs;

  @NonNull
  public final Button btnSend;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final TextInputEditText msgg;

  @NonNull
  public final TextInputEditText receiverId;

  @NonNull
  public final TextView uidDisplay;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnCopy,
      @NonNull Button btnMsgs, @NonNull Button btnSend, @NonNull ConstraintLayout main,
      @NonNull TextInputEditText msgg, @NonNull TextInputEditText receiverId,
      @NonNull TextView uidDisplay) {
    this.rootView = rootView;
    this.btnCopy = btnCopy;
    this.btnMsgs = btnMsgs;
    this.btnSend = btnSend;
    this.main = main;
    this.msgg = msgg;
    this.receiverId = receiverId;
    this.uidDisplay = uidDisplay;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_copy;
      Button btnCopy = ViewBindings.findChildViewById(rootView, id);
      if (btnCopy == null) {
        break missingId;
      }

      id = R.id.btn_msgs;
      Button btnMsgs = ViewBindings.findChildViewById(rootView, id);
      if (btnMsgs == null) {
        break missingId;
      }

      id = R.id.btn_send;
      Button btnSend = ViewBindings.findChildViewById(rootView, id);
      if (btnSend == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.msgg;
      TextInputEditText msgg = ViewBindings.findChildViewById(rootView, id);
      if (msgg == null) {
        break missingId;
      }

      id = R.id.receiver_id;
      TextInputEditText receiverId = ViewBindings.findChildViewById(rootView, id);
      if (receiverId == null) {
        break missingId;
      }

      id = R.id.uid_display;
      TextView uidDisplay = ViewBindings.findChildViewById(rootView, id);
      if (uidDisplay == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, btnCopy, btnMsgs, btnSend, main,
          msgg, receiverId, uidDisplay);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
