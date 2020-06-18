package com.example.jumpresult

import android.app.Activity
import android.content.Intent
import android.widget.FrameLayout
import androidx.fragment.app.FragmentActivity

class JumpResult {

    private val TAG = "JumpResult"

    var tempFragment: TempFragment? = null

    constructor(activity: FragmentActivity) {
        getTempFragment(activity)
    }


    private fun getTempFragment(activity: FragmentActivity) {
        tempFragment = findTempFragment(activity)
        if (tempFragment == null) {
            tempFragment = TempFragment()
            val manager = activity.supportFragmentManager
            manager.beginTransaction()
                .add(tempFragment!!, TAG)
                .commitAllowingStateLoss()
            manager.executePendingTransactions();
        }
    }


    private fun findTempFragment(activity: FragmentActivity): TempFragment? {
        return activity.supportFragmentManager.findFragmentByTag(TAG) as TempFragment?
    }


    fun startForResult(intent: Intent, onResult: (requestCode: Int, data: Intent?) -> Unit) {

    }
}