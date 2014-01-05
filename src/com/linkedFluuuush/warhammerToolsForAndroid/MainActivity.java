package com.linkedFluuuush.warhammerToolsForAndroid;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.*;
import com.linkedFluuuush.warhammerToolsForAndroid.core.World;
import com.linkedFluuuush.warhammerToolsForAndroid.core.characteristics.Career;
import com.linkedFluuuush.warhammerToolsForAndroid.core.characteristics.Race;
import com.linkedFluuuush.warhammerToolsForAndroid.core.entities.*;
import com.linkedFluuuush.warhammerToolsForAndroid.core.entities.Character;
import com.linkedFluuuush.warhammerToolsForAndroid.core.xmlHelper.xmlLoader;
import com.linkedFluuuush.warhammerToolsForAndroid.core.xmlHelper.xmlSaver;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ProgressDialog progressDialog;
    private Spinner raceSpinner;
    private Spinner careerSpinner;
    private Button buttonCreate;
    private TextView characterText;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        raceSpinner = (Spinner)findViewById(R.id.raceSpinner);
        careerSpinner = (Spinner)findViewById(R.id.careerSpinner);
        buttonCreate = (Button)findViewById(R.id.buttonCreate);
        characterText = (TextView)findViewById(R.id.characterText);

        new LoadViewTask().execute();
    }

    private class LoadViewTask extends AsyncTask<Void, String, Void>{
        protected void onPreExecute(){
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setTitle("Loading");
            progressDialog.setMessage("Loading resources, please wait...");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(false);
            progressDialog.setProgress(0);
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            Context context = MainActivity.this.getApplicationContext();
            int progress = 0;
            publishProgress("skills:" + progress * 9);
            World.SKILLS = xmlLoader.skillLoader(context);
            progress++;
            publishProgress("talents:" + progress * 9);
            World.TALENTS = xmlLoader.talentLoader(context);
            progress++;
            publishProgress("weapons:" + progress * 9);
            World.WEAPONS = xmlLoader.weaponLoader(context);
            progress++;
            publishProgress("armours:" + progress * 9);
            World.ARMOURS = xmlLoader.armourLoader(context);
            progress++;
            publishProgress("equipments:" + progress * 9);
            World.EQUIPMENTS = xmlLoader.equipmentLoader(context);
            progress++;
            publishProgress("gods:" + progress * 9);
            World.GODS = xmlLoader.godLoader(context);
            progress++;
            publishProgress("astral signs:" + progress * 9);
            World.ASTRALSIGNS = xmlLoader.astralSignsLoader(context);
            progress++;
            publishProgress("distinguishing signs:" + progress * 9);
            World.DISTINGUISHINGSIGNS = xmlLoader.distinguishingSignsLoader(context);
            progress++;
            publishProgress("races:" + progress * 9);
            World.RACES = xmlLoader.raceLoader(context);
            progress++;
            publishProgress("careers:" + progress * 9);
            World.CAREERS = xmlLoader.careerLoader(context);
            progress++;
            publishProgress("careers:" + progress * 9);
            xmlLoader.careerLinker(context);
            return null;
        }

        @Override
        public void onProgressUpdate(String... values){
            values = values[0].split(":");
            progressDialog.setMessage("Loading " + values[0]);
            progressDialog.setProgress(Integer.parseInt(values[1]));
        }

        @Override
        public void onPostExecute(Void result){
            progressDialog.dismiss();

            List<Career> careerList = World.CAREERS;

            ArrayAdapter<Career> careerDataAdapter = new ArrayAdapter<Career>(MainActivity.this.getApplicationContext(), android.R.layout.simple_spinner_item, careerList);
            careerDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            careerSpinner.setAdapter(careerDataAdapter);

            List<Race> raceList = World.RACES;

            ArrayAdapter<Race> raceDataAdapter = new ArrayAdapter<Race>(MainActivity.this.getApplicationContext(), android.R.layout.simple_spinner_item, raceList);
            raceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            raceSpinner.setAdapter(raceDataAdapter);

            buttonCreate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Career career = (Career) careerSpinner.getSelectedItem();
                    Race race = (Race) raceSpinner.getSelectedItem();

                    Character character = new Character(race, career);

                    MainActivity.this.setContentView(R.layout.display_character);

                    characterText = (TextView)findViewById(R.id.characterText);
                    characterText.setText(character.toString());
                }
            });
        }
    }
}
