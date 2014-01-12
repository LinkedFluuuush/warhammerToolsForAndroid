package com.linkedFluuuush.warhammerToolsForAndroid.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.linkedFluuuush.warhammerToolsForAndroid.R;
import com.linkedFluuuush.warhammerToolsForAndroid.core.equipment.Money;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: linked
 * Date: 12/01/14
 * Time: 16:32
 *
 * @author Jean-Baptiste Louvet jbaptiste.louvet@gmail.com
 * @version 1.0
 */
public class UtilsFragment extends Fragment {
    EditText editTextMoney;
    Button buttonRandomizeMoney;
    TextView textMoneyFinal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState){
        View rootView = inflater.inflate(R.layout.utils_display, container, false);

        editTextMoney = (EditText)rootView.findViewById(R.id.textBaseMoney);
        buttonRandomizeMoney = (Button)rootView.findViewById(R.id.buttonRandomizeMoney);
        textMoneyFinal = (TextView)rootView.findViewById(R.id.textMoneyFinal);

        buttonRandomizeMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textMoneyFinal.setText(randomMoney(Integer.parseInt(editTextMoney.getText().toString())).toString());
            }
        });

        return rootView;
    }

    public static Money randomMoney(int base){
        Random r = new Random();
        int initialMoney = base;

        int goldenCrowns = r.nextInt(initialMoney + 1);

        int silverShillings = 0;
        int brassPennies = 0;

        initialMoney = initialMoney - goldenCrowns;

        if(initialMoney > 0){
            initialMoney = initialMoney * 20;
            silverShillings = r.nextInt(initialMoney + 1);
            initialMoney = initialMoney - silverShillings;

            if(initialMoney > 0){
                brassPennies = initialMoney * 12;
            }
        }

        return new Money(goldenCrowns, silverShillings, brassPennies);
    }
}
