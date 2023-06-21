package pwr.aplikacja_dat

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(private val dataList: List<DataModel>) : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {


    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textNazwa: TextView = itemView.findViewById(R.id.name)
        val textStatus: TextView = itemView.findViewById(R.id.status)
        val textZuzyteDane: TextView = itemView.findViewById(R.id.dane)
        val s1: Button = itemView.findViewById(R.id.s1)
        val z1: Button = itemView.findViewById(R.id.z1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return DataViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val data = dataList[position]
        holder.textNazwa.text = data.nazwa
        holder.textStatus.text = data.status
        holder.textZuzyteDane.text = data.zuzyteDane
        holder.s1.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, StatisticsActivity::class.java)
            context.startActivity(intent)
        }
        holder.z1.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DevicesActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}