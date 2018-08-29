package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import pitman.co.za.androidjokelib.JokeActivity;
import pitman.co.za.javajokelib.JavaJoke;


public class MainActivity extends AppCompatActivity {

    private static String LOG_TAG = MainActivity.class.getSimpleName();
    private JavaJoke mJavaJoke;
    private String returnedJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mJavaJoke = new JavaJoke();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
/*
* Step 1: jokes retrieved from Java library, presented in toast
*         Toast.makeText(this, mJavaJoke.getJoke(), Toast.LENGTH_SHORT).show();
*

/* Step 2: jokes retrieved from Java library, but sent to android library in Intent
*
*        Intent jokeTellingIntent = new Intent(this, JokeActivity.class);
*        jokeTellingIntent.putExtra(getString(R.string.joke_intent_ref), mJavaJoke.getJoke());
*        startActivity(jokeTellingIntent);
*/

/* Step 3: GCE backend integration
* */
        new EndpointsAsyncTask(this).execute(this);
    }

    public void callJokeTellingIntent(String joke) {
        this.returnedJoke = joke;       // This is for testing
        Intent jokeTellingIntent = new Intent(this, JokeActivity.class);
        jokeTellingIntent.putExtra(getString(R.string.joke_intent_ref), joke);
        startActivity(jokeTellingIntent);
    }

    public String getReturnedJoke() {
        return this.returnedJoke;
    }
}
