package com.linkedFluuuush.warhammerToolsForAndroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.linkedFluuuush.warhammerToolsForAndroid.core.World;
import com.linkedFluuuush.warhammerToolsForAndroid.core.entities.*;
import com.linkedFluuuush.warhammerToolsForAndroid.core.entities.Character;

public class MainActivity extends Activity {
    TextView text;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        text = (TextView) findViewById(R.id.textView);

        World.loadAll(this.getApplicationContext());

        Character randomCharacter = new Character(World.searchRaceByName("Halfing"), World.searchCareerByName("Agitateur"));

        System.out.println("");

        text.setText(randomCharacter.toString());
    }
}
