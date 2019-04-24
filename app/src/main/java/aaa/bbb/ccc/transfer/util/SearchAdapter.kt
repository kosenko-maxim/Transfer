package aaa.bbb.ccc.transfer.util

import aaa.bbb.ccc.transfer.R
import aaa.bbb.ccc.transfer.data.retrofit.model.RecyclerItemSearch
import aaa.bbb.ccc.transfer.mvp.presenter.main.MainPresenter
import aaa.bbb.ccc.transfer.ui.login.LoginActivity
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import org.jetbrains.anko.*

class SearchAdapter(
    var context: Context,
    var presenter: MainPresenter,
    var list: ArrayList<RecyclerItemSearch> = arrayListOf()
) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_search_item, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("CheckResult")
        fun bindItems(recyclerItemSearch: RecyclerItemSearch) {
            itemView.findViewById<TextView>(R.id.tvId).text = recyclerItemSearch.id.toString()
            val tvName = itemView.findViewById<TextView>(R.id.tvName)
            RxTextView.text(tvName).accept(recyclerItemSearch.name)
            RxView.clicks(itemView.findViewById<ImageView>(R.id.tranns)).subscribe {
                context.alert {
                    customView {
                        val text = editText {
                            inputType = 2002
                        }.text
                        yesButton {
                            var idToken = LoginActivity.Sharedprefernces_IdToken.getString(LoginActivity.App_Prefences_Id_Token, "")

                            presenter.createTransaction(idToken, tvName.text.toString(), text.toString())
                        }
                        noButton {}
                    }
                }.show()
            }
        }
    }
}