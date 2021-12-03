package com.reihan.portofolio

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load



@BindingAdapter("androidTitle")
fun TextView.setTitleAndroid(data: Portofolio?) {
    data?.let{
        text = it.title
    }
}

@BindingAdapter("androidImage")
fun ImageView.setAndroidImage(data: Portofolio) {
    load(data.image){
        crossfade(1000)
    }
}