package com.tangao.library

import android.content.pm.PackageManager
import androidx.fragment.app.Fragment
import java.util.*

/**
 *    author : TANGAO
 *    e-mail : TAA1007@163.com
 *    date   : 2020/5/9 14:20
 *    desc   :
 */

typealias PermissionCallBack  = (Boolean, List<String>) -> Unit

class InvisibleFragment : Fragment(){
    
    private var callback : PermissionCallBack? = null

    fun requestNow(cb : PermissionCallBack , vararg  permission : String?){
        callback = cb
        requestPermissions(permission , 1)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if ((requestCode == 1)){
            val deniedList = ArrayList<String>()
            for ((index , result) in grantResults.withIndex()){
                if (result != PackageManager.PERMISSION_GRANTED){
                    deniedList.add(permissions[index])
                }
            }
            val allGranted =deniedList.isEmpty()
            callback?.let{ it(allGranted , deniedList)}
        }
    }

}