package com.projects.trending.foodyster.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import coil.load
import com.projects.trending.foodyster.R
import com.projects.trending.foodyster.utils.Constants
import com.smarteist.autoimageslider.SliderViewAdapter
import kotlinx.android.synthetic.main.ingredients_row_layout.view.*

class SliderAdapter(imageUrl: ArrayList<String>) :
    SliderViewAdapter<SliderAdapter.SliderViewHolder>() {

    var sliderList: ArrayList<String> = imageUrl

    override fun getCount(): Int {
        return sliderList.size
    }


    override fun onCreateViewHolder(parent: ViewGroup?): SliderAdapter.SliderViewHolder {

        val inflate: View =
            LayoutInflater.from(parent!!.context).inflate(R.layout.slider_item, null)

        return SliderViewHolder(inflate)
    }


    override fun onBindViewHolder(viewHolder: SliderAdapter.SliderViewHolder?, position: Int) {


        viewHolder?.imageView?.load(sliderList[position]){
            crossfade(600)
            error(R.drawable.ic_error_placeholder)
        }
    }


    class SliderViewHolder(itemView: View?) : SliderViewAdapter.ViewHolder(itemView) {


        var imageView: ImageView = itemView!!.findViewById(R.id.myimage)
    }
}