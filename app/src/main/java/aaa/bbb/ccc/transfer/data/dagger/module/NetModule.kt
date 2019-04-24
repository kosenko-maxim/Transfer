package aaa.bbb.ccc.transfer.data.dagger.module

import aaa.bbb.ccc.transfer.data.retrofit.SearchResponse
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetModule {
    val url = "http://193.124.114.46:3001/"
    @Provides
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    fun getResults(retrofit: Retrofit): SearchResponse {
        return retrofit.create(SearchResponse::class.java)
    }
}