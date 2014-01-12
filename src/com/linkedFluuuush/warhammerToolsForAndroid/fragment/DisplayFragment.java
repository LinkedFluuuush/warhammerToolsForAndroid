package com.linkedFluuuush.warhammerToolsForAndroid.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import com.linkedFluuuush.warhammerToolsForAndroid.R;
import com.linkedFluuuush.warhammerToolsForAndroid.core.World;
import com.linkedFluuuush.warhammerToolsForAndroid.core.characteristics.Career;
import com.linkedFluuuush.warhammerToolsForAndroid.core.characteristics.Race;
import com.linkedFluuuush.warhammerToolsForAndroid.core.entities.Character;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: linked
 * Date: 07/01/14
 * Time: 15:29
 *
 * @author Jean-Baptiste Louvet jbaptiste.louvet@gmail.com
 * @version 1.0
 */
public class DisplayFragment extends Fragment {
    Spinner raceSpinner;
    Spinner careerSpinner;
    Button buttonCreate;
    TextView characterText;
    Character character;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState){
        View rootView = inflater.inflate(R.layout.display_character, container, false);

        raceSpinner = (Spinner) rootView.findViewById(R.id.raceSpinner);
        careerSpinner = (Spinner) rootView.findViewById(R.id.careerSpinner);
        buttonCreate = (Button) rootView.findViewById(R.id.buttonCreate);
        characterText = (TextView) rootView.findViewById(R.id.characterText);

        List<Career> careerList = World.CAREERS;

        ArrayAdapter<Career> careerDataAdapter = new ArrayAdapter<Career>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, careerList);
        careerDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        careerSpinner.setAdapter(careerDataAdapter);

        List<Race> raceList = World.RACES;

        ArrayAdapter<Race> raceDataAdapter = new ArrayAdapter<Race>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, raceList);
        raceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        raceSpinner.setAdapter(raceDataAdapter);

        if(character != null){
            characterText.setText(character.toString());
        }

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Career career = (Career) careerSpinner.getSelectedItem();
                Race race = (Race) raceSpinner.getSelectedItem();

                character = new Character(race, career);

                characterText.setText(character.toString());

                /*Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                intent.putExtra("EXTRA_RACE", race.getName());
                intent.putExtra("EXTRA_CAREER", career.getName());

                startActivity(intent);*/
            }
        });

        return rootView;
    }
}
