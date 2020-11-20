package com.github.dev.objectnotation.html;

import java.util.HashSet;
import java.util.Set;

/**
 * fieldset
 */
class TagFieldset extends TagAbstractImpl {

	private static final Set<String> ATTRIBUTES = new HashSet<>();

	static {
		ATTRIBUTES.add("disabled");
		ATTRIBUTES.add("form");
		ATTRIBUTES.add("name");
	}

	public TagFieldset() {
		super("fieldset");
	}

	@Override
	public boolean isAttribute(String str) {
		return ATTRIBUTES.contains(str);
	}

}
