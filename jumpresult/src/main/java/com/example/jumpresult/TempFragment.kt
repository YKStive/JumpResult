package com.example.jumpresult

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment

class TempFragment : Fragment() {
    private val code: Int = hashCode()
    private lateinit var mResult: (requestCode: Int, data: Intent?) -> Unit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun startForResult(intent: Intent, onResult: (requestCode: Int, data: Intent?) -> Unit) {
        this.mResult = onResult
        startActivityForResult(intent, code)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == code && requestCode == 200) {
            mResult.invoke(requestCode, data)
        }
        if (null != activity && !activity!!.isDestroyed) {
            activity!!.supportFragmentManager.beginTransaction().remove(this)
                .commit()
        }


    }

}