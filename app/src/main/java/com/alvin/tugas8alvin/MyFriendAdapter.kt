package com.alvin.tugas8alvin

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_my_friends.*
import kotlinx.android.synthetic.main.fragment_my_friends.view.*
import kotlinx.android.synthetic.main.my_friends_item.*

class MyFriendAdapter(private val context: Context, private val items: MutableList<User>)
    :RecyclerView.Adapter<MyFriendAdapter.ViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
       val itemview =  LayoutInflater.from(context).inflate(R.layout.my_friends_item, parent, false)
        return    ViewHolder(itemview)
    }


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position))

        holder.itemView.setOnClickListener{
           Toast.makeText(context,items[position].telpon.toString(),Toast.LENGTH_SHORT).show()




        }
    }


    class  ViewHolder(override val containerView:View):
            RecyclerView.ViewHolder(containerView), LayoutContainer{
                fun bindItem(item:User){
                    txtFriendName.text = item.name
                    txtFriendEmail.text = item.email
                    txtFriendTelp.text = item.telpon.toString()
                    txtFriendAlamat.text = item.alamat

                }

            }


    }

