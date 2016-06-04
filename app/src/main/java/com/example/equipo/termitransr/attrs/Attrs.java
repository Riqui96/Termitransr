package com.example.equipo.termitransr.attrs;

import android.content.res.AssetManager;
import android.databinding.BindingAdapter;
import android.graphics.Typeface;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

/**
 * Created by EQUIPO on 4/05/2016.
 */
public class Attrs {

    private static Transformation transformation = new RoundedTransformationBuilder()
            .scaleType(ImageView.ScaleType.CENTER_CROP)
            .oval(true)
            .build();

    @BindingAdapter("app:imgUrl")
    public static void loadImg(ImageView view,String url )
    {
        Uri uri = Uri.parse(url);
        Picasso.with(view.getContext()).load(uri).into(view);
    }


    @BindingAdapter("app:imgCircleUrl")
    public static void loadCircleImage(ImageView view, String url){
        Uri uri = Uri.parse(url);
        int size =  view.getLayoutParams().width;
        Picasso.with(view.getContext()).load(uri).resize(size, size)
                .centerCrop()
                .transform(transformation).into(view);
    }

    @BindingAdapter("app:fontTtf")
    public static void  loadFont(TextView txt, String font)
    {
        AssetManager assetManager = txt.getContext().getAssets();
        Typeface typeface = Typeface.createFromAsset(assetManager, "fonts/"+font+".TTF");
        txt.setTypeface(typeface);

    }


}
