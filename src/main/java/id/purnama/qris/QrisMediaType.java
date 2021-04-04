package id.purnama.qris;

import org.springframework.http.MediaType;

public class QrisMediaType extends MediaType {

    public QrisMediaType(String type) {
        super(type);
    }

    /**
     * Public constant media type for {@code application/qris}.
     */
    public static final org.springframework.http.MediaType APPLICATION_QRIS = MediaType.valueOf(QrisMediaType.APPLICATION_QRIS_VALUE);

    /**
     * A String equivalent of {@link QrisMediaType#APPLICATION_QRIS}.
     */
    public static final String APPLICATION_QRIS_VALUE = "application/qris";


}
