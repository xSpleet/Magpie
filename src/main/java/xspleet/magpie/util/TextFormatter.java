package xspleet.magpie.util;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Pair;
import xspleet.magpie.MagpieMod;

import java.util.ArrayList;
import java.util.List;

import static xspleet.magpie.MagpieMod.SYMBOLS_PER_LINE;

/**
 * The class describing the function of the formatting of the descriptions of items. To see the specification of the markup please look at the wiki or at an example
 */
public class TextFormatter
{

    private static List<Formatting> translateFormatTag(String tagSequence)
    {
        List<Formatting> formats = new ArrayList<>();
        tagSequence = tagSequence.substring(1, tagSequence.length()-1);
        String[] tags = tagSequence.split("~");
        for(String tag: tags)
        {
            Formatting format = Formatting.byName(tag);
            if(format != null)
            {
                formats.add(format);
            }
        }
        return formats;
    }

    private static List<List<Pair<String, List<Formatting>>>> translateMarkUpText(String text)
    {
        List<List<Pair<String, List<Formatting>>>> lines = new ArrayList<>();
        List<Formatting> stringFormat = new ArrayList<>();
        text += " <>";
        text = text.replaceAll("(<(\\w+~)*(\\w+)?>)", " $1 ");
        text = text.replaceAll("(&nwln;)", " $1 ");
        String[] splitText = text.split("(\\s+)");
        for(int i = 0 ; i < splitText.length; i++ )
        {
            splitText[i] = splitText[i].replaceAll("(&nbsp;)+", " ");
        }
        StringBuilder currentText = new StringBuilder();
        int currentLineLength = 0;
        List<Pair<String, List<Formatting>>> line = new ArrayList<>() ;
        for(String word: splitText)
        {
            if(word.isEmpty())
                continue;
            else if(word.charAt(0) == '<' && word.charAt(word.length()-1) == '>')
            {
                line.add(new Pair<>(currentText.toString(), new ArrayList<Formatting>(stringFormat)));
                stringFormat = translateFormatTag(word);
                currentText = new StringBuilder();
            }
            else if(word.equals("&nwln;"))
            {
                line.add(new Pair<>(currentText.toString(), new ArrayList<Formatting>(stringFormat)));
                lines.add(new ArrayList<>(line));
                line = new ArrayList<>();
                currentLineLength = 0;
                currentText = new StringBuilder();
            }
            else
            {
                if(currentLineLength + word.length() > SYMBOLS_PER_LINE && currentLineLength != 0)
                {
                    line.add(new Pair<>(currentText.toString(), new ArrayList<Formatting>(stringFormat)));
                    lines.add(new ArrayList<>(line));
                    line = new ArrayList<>();
                    currentText = new StringBuilder();
                    currentLineLength = 0;
                }
                currentText.append(word).append(" ");
                currentLineLength += word.length()+1;
            }
        }
        lines.add(line);
        return lines;
    }

    private static List<Text> getTooltips(String markup)
    {
        List<List<Pair<String, List<Formatting>>>> generatedTooltips = translateMarkUpText(markup);
        List<Text> tooltips = new ArrayList<>();
        for(List<Pair<String, List<Formatting>>> line: generatedTooltips)
        {
            MutableText text = Text.literal("");
            for(Pair<String, List<Formatting>> linePart: line)
            {
                if(linePart.getLeft().isEmpty())
                    continue;
                MutableText textPart = Text.literal(linePart.getLeft());
                for(Formatting format: linePart.getRight())
                {
                    textPart.formatted(format);
                }
                text.append(textPart);
                text.append(" ");
            }
            tooltips.add(text);
        }
        return tooltips;
    }

    public static void addTooltips(Text markup, List<Text> tooltip)
    {
        tooltip.addAll(getTooltips(markup.getString()));
    }
}
