package aaa.bbb.ccc.transfer.ui.login.main

import aaa.bbb.ccc.transfer.R
import aaa.bbb.ccc.transfer.util.SearchAdapter
import aaa.bbb.ccc.transfer.data.retrofit.model.RecyclerItemSearch
import aaa.bbb.ccc.transfer.data.retrofit.model.TransToken
import aaa.bbb.ccc.transfer.mvp.moxy.MvpAppCompatFragment
import aaa.bbb.ccc.transfer.mvp.presenter.main.MainPresenter
import aaa.bbb.ccc.transfer.mvp.presenter.main.MainView
import aaa.bbb.ccc.transfer.ui.login.LoginActivity
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatEditText
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.jakewharton.rxbinding2.widget.RxTextView
import kotlinx.android.synthetic.main.fragment_search.*
import org.jetbrains.anko.support.v4.toast
import java.util.ArrayList

class SearchFragment : MvpAppCompatFragment(), MainView {

    @InjectPresenter(type = PresenterType.LOCAL)
    lateinit var presenter: MainPresenter

    @SuppressLint("CheckResult")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        var idToken = LoginActivity.Sharedprefernces_IdToken.getString(LoginActivity.App_Prefences_Id_Token, "")
        RxTextView.textChanges(view.findViewById<AppCompatEditText>(R.id.inputSearch)).subscribe { text ->
            if (text.length > 0)
                presenter.filteredUserList(idToken, text.toString())
        }


        return view
    }

    override fun showError(text: String) {
        toast(text)
    }

    override fun searchName(list: ArrayList<RecyclerItemSearch>) {
        recyclerView.adapter = context?.let { SearchAdapter(it,presenter, list) }
    }

    override fun showText(id: String, name: String, email: String, balance: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showHistory(list: ArrayList<TransToken>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}