package nail.lynxmsk.test.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Items {
    @SerializedName("events")
    public ArrayList<Articles> events;
}
