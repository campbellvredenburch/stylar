package com.zeoflow.stylar.ext.latex;

import androidx.annotation.Nullable;

import com.zeoflow.stylar.inlineparser.InlineProcessor;

import org.commonmark.node.Node;

import java.util.regex.Pattern;

/**
 * @since 4.3.0
 */
class JLatexMathInlineProcessor extends InlineProcessor
{

    private static final Pattern RE = Pattern.compile("(\\${2})([\\s\\S]+?)\\1");

    @Override
    public char specialCharacter() {
        return '$';
    }

    @Nullable
    @Override
    protected Node parse() {

        final String latex = match(RE);
        if (latex == null) {
            return null;
        }

        final JLatexMathNode node = new JLatexMathNode();
        node.latex(latex.substring(2, latex.length() - 2));
        return node;
    }
}
