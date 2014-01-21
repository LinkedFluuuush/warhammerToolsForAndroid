package com.linkedFluuuush.warhammerToolsForAndroid.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.linkedFluuuush.warhammerToolsForAndroid.R;
import com.linkedFluuuush.warhammerToolsForAndroid.core.World;
import com.linkedFluuuush.warhammerToolsForAndroid.core.characteristics.Career;
import com.linkedFluuuush.warhammerToolsForAndroid.core.characteristics.Race;
import com.linkedFluuuush.warhammerToolsForAndroid.core.entities.Character;
import com.linkedFluuuush.warhammerToolsForAndroid.core.entities.God;

import java.util.LinkedList;
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

    EditText textName;
    EditText textAge;
    EditText textEyeColor;
    EditText textHairColor;
    EditText textAstralSign;
    EditText textBirthPlace;
    EditText textHeight;
    EditText textWeight;
    EditText textDistinguishingSigns;

    EditText textWS;
    EditText textBS;
    EditText textS;
    EditText textT;
    EditText textAg;
    EditText textInt;
    EditText textWP;
    EditText textFel;

    EditText textA;
    EditText textW;
    EditText textSB;
    EditText textTB;
    EditText textM;
    EditText textMag;
    EditText textIP;
    EditText textFP;

    Spinner genderSpinner;
    Spinner mainHandSpinner;
    Spinner godSpinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
		inflater.inflate(R.layout.display_character, container);

        if(savedInstanceState != null){
            this.character = (Character) savedInstanceState.getSerializable("character");
        }

        View rootView = inflater.inflate(R.layout.display_character, container, false);

        raceSpinner = (Spinner) rootView.findViewById(R.id.raceSpinner);
        careerSpinner = (Spinner) rootView.findViewById(R.id.careerSpinner);
        buttonCreate = (Button) rootView.findViewById(R.id.buttonCreate);

        textName = (EditText) rootView.findViewById(R.id.textName);
        textAge = (EditText) rootView.findViewById(R.id.textAge);
        textEyeColor = (EditText) rootView.findViewById(R.id.textEyeColour);
        textHairColor = (EditText) rootView.findViewById(R.id.textHairColour);
        textAstralSign = (EditText) rootView.findViewById(R.id.textAstralSign);
        textBirthPlace = (EditText) rootView.findViewById(R.id.textBirthPlace);
        textHeight = (EditText) rootView.findViewById(R.id.textHeight);
        textWeight = (EditText) rootView.findViewById(R.id.textWeight);
        textDistinguishingSigns = (EditText) rootView.findViewById(R.id.textDistinguishingSigns);

        genderSpinner = (Spinner) rootView.findViewById(R.id.spinnerGender);
        mainHandSpinner = (Spinner) rootView.findViewById(R.id.spinnerMainHand);
        godSpinner = (Spinner) rootView.findViewById(R.id.favoriteGod);

        textWS = (EditText) rootView.findViewById(R.id.WSText);
        textBS = (EditText) rootView.findViewById(R.id.BSText);
        textS = (EditText) rootView.findViewById(R.id.SText);
        textT = (EditText) rootView.findViewById(R.id.TText);
        textAg = (EditText) rootView.findViewById(R.id.AgText);
        textInt = (EditText) rootView.findViewById(R.id.IntText);
        textWP = (EditText) rootView.findViewById(R.id.WPText);
        textFel = (EditText) rootView.findViewById(R.id.FelText);

        textA = (EditText) rootView.findViewById(R.id.AText);
        textW = (EditText) rootView.findViewById(R.id.WText);
        textSB = (EditText) rootView.findViewById(R.id.SBText);
        textTB = (EditText) rootView.findViewById(R.id.TBText);
        textM = (EditText) rootView.findViewById(R.id.MText);
        textMag = (EditText) rootView.findViewById(R.id.MagText);
        textIP = (EditText) rootView.findViewById(R.id.IPText);
        textFP = (EditText) rootView.findViewById(R.id.FPText);

        ArrayAdapter<Career> careerDataAdapter = new ArrayAdapter<Career>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, World.CAREERS);
        careerDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        careerSpinner.setAdapter(careerDataAdapter);

        ArrayAdapter<Race> raceDataAdapter = new ArrayAdapter<Race>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, World.RACES);
        raceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        raceSpinner.setAdapter(raceDataAdapter);

        ArrayAdapter<God> godDataAdapter = new ArrayAdapter<God>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, World.GODS);
        godDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        godSpinner.setAdapter(godDataAdapter);

        List<String> genderList = new LinkedList<String>();
        genderList.add("Masculin");
        genderList.add("Féminin");
        genderList.add("Indéfini");

        ArrayAdapter<String> genderDataAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, genderList);
        genderDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        genderSpinner.setAdapter(genderDataAdapter);

        List<String> handList = new LinkedList<String>();
        handList.add("Droite");
        handList.add("Gauche");
        handList.add("Ambidextre");
        handList.add("Ambisinistre ");

        ArrayAdapter<String> handDataAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, handList);
        handDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mainHandSpinner.setAdapter(handDataAdapter);


        if(character != null){
            applyCharacter();
        }

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Career career = (Career) careerSpinner.getSelectedItem();
                Race race = (Race) raceSpinner.getSelectedItem();

                character = new Character(race, career);

                //characterText.setText(character.toString())

                applyCharacter();
            }
        });

        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("character", character);
    }

    private void applyCharacter(){
        textName.setText(character.getName());
        textAge.setText(character.getDetails().getAge() + " ans");
        textEyeColor.setText(character.getDetails().getEyeColour());
        textHairColor.setText(character.getDetails().getHairColour());
        textAstralSign.setText(character.getDetails().getAstralSign().getName());
        if(((character.getDetails().getHeight() % 100) + "").length() == 1)
            textHeight.setText(character.getDetails().getHeight() / 100 + "m0" + character.getDetails().getHeight() % 100);
        else
            textHeight.setText(character.getDetails().getHeight() / 100 + "m" + character.getDetails().getHeight() % 100);
        textWeight.setText(character.getDetails().getWeight() + " kg");
        textBirthPlace.setText(character.getDetails().getBirthplace());

        String s = "";
        for(String sign : character.getDetails().getDistinguishingMarks()){
            s += sign + "\n";
        }
        s = s.substring(0, s.length() - 1);
        textDistinguishingSigns.setText(s);

        if(character.getDetails().isMale()){
            genderSpinner.setSelection(0);
        } else {
            genderSpinner.setSelection(1);
        }

        godSpinner.setSelection(World.GODS.indexOf(character.getDetails().getFavoriteGod()));

        textWS.setText(character.getProfile().getWs() + "");
        textBS.setText(character.getProfile().getBs() + "");
        textS.setText(character.getProfile().getS() + "");
        textT.setText(character.getProfile().getT() + "");
        textAg.setText(character.getProfile().getAg() + "");
        textInt.setText(character.getProfile().getIntel() + "");
        textWP.setText(character.getProfile().getWp() + "");
        textFel.setText(character.getProfile().getFel() + "");

        textA.setText(character.getProfile().getA() + "");
        textW.setText(character.getProfile().getW() + "");
        textSB.setText(character.getProfile().getSb() + "");
        textTB.setText(character.getProfile().getTb() + "");
        textM.setText(character.getProfile().getM() + "");
        textMag.setText(character.getProfile().getMag() + "");
        textIP.setText(character.getProfile().getIp() + "");
        textFP.setText(character.getProfile().getFp() + "");
    }

}
