package com.example.davaleba7


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit.API.models.ReqResData
import com.example.retrofit.API.models.User

typealias onClicked = (v: User) -> Unit

class MainActivityAdapter :
    ListAdapter<User, MainActivityAdapter.Viewholder>(DIFF_CALLBACK) {

    lateinit var onClicked: onClicked


    class Viewholder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.name)
        val email: TextView = view.findViewById(R.id.email)
        val image: ImageView = view.findViewById(R.id.image)
        val card: View = view.findViewById(R.id.card)

    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(
                oldItem: User,
                newItem: User
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: User,
                newItem: User
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_main_adapter, parent, false)

        return Viewholder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val itemsData = getItem(position)
        holder.name.text = itemsData.firstName + " " + itemsData.lastName
        holder.email.text = itemsData.email

        Glide.with(holder.image)
            .load(itemsData.avatar)
            .into(holder.image)


        holder.card.setOnClickListener {
            onClicked(itemsData)
        }

    }


}