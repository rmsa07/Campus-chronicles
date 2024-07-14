package com.example.journalapp


import android.app.Application
import com.example.journalapp.JournalUser

class commentUser:Application() {

    var id :String? = "Ramesh Kumar"
    var userId: String? ="Ramesh Kumar"
    companion object{
        var instance: JournalUser?=null
            get() {
                if(field == null){
                    field = JournalUser()
                }
                return field
            }
            private set
    }
}