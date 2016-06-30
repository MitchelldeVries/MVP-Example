package nl.mitchelldevries.chucknorris.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nl.mitchelldevries.chucknorris.R;
import nl.mitchelldevries.chucknorris.interactor.FetchJokeInteractor;
import nl.mitchelldevries.chucknorris.model.Joke;
import nl.mitchelldevries.chucknorris.network.JokeApi;
import nl.mitchelldevries.chucknorris.network.JokeService;
import nl.mitchelldevries.chucknorris.presenter.JokePresenter;
import nl.mitchelldevries.chucknorris.presenter.JokePresenterImpl;
import nl.mitchelldevries.chucknorris.view.JokeView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.*;

/**
 * Chuck Norris Joke app built with RxJava and MVP pattern.
 *
 * @author Mitchell de Vries
 */
public class JokeActivity extends AppCompatActivity implements JokeView {

    @BindView(R.id.joke_text_field)
    TextView jokeTextView;
    @BindView(R.id.progress)
    ProgressBar progress;

    private JokePresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        FetchJokeInteractor fetchJokeInteractor = new FetchJokeInteractor(JokeService.getInstance().getApi());
        presenter = new JokePresenterImpl(this, fetchJokeInteractor);
        presenter.loadJoke();
    }

    @Override
    public void setJoke(String joke) {
        jokeTextView.setText(joke);
    }

    @Override
    public void showProgress() {
        jokeTextView.setVisibility(GONE);
        progress.setVisibility(VISIBLE);
    }

    @Override
    public void showError(String errorMessage) {
        jokeTextView.setText(errorMessage);
    }

    @Override
    public void hideProgress() {
        jokeTextView.setVisibility(VISIBLE);
        progress.setVisibility(GONE);
    }

    @OnClick(R.id.new_joke_button)
    void loadNewJoke(){
        presenter.loadJoke();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.finish();
    }
}
