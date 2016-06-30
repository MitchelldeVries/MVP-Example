package nl.mitchelldevries.chucknorris.presenter;

import nl.mitchelldevries.chucknorris.model.Joke;

/**
 * Chuck Norris Joke app built with RxJava and MVP pattern.
 *
 * @author Mitchell de Vries
 */
public interface JokePresenter extends BasePresenter {

    void loadJoke();
}
