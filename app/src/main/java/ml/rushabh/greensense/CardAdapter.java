package ml.rushabh.greensense;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends ArrayAdapter<DeviceData>{
    private final Context context;
    private final ArrayList<DeviceData> list;

    public CardAdapter(@NonNull Context context, int resource, ArrayList<DeviceData> list) {
        super(context, resource, list);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View cardView = inflater.inflate(R.layout.card,parent,false);
        TextView textView = (TextView)cardView.findViewById(R.id.tv);
        DeviceData deviceData = list.get(position);
        textView.setText("Air Humidity : "+deviceData.airHumidity
        +"\npH : "+deviceData.pH+"\nSoil Moisture : " + deviceData.soilMoisture+"\ntemperature : "+deviceData.temperature+"\nTimeUnderSunlight : "+deviceData.timeUnderSunlight);
        return cardView;
    }

    @Override
    public void add(@Nullable DeviceData object) {
        super.add(object);
    }
}