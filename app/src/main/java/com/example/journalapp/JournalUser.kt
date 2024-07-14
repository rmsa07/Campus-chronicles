package com.example.journalapp

import android.app.Application

class JournalUser:Application() {

<<<<<<< HEAD
    var username :String? = "Ramesh Kumar"
    var userId: String? ="Ramesh Kumar"
=======
    var username :String? = null
    var userId: String? =null
>>>>>>> 91f5bfc72d00e3ba464642ce669029845a43e38e
    companion object{
        var instance:JournalUser?=null
            get() {
                if(field == null){
                    field = JournalUser()
                }
                return field
            }
        private set
    }
}