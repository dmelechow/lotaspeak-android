package com.lotaspeak.speak.view.threads

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.lotaspeak.speak.App
import com.lotaspeak.speak.R
import kotlinx.android.synthetic.main.fragment_threads.*
import com.lotaspeak.speak.data.model.Thread
import com.lotaspeak.speak.data.repository.ThreadsData
import com.lotaspeak.speak.di.threads.DaggerThreadsComponent
import com.lotaspeak.speak.di.threads.ThreadsModule
import com.lotaspeak.speak.utils.RecyclerAdapterActions
import com.lotaspeak.speak.view.base.viewholder.ThreadAdapterActions
import javax.inject.Inject


class ThreadsFragment : Fragment(), ThreadsContract.View, View.OnClickListener, ThreadAdapterActions {

    @Inject
    lateinit var presenter: ThreadsContract.Presenter

    private lateinit var adapter: ThreadsAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        DaggerThreadsComponent.builder()
            .appComponent(App.appComponent)
            .threadsModule(ThreadsModule())
            .build()
            .inject(this)

        presenter.onAttach(this)
        return inflater.inflate(R.layout.fragment_threads, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    override fun onStart() {
        super.onStart()
        presenter.fetchThreads()
    }

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }

    override fun showThreads(threadsData: ThreadsData) {
        if(threadsData.threads != null) {
            adapter.notifyItems(threadsData.threads!!)
        }
    }

    override fun onClick(v: View?) {
    }

    private fun initAdapter() {
        adapter = ThreadsAdapter(this, this)
        layoutManager = LinearLayoutManager(activity?.baseContext)
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = adapter
    }

    override fun joinThread(thread: Thread) {
        Toast.makeText(activity, "You'll join in next version", Toast.LENGTH_SHORT).show()
    }

    override fun infoThread(thread: Thread) {
        Toast.makeText(activity, "You'll see an info in next version", Toast.LENGTH_SHORT).show()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ThreadsFragment()
    }
}
