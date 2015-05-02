package com.hackathon.barter.dialog;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.gc.materialdesign.views.ButtonFlat;
import com.hackathon.barter.R;
import com.hackathon.barter.image.ImageLoader;
import com.hackathon.barter.structs.MyItems;

/**
 * Created by Charlton on 5/2/2015.
 */
public class PopupItemDialog extends DialogFragment implements View.OnClickListener {

    public PopupItemDialog(MyItems myItems) {
        this.myItems = myItems;
    }

    MyItems myItems;
    ImageView img;
    View view;
    ButtonFlat close, notify;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.item_dialog, container, false);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));

        img = (ImageView) view.findViewById(R.id.popup_img);
        close = (ButtonFlat) view.findViewById(R.id.pop_close);
        notify = (ButtonFlat)view.findViewById(R.id.pop_notify);

        ImageLoader imageLoader = new ImageLoader(view.getContext());
        imageLoader.DisplayImage(myItems.getImg(),img);
        close.setOnClickListener(this);
        notify.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.pop_close:
                dismiss();
                break;
            case R.id.pop_notify:

                break;
        }
    }
}
