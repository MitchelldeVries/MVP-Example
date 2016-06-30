package nl.mitchelldevries.chucknorris.view;

/**
 * Chuck Norris Joke app built with RxJava and MVP pattern.
 *
 * @author Mitchell de Vries
 */
public interface BaseView {

    void showProgress();

    void showError(String errorMessage);

    void hideProgress();

}
