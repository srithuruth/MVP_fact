package com.example.mvp_fact.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvp_fact.R
import kotlinx.android.synthetic.main.item_pass.view.*
import okhttp3.Response

class APIAdapter : RecyclerView.Adapter<APIAdapter.APIViewHolder>(){

    private val data = arrayListOf<Response>()

    fun setData(items: List<Response>){
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): APIViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pass, parent, false)
        return APIViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder: APIViewHolder, position: Int) {
        viewHolder.bind(data[position])
    }

    class APIViewHolder(val view: View): RecyclerView.ViewHolder(view){
        fun bind(response: Response){
            view.tvAnimalId.text = response.animalId.toString()
            view.tvAnimalDesc.text = response.animalDesc.toString()
            view.tvUpdate.text = response.updatedAt.toString()


        }
    }
}