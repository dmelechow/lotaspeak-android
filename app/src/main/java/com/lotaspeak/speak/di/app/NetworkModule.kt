package com.lotaspeak.speak.di.app

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.lotaspeak.speak.App
import com.lotaspeak.speak.data.network.RestApi
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Dispatcher
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import javax.inject.Singleton

private const val BASE_URL = "http://lotaspeak.herokuapp.com/api/"

@Module
class NetworkModule(private val cacheSize: Long) {

    /**
     * @param app
     * @return
     */
    @Provides
    fun provideInterceptor(app: App): Interceptor {
        return Interceptor { chain ->
            var request = chain.request()

            request = request.newBuilder()
                .addHeader("From", "android")
                .build()

            chain.proceed(request)
        }
    }

    /**
     * @return
     */
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssz")
            .create()
    }

    /**
     * @return
     */
    @Provides
    fun provideHttpCache(app: App): Cache {
        val httpCacheDirectory = File(app.baseContext.cacheDir, "responses")
        return Cache(httpCacheDirectory, cacheSize)
    }


    /**
     * @param interceptor
     * @param cache
     * @param cookie
     * @return
     */
    @Provides
    fun provideHttpClient(
       interceptor: Interceptor
    ): OkHttpClient.Builder {

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val request = chain.request().newBuilder().addHeader("User-Agent", "sunlight-android").build()
            chain.proceed(request)
        }


        httpClient.addInterceptor(interceptor)
        val dispatcher = Dispatcher()
        dispatcher.maxRequestsPerHost = NUMBER_OF_CORES
        httpClient.dispatcher(dispatcher)
        return httpClient
    }


    /**
     * @param gson
     * @param httpClient
     * @return
     */
    @Provides
    fun provideRetrofit(gson: Gson,  httpClient: OkHttpClient.Builder): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(NullOnEmptyConverterFactory())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient.build())
            .build()
    }

    /**
     * @param retrofit
     * @return
     */
    @Provides
    @Singleton
    fun provideRestApi(retrofit: Retrofit): RestApi {
        return retrofit.create(RestApi::class.java)
    }

    companion object {
        private val NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors()
    }
}
