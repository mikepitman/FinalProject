package pitman.co.za.androidjokelib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    private static String LOG_TAG = JokeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView jokeTextView = (TextView) findViewById(R.id.lame_joke_text);

        Intent intent = getIntent();
        if ((intent != null)) {

            String joke = intent.getStringExtra(getString(R.string.joke_intent_ref));
            if (!joke.isEmpty()) {
                jokeTextView.setText(joke);
                Log.d(LOG_TAG, "Intent non-null, setting joke value");
            } else {
                Log.d(LOG_TAG, "StringExtra on intent is empty");
                jokeTextView.setText(R.string.joke_failure);
            }
        } else {
            Log.d(LOG_TAG, "Intent is NULL");
            jokeTextView.setText(R.string.joke_failure);
        }
    }
}
