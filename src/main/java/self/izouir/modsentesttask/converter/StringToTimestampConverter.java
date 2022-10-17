package self.izouir.modsentesttask.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class StringToTimestampConverter implements Converter<String, Timestamp> {
    @Override
    public Timestamp convert(@NonNull String source) {
        source = source.replaceAll("[TZ]", " ");
        return Timestamp.valueOf(source);
    }
}
