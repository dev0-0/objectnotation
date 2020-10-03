package com.github.dev.objectnotation;

/**
 * Judge whether or not a new line.
 */
final class ParseNextLine implements IntToFunction {

	private final Parser parser;

	ParseNextLine(Parser parser) {
		this.parser = parser;
	}

	@Override
	public IntToFunction apply(int i) {
		if (i == -1) {
			parser.valueConsumer.accept(-1);
			return parser.offset;
		}
		char c = (char) i;
		if (parser.n == 0) {
			if (c >= '0' && c <= '9') {
				parser.valueConsumer.accept(-1);
				parser.addRow();
				return parser.offset.apply(i);
			} else if (c == '\n' || c == '\r') {
				return parser.text.apply(i);
			}
		}
		if (c == ' ') {
			if (parser.n < parser.offset.getOffsetLength()) {
				return this;
			} else if (parser.n == parser.offset.getOffsetLength()) {
				return parser.text;
			}
		}
		throw new IllegalCharException(parser.getRow(), parser.n);
	}

}
