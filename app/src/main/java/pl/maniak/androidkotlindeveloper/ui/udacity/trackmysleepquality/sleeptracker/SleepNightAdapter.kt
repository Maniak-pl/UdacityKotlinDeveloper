package pl.maniak.androidkotlindeveloper.ui.udacity.trackmysleepquality.sleeptracker

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.maniak.androidkotlindeveloper.ui.udacity.trackmysleepquality.database.SleepNight

class SleepNightAdapter : RecyclerView.Adapter<TextItemViewHolder>() {

    var data = listOf<SleepNight>()

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.sleepQuality.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        TODO("Not yet implemented")
    }
}