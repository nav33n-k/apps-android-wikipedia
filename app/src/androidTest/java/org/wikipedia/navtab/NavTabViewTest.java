package org.wikipedia.navtab;

import android.support.annotation.NonNull;

import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.wikipedia.test.ViewTest;
import org.wikipedia.theme.Theme;

public class NavTabViewTest extends ViewTest {
    private NavTabView subject;

    @Theory public void testWidth(@TestedOn(ints = {WIDTH_DP_XL, WIDTH_DP_XS}) int widthDp,
                                  float fontScale) {
        setUp(widthDp, LayoutDirection.LOCALE, fontScale, Theme.LIGHT);
        snap(subject);
    }

    @Theory public void testLayoutDirection(@TestedOn(ints = {WIDTH_DP_L, WIDTH_DP_XS}) int widthDp,
                                            LayoutDirection direction) {
        setUp(widthDp, direction, 1, Theme.LIGHT);
        snap(subject);
    }

    @Theory public void testTheme(Theme theme) {
        setUp(WIDTH_DP_XS, LayoutDirection.LOCALE, 1, theme);
        snap(subject);
    }

    @Theory public void testSelect(Theme theme) {
        setUp(WIDTH_DP_XS, LayoutDirection.LOCALE, 1, theme);
        subject.setSelected(true);
        snap(subject);
    }

    @Override protected void setUp(int widthDp, @NonNull LayoutDirection layoutDirection,
                                   float fontScale, @NonNull Theme theme) {
        super.setUp(widthDp, layoutDirection, fontScale, theme);

        subject = new NavTabView(ctx())
                .text(NavTab.EXPLORE.text())
                .icon(NavTab.EXPLORE.icon());
    }
}