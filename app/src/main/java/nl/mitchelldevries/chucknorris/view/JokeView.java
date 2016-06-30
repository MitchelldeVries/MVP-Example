package nl.mitchelldevries.chucknorris.view;

import nl.mitchelldevries.chucknorris.model.Joke;

/**
 * Chuck Norris Joke app built with RxJava and MVP pattern.
 *
 * @author Mitchell de Vries
 */
public interface JokeView extends BaseView {

    void setJoke(Joke joke);
}
