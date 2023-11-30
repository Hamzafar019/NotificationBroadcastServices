package com.example.myapplication

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log

// TODO: Rename actions, choose action names that describe tasks that this
// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
private const val ACTION_FOO = "com.example.myapplication.action.FOO"
private const val ACTION_BAZ = "com.example.myapplication.action.BAZ"


class MyIntentService : IntentService("MyIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        if(intent!=null){
            Log.d("MYTAG",intent.getStringExtra("DATA_REC")!!)
        }
    }

    private fun handleActionFoo(param1: String?, param2: String?) {
    }

    private fun handleActionBaz(param1: String?, param2: String?) {
    }

    companion object {

    }
}