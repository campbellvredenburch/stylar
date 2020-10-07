package com.zeoflow.stylar.core.spans;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

import androidx.annotation.NonNull;

/**
 * A span implementation that allow applying custom Typeface. Although it is
 * not used directly by the library, it\'s helpful for customizations.
 * <p>
 * Please note that this implementation does not validate current paint state
 * and won\'t be updating/modifying supplied Typeface.
 *
 * @since 3.0.0
 */
public class CustomTypefaceSpan extends MetricAffectingSpan
{

    private final Typeface typeface;

    public CustomTypefaceSpan(@NonNull Typeface typeface)
    {
        this.typeface = typeface;
    }

    @NonNull
    public static CustomTypefaceSpan create(@NonNull Typeface typeface)
    {
        return new CustomTypefaceSpan(typeface);
    }

    @Override
    public void updateMeasureState(@NonNull TextPaint p)
    {
        updatePaint(p);
    }

    @Override
    public void updateDrawState(TextPaint tp)
    {
        updatePaint(tp);
    }

    private void updatePaint(@NonNull TextPaint paint)
    {
        paint.setTypeface(typeface);
    }
}
