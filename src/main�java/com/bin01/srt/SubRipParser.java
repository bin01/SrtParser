package com.bin01.srt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import com.bin01.srt.SrtParser.ParseContext;

public class SubRipParser {
  private final File file;

  public SubRipParser(File file) {
    this.file = file;
  }

  public SubRip parse() throws IOException {
    ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(file));
    SrtLexer lexer = new SrtLexer(input);
    CommonTokenStream stream = new CommonTokenStream(lexer);
    SrtParser parser = new SrtParser(stream);
    ParseContext context = parser.parse();
    SubRipVisitor visitor = new SubRipVisitor();
    context.accept(visitor);
    return visitor.getSubRip();
  }
}
