package com.anychart.core.ui;

import com.anychart.APIlib;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.JsObject;
import com.anychart.core.Text;

import java.util.Locale;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import android.text.TextUtils;

// class
/**
 * Label element class.<br/>
Label can be a part of another element (such as chart, legend, axis, etc) or it can
be used independently.<br/>
Label has a background and a large number of positioning options:
<ul>
  <li>{@link anychart.core.ui.Label#anchor}</li>
  <li>{@link anychart.core.ui.Label#position}</li>
  <li>{@link anychart.core.ui.Label#offsetX} and {@link anychart.core.ui.Label#offsetY}</li>
  <li>{@link anychart.core.ui.Label#parentBounds}</li>
</ul>
 */
public class Label extends Text {

    protected Label() {

    }

    public static Label instantiate() {
        return new Label("new anychart.core.ui.label()");
    }

    

    public Label(String jsChart) {
        jsBase = "label" + ++variableIndex;
        APIlib.getInstance().addJSLine(jsBase + " = " + jsChart + ";");
    }

    public String getJsBase() {
        return jsBase;
    }

    
    /**
     * Getter for the adjust font settings.
     */
    public void adjustFontSize() {
        APIlib.getInstance().addJSLine(jsBase + ".adjustFontSize();");
    }
    /**
     * Setter for the adjust font settings.
     */
    public com.anychart.core.ui.Label adjustFontSize(String bothOrByWidth, Boolean byHeight) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".adjustFontSize(%s, %s);", wrapQuotes(bothOrByWidth), byHeight));

        return this;
    }
    /**
     * Setter for the adjust font settings.
     */
    public com.anychart.core.ui.Label adjustFontSize(Boolean[] bothOrByWidth, Boolean byHeight) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".adjustFontSize(%s, %s);", arrayToString(bothOrByWidth), byHeight));

        return this;
    }
    /**
     * Setter for the adjust font settings.
     */
    public com.anychart.core.ui.Label adjustFontSize(Boolean bothOrByWidth, Boolean byHeight) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".adjustFontSize(%s, %s);", bothOrByWidth, byHeight));

        return this;
    }
    /**
     * Getter for label anchor settings.
     */
    public void anchor() {
        APIlib.getInstance().addJSLine(jsBase + ".anchor();");
    }
    /**
     * Setter for label anchor settings.
     */
    public com.anychart.core.ui.Label anchor(com.anychart.enums.Anchor anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".anchor(%s);", (anchor != null) ? anchor.getJsBase() : null));

        return this;
    }
    /**
     * Setter for label anchor settings.
     */
    public com.anychart.core.ui.Label anchor(String anchor) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".anchor(%s);", wrapQuotes(anchor)));

        return this;
    }
    /**
     * Getter for label background settings.
     */
    public com.anychart.core.ui.Background background() {
        return new com.anychart.core.ui.Background(jsBase + ".background()");
    }
    /**
     * Setter for label background settings.
     */
    public com.anychart.core.ui.Label background(String settings) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".background(%s);", wrapQuotes(settings)));

        return this;
    }
    /**
     * Setter for label background settings.
     */
    public com.anychart.core.ui.Label background(Boolean settings) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".background(%s);", settings));

        return this;
    }
    /**
     * Getter for the pointer events.
     */
    public void disablePointerEvents() {
        APIlib.getInstance().addJSLine(jsBase + ".disablePointerEvents();");
    }
    /**
     * Setter for the pointer events.
     */
    public com.anychart.core.ui.Label disablePointerEvents(Boolean enabled) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".disablePointerEvents(%s);", enabled));

        return this;
    }
    /**
     * Getter for the element state (enabled or disabled).
     */
    public void enabled() {
        APIlib.getInstance().addJSLine(jsBase + ".enabled();");
    }
    /**
     * Setter for the element enabled state.
     */
    public com.anychart.core.ui.Label enabled(Boolean enabled) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".enabled(%s);", enabled));

        return this;
    }
    /**
     * Getter for the text font color.
     */
    public void fontColor() {
        APIlib.getInstance().addJSLine(jsBase + ".fontColor();");
    }
    /**
     * Setter for the text font color.<br/>
{@link https://www.w3schools.com/html/html_colors.asp}
     */
    public com.anychart.core.ui.Label fontColor(String color) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fontColor(%s);", wrapQuotes(color)));

        return this;
    }
    /**
     * Getter for the text font decoration.
     */
    public void fontDecoration() {
        APIlib.getInstance().addJSLine(jsBase + ".fontDecoration();");
    }
    /**
     * Setter for the text font decoration.
     */
    public com.anychart.core.ui.Label fontDecoration(com.anychart.graphics.vector.text.Decoration value) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fontDecoration(%s);", (value != null) ? value.getJsBase() : null));

        return this;
    }
    /**
     * Setter for the text font decoration.
     */
    public com.anychart.core.ui.Label fontDecoration(String value) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fontDecoration(%s);", wrapQuotes(value)));

        return this;
    }
    /**
     * Getter for the font family.
     */
    public void fontFamily() {
        APIlib.getInstance().addJSLine(jsBase + ".fontFamily();");
    }
    /**
     * Setter for the font family.
     */
    public com.anychart.core.ui.Label fontFamily(String family) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fontFamily(%s);", wrapQuotes(family)));

        return this;
    }
    /**
     * Getter for the text font opacity.
     */
    public void fontOpacity() {
        APIlib.getInstance().addJSLine(jsBase + ".fontOpacity();");
    }
    /**
     * Setter for the text font opacity. Double value from 0 to 1.
     */
    public com.anychart.core.ui.Label fontOpacity(Number opacity) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fontOpacity(%s);", opacity));

        return this;
    }
    /**
     * Getter for the text font size.
     */
    public void fontSize() {
        APIlib.getInstance().addJSLine(jsBase + ".fontSize();");
    }
    /**
     * Setter for the text font size.
     */
    public com.anychart.core.ui.Label fontSize(String size) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fontSize(%s);", wrapQuotes(size)));

        return this;
    }
    /**
     * Setter for the text font size.
     */
    public com.anychart.core.ui.Label fontSize(Number size) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fontSize(%s);", size));

        return this;
    }
    /**
     * Getter for the text font style.
     */
    public void fontStyle() {
        APIlib.getInstance().addJSLine(jsBase + ".fontStyle();");
    }
    /**
     * Setter for the text font style.
     */
    public com.anychart.core.ui.Label fontStyle(com.anychart.graphics.vector.text.FontStyle style) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fontStyle(%s);", (style != null) ? style.getJsBase() : null));

        return this;
    }
    /**
     * Setter for the text font style.
     */
    public com.anychart.core.ui.Label fontStyle(String style) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fontStyle(%s);", wrapQuotes(style)));

        return this;
    }
    /**
     * Getter for the text font variant.
     */
    public void fontVariant() {
        APIlib.getInstance().addJSLine(jsBase + ".fontVariant();");
    }
    /**
     * Setter for the text font variant.
     */
    public com.anychart.core.ui.Label fontVariant(com.anychart.graphics.vector.text.FontVariant value) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fontVariant(%s);", (value != null) ? value.getJsBase() : null));

        return this;
    }
    /**
     * Setter for the text font variant.
     */
    public com.anychart.core.ui.Label fontVariant(String value) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fontVariant(%s);", wrapQuotes(value)));

        return this;
    }
    /**
     * Getter for the text font weight.
     */
    public void fontWeight() {
        APIlib.getInstance().addJSLine(jsBase + ".fontWeight();");
    }
    /**
     * Setter for the text font weight.<br/>
{@link https://www.w3schools.com/cssref/pr_font_weight.asp}
     */
    public com.anychart.core.ui.Label fontWeight(String weight) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fontWeight(%s);", wrapQuotes(weight)));

        return this;
    }
    /**
     * Setter for the text font weight.<br/>
{@link https://www.w3schools.com/cssref/pr_font_weight.asp}
     */
    public com.anychart.core.ui.Label fontWeight(Number weight) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".fontWeight(%s);", weight));

        return this;
    }
    /**
     * Getter for the text horizontal align.
     */
    public void hAlign() {
        APIlib.getInstance().addJSLine(jsBase + ".hAlign();");
    }
    /**
     * Setter for the text horizontal align.
     */
    public com.anychart.core.ui.Label hAlign(com.anychart.graphics.vector.text.HAlign align) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".hAlign(%s);", (align != null) ? align.getJsBase() : null));

        return this;
    }
    /**
     * Setter for the text horizontal align.
     */
    public com.anychart.core.ui.Label hAlign(String align) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".hAlign(%s);", wrapQuotes(align)));

        return this;
    }
    /**
     * Getter for the label height.
     */
    public void height() {
        APIlib.getInstance().addJSLine(jsBase + ".height();");
    }
    /**
     * Setter for the label height.
     */
    public com.anychart.core.ui.Label height(Number height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".height(%s);", height));

        return this;
    }
    /**
     * Setter for the label height.
     */
    public com.anychart.core.ui.Label height(String height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".height(%s);", wrapQuotes(height)));

        return this;
    }
    /**
     * Getter for the text letter spacing.
     */
    public void letterSpacing() {
        APIlib.getInstance().addJSLine(jsBase + ".letterSpacing();");
    }
    /**
     * Setter for the text letter spacing.<br/>
{@link https://www.w3schools.com/cssref/pr_text_letter-spacing.asp}
     */
    public com.anychart.core.ui.Label letterSpacing(String spacing) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".letterSpacing(%s);", wrapQuotes(spacing)));

        return this;
    }
    /**
     * Setter for the text letter spacing.<br/>
{@link https://www.w3schools.com/cssref/pr_text_letter-spacing.asp}
     */
    public com.anychart.core.ui.Label letterSpacing(Number spacing) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".letterSpacing(%s);", spacing));

        return this;
    }
    /**
     * Getter for the text line height.
     */
    public void lineHeight() {
        APIlib.getInstance().addJSLine(jsBase + ".lineHeight();");
    }
    /**
     * Setter for the text line height.<br/>
{@link https://www.w3schools.com/cssref/pr_dim_line-height.asp}
     */
    public com.anychart.core.ui.Label lineHeight(String height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".lineHeight(%s);", wrapQuotes(height)));

        return this;
    }
    /**
     * Setter for the text line height.<br/>
{@link https://www.w3schools.com/cssref/pr_dim_line-height.asp}
     */
    public com.anychart.core.ui.Label lineHeight(Number height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".lineHeight(%s);", height));

        return this;
    }
    /**
     * Getter for maximum font size settings for adjust text to.
     */
    public void maxFontSize() {
        APIlib.getInstance().addJSLine(jsBase + ".maxFontSize();");
    }
    /**
     * Setter for maximum font size settings for adjust text to.
     */
    public com.anychart.core.ui.Label maxFontSize(Number size) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".maxFontSize(%s);", size));

        return this;
    }
    /**
     * Setter for maximum font size settings for adjust text to.
     */
    public com.anychart.core.ui.Label maxFontSize(String size) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".maxFontSize(%s);", wrapQuotes(size)));

        return this;
    }
    /**
     * Getter for minimum font size settings for adjust text from.
     */
    public void minFontSize() {
        APIlib.getInstance().addJSLine(jsBase + ".minFontSize();");
    }
    /**
     * Setter for minimum font size settings for adjust text from.
     */
    public com.anychart.core.ui.Label minFontSize(Number size) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".minFontSize(%s);", size));

        return this;
    }
    /**
     * Setter for minimum font size settings for adjust text from.
     */
    public com.anychart.core.ui.Label minFontSize(String size) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".minFontSize(%s);", wrapQuotes(size)));

        return this;
    }
    /**
     * Getter for label offsetX settings.
     */
    public void offsetX() {
        APIlib.getInstance().addJSLine(jsBase + ".offsetX();");
    }
    /**
     * Setter for label offsetX settings.<br/>
<img src='/si/8.4.0/anychart.core.ui.CrosshairLabel.offsetX.png' height='436' width='577'/><br/>
Arrows show offsets layout.
     */
    public com.anychart.core.ui.Label offsetX(Number offset) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".offsetX(%s);", offset));

        return this;
    }
    /**
     * Setter for label offsetX settings.<br/>
<img src='/si/8.4.0/anychart.core.ui.CrosshairLabel.offsetX.png' height='436' width='577'/><br/>
Arrows show offsets layout.
     */
    public com.anychart.core.ui.Label offsetX(String offset) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".offsetX(%s);", wrapQuotes(offset)));

        return this;
    }
    /**
     * Getter for label offsetY settings.
     */
    public void offsetY() {
        APIlib.getInstance().addJSLine(jsBase + ".offsetY();");
    }
    /**
     * Setter for label offsetY settings.<br/>
<img src='/si/8.4.0/anychart.core.ui.CrosshairLabel.offsetX.png' height='436' width='577'/><br/>
Arrows show offsets layout.
     */
    public com.anychart.core.ui.Label offsetY(Number offset) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".offsetY(%s);", offset));

        return this;
    }
    /**
     * Setter for label offsetY settings.<br/>
<img src='/si/8.4.0/anychart.core.ui.CrosshairLabel.offsetX.png' height='436' width='577'/><br/>
Arrows show offsets layout.
     */
    public com.anychart.core.ui.Label offsetY(String offset) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".offsetY(%s);", wrapQuotes(offset)));

        return this;
    }
    /**
     * Getter for the label padding.
     */
    public com.anychart.core.utils.Padding padding() {
        return new com.anychart.core.utils.Padding(jsBase + ".padding()");
    }
    /**
     * Setter for the label padding in pixels by one value.
     */
    public com.anychart.core.ui.Label padding(Number[] padding) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".padding(%s);", Arrays.toString(padding)));

        return this;
    }
    /**
     * Setter for the label padding in pixels by one value.
     */
    public com.anychart.core.ui.Label padding(String[] padding) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".padding(%s);", arrayToStringWrapQuotes(padding)));

        return this;
    }
    /**
     * Setter for the label padding in pixels by one value.
     */
    public com.anychart.core.ui.Label padding(String padding) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".padding(%s);", wrapQuotes(padding)));

        return this;
    }
    /**
     * Setter for the label padding in pixels.
     */
    public com.anychart.core.ui.Label padding(String value1, String value2, String value3, String value4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(value1), wrapQuotes(value2), wrapQuotes(value3), wrapQuotes(value4)));

        return this;
    }
    /**
     * Setter for the label padding in pixels.
     */
    public com.anychart.core.ui.Label padding(String value1, String value2, String value3, Number value4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(value1), wrapQuotes(value2), wrapQuotes(value3), value4));

        return this;
    }
    /**
     * Setter for the label padding in pixels.
     */
    public com.anychart.core.ui.Label padding(String value1, String value2, Number value3, String value4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(value1), wrapQuotes(value2), value3, wrapQuotes(value4)));

        return this;
    }
    /**
     * Setter for the label padding in pixels.
     */
    public com.anychart.core.ui.Label padding(String value1, String value2, Number value3, Number value4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(value1), wrapQuotes(value2), value3, value4));

        return this;
    }
    /**
     * Setter for the label padding in pixels.
     */
    public com.anychart.core.ui.Label padding(String value1, Number value2, String value3, String value4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(value1), value2, wrapQuotes(value3), wrapQuotes(value4)));

        return this;
    }
    /**
     * Setter for the label padding in pixels.
     */
    public com.anychart.core.ui.Label padding(String value1, Number value2, String value3, Number value4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(value1), value2, wrapQuotes(value3), value4));

        return this;
    }
    /**
     * Setter for the label padding in pixels.
     */
    public com.anychart.core.ui.Label padding(String value1, Number value2, Number value3, String value4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(value1), value2, value3, wrapQuotes(value4)));

        return this;
    }
    /**
     * Setter for the label padding in pixels.
     */
    public com.anychart.core.ui.Label padding(String value1, Number value2, Number value3, Number value4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".padding(%s, %s, %s, %s);", wrapQuotes(value1), value2, value3, value4));

        return this;
    }
    /**
     * Setter for the label padding in pixels.
     */
    public com.anychart.core.ui.Label padding(Number value1, String value2, String value3, String value4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".padding(%s, %s, %s, %s);", value1, wrapQuotes(value2), wrapQuotes(value3), wrapQuotes(value4)));

        return this;
    }
    /**
     * Setter for the label padding in pixels.
     */
    public com.anychart.core.ui.Label padding(Number value1, String value2, String value3, Number value4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".padding(%s, %s, %s, %s);", value1, wrapQuotes(value2), wrapQuotes(value3), value4));

        return this;
    }
    /**
     * Setter for the label padding in pixels.
     */
    public com.anychart.core.ui.Label padding(Number value1, String value2, Number value3, String value4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".padding(%s, %s, %s, %s);", value1, wrapQuotes(value2), value3, wrapQuotes(value4)));

        return this;
    }
    /**
     * Setter for the label padding in pixels.
     */
    public com.anychart.core.ui.Label padding(Number value1, String value2, Number value3, Number value4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".padding(%s, %s, %s, %s);", value1, wrapQuotes(value2), value3, value4));

        return this;
    }
    /**
     * Setter for the label padding in pixels.
     */
    public com.anychart.core.ui.Label padding(Number value1, Number value2, String value3, String value4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".padding(%s, %s, %s, %s);", value1, value2, wrapQuotes(value3), wrapQuotes(value4)));

        return this;
    }
    /**
     * Setter for the label padding in pixels.
     */
    public com.anychart.core.ui.Label padding(Number value1, Number value2, String value3, Number value4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".padding(%s, %s, %s, %s);", value1, value2, wrapQuotes(value3), value4));

        return this;
    }
    /**
     * Setter for the label padding in pixels.
     */
    public com.anychart.core.ui.Label padding(Number value1, Number value2, Number value3, String value4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".padding(%s, %s, %s, %s);", value1, value2, value3, wrapQuotes(value4)));

        return this;
    }
    /**
     * Setter for the label padding in pixels.
     */
    public com.anychart.core.ui.Label padding(Number value1, Number value2, Number value3, Number value4) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".padding(%s, %s, %s, %s);", value1, value2, value3, value4));

        return this;
    }
    /**
     * Getter for label position settings.
     */
    public void position() {
        APIlib.getInstance().addJSLine(jsBase + ".position();");
    }
    /**
     * Setter for label position settings.
     */
    public com.anychart.core.ui.Label position(com.anychart.enums.Position position) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".position(%s);", (position != null) ? position.getJsBase() : null));

        return this;
    }
    /**
     * Setter for label position settings.
     */
    public com.anychart.core.ui.Label position(String position) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".position(%s);", wrapQuotes(position)));

        return this;
    }
    /**
     * Prints all elements on related stage.
     */
    public void print(com.anychart.graphics.vector.PaperSize paperSizeOrOptions, Boolean landscape) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".print(%s, %s);", (paperSizeOrOptions != null) ? paperSizeOrOptions.getJsBase() : null, landscape));
    }
    /**
     * Prints all elements on related stage.
     */
    public void print(String paperSizeOrOptions, Boolean landscape) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".print(%s, %s);", wrapQuotes(paperSizeOrOptions), landscape));
    }
    /**
     * Removes all listeners from an object. You can also optionally remove listeners of some particular type.
     */
    public void removeAllListeners(String type) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".removeAllListeners(%s);", wrapQuotes(type)));
    }
    /**
     * Getter for the label rotation.
     */
    public void rotation() {
        APIlib.getInstance().addJSLine(jsBase + ".rotation();");
    }
    /**
     * Setter for the label rotation.
     */
    public com.anychart.core.ui.Label rotation(Number rotation) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".rotation(%s);", rotation));

        return this;
    }
    /**
     * Getter for the text selectable option.
     */
    public void selectable() {
        APIlib.getInstance().addJSLine(jsBase + ".selectable();");
    }
    /**
     * Setter for the text selectable.
     */
    public com.anychart.core.ui.Label selectable(Boolean enabled) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".selectable(%s);", enabled));

        return this;
    }
    /**
     * Getter for the text content for a label.
     */
    public void text() {
        APIlib.getInstance().addJSLine(jsBase + ".text();");
    }
    /**
     * Setter for text content for a label.
     */
    public com.anychart.core.ui.Label text(String text) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".text(%s);", wrapQuotes(text)));

        return this;
    }
    /**
     * Getter for the text direction.
     */
    public void textDirection() {
        APIlib.getInstance().addJSLine(jsBase + ".textDirection();");
    }
    /**
     * Setter for the text direction.
     */
    public com.anychart.core.ui.Label textDirection(com.anychart.graphics.vector.text.Direction direction) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".textDirection(%s);", (direction != null) ? direction.getJsBase() : null));

        return this;
    }
    /**
     * Setter for the text direction.
     */
    public com.anychart.core.ui.Label textDirection(String direction) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".textDirection(%s);", wrapQuotes(direction)));

        return this;
    }
    /**
     * Getter for the text indent.
     */
    public void textIndent() {
        APIlib.getInstance().addJSLine(jsBase + ".textIndent();");
    }
    /**
     * Setter for the text indent.
     */
    public com.anychart.core.ui.Label textIndent(Number indent) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".textIndent(%s);", indent));

        return this;
    }
    /**
     * Getter for the text overflow settings.
     */
    public void textOverflow() {
        APIlib.getInstance().addJSLine(jsBase + ".textOverflow();");
    }
    /**
     * Setter for the text overflow settings.
     */
    public com.anychart.core.ui.Label textOverflow(com.anychart.graphics.vector.text.TextOverflow value) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".textOverflow(%s);", (value != null) ? value.getJsBase() : null));

        return this;
    }
    /**
     * Setter for the text overflow settings.
     */
    public com.anychart.core.ui.Label textOverflow(String value) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".textOverflow(%s);", wrapQuotes(value)));

        return this;
    }
    /**
     * Getter for the full text appearance settings.
     */
    public void textSettings() {
        APIlib.getInstance().addJSLine(jsBase + ".textSettings();");
    }
    /**
     * Getter for all text appearance settings.
     */
    public void textSettings(String name) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".textSettings(%s);", wrapQuotes(name)));
    }
    /**
     * Setter for the text appearance settings.
     */
    public com.anychart.core.ui.Label textSettings(String name, String settings) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".textSettings(%s, %s);", wrapQuotes(name), wrapQuotes(settings)));

        return this;
    }
    /**
     * Setter for the text appearance settings.
     */
    public com.anychart.core.ui.Label textSettings(String name, Number settings) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".textSettings(%s, %s);", wrapQuotes(name), settings));

        return this;
    }
    /**
     * Setter for the text appearance settings.
     */
    public com.anychart.core.ui.Label textSettings(String name, Boolean settings) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".textSettings(%s, %s);", wrapQuotes(name), settings));

        return this;
    }
    public void setOnClickListener(com.anychart.chart.common.listener.ListenersInterface.OnClickListener listener) {
        StringBuilder js = new StringBuilder();

        js.append(jsBase).append(".listen('pointClick', function(e) {");

        if (listener.getFields() != null) {
            js.append("var result = ");
            for (String field : listener.getFields()) {
                js.append(String.format(Locale.US, "'%1$s' + ':' + e.point.get('%1$s') + ',' +", field));
            }
            js.setLength(js.length() - 8);
            js.append(";");

            js.append("android.onClick(result);");
        } else {
            js.append("android.onClick(null);");
        }
        js.append("});");

        com.anychart.chart.common.listener.ListenersInterface.getInstance().setOnClickListener(listener);

        APIlib.getInstance().addJSLine(js.toString());
    }
    /**
     * Removes an event listener which was added with listen() by the key returned by listen() or listenOnce().
     */
    public void unlistenByKey(String key) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".unlistenByKey(%s);", wrapQuotes(key)));
    }
    /**
     * Getter for the useHTML flag.
     */
    public void useHtml() {
        APIlib.getInstance().addJSLine(jsBase + ".useHtml();");
    }
    /**
     * Setter for flag useHTML.
     */
    public com.anychart.core.ui.Label useHtml(Boolean enabled) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".useHtml(%s);", enabled));

        return this;
    }
    /**
     * Getter for the text vertical align.
     */
    public void vAlign() {
        APIlib.getInstance().addJSLine(jsBase + ".vAlign();");
    }
    /**
     * Setter for the text vertical align.
     */
    public com.anychart.core.ui.Label vAlign(com.anychart.graphics.vector.text.VAlign align) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".vAlign(%s);", (align != null) ? align.getJsBase() : null));

        return this;
    }
    /**
     * Setter for the text vertical align.
     */
    public com.anychart.core.ui.Label vAlign(String align) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".vAlign(%s);", wrapQuotes(align)));

        return this;
    }
    /**
     * Getter for the label width.
     */
    public void width() {
        APIlib.getInstance().addJSLine(jsBase + ".width();");
    }
    /**
     * Setter for the label width.
     */
    public com.anychart.core.ui.Label width(Number width) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".width(%s);", width));

        return this;
    }
    /**
     * Setter for the label width.
     */
    public com.anychart.core.ui.Label width(String width) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".width(%s);", wrapQuotes(width)));

        return this;
    }
    /**
     * Getter for the word-break mode.
     */
    public void wordBreak() {
        APIlib.getInstance().addJSLine(jsBase + ".wordBreak();");
    }
    /**
     * Setter for the word-break mode.
     */
    public com.anychart.core.ui.Label wordBreak(com.anychart.enums.WordBreak mode) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".wordBreak(%s);", (mode != null) ? mode.getJsBase() : null));

        return this;
    }
    /**
     * Setter for the word-break mode.
     */
    public com.anychart.core.ui.Label wordBreak(String mode) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".wordBreak(%s);", wrapQuotes(mode)));

        return this;
    }
    /**
     * Getter for the word-wrap mode.
     */
    public void wordWrap() {
        APIlib.getInstance().addJSLine(jsBase + ".wordWrap();");
    }
    /**
     * Setter for the word-wrap mode.
     */
    public com.anychart.core.ui.Label wordWrap(com.anychart.enums.WordWrap mode) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".wordWrap(%s);", (mode != null) ? mode.getJsBase() : null));

        return this;
    }
    /**
     * Setter for the word-wrap mode.
     */
    public com.anychart.core.ui.Label wordWrap(String mode) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".wordWrap(%s);", wrapQuotes(mode)));

        return this;
    }
    /**
     * Getter for the Z-index of the element.
     */
    public void zIndex() {
        APIlib.getInstance().addJSLine(jsBase + ".zIndex();");
    }
    /**
     * Setter for the Z-index of the element.
     */
    public com.anychart.core.ui.Label zIndex(Number zIndex) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".zIndex(%s);", zIndex));

        return this;
    }
    /**
     * Getter for the container.
     */
    public com.anychart.graphics.vector.Layer container() {
        return new com.anychart.graphics.vector.Layer(jsBase + ".container()");
    }
    /**
     * Setter for the container.
     */
    public com.anychart.core.ui.Label container(com.anychart.graphics.vector.Layer element) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".container(%s);", (element != null) ? element.getJsBase() : null));

        return this;
    }
    /**
     * Setter for the container.
     */
    public com.anychart.core.ui.Label container(com.anychart.graphics.vector.Stage element) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".container(%s);", (element != null) ? element.getJsBase() : null));

        return this;
    }
    /**
     * Setter for the container.
     */
    public com.anychart.core.ui.Label container(String element) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".container(%s);", wrapQuotes(element)));

        return this;
    }
    /**
     * Getter for the parent bounds.<br>
Bounds that would be used in case of percent size calculations. Expects pixel values only.
     */
    public com.anychart.math.Rect parentBounds() {
        return new com.anychart.math.Rect(jsBase + ".parentBounds()");
    }
    /**
     * Setter for the parent bounds using single value.<br>
Bounds that would be used in case of percent size calculations. Expects pixel values only.
     */
    public com.anychart.core.ui.Label parentBounds(com.anychart.math.Rect bounds) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".parentBounds(%s);", (bounds != null) ? bounds.getJsBase() : null));

        return this;
    }
    /**
     * Setter for the parent bounds using single value.<br>
Bounds that would be used in case of percent size calculations. Expects pixel values only.
     */
    public com.anychart.core.ui.Label parentBounds(String bounds) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".parentBounds(%s);", wrapQuotes(bounds)));

        return this;
    }
    /**
     * Setter for the parent bounds using single value.<br>
Bounds that would be used in case of percent size calculations. Expects pixel values only.
     */
    public com.anychart.core.ui.Label parentBounds(Number bounds) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".parentBounds(%s);", bounds));

        return this;
    }
    /**
     * Setter for the parent bounds using several values.<br>
Bounds that would be used in case of percent size calculations. Expects pixel values only.
     */
    public com.anychart.core.ui.Label parentBounds(Number left, Number top, Number width, Number height) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".parentBounds(%s, %s, %s, %s);", left, top, width, height));

        return this;
    }

}