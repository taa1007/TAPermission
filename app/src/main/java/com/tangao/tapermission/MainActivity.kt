package com.tangao.tapermission

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tangao.library.TAPermission
import kotlinx.android.synthetic.main.activity_main.*
/**
 *    author : TANGAO
 *    e-mail : TAA1007@163.com
 *    date   : 2020/5/9 15:23
 *    desc   :
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener {
            TAPermission.request(this , Manifest.permission.CALL_PHONE , Manifest.permission.WRITE_EXTERNAL_STORAGE){ allGranted, deniedList ->
            if (allGranted){
                call()
            }else{
                Toast.makeText(this, "You  Denied $deniedList", Toast.LENGTH_SHORT).show()
            }
        } }

    }
    private fun call(){
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:10086")
        startActivity(intent)
    }
}
