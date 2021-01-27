package pl.maniak.developer.ui.udacity.motionlayout

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import pl.maniak.developer.R
import pl.maniak.developer.ui.udacity.motionlayout.data.Step

class MotionLayoutAdapter(val data: List<Step>) :
    RecyclerView.Adapter<MotionLayoutAdapter.MotionLayoutViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MotionLayoutViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MotionLayoutViewHolder(view as CardView)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MotionLayoutViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class MotionLayoutViewHolder(val cardView: CardView) : RecyclerView.ViewHolder(cardView) {
        val header: TextView = cardView.findViewById(R.id.header)
        val description: TextView = cardView.findViewById(R.id.description)
        val caption: TextView = cardView.findViewById(R.id.caption)

        fun bind(step: Step) {
            header.text = step.number
            description.text = step.name
            caption.text = step.caption
            val context = cardView.context
            cardView.setOnClickListener {
                val intent = Intent(context, step.activity.java)
                context.startActivity(intent)
            }
            val color = if (step.highlight) {
                context.resources.getColor(R.color.secondaryLightColor)
            } else {
                context.resources.getColor(R.color.primaryTextColor)
            }
            header.setTextColor(color)
            description.setTextColor(color)
        }
    }
}