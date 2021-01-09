package pl.maniak.developer.ui.udacity.gdgfinder.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import pl.maniak.developer.databinding.ItemListBinding
import pl.maniak.developer.ui.udacity.gdgfinder.network.GdgChapter
import pl.maniak.developer.ui.udacity.gdgfinder.search.GdgListAdapter.GdgListViewHolder

class GdgListAdapter(val clickListener: GdgClickListener) :
    ListAdapter<GdgChapter, GdgListViewHolder>(
        DiffCallback
    ) {
    companion object DiffCallback : DiffUtil.ItemCallback<GdgChapter>() {
        override fun areItemsTheSame(oldItem: GdgChapter, newItem: GdgChapter): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: GdgChapter, newItem: GdgChapter): Boolean {
            return oldItem == newItem
        }
    }

    class GdgListViewHolder(private var binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: GdgClickListener, gdgChapter: GdgChapter) {
            binding.chapter = gdgChapter
            binding.clickListener = listener
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): GdgListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemListBinding.inflate(layoutInflater, parent, false)
                return GdgListViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GdgListViewHolder {
        return GdgListViewHolder.from(parent)

    }

    override fun onBindViewHolder(holder: GdgListViewHolder, position: Int) {
        holder.bind(clickListener, getItem(position))
    }
}

class GdgClickListener(val clickListener: (chapter: GdgChapter) -> Unit) {
    fun onClick(chapter: GdgChapter) = clickListener(chapter)
}