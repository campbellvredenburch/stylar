package com.zeoflow.stylar.utils;

import android.graphics.Canvas;
import android.text.Layout;
import android.text.Spanned;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.zeoflow.stylar.core.spans.TextLayoutSpan;
import com.zeoflow.stylar.core.spans.TextViewSpan;

/**
 * @since 4.4.0
 */
public abstract class SpanUtils {

    public static int width(@NonNull Canvas canvas, @NonNull CharSequence cs) {
        // Layout
        // TextView
        // canvas

        if (cs instanceof Spanned) {
            final Spanned spanned = (Spanned) cs;

            // if we are displayed with layout information -> use it
            final Layout layout = TextLayoutSpan.layoutOf(spanned);
            if (layout != null) {
                return layout.getWidth();
            }

            // if we have TextView -> obtain width from it (exclude padding)
            final TextView textView = TextViewSpan.textViewOf(spanned);
            if (textView != null) {
                return textView.getWidth() - textView.getPaddingLeft() - textView.getPaddingRight();
            }
        }

        // else just use canvas width
        return canvas.getWidth();
    }
}
