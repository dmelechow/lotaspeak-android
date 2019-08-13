package com.lotaspeak.speak.view.base.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lotaspeak.speak.R
import com.lotaspeak.speak.data.model.Thread
import com.lotaspeak.speak.utils.RecyclerAdapterActions
import com.lotaspeak.speak.utils.SetActionsViewHolder
import kotlinx.android.synthetic.main.item_thread_adapter.view.*


class ThreadViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView), UpdateViewHolder<Thread>,
    SetActionsViewHolder {

    override fun setActions(actionsAdapter: RecyclerAdapterActions) {
        this.threadActions = actionsAdapter as ThreadAdapterActions
    }

    private lateinit var threadActions: ThreadAdapterActions

    private var listener: View.OnClickListener? = null
    private val languageView: TextView = itemView.language_text_view
    private val levelView: TextView = itemView.level_text_view
    private val joinButton: TextView = itemView.join_button
    private val infoButton: TextView = itemView.info_view

    private lateinit var thread: Thread

    override fun bindViews(item: Thread) {
        this.thread = item
        joinButton.setOnClickListener { threadActions.joinThread(item) }
        infoButton.setOnClickListener { threadActions.infoThread(item) }
    }

    companion object {
        const val layout = R.layout.item_thread_adapter
    }
}

interface ThreadAdapterActions : RecyclerAdapterActions {

    fun joinThread(thread: Thread)

    fun infoThread(thread: Thread)
}

