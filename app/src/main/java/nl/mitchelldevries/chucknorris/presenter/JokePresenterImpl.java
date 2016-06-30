package nl.mitchelldevries.chucknorris.presenter;

import nl.mitchelldevries.chucknorris.interactor.FetchJokeInteractor;
import nl.mitchelldevries.chucknorris.model.Joke;
import nl.mitchelldevries.chucknorris.view.JokeView;
import rx.Subscriber;

/**
 * Chuck Norris Joke app built with RxJava and MVP pattern.
 *
 * @author Mitchell de Vries
 */
public class JokePresenterImpl implements JokePresenter {

    private JokeView view;
    private FetchJokeInteractor interactor;

    public JokePresenterImpl(JokeView view, FetchJokeInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void loadJoke() {
        view.showProgress();
        interactor.execute(new JokeSubscriber());
    }

    @Override
    public void finish() {
        interactor.unsubscribe();
    }

    private final class JokeSubscriber extends Subscriber<Joke> {

        @Override
        public void onStart() {
            view.showProgress();
        }

        @Override
        public void onCompleted() {
            view.hideProgress();
        }

        @Override
        public void onError(Throwable error) {
            view.hideProgress();
            view.showError(error.getMessage());
        }

        @Override
        public void onNext(Joke joke) {
            view.setJoke(joke);
        }
    }
}
