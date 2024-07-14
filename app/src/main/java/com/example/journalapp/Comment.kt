package com.example.journalapp

import com.google.firebase.Timestamp


data class Comment(
    val id: String, // Unique ID for each comment
    val postId: String, // ID of the blog post the comment belongs to
    val userId: String, // ID of the user who posted the comment
    val commentText: String,
    val timestamp: Timestamp // Timestamp of when the comment was posted
)


