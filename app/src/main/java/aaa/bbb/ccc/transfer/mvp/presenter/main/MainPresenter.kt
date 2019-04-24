package aaa.bbb.ccc.transfer.mvp.presenter.main


import aaa.bbb.ccc.transfer.App
import aaa.bbb.ccc.transfer.data.retrofit.SearchResponse
import aaa.bbb.ccc.transfer.data.retrofit.model.Filter
import aaa.bbb.ccc.transfer.data.retrofit.model.OtherUser
import aaa.bbb.ccc.transfer.data.retrofit.model.RecyclerItemSearch
import aaa.bbb.ccc.transfer.data.retrofit.model.Results
import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen

import java.util.ArrayList
import javax.inject.Inject

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {
    @Inject
    lateinit var searchResponse: SearchResponse
    @Inject
    lateinit var router: Router
    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    init {
        App.component.injectsToMainActivity(this)
    }


    fun loggedUserInfo(id_token: String) {
        val call = searchResponse.getLoggedUserInfo(id_token)
        Log.i("+++++++++++++++++", id_token)
        call.enqueue(object : Callback<Results> {
            override fun onResponse(call: Call<Results>, response: Response<Results>) {
                if (response.isSuccessful()) {
                    val id = response.body()!!.userInfoToken!!.id.toString()
                    val userName = response.body()!!.userInfoToken!!.name
                    val email = response.body()!!.userInfoToken!!.email
                    val balance = response.body()!!.userInfoToken!!.balance.toString()
                    viewState.showText(id, userName!!, email!!, balance)
                } else {
                    when (response.code()) {
                        400 -> viewState.showError("User not found")
                        401 -> viewState.showError("UnauthorizedError")
                    }
                }
            }

            override fun onFailure(call: Call<Results>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    fun listOfLoggedUserTransactions(id_token: String) {
        val call = searchResponse.getListOfLoggedUserTransactions(id_token)

        call.enqueue(object : Callback<Results> {
            override fun onResponse(call: Call<Results>, response: Response<Results>) {
                if (response.isSuccessful()) {
                    viewState.showHistory(response.body()!!.transToken!!)

                } else {
                    viewState.showError("UnauthorizedError")
                }
            }

            override fun onFailure(call: Call<Results>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    fun createTransaction(id_token: String, name: String, amount: String) {
        val call = searchResponse.postCreateTransaction(id_token, OtherUser(name, amount))
        call.enqueue(object : Callback<Results> {
            override fun onResponse(call: Call<Results>, response: Response<Results>) {
                println(response.message())
            }

            override fun onFailure(call: Call<Results>, t: Throwable) {

            }
        })
    }

    fun filteredUserList(id_token: String, filter: String) {
        val list = ArrayList<RecyclerItemSearch>()
        val call = searchResponse.postFilteredUserList(id_token, Filter(filter))
        call.enqueue(object : Callback<ArrayList<RecyclerItemSearch>> {
            override fun onResponse(
                call: Call<ArrayList<RecyclerItemSearch>>,
                response: Response<ArrayList<RecyclerItemSearch>>
            ) {
                if (response.isSuccessful) {
                    for (i in 0 until response.body()!!.size) {
                        println("${response.body()!![i].id} ${response.body()!![i].name}")
                        list.add(RecyclerItemSearch(response.body()!![i].id, response.body()!![i].name))
                    }
                    viewState.searchName(list)
                }
            }
            override fun onFailure(call: Call<ArrayList<RecyclerItemSearch>>, t: Throwable) {

            }
        }

        )
    }

    fun navigateTo(screen: SupportAppScreen) {
        router.navigateTo(screen)
    }

    fun replaceScreen(screen: SupportAppScreen) {
        router.replaceScreen(screen)
    }
    fun onBackPressed(){
        router.exit()
    }
}
