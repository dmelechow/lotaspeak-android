package com.lotaspeak.speak.view.thread


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.lotaspeak.speak.R
import com.lotaspeak.speak.data.model.Thread

private const val ARG_THREAD = "thread"

class ThreadFragment : Fragment() {

    private lateinit var mThread: Thread

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mThread = it.getSerializable(ARG_THREAD) as Thread
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thread, container, false)
    }


    companion object {
        @JvmStatic
        fun newInstance(thread: Thread) =
            ThreadFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_THREAD, thread)
                }
            }
    }
}
