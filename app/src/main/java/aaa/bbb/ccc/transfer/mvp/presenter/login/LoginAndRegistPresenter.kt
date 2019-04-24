package aaa.bbb.ccc.transfer.mvp.presenter.login


import aaa.bbb.ccc.transfer.App
import aaa.bbb.ccc.transfer.data.retrofit.SearchResponse
import aaa.bbb.ccc.transfer.data.retrofit.model.LoginUser
import aaa.bbb.ccc.transfer.data.retrofit.model.RegisterUser
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
import javax.inject.Inject

@InjectViewState
class LoginAndRegistPresenter : MvpPresenter<LoginAndRegistView>() {
    @Inject
    lateinit var searchResponse: SearchResponse
    @Inject
    lateinit var router: Router
    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    init {
        App.component.injectsToLogActivity(this)
    }

    fun loginUser(email: String, password: String) {
        val call = searchResponse.postLoginUser(LoginUser(email, password))
        call.enqueue(object : Callback<Results> {

            override fun onResponse(call: Call<Results>, response: Response<Results>) {
                if (response.isSuccessful) {
                    Log.i("------------------", response.body()!!.id_token);
                    viewState.saveIdToken("Bearer ${response.body()!!.id_token!!}")
                } else
                    viewState.showError("You must send email and password")
            }

            override fun onFailure(call: Call<Results>, t: Throwable) {
                viewState.showError("You must send email and password")
            }
        })
    }

    fun registerUser(username: String, password: String, email: String) {
        val call = searchResponse.postRegisterUser(RegisterUser(username, password, email))
        call.enqueue(object : Callback<Results> {

            override fun onResponse(call: Call<Results>, response: Response<Results>) {
                if (response.isSuccessful)
                    viewState.saveIdToken("Bearer ${response.body()!!.id_token!!}")
                else {
                    viewState.showError("You must send email and password")
                }
            }

            override fun onFailure(call: Call<Results>, t: Throwable) {

            }
        })

    }

    fun navigateTo(screen: SupportAppScreen) {
        router.navigateTo(screen)
    }
    fun replaceScreen(screen: SupportAppScreen) {
        router.replaceScreen(screen)
    }

}
