package de.kiltz.rest.provider;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
@Produces("application/tz-csv")
public class CSVMarshaller implements MessageBodyWriter {

	@Override
	public boolean isWriteable(Class klasse, Type type, Annotation[] anno, MediaType media) {
		return media.toString().equals("application/tz-csv");
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void writeTo(Object target, Class type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap httpHeaders, OutputStream outputStream) throws IOException, WebApplicationException {
		if (target instanceof List) {
			List<Info> liste = (List<Info>) target;
			for (Info i : liste) {
				String zeile = String.format("%d;%s;%s\n", i.getNr(),
						i.getDatum().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), i.getText());
				outputStream.write(zeile.getBytes());

			}
		}

	}

}
