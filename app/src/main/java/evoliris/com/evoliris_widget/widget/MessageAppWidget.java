package evoliris.com.evoliris_widget.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import java.util.Date;

import evoliris.com.evoliris_widget.R;

/**
 * Implementation of App Widget functionality.
 */
public class MessageAppWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        final int N = appWidgetIds.length;
        for (int i = 0; i < N; i++) {
            updateAppWidget(context, appWidgetManager, appWidgetIds[i]);
        }
    }


    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created

        Log.i("onEnabled","Enabling");
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = "Today is: "+ new Date().toString();
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.message_app_widget);
        views.setTextViewText(R.id.appwidget_text, widgetText);

        Intent refresh= new Intent(context, MessageAppWidget.class);
        refresh.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        refresh.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, new int [] {appWidgetId});

        PendingIntent pendingIntent= PendingIntent.getBroadcast(context,
                0, refresh, 0);
        views.setOnClickPendingIntent(R.id.btn_main_refresh, pendingIntent);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }
}


