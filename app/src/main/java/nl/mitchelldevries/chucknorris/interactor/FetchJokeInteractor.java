package nl.mitchelldevries.chucknorris.interactor;

import nl.mitchelldevries.chucknorris.model.Joke;
import nl.mitchelldevries.chucknorris.network.JokeApi;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Chuck Norris Joke app built with RxJava and MVP pattern.
 *
 * @author Mitchell de Vries
 */
public class FetchJokeInteractor extends Interactor<Joke> {

    private JokeApi api;

    public FetchJokeInteractor(JokeApi api) {
        this.api = api;
    }

    @Override
    protected Observable<Joke> getObservable() {
        return api.getRandomJoke()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
