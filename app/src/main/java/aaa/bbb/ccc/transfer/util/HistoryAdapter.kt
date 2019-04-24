package aaa.bbb.ccc.transfer.util

import aaa.bbb.ccc.transfer.R
import aaa.bbb.ccc.transfer.data.retrofit.model.TransToken
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.rxbinding2.widget.RxTextView

class HistoryAdapter(var context: Context, var list: ArrayList<TransToken> = arrayListOf()) :
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.recyler_history_item, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(transToken: TransToken) {
            RxTextView.text(itemView.findViewById(R.id.tvId)).accept(transToken.id.toString())
            RxTextView.text(itemView.findViewById(R.id.tvDate)).accept(transToken.date)
            RxTextView.text(itemView.findViewById(R.id.tvUserName)).accept(transToken.username)
            RxTextView.text(itemView.findViewById(R.id.tvAmount)).accept(transToken.amount.toString())
            RxTextView.text(itemView.findViewById(R.id.tvBalance)).accept(transToken.balance.toString())
        }
    }
}