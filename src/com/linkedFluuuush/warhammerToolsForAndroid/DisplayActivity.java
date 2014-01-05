package com.linkedFluuuush.warhammerToolsForAndroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.linkedFluuuush.warhammerToolsForAndroid.core.World;
import com.linkedFluuuush.warhammerToolsForAndroid.core.characteristics.Career;
import com.linkedFluuuush.warhammerToolsForAndroid.core.characteristics.Race;
import com.linkedFluuuush.warhammerToolsForAndroid.core.entities.Character;

/**
 * Created with IntelliJ IDEA.
 * User: linked
 * Date: 05/01/14
 * Time: 11:54
 *
 * @author Jean-Baptiste Louvet jbaptiste.louvet@gmail.com
 * @version 1.0
 */
public class DisplayActivity extends Activity {

    TextView characterText;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_character);

        characterText = (TextView) findViewById(R.id.characterText);

        Intent intent = getIntent();

        if(intent != null){
            Career career = World.searchCareerByName(intent.getStringExtra("EXTRA_CAREER"));
            Race race = World.searchRaceByName(intent.getStringExtra("EXTRA_RACE"));

            Character character = new Character(race, career);

            characterText.setText(character.toString());
        } else {
            characterText.setText("Undefined character");
        }
    }
}
