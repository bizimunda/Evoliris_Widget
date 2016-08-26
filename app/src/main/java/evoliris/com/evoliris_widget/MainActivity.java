package evoliris.com.evoliris_widget;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import evoliris.com.evoliris_widget.widget.MessageAppWidget;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent refresh = new Intent(MainActivity.this, MessageAppWidget.class);
        refresh.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        refresh.putExtra(
                AppWidgetManager.EXTRA_APPWIDGET_IDS,
                AppWidgetManager.getInstance(this)
                        .getAppWidgetIds(
                                new ComponentName(this, MessageAppWidget.class)));
        sendBroadcast(refresh);
    }



}
