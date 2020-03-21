package com.kedar.dependencyinjection.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kedar.dependencyinjection.R
import com.kedar.dependencyinjection.api.model.User
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_user_detail.view.*

class UsersRecyclerAdapter(context: Context, private val picasso: Picasso) :
    RecyclerView.Adapter<UsersRecyclerAdapter.UsersViewHolder>() {
    var users:List<User> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        return UsersViewHolder(layoutInflater.inflate(R.layout.row_user_detail, parent, false))
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val user = users[position]
        with(holder.itemView) {
            tvRowId.text = user.id.toString()
            tvRowName.text = "${user.first_name} ${user.last_name}"
            tvRowEmail.text = user.email
            picasso.load(user.avatar).into(imageView)
        }
    }

    class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}