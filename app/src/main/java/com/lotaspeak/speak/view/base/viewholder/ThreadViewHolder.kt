package com.lotaspeak.speak.view.base.viewholder

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lotaspeak.speak.R
import com.lotaspeak.speak.data.model.Thread
import com.lotaspeak.speak.utils.ImageLoader
import com.lotaspeak.speak.utils.RecyclerAdapterActions
import com.lotaspeak.speak.utils.SetActionsViewHolder
import kotlinx.android.synthetic.main.item_thread_adapter.view.*
import kotlinx.android.synthetic.main.user_item.view.*


class ThreadViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView), UpdateViewHolder<Thread>,
    SetActionsViewHolder {

    override fun setActions(actionsAdapter: RecyclerAdapterActions) {
        this.threadActions = actionsAdapter as ThreadAdapterActions
    }

    private lateinit var threadActions: ThreadAdapterActions

    private val languageView: TextView = itemView.language_text_view
    private val levelView: TextView = itemView.level_text_view
    private val joinButton: TextView = itemView.join_button
    private val infoButton: TextView = itemView.info_view
    private val iconUserView: ImageView = itemView.icon_user_view
    private val nameUserView: TextView = itemView.name_user_view

    private lateinit var thread: Thread

    @SuppressLint("SetTextI18n")
    override fun bindViews(item: Thread) {
        this.thread = item
        languageView.text = "${item.language?.flag} ${item.language?.title}"
        levelView.text = item.level?.title
        ImageLoader.load(itemView.context, item.author?.image, iconUserView)
        nameUserView.text = "${item.author?.firstName} ${item.author?.lastName}"
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

