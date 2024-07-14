package com.example.journalapp

import com.google.firebase.Timestamp


data class Jounal(
      val title:String,
      val thoughts:String,
      val imageUrl:String,

      val userId:String,
      val timeAdded:Timestamp,
<<<<<<< HEAD
      val username:String,
=======
      val username:String
>>>>>>> 91f5bfc72d00e3ba464642ce669029845a43e38e
)
