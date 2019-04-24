package aaa.bbb.ccc.transfer.data.retrofit


import aaa.bbb.ccc.transfer.data.retrofit.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import java.util.ArrayList

interface SearchResponse {
    @POST("users")
    fun postRegisterUser(@Body register: RegisterUser): Call<Results>

    @POST("sessions/create")
    fun postLoginUser(@Body login: LoginUser): Call<Results>

    @GET("api/protected/user-info")
    fun getLoggedUserInfo(@Header("Authorization")id_token: String): Call<Results>

    @GET("api/protected/transactions")
    fun getListOfLoggedUserTransactions(@Header("Authorization")id_token: String): Call<Results>

    @POST("api/protected/transactions")
    fun postCreateTransaction(@Header("Authorization")id_token: String,@Body otherUser: OtherUser): Call<Results>

    @POST("api/protected/users/list")
    fun postFilteredUserList(@Header("Authorization")id_token: String,@Body filter: Filter): Call<ArrayList<RecyclerItemSearch>>

}