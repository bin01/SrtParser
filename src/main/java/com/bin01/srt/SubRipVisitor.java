package com.bin01.srt;

import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.bin01.srt.SrtParser.BlockContext;
import com.bin01.srt.SrtParser.LineContext;
import com.bin01.srt.SrtParser.TimeRangeContext;
import com.google.common.base.Function;
import com.google.common.collect.Lists;

class SubRipVisitor extends SrtBaseVisitor<Void> {
  private final List<Block> blocks = Lists.newArrayList();

  SubRip getSubRip() {
    return SubRip.newSubRip(blocks);
  }
  
  @Override
  public Void visit(ParseTree tree) {
    return super.visit(tree);
  }
  
  @Override
  public Void visitBlock(BlockContext ctx) {
    Integer id = parseId(ctx);
    TimeRange timeRange = parseTimeRange(ctx);
    List<String> lines = parseTextLines(ctx);
    blocks.add(Block.newBlock(id, timeRange, lines));
    return super.visitBlock(ctx);
  }

  private Integer parseId(BlockContext ctx) {
    TerminalNode number = ctx.Number();
    return Integer.parseInt(number.getText());
  }

  private TimeRange parseTimeRange(BlockContext ctx) {
    TimeRangeContext timeRange = ctx.timeRange();
    List<TerminalNode> time = timeRange.Time();
    return TimeRange.newTimeRange(parseDateTime(time.get(0)), parseDateTime(time.get(1)));
  }

  private DateTime parseDateTime(TerminalNode terminalNode) {
    return DateTimeParser.parse(terminalNode.getText());
  }

  private List<String> parseTextLines(BlockContext ctx) {
    List<LineContext> lines = ctx.textLines().line();
    return Lists.transform(lines, new Function<LineContext, String>() {
      @Override
      public String apply(LineContext ctx) {
        return ctx.getText();
      }
    });
  }
}
