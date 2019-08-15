package com.lotaspeak.speak.view.threads

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lotaspeak.speak.view.base.OnClickAdapterItemListener
import com.lotaspeak.speak.data.model.Thread
import com.lotaspeak.speak.utils.RecyclerAdapterActions
import com.lotaspeak.speak.utils.SetActionsViewHolder
import com.lotaspeak.speak.view.base.viewholder.*


private const val ITEM_EMPTY = 0
private const val ITEM_THREAD = 1

class ThreadsAdapter(
        private val actionsAdapter: ThreadAdapterActions
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: MutableList<Thread> = ArrayList()

    interface ThreadItemAdapter

    fun notifyItems(items: List<Thread>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_THREAD -> ThreadViewHolder(LayoutInflater.from(parent.context).inflate(ThreadViewHolder.layout, parent, false))
            else -> EmptyViewHolder(LayoutInflater.from(parent.context).inflate(EmptyViewHolder.layout, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        items[position].let {
            if( holder is SetActionsViewHolder){
                holder.setActions(actionsAdapter)
            }
            (holder as UpdateViewHolder<ThreadItemAdapter>).bindViews(it)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ThreadItemAdapter -> ITEM_THREAD
            else -> ITEM_EMPTY
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}