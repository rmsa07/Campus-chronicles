package com.example.journalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.journalapp.databinding.CommentlistBinding
import com.google.firebase.Firebase
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.StorageReference


class CommentList : AppCompatActivity() {

    private lateinit var binding:CommentlistBinding

    lateinit var firebaseAuth : FirebaseAuth
    lateinit var user : FirebaseUser
    var db = FirebaseFirestore.getInstance()
    lateinit var storageReference: StorageReference
    var collectionReference:CollectionReference =db.collection("comment")

    lateinit var commentList : MutableList<Comment>
    lateinit var adapter: CommentRecyclerAdapter




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_journal_list)

        binding = DataBindingUtil.setContentView(this, R.layout.commentlist)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        firebaseAuth = Firebase.auth
        user = firebaseAuth.currentUser !!

        //Recycle View
        binding.recyclerView.setHasFixedSize(true)

        binding.recyclerView.layoutManager=LinearLayoutManager(this)

        //Posta arralist
        commentList = arrayListOf<Comment>()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.action_add -> if(user != null && firebaseAuth != null){
                val intent = Intent(this, AddcommentActivity::class.java)
                startActivity(intent)
            }
            R.id.action_signout ->{
                if(user != null && firebaseAuth != null){
                    firebaseAuth.signOut()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
    //getting all posts
    override fun onStart() {
        super.onStart()

        collectionReference
            .get()
            .addOnSuccessListener {
                if (!it.isEmpty) {

                    for (document in it) {

                        var comment = Comment(
                            document.data.get("id").toString(),
                            document.data.get("postId").toString(),
                            document.data.get("userId").toString(),
                            document.data.get("commentText").toString(),
                            document.data.get("timestamp") as Timestamp,
                        )
                        commentList.add(comment)
                    }

                    //Recycler view
                    adapter = CommentRecyclerAdapter(
                        this, commentList
                    )
                    binding.recyclerView.setAdapter(adapter)
                    adapter.run { notifyDataSetChanged() }
                }
                else{
                    binding.fab.visibility = View.VISIBLE
                }
            }.addOnFailureListener{
                Toast.makeText(this,
                    "Error!!",
                    Toast.LENGTH_LONG
                ).show()
            }
    }


}
