package com.bycuimiao.copy;

import java.io.IOException;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import org.springframework.beans.factory.xml.PluggableSchemaResolver;

/**
 * TODO completion javadoc.
 *
 * @author cuimiao
 * @since 08 January 2019
 */
public class MyEntityResolver implements EntityResolver {
	private PluggableSchemaResolver pluggableSchemaResolver = new PluggableSchemaResolver(ClassLoader.getSystemClassLoader());
	@Override
	public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
		return this.pluggableSchemaResolver.resolveEntity(publicId, systemId);
	}
}
