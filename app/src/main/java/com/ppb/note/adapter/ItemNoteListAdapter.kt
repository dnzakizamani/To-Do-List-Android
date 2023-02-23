package com.ppb.note.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ppb.note.R
import com.ppb.note.model.ListNote
import com.ppb.note.util.Utilities.toEditable


class ItemNoteListAdapter(
        private val context: Context,
        private val itemNoteList: List<ListNote>
) : RecyclerView.Adapter<ItemNoteListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.item_list_note_snippet, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listNote = itemNoteList[position]

        holder.checkBox.isChecked = listNote.check
        holder.item.text = listNote.item.toEditable()
    }

    override fun getItemCount(): Int {
        return itemNoteList.size.coerceAtMost(4)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkBox:CheckBox = itemView.findViewById(R.id.cb_snippet)
        val item:TextView = itemView.findViewById(R.id.tv_snippet)
    }
}
