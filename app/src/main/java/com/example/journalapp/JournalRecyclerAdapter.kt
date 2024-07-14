package com.example.journalapp

import android.content.Context
<<<<<<< HEAD
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
=======
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
>>>>>>> 91f5bfc72d00e3ba464642ce669029845a43e38e
import com.example.journalapp.databinding.JournalRowBinding
import com.squareup.picasso.Picasso


<<<<<<< HEAD



=======
>>>>>>> 91f5bfc72d00e3ba464642ce669029845a43e38e
class JournalRecyclerAdapter( val context : Context, val journalList: List<Jounal>)
    : RecyclerView.Adapter<JournalRecyclerAdapter.MyViewHolder>() {
    lateinit var img:ImageView

     lateinit var binding:JournalRowBinding

        //view Holder
         class MyViewHolder(var binding: JournalRowBinding)
            :RecyclerView.ViewHolder(binding.root){

                fun bind(journal:Jounal){
<<<<<<< HEAD

                    binding.journal =journal
//                    binding.buttonlike.setOnClickListener {
//                        deleteBlogPost(journal.userId)
//                    }

                }


//                var db: FirebaseFirestore = FirebaseFirestore.getInstance()
//
//
//                fun deleteBlogPost(userId: String) {
//                    db.collection("Jounal")
//                        .document(userId)
//                        .delete()
//                        .addOnSuccessListener {
//                            Log.w("TAGY", "Sucess")
//                            // DocumentSnapshot successfully deleted
//                        }
//                        .addOnFailureListener {
//                            // Handle any errors
//                        }
//                }



        }


=======
                    binding.journal =journal
                }
        }

>>>>>>> 91f5bfc72d00e3ba464642ce669029845a43e38e
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val view:View = LayoutInflater.from(context)
//            .inflate(R.layout.journal_row,parent,false)
        binding = JournalRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )


        return MyViewHolder(binding)

    }

    override fun getItemCount(): Int = journalList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val jounal:Jounal = journalList[position]
        holder.bind(jounal)
<<<<<<< HEAD
        holder.binding.buttonshare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, journalList[position].title + ("\n") + journalList[position].thoughts)
            }
            context.startActivity(Intent.createChooser(intent, "Share To:"))
        }
        holder.binding.comment.setOnClickListener{
            val intent = Intent(context, CommentList::class.java)
            context.startActivity(intent)
        }
=======

>>>>>>> 91f5bfc72d00e3ba464642ce669029845a43e38e

        //set image in recycle view using picasso

        var imageurl = jounal.imageUrl.toString()
        img = binding.journalImageList

        Picasso
            .get()
            .load(imageurl)
            .noFade()
            .into(img);


    }

<<<<<<< HEAD
//    var share_text_1_btn:Button = findViewById(R.id.share_text_1_btn)


}



=======
}

>>>>>>> 91f5bfc72d00e3ba464642ce669029845a43e38e
//private fun Any.into(s: String) {
//
//}
