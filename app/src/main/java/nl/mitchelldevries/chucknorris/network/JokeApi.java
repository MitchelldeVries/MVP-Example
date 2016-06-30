package nl.mitchelldevries.chucknorris.network;

import nl.mitchelldevries.chucknorris.model.Joke;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Chuck Norris Joke app built with RxJava and MVP pattern.
 *
 * @author Mitchell de Vries
 */
public interface JokeApi {

    @GET(value = "/jokes/random")
    Observable<Joke> getRandomJoke();
}
