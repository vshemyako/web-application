package org.laplas.spring.web.resolver;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractCachingViewResolver;

/**
 * Dummy view resolver to verify workings of view-resolver chain.
 *
 * @author Valentine Shemyako
 * @since January 16, 2019
 */
public class DummyViewResolver extends AbstractCachingViewResolver {

    @Override
    protected View loadView(String viewName, Locale locale) throws Exception {
        return DummyView.INSTANCE;
    }

    private static class DummyView implements View {

        private static final View INSTANCE = new DummyView();

        @Override
        public void render(@Nullable Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
            String values = model.values()
                    .stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(","));

            try (PrintWriter writer = new PrintWriter(response.getOutputStream())) {
                writer.write(values);
            }
        }
    }
}
