package com.whv.doc.utils.convert;

import java.io.IOException;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.BodyContent;

// Referenced classes of package org.loushang.web.taglib.util:
//            MessageResources, LocaleUtils

public final class ResponseUtils
{

    private ResponseUtils()
    {
    }

    public static String filter(String value)
    {
        if(value == null)
            return null;
        char content[] = new char[value.length()];
        value.getChars(0, value.length(), content, 0);
        StringBuffer result = new StringBuffer(content.length + 50);
        for(int i = 0; i < content.length; i++)
            switch(content[i])
            {
            case 60: // '<'
                result.append("&lt;");
                break;

            case 62: // '>'
                result.append("&gt;");
                break;

            case 38: // '&'
                result.append("&amp;");
                break;

            case 34: // '"'
                result.append("&quot;");
                break;

            case 39: // '\''
                result.append("&#39;");
                break;

            default:
                result.append(content[i]);
                break;
            }

        return result.toString();
    }

    public static void write(PageContext pageContext, String text)
    {
        JspWriter writer = pageContext.getOut();
        try
        {
            writer.print(text);
        }
        catch(IOException e)
        {
        }
    }

    public static void writePrevious(PageContext pageContext, String text)
    {
        JspWriter writer = pageContext.getOut();
        if(writer instanceof BodyContent)
            writer = ((BodyContent)writer).getEnclosingWriter();
        try
        {
            writer.print(text);
        }
        catch(IOException e)
        {
        }
    }
  
}


