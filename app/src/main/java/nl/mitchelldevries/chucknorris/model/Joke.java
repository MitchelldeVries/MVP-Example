package nl.mitchelldevries.chucknorris.model;

import com.google.gson.annotations.SerializedName;

/**
 * Chuck Norris Joke app built with RxJava and MVP pattern.
 *
 * @author Mitchell de Vries
 */
public class Joke {

    @SerializedName(value = "value")
    private Value value;

    public Value getValue() {
        return value;
    }
}
