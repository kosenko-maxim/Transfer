package aaa.bbb.ccc.transfer.mvp.presenter.main



import aaa.bbb.ccc.transfer.data.retrofit.model.RecyclerItemSearch
import aaa.bbb.ccc.transfer.data.retrofit.model.TransToken
import com.arellomobile.mvp.MvpView
import java.util.ArrayList

interface MainView : MvpView {
    fun showText(id: String, name: String, email: String, balance: String)

    fun showError(text: String)

    fun searchName(list: ArrayList<RecyclerItemSearch>)

    fun showHistory(list: ArrayList<TransToken>)
}
