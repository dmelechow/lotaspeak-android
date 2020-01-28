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
import com.lotaspeak.speak.view.base.viewholder.ThreadAdapterActions
import com.lotaspeak.speak.view.thread.ThreadActivity
import javax.inject.Inject


class ThreadsFragment : Fragment(), ThreadsContract.View, ThreadAdapterActions {

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
        presenter.fetchThreads()
    }

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }

    override fun showThreadsState(threadsData: ThreadsData) {
        loaderView.visibility = View.GONE
        if(threadsData.threads != null) {
            adapter.notifyItems(threadsData.threads!!)
        }
    }

    override fun showErrorState(message: String?) {
        loaderView.visibility = View.GONE
        recycler_view.visibility = View.GONE
        alert_text_view.visibility = View.VISIBLE
        alert_text_view.text = activity?.resources?.getString(R.string.thread_error_state)
    }

    override fun showEmptyState() {
        loaderView.visibility = View.GONE
        recycler_view.visibility = View.GONE
        alert_text_view.visibility = View.VISIBLE
        alert_text_view.text = activity?.resources?.getString(R.string.thread_empty_state)
    }

    private fun initAdapter() {
        adapter = ThreadsAdapter(this)
        layoutManager = LinearLayoutManager(activity?.baseContext)
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = adapter
    }

    override fun joinThread(thread: Thread) {
        Toast.makeText(activity, activity?.getString(R.string.thread_join_notify), Toast.LENGTH_SHORT).show()
    }

    override fun onClickThread(thread: Thread) {
        activity?.let { ThreadActivity.startActivity(it, thread) }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ThreadsFragment()
    }
}
