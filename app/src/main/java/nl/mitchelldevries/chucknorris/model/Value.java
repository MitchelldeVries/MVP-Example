package nl.mitchelldevries.chucknorris.model;

import com.google.gson.annotations.SerializedName;

/**
 * Chuck Norris Joke app built with RxJava and MVP pattern.
 *
 * @author Mitchell de Vries
 */
public class Value {

    @SerializedName(value = "joke")
    private String joke;

    public String getJoke() {
        return joke;
    }
}
