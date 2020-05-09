package com.tangao.library

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

/**
 *    author : TANGAO
 *    e-mail : TAA1007@163.com
 *    date   : 2020/5/9 14:42
 *    desc   :
 */
object TAPermission {

    private const val TAG = "InvisibleFragment"

    fun request(activity : FragmentActivity, vararg permission: String , callback : PermissionCallBack){
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if(existedFragment != null){
            existedFragment as InvisibleFragment
        }else{
            val invisibleFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment , TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback , *permission)

    }
}