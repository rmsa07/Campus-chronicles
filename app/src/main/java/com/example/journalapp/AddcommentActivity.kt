package com.example.journalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle



import android.content.Intent

import android.text.TextUtils
import androidx.databinding.DataBindingUtil
import com.example.journalapp.databinding.AddCommentBinding
import com.google.firebase.Firebase
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.Date



class AddcommentActivity : AppCompatActivity() {
    private lateinit var binding: AddCommentBinding

    var currentUseId: String = ""
    var currentUserName: String = ""

    //Firebase
    lateinit var auth: FirebaseAuth
    lateinit var user: FirebaseUser

    //Firebase Firestore

    var db: FirebaseFirestore = FirebaseFirestore.getInstance()
    lateinit var storageReference: StorageReference

    var collectionReference: CollectionReference = db.collection("comment")

    // lateinit var imageUri:Uri


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.add_comment)

        storageReference = FirebaseStorage.getInstance().getReference()

        auth = Firebase.auth

        binding.apply {
//            postProgressBar.visibility= View.INVISIBLE

            if (commentUser.instance != null) {
                currentUseId = auth.currentUser?.uid.toString()

                currentUserName = auth.currentUser?.displayName.toString()
            }


            SAve.setOnClickListener() {
                SaveJournal()
            }
        }


    }

    private fun SaveJournal() {
//        var title:String = binding.postTitleEt.text.toString().trim()
        var commentText:String = binding.commentText.text.toString().trim()

//        binding.postProgressBar.visibility = View.VISIBLE

        if( !TextUtils.isEmpty(commentText) ){

                        //craeting the object of Journal
                        var id = auth.tenantId.toString()
                        var postId = auth.uid.toString()
                        var userId = auth.currentUser.toString()


                        var timeStamp: Timestamp = Timestamp(Date())
                        var comment: Comment = Comment(
                             id, // Unique ID for each comment
                             postId, // ID of the blog post the comment belongs to
                             userId, // ID of the user who posted the comment
                             commentText,
                            timeStamp

                            )
                        //adding the new jounal
                        collectionReference.add(comment)
                            .addOnSuccessListener {
//                                binding.postProgressBar.visibility=View.INVISIBLE
                                var i :Intent =Intent(this, CommentList::class.java)
                                startActivity(i)
                                finish()
                            }
                    }
                }


    override fun onStart() {
        super.onStart()
        user =auth.currentUser!!

    }

    override fun onStop() {
        super.onStop()
        if(auth != null){

        }
    }
}