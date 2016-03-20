package com.example.zeeshan.customdialerpad;

/**
 * Created by AZforever on 16-03-2016.
 */
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.widget.Button;
import android.widget.TextView;

public class SpannedString {
    public static  void main(Button Keyx, String toappend) {
        desired(Keyx,toappend);
    }

    static void desired(Button KeyX, String toAppend) {

        SpannableString text = new SpannableString(KeyX.getText().toString()+" "+toAppend);
        text.setSpan(new RelativeSizeSpan(1.0f), 0, 1, 0);
        text.setSpan(new RelativeSizeSpan(0.5f), 2, text.length(), 0);
        KeyX.setText(text, TextView.BufferType.SPANNABLE);

    }
}
