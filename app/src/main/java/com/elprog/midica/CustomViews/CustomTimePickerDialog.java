package com.elprog.midica.CustomViews;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import com.facebook.appevents.AppEventsConstants;

import java.util.ArrayList;

public class CustomTimePickerDialog extends TimePickerDialog {
    private static final int TIME_PICKER_INTERVAL = 15;
    private TimePicker mTimePicker;
    private final OnTimeSetListener mTimeSetListener;

    public static String timeAmPmStatus(int i) {
        return i > 11 ? "PM" : "AM";
    }

    public CustomTimePickerDialog(Context context, OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, 3, (OnTimeSetListener) null, i, i2 / 15, z);
        this.mTimeSetListener = onTimeSetListener;
    }

    public void updateTime(int i, int i2) {
        this.mTimePicker.setCurrentHour(Integer.valueOf(i));
        this.mTimePicker.setCurrentMinute(Integer.valueOf(i2 / 15));
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        OnTimeSetListener onTimeSetListener;
        if (i == -2) {
            cancel();
        } else if (i == -1 && (onTimeSetListener = this.mTimeSetListener) != null) {
            TimePicker timePicker = this.mTimePicker;
            onTimeSetListener.onTimeSet(timePicker, timePicker.getCurrentHour().intValue(), this.mTimePicker.getCurrentMinute().intValue() * 15);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            Class<?> cls = Class.forName("com.android.internal.R$id");
            this.mTimePicker = (TimePicker) findViewById(cls.getField("timePicker").getInt((Object) null));
            NumberPicker numberPicker = (NumberPicker) this.mTimePicker.findViewById(cls.getField("minute").getInt((Object) null));
            numberPicker.setMinValue(0);
            numberPicker.setMaxValue(3);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 60; i += 15) {
                arrayList.add(String.format("%02d", new Object[]{Integer.valueOf(i)}));
            }
            numberPicker.setDisplayedValues((String[]) arrayList.toArray(new String[arrayList.size()]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String selectedHourFormat(String str) {
        if (str.length() != 1) {
            return str;
        }
        return AppEventsConstants.EVENT_PARAM_VALUE_NO + str;
    }

    public static String selectedMinuteFormat(int i) {
        return i == 0 ? "00" : String.valueOf(i);
    }

    public static String selectedHour(int i) {
        if (i == 0) {
            return "12";
        }
        if (i > 12) {
            return String.valueOf(i - 12);
        }
        return String.valueOf(i);
    }
}
