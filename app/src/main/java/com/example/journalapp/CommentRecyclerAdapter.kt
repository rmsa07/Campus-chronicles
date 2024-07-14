package com.example.journalapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.journalapp.databinding.CommentRowBinding


class CommentRecyclerAdapter(val context : Context, val commentList: List<Comment>)
    : RecyclerView.Adapter<CommentRecyclerAdapter.MyViewHolder>() {
    lateinit var img: ImageView

    lateinit var binding: CommentRowBinding

    //view Holder
    class MyViewHolder(var binding: CommentRowBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(comment: Comment) {

            binding.comment = comment
//                    binding.buttonlike.setOnClickListener {
//                        deleteBlogPost(journal.userId)
//                    }

        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val view:View = LayoutInflater.from(context)
//            .inflate(R.layout.journal_row,parent,false)
        binding = CommentRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )


        return MyViewHolder(binding)

    }

    override fun getItemCount(): Int = commentList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val comment: Comment = commentList[position]
        holder.bind(comment)

    }

}

