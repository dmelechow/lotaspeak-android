package com.lotaspeak.speak.view.thread

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lotaspeak.speak.R
import com.lotaspeak.speak.data.model.Thread
import com.lotaspeak.speak.utils.ImageLoader
import kotlinx.android.synthetic.main.activity_thread.*
import kotlinx.android.synthetic.main.user_item.*

const val ARG_THREAD = "thread"

class ThreadActivity : AppCompatActivity() {

    lateinit var thread: Thread

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)
        val intent = intent
        thread = intent.getSerializableExtra(ARG_THREAD) as Thread

        initThread(this, thread)
    }

    @SuppressLint("SetTextI18n")
    fun initThread(activity: Activity, thread: Thread) {
        language_text_view.text = "${thread.language?.flag} ${thread.language?.title}"
        level_text_view.text = thread.level?.title
        if (thread.author?.image != null) {
            ImageLoader.load(activity, thread.author?.image, icon_user_view)
        } else {
            ImageLoader.load(
                activity,
                activity.getDrawable(R.drawable.ic_anonim),
                icon_user_view
            )
        }
        name_user_view.text = thread.author?.username
        join_button.setOnClickListener {
            Toast.makeText(activity, activity.getString(R.string.thread_join_notify), Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        @JvmStatic
        fun startActivity(activity: Activity, thread: Thread) {
            val myIntent = Intent(activity, ThreadActivity::class.java)
            myIntent.putExtra(ARG_THREAD, thread)
            activity.startActivity(myIntent)
        }

    }
}
