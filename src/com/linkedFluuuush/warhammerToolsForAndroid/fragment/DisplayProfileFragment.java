package com.linkedFluuuush.warhammerToolsForAndroid.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.linkedFluuuush.warhammerToolsForAndroid.R;

import java.util.List;
import java.util.LinkedList;

import com.linkedFluuuush.warhammerToolsForAndroid.core.*;
import com.linkedFluuuush.warhammerToolsForAndroid.core.entities.*;

public class DisplayProfileFragment extends Fragment
{
	
	EditText textName;
    EditText textAge;
    EditText textEyeColor;
    EditText textHairColor;
    EditText textAstralSign;
    EditText textBirthPlace;
    EditText textHeight;
    EditText textWeight;
    EditText textDistinguishingSigns;
	
	Spinner genderSpinner;
    Spinner mainHandSpinner;
    Spinner godSpinner;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.character_details, container, false);
		
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
		
		return rootView;
	}
}
