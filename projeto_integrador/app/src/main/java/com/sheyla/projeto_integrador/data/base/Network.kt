package com.sheyla.projeto_integrador.data.base

import com.sheyla.projeto_integrador.data.remotesource.MoviesRemoteSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

object Network {

    fun getMoviesRemoteSource(): MoviesRemoteSource {
        val api = getService()
        return api.create(MoviesRemoteSource::class.java)
    }


    private fun getService(): Retrofit {

        //criando uma instância do logging interceptor pra poder me mostrar no logcat tudo que vier do body da aplicação
        //precisa importar a biblioteca do logging interceptor la no build.gradle
        val logging = HttpLoggingInterceptor() //Isso se refere ao logging-interceptor, apenas para ver no logcat tudo relacionado à API.
        logging.level = HttpLoggingInterceptor.Level.BODY //Isso se refere ao logging-interceptor, apenas para ver no logcat tudo relacionado à API.

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging) //Isso se refere ao logging-interceptor, apenas para ver no logcat tudo relacionado à API.
        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url()

            val url = originalHttpUrl.newBuilder() //Essa parte é uma interceptação da URL para colocar os dados desejados.
                .addQueryParameter("api_key", Constants.PRIVATE_KEY.value) //O parâmetro (aqui como "api_key") precisa estar como consta na documentação da API. No caso do TMDB, é "api_key".
                .addQueryParameter("language", "pt-BR")
                .build() //Aqui a URL é construída.

            chain.proceed(original.newBuilder().url(url).build()) //Aqui se finaliza a construção e atribui a URL à chamada em si.
        }

        //Retrofit
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL.value)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //Com o rxjava, o Retrofit deixa de ser o responsável pelo “onResponse” e “onFailure”, sendo essa função agora do rxjava.
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
    }

}