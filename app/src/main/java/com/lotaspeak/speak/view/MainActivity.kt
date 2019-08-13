package com.lotaspeak.speak.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.lotaspeak.speak.R
import com.lotaspeak.speak.view.threads.ThreadsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        attachFragment(ThreadsFragment.newInstance())
    }

    private fun attachFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(container.id, fragment)
            .commit()
    }
}
