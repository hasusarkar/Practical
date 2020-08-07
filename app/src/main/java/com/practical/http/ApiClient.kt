package com.practical.http

import android.content.Context

import com.practical.AppConstant

import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

object ApiClient {

    fun createService(context: Context): ApiService {
        return setupRetrofit(context)
            .create(ApiService::class.java)
    }

    fun setupOkHttp(context: Context): OkHttpClient {
        val cacheSize = 10 * 1024 * 1024 // 10 MiB
        val cacheDir = File(context.cacheDir, "HttpCache")
        val cache = Cache(cacheDir, cacheSize.toLong())
        //TODO Replace sample_certificate.pem with your server public certificate in raw resource and uncomment .setupNetworkSecurity(context)
        val builder = OkHttpClient.Builder()
            .readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
//            .setupNetworkSecurity(context)
            .cache(cache)
        // if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(loggingInterceptor)
        builder.addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
            // Adding Authorization token (API Key)
            val request = requestBuilder.build()
            chain.proceed(request)
        }
        // }
        return builder.build()
    }

    private fun setupRetrofit(context: Context): Retrofit {
        return Retrofit.Builder()
            .baseUrl(AppConstant.Base_Url)
            .client(setupOkHttp(context))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}