package com.lotaspeak.speak.view.base.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lotaspeak.speak.R
import com.lotaspeak.speak.data.model.Thread
import com.lotaspeak.speak.view.base.OnClickAdapterItemListener
import kotlinx.android.synthetic.main.item_thread_adapter.view.*


class EmptyViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView), UpdateViewHolder<Thread> {

    override fun bindViews(item: Thread) {

    }

    companion object {
        const val layout = R.layout.item_empty_adapter
    }
}