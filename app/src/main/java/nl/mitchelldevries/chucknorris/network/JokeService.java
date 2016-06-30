package nl.mitchelldevries.chucknorris.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Chuck Norris Joke app built with RxJava and MVP pattern.
 *
 * @author Mitchell de Vries
 */
public class JokeService {

    private static JokeService ourInstance = new JokeService();

    public static JokeService getInstance() {
        return ourInstance;
    }

    private JokeApi api;

    private String baseUrl = "http://api.icndb.com/";

    private JokeService() {
        api = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(JokeApi.class);
    }

    public JokeApi getApi() {
        return api;
    }
}
