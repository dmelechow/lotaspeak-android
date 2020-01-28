package com.lotaspeak.speak.view.base.viewholder

import android.annotation.SuppressLint
import android.view.View
import android.widget.Button
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

    private val cardContainer: View = itemView.card_container
    private val languageView: TextView = itemView.language_text_view
    private val levelView: TextView = itemView.level_text_view
    private val joinButton: Button = itemView.join_button
    private val iconUserView: ImageView = itemView.icon_user_view
    private val nameUserView: TextView = itemView.name_user_view
    private val emptyTitleView: TextView = itemView.empty_title_view
    private val freeSeatsView: TextView = itemView.free_seats_view

    private lateinit var thread: Thread

    @SuppressLint("SetTextI18n")
    override fun bindViews(thread: Thread) {
        this.thread = thread
        cardContainer.setOnClickListener {
            threadActions.onClickThread(thread)
        }
        languageView.text = "${thread.language?.flag} ${thread.language?.title}"
        levelView.text = thread.level?.title
        freeSeatsView.text = itemView.context.getString(R.string.thread_free_seats, thread.numberSeats)
        if (thread.author != null) {
            iconUserView.visibility = View.VISIBLE
            emptyTitleView.visibility = View.GONE
            if (thread.author?.image != null) {
                ImageLoader.load(itemView.context, thread.author?.image, iconUserView)
            } else {
                ImageLoader.load(
                    itemView.context,
                    itemView.context.resources.getDrawable(R.drawable.ic_anonim),
                    iconUserView
                )
            }
        } else {
            iconUserView.visibility = View.GONE
            emptyTitleView.visibility = View.VISIBLE
        }
        nameUserView.text = thread.author?.username
        joinButton.setOnClickListener { threadActions.joinThread(thread) }
    }

    companion object {
        const val layout = R.layout.item_thread_adapter
    }
}

interface ThreadAdapterActions : RecyclerAdapterActions {

    fun joinThread(thread: Thread)

    fun onClickThread(thread: Thread)
}

